package com.springbootlq03.demo.entites;

public class Meeting {
     private Integer mid; //会议唯一编号
     private Integer uid; //创建该会议的用户id
     private String theme;//会议主题
     private  String  time;//会议开始时间
     private String lasttime;//会议总时长
     private  String maxnumber;//会议总人数
     private  String place;//会议地点
     private  String  sponor;//会议主办方
     private  String request;//特殊要求
    private  String munumber;//会议唯一编号
    private  String mark;//连接数字

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLasttime() {
        return lasttime;
    }

    public void setLasttime(String lasttime) {
        this.lasttime = lasttime;
    }

    public String getMaxnumber() {
        return maxnumber;
    }

    public void setMaxnumber(String maxnumber) {
        this.maxnumber = maxnumber;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getSponor() {
        return sponor;
    }

    public void setSponor(String sponor) {
        this.sponor = sponor;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getMunumber() {
        return munumber;
    }

    public void setMunumber(String munumber) {
        this.munumber = munumber;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "mid=" + mid +
                ", uid=" + uid +
                ", theme='" + theme + '\'' +
                ", time='" + time + '\'' +
                ", lasttime='" + lasttime + '\'' +
                ", maxnumber='" + maxnumber + '\'' +
                ", place='" + place + '\'' +
                ", sponor='" + sponor + '\'' +
                ", request='" + request + '\'' +
                ", munumber='" + munumber + '\'' +
                ", mark='" + mark + '\'' +
                '}';
    }
}

