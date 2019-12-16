package com.springbootlq03.demo.controller;

import com.springbootlq03.demo.dao.MeetingMemberdao;
import com.springbootlq03.demo.dao.Meetingdao;
import com.springbootlq03.demo.entites.Meeting;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
@Controller
public class addController {
    @Resource
    Meetingdao meetingdao;
    @Resource
    MeetingMemberdao meetingmemberdao;


    @GetMapping("/user/add.html/{mid}")
    public String add(@PathVariable("mid") Integer mid, HttpSession session) {
        Meeting meeting = meetingdao.findMeetingByMid(mid);
        session.setAttribute("mids", mid);
        //生成要求的字符串数组
        String[] sqlite = meeting.getMark().split("_");
        List<String> markss = new ArrayList<>();
        for (int i = 0; i < sqlite.length; i++)
            markss.add(sqlite[i]);
        session.setAttribute("markss", markss);
        System.out.println(markss);

        return "add";
    }



//    <!--                private String name;      //姓名-->
//<!--                private Integer sex;      //性别-->
//<!--                private String idnumber;   //身份证号码，规定为18位数-->
//<!--                private String attedtime;   //参会时间-->
//<!--                private Integer isneedroom; //判断参加会议的时候，是否需要房间-->

@PostMapping("/add.html")
public String insert(@RequestParam("name") String name,
                       @RequestParam("sex") String sex,
                       @RequestParam("idnumber") String idnumber,
                       @RequestParam("attendtime") String attendtime,
                       @RequestParam("isneedroom") String isneedroom,
                     @RequestParam("uid") Integer uid,
                     @RequestParam("mid") Integer mid,
                       HttpServletRequest request, HttpSession session) {
//    String uids = request.getParameter("uid");
//    String mids = request.getParameter("uid");
//    Integer mid = Integer.valueOf(mids);
//    Integer uid = Integer.valueOf(uids);
    System.out.println(uid);
    System.out.println(mid);
    System.out.println(name);
    System.out.println(sex);
    System.out.println(idnumber);
    System.out.println(attendtime);
    System.out.println(isneedroom);



//    Meeting meeting = meetingdao.findMeetingByMid(mid);

   meetingmemberdao.insertmeetingmember( mid,uid,name,sex,idnumber,attendtime,isneedroom);
    return "redirect:/allmeeting.html";
}

    }