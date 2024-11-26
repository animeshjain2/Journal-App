package com.example.journalApp.cache;

import com.example.journalApp.entity.JournalAppConfigEntity;
import com.example.journalApp.repository.JournalAppConfigRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class AppCache {

    public HashMap<String,String> APP_CACHE = new HashMap<>();

    @Autowired
    private JournalAppConfigRepository journalAppConfigRepository;
    @PostConstruct()
    public void init()
    {
        List<JournalAppConfigEntity> all =  journalAppConfigRepository.findAll();
        for(JournalAppConfigEntity entity : all)
        {
            APP_CACHE.put(entity.getKey(),entity.getValue());
        }
    }

}
