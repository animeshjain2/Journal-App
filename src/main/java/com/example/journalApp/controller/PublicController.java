package com.example.journalApp.controller;

import com.example.journalApp.entity.User;
import com.example.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserService userService;
    @GetMapping("checkHealth")
    public String checkHealth(){
        return "ok";
    }

    @PostMapping("/createUser")
    public void createUser(@RequestBody User user)
    {
        userService.createUser(user);
    }
}
