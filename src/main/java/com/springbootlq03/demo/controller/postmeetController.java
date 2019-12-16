package com.springbootlq03.demo.controller;

import com.springbootlq03.demo.dao.Meetingdao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class postmeetController {

    @Resource
    Meetingdao meetingdao;
    /*@RequestParam("workplace") String workplace*/

//                <!--            private String meetingname;     //会议的名字-->
//            <!--            private String meetingtime;     //会议开始的时间-->
//            <!--            private String meetingplace;    //会议举行的地点-->
//            <!--            private String meetingdescribe; //会议内容-->
//            <!--            private String pernum;          //会议可以容纳的人数-->
////            <!--            private Integer createid;       //创建该会议的用户的唯一标识号码-->

//            <!--            private String youqiu;          //报名此会议的可选项-->

//                    <!--        private String realname    //真实名字-->
//                <!--            private String sex         //性别-->
//                <!--            private String numberid;   //身份证号码，规定为18位数-->
//                <!--            private String phone;      //电话号码，规定为11位数-->
//                <!--            private String workplace;  //工作地点-->
//                <!--            private String needroom;   //参加会议的时,是否需要房间-->



    @GetMapping("/postmeeting.html")
    public String gotopost() {
        return "postmeeting";
    }

    @PostMapping("/postmeeting.html/{uid}")
    public String Inregister(@PathVariable("uid") Integer uid, @RequestParam("theme") String theme,
                             @RequestParam("time") String time,@RequestParam("lasttime") String lasttime,
                             @RequestParam("maxnumber") String maxnumber,@RequestParam("place") String place,
                             @RequestParam("sponor") String sponor, @RequestParam("request") String request,
                             @RequestParam("name") String name, @RequestParam("sex") String sex,
                             @RequestParam("idnumber") String idnumber, @RequestParam("attedtime") String attedtime,
                             @RequestParam("isneedroom") String isneedroom, HttpSession session) {

        String yaoqiu = new String();

        //name
        int iIndex = 0;
        if(name.indexOf("1") != -1) {
            for (int i = 0; i < name.length(); i++) {
                if (name.charAt(i) == '1' || name.charAt(i) == ',') {
                    if (i > 0) {
                        yaoqiu += name.substring(iIndex, i);
                    }
                    iIndex = i + 1;
                }
            }
            if (iIndex <= name.length()) {
                yaoqiu += name.substring(iIndex, name.length());
            }
            yaoqiu += "_";
        } else {
            yaoqiu += "null_";
        }



        //sex
        iIndex = 0;
        if(sex.indexOf("1") != -1) {
            for (int i = 0; i < sex.length(); i++) {
                if (sex.charAt(i) == '1' || sex.charAt(i) == ',') {
                    if (i > 0) {
                        yaoqiu += sex.substring(iIndex, i);
                    }
                    iIndex = i + 1;
                }
            }
            if (iIndex <= sex.length()) {
                yaoqiu += sex.substring(iIndex, sex.length());
            }
            yaoqiu += "_";
        } else {
            yaoqiu += "null_";
        }


        //idnumber
        iIndex = 0;
        if(idnumber.indexOf("1") != -1) {
            for (int i = 0; i < idnumber.length(); i++) {
                if (idnumber.charAt(i) == '1' || idnumber.charAt(i) == ',') {
                    if (i > 0) {
                        yaoqiu += idnumber.substring(iIndex, i);
                    }
                    iIndex = i + 1;
                }
            }
            if (iIndex <= idnumber.length()) {
                yaoqiu += idnumber.substring(iIndex, idnumber.length());
            }
            yaoqiu += "_";
        } else {
            yaoqiu += "null_";
        }

        //attedtime
        iIndex = 0;
        if(attedtime.indexOf("1") != -1) {
            for (int i = 0; i < attedtime.length(); i++) {
                if (attedtime.charAt(i) == '1' || attedtime.charAt(i) == ',') {
                    if (i > 0) {
                        yaoqiu += attedtime.substring(iIndex, i);
                    }
                    iIndex = i + 1;
                }
            }
            if (iIndex <= attedtime.length()) {
                yaoqiu += attedtime.substring(iIndex, attedtime.length());
            }
            yaoqiu += "_";
        } else {
            yaoqiu += "null_";
        }

        //isneedroom
        iIndex = 0;
        if(isneedroom.indexOf("1") != -1) {
            for (int i = 0; i < isneedroom.length(); i++) {
                if (isneedroom.charAt(i) == '1' || isneedroom.charAt(i) == ',') {
                    if (i > 0) {
                        yaoqiu += isneedroom.substring(iIndex, i);
                    }
                    iIndex = i + 1;
                }
            }
            if (iIndex <= isneedroom.length()) {
                yaoqiu += isneedroom.substring(iIndex, isneedroom.length());
            }
            yaoqiu += "_";
        } else {
            yaoqiu += "null_";
        }




        System.out.println(yaoqiu);

        Date tmp = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String munum = formatter.format(tmp);
        StringBuilder strBuilder = new StringBuilder(munum);
        for(int i = 0; i < strBuilder.length();) {
            if(!(strBuilder.charAt(i) >= '0' && strBuilder.charAt(i) <= '9')) {
                for(int j = i ; j < strBuilder.length() - 1; j ++)
                    strBuilder.setCharAt(j, strBuilder.charAt(j + 1));
            } else i ++;
        }
        munum = strBuilder.toString();
        System.out.println(munum);
        System.out.println(yaoqiu);
        meetingdao.InsertMeeting(uid, theme, time, lasttime, maxnumber, place, sponor,request, munum,yaoqiu);
        return "redirect:/allmeeting.html";
    }
}
