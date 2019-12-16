package com.springbootlq03.demo.controller;


import com.springbootlq03.demo.dao.MeetingMemberdao;
import com.springbootlq03.demo.dao.Meetingdao;
import com.springbootlq03.demo.dao.Userdao;
import com.springbootlq03.demo.entites.Meeting;
import com.springbootlq03.demo.entites.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Collection;

@Controller
public class adminController {

    @Resource
    MeetingMemberdao meetingmemberdao;
    @Resource
    Userdao userdao;
    @Resource
    Meetingdao meetingdao;

    @GetMapping("/meeting.html")
    public String meetinglist(HttpSession session) {
        Collection<Meeting> meetingss = meetingdao.findAllMeeting();
        session.setAttribute("meeting4", meetingss);

        System.out.print(meetingss);

        return "meeting";
    }

    @GetMapping("/user.html")
    public String showuser(HttpSession session){
        Collection<User> users=userdao.findAllUser();
        session.setAttribute("user", users);
        System.out.print(users);
        return "user";
    }

    @PostMapping("/meeting.html/{mid}")
    public String Deletemeeting(@PathVariable("mid") Integer mid, HttpSession session) {

        //首先删除会议用户表中的数据
        meetingmemberdao.deleteUMBymid(mid);

        //然后再删除会议表中的数据
        meetingdao.deleteMeetingByMid(mid);

        return "redirect:/meeting.html";
    }
    @PostMapping("/user.html/{uid}")
    public String Deleteuser(@PathVariable("uid") Integer uid,HttpSession session) {

        //首先删除用户信息中的数据
        userdao.deleteUserByNid(uid);

        //然后再删除会议表中的数据
        meetingdao.deleteMeetingByUid(uid);

        //最后删除会议信息表中的数据
        meetingmemberdao.deleteUMByUid(uid);

        return "redirect:/user.html";
    }
}
