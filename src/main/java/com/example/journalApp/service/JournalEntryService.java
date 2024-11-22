package com.example.journalApp.service;

import com.example.journalApp.entity.JournalEntry;
import com.example.journalApp.entity.User;
import com.example.journalApp.repository.JournalRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class JournalEntryService {

    @Autowired
    private JournalRepository journalRepository;
    @Autowired
    private UserService userService;

    @Transactional
    public void createJournal(JournalEntry myEntry,String userName){
        User user = userService.findByUserName(userName);

        myEntry.setDate(LocalDateTime.now());
        List<JournalEntry> saved = user.getJournalEntries();
        saved.add(myEntry);
        journalRepository.save(myEntry);
        userService.saveUser(user);
    }

    public void  createJournal(JournalEntry myEntry){
        myEntry.setDate(LocalDateTime.now());
        journalRepository.save(myEntry);
    }

    public void saveEntry(JournalEntry myEntry){
        journalRepository.save(myEntry);
    }


    public List<JournalEntry> getAll(){
        return journalRepository.findAll();
    }

    public Optional<JournalEntry> findJournalById(ObjectId id){
        return journalRepository.findById(id);
    }

    public boolean deleteJournalById(ObjectId id,String userName){
        boolean removed = false;
        try{
            User user = userService.findByUserName(userName);
            List<JournalEntry> saved = user.getJournalEntries();
            removed = saved.removeIf(x-> x.getId().equals(id));
            if(removed)
            {
                userService.saveUser(user);
                journalRepository.deleteById(id);
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
            throw new RuntimeException("An error occured while deleting the entry. ",e);
        }

        return removed;

    }
}
