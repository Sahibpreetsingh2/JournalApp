package com.edigest.test1.Service;

import com.edigest.test1.Entity.JournalEntry;
import com.edigest.test1.Entity.User;
import com.edigest.test1.REPOSITORY.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class JournalEntryService {

        @Autowired
        private JournalEntryRepository JournalEntryRepo;

        @Autowired
        private UserService userService;

//        private  static final Logger  logger = LoggerFactory.getLogger(JournalEntryService.class);



        @Transactional
        public void  savedEntry(JournalEntry journalEntry , String userName){
          try{
              User user = userService.findByUserName(userName);
              JournalEntry saved = JournalEntryRepo.save(journalEntry);
              user.getJournalEntries().add(saved);
              userService.saveUser(user);
          }
          catch(Exception e){
//              System.out.println(e);

              throw new RuntimeException("an arror occured while saving the entry",e);
          }
        }
        public void saveEntry(JournalEntry journalEntry){
            JournalEntryRepo.save(journalEntry);
        }

        public List<JournalEntry> getAll(){
            return JournalEntryRepo.findAll();
        }

        public Optional<JournalEntry> findById(ObjectId id){
            return JournalEntryRepo.findById(id);
        }

        @Transactional
        public boolean deleteById(ObjectId id, String userName) {
                boolean removed = false;
            try{
                User user = userService.findByUserName(userName);
                 removed = user.getJournalEntries().removeIf(x -> x.getId().equals(id));
                if (removed) {
                    userService.saveUser(user);
                    JournalEntryRepo.deleteById(id);
                }
            }
            catch (Exception e){
                throw new RuntimeException("an error occured while saving the entry",e);
                
            }
            return removed;
        }


    // controller --> sevice ---> reppsitory
}
