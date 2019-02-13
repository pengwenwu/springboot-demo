package com.example.demo.controller;

import com.example.demo.domain.entity.User;
import com.example.demo.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value="/", method=RequestMethod.GET)
    public List<User> getUserList() {
        return userRepository.findAll();
    }

    @RequestMapping(value="/", method=RequestMethod.POST)
    public String postUser(
            @RequestParam String name,
            @RequestParam Integer age
    ) {
        userRepository.save(new User(name, age));
        return "success";
    }
}
