package com.springbootlq03.demo.controller;


import com.springbootlq03.demo.dao.Userdao;
import com.springbootlq03.demo.entites.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.Map;

@Controller
public class RegisterController {

    @Resource
    Userdao userdao;

    @GetMapping("/user/register")
    public String Inregister() {
        System.out.println("111");
        return "redirect:/register.html";
    }




    @PostMapping("/user/register")
    public String Register(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           @RequestParam("passwordagain") String passwordagain,
                           Map<String, Object> map) {
        User user = userdao.findUserByUsername(username);
        if(!password.equals(passwordagain)) {
            map.put("msg", "两次输入的密码不一致，请重新输入");
            return "register";
        } else if(user != null) {
            map.put("msg", "该用户名已经注册，请重新输入");
            return "register";
        }
        userdao.insertUser(username,password);
        return "redirect:/login.html";
    }
}

