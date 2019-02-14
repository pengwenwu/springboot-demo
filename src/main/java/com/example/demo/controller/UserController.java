package com.example.demo.controller;

import com.example.demo.domain.entity.User;
import com.example.demo.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public User putUser(
            @PathVariable(value = "id") Long id,
            @RequestParam String name,
            @RequestParam Integer age
    ) {
        // todo: 异常处理
        User user = userRepository.findById(id).orElseThrow();
        user.setName(name);
        user.setAge(age);
        User updateUser = userRepository.save(user);
        return updateUser;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long id) {
        User user = userRepository.findById(id).orElseThrow();
        userRepository.delete(user);
        return ResponseEntity.ok().build();
    }
}
