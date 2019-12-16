package com.springbootlq03.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class gobackController {



    @RequestMapping(value="/backmyattendmeeting.html")
    public String Backmyattendmeeting(){
        return "myattendmeeting";
    }

    @RequestMapping(value="/abc.html")
    public String Backmycreatemeeting(){
        return "abc";
    }

}
