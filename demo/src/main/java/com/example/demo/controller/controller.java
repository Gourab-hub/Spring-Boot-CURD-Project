package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

    @GetMapping("/")
    public String hello(){
        return "hello world";
    }

    @RequestMapping(value = "/about" ,method = RequestMethod.GET)
    public String about(){
        return "hello about page...";
    }

}
