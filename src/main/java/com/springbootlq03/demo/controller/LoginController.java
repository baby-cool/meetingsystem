package com.springbootlq03.demo.controller;


import com.springbootlq03.demo.dao.Meetingdao;
import com.springbootlq03.demo.dao.Userdao;
import com.springbootlq03.demo.entites.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @Resource
    Meetingdao meetingdao;
    @Resource
    Userdao userdao;

    @GetMapping(value="/user/login")
    public String login(@RequestParam("username") String username,
                         @RequestParam("password") String password,
                         Map<String,Object> map,HttpSession session){

        User user = userdao.findUserByUsername(username);
        if("yw".equals(username) && "123456".equals(password))
            //管理员专属密码
            return "redirect:/meeting.html";
        else if(user != null && user.getPassword().equals(password)) {
            session.setAttribute("user", user);
            System.out.println(user);
            return "redirect:/allmeeting.html";
        } else {
           map.put("msg", "账号或密码输入错误");
            return "login";
        }


    }
}
