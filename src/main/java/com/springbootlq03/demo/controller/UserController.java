package com.springbootlq03.demo.controller;

import com.springbootlq03.demo.dao.MeetingMemberdao;
import com.springbootlq03.demo.dao.Meetingdao;
import com.springbootlq03.demo.entites.Meeting;
import com.springbootlq03.demo.entites.MeetingMember;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
public class UserController {
    @Resource
    Meetingdao meetingdao;

    @Resource
    MeetingMemberdao meetingmemberdao;

    @GetMapping("/allmeeting.html")
    public String allmeetinglist(HttpSession session) {
        Collection<Meeting> meetingss = meetingdao.findAllMeeting();
        session.setAttribute("meeting1", meetingss);
//        model.setAttribute("meetings", meetingss);
//        System.out.println("111");
        System.out.print(meetingss);

        return "allmeeting";
    }

    @GetMapping("/add")
    public String allmeetinglist(HttpServletRequest request,HttpSession session) {
        Collection<Meeting> meetingss = meetingdao.findAllMeeting();
        session.setAttribute("meeting1", meetingss);
//        model.setAttribute("meetings", meetingss);
//        System.out.println("111");
        System.out.print(meetingss);

        return "allmeeting";
    }


    @GetMapping("/myattendmeeting.html/{uid}")
    public String myattendmeetinglist(@PathVariable("uid") Integer uid, HttpSession session) {
        Collection<MeetingMember> attendmeeting1 = meetingmemberdao.findByUid(uid);
        session.setAttribute("meetingmember1", attendmeeting1);
        System.out.print(attendmeeting1);
        return "myattendmeeting";
    }

    @GetMapping("/abc.html/{uid}")
    public String mycreatemeetinglist(@PathVariable("uid") Integer uid, HttpSession session) {
        Collection<Meeting> mycreatemeetings = meetingdao.findMeetingByUid(uid);
        session.setAttribute("a", mycreatemeetings);
        System.out.print(mycreatemeetings);
        return "abc";
    }



    @GetMapping("/a.html/{mid}")
    public String myattendmeeting2list(@PathVariable("mid") Integer mid, HttpSession session) {
        Meeting attendmeeting2 = meetingdao.findMeetingByMid(mid);
        session.setAttribute("meeting3", attendmeeting2);
        System.out.print(attendmeeting2);
        return "a";
    }

    @PostMapping("/a.html")
    public String myattendmeeting2list(@RequestParam("bianhao") String bianhao, HttpSession session) {

        Meeting attendmeeting2 = meetingdao.findMeetingByMunumber(bianhao);
        session.setAttribute("meeting1", attendmeeting2);
        System.out.print(attendmeeting2);
        return "allmeeting";
    }

    @GetMapping("/b.html/{mid}")
    public String mycreatemeeting2list(@PathVariable("mid") Integer mid, HttpSession session) {
        Collection<MeetingMember> mycreatemeeting2 = meetingmemberdao.findByMid(mid);

        Meeting meeting = meetingdao.findMeetingByMid(mid);
        String munumber=meeting.getMunumber();
        session.setAttribute("munumbers", munumber);
        System.out.println(munumber);

        //生成要求的字符串数组
        String[] sqlite = meeting.getMark().split("_");
        List<String> marks = new ArrayList<>();
        for (int i = 0; i < sqlite.length; i++)
            marks.add(sqlite[i]);
        session.setAttribute("marks", marks);
        System.out.println(marks);
        session.setAttribute("meetingmember2", mycreatemeeting2);
        System.out.print(mycreatemeeting2);

        return "b";
    }
//<form method="post" th:action="@{/myattendmeeting.html/}+${emp2.mid}">
//                                <button type="submit" class="btn btn-sm btn-danger">删除</button>
//                            </form>
    @PostMapping("/myattendmeeting.html/{mid}")
    public String Deletemyattendmeeting(@PathVariable("mid") Integer mid) {

        //删除会议用户表中的数据
        meetingmemberdao.deleteUMBymid(mid);
        return "myattendmeeting";
    }


    //删除
    @PostMapping("/abc.html/{mid}")
    public String Deletemycreatemeeting(@PathVariable("mid") Integer mid) {

        //首先删除会议用户表中的数据
        meetingmemberdao.deleteUMBymid(mid);

        //然后再删除会议表中的数据
        meetingdao.deleteMeetingByMid(mid);


        return "abc";
    }

}