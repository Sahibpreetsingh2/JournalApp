package com.edigest.test1.cache;


import com.edigest.test1.Entity.ConfigJournalAppEntity;
import com.edigest.test1.REPOSITORY.ConfigJournalAppRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class Appcache {

    @Autowired
    private ConfigJournalAppRepository configJournalAppRepository;

    private Map<String,String> APP_CACHE;


    @PostConstruct
    public void init(){
        List<ConfigJournalAppEntity> all = configJournalAppRepository.findAll();
        for(ConfigJournalAppEntity configJournalAppEntity :all){
            APP_CACHE.put(configJournalAppEntity.getKey(),configJournalAppEntity.getValue());

        }
        APP_CACHE = null;
    }
}
