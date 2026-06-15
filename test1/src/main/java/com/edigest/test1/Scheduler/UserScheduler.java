package com.edigest.test1.Scheduler;

import com.edigest.test1.Entity.JournalEntry;
import com.edigest.test1.Entity.User;
import com.edigest.test1.REPOSITORY.UserRepositoryImpl;
import com.edigest.test1.Service.EmailService;
import com.edigest.test1.Service.SentimentAnalysisService;
import com.edigest.test1.enums.sentiment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class UserScheduler {
    @Autowired
    private EmailService emailService;

    @Autowired
    private UserRepositoryImpl userRepository;

    @Autowired
private SentimentAnalysisService sentimentAnalysisService;

//    @Scheduled(cron ="0 0 9 * * SUN")
    public void fetchUsersandSendSaMail(){
        List<User> users = userRepository.getUserForSA();
        for(User user : users){
            List<JournalEntry> journalEntries = user.getJournalEntries();
            List<sentiment> sentiments = journalEntries.stream()
                    .filter(x -> x.getDate()
                            .isAfter(LocalDateTime.now()
                                    .minus(7, ChronoUnit.DAYS)))
                    .map( x-> x.getSentiment())
                    .collect(Collectors.toList());
            Map<sentiment,Integer> sentimentCounts = new HashMap<>();
            for(sentiment Sentiment : sentiments){
                if(Sentiment != null){
                    sentimentCounts.put(Sentiment,sentimentCounts.getOrDefault(Sentiment , 0)+1);

                }
            }
            sentiment mostFrequentSentiment = null;
            int maxCount = 0;
            for(Map.Entry<sentiment , Integer> entry : sentimentCounts.entrySet()){
                if(entry.getValue() > maxCount){
                    maxCount = entry.getValue();
                    mostFrequentSentiment = entry.getKey();
                }
            }
            if(mostFrequentSentiment != null){
                emailService.sendEmail(user.getEmail(),"Sentiment for last 7 days",mostFrequentSentiment.toString());
            }
//            String entry = String.join(" ",filteredEntries);
////            String sentiment = sentimentAnalysisService.getSentiment(entry);
//            emailService.sendEmail(user.getEmail(), " SEntiment for last 7 days" ,sentiment);
        }
    }
}
