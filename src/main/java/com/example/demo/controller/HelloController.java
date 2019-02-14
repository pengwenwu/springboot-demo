package com.example.demo.controller;

import com.example.demo.exception.MyException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String index() throws MyException {
        throw new MyException("访问hello发生错误");
    }
}
