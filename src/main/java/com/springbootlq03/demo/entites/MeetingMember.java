package com.springbootlq03.demo.entites;

public class MeetingMember {
    private Integer muid;           //会议成员信息的唯一号码
    private Integer mid;        //参加的会议的唯一表示号码
    private Integer uid;      //参加该会议用户的id
    private String name;      //姓名
    private String sex;      //性别
    private String idnumber;   //身份证号码，规定为18位数
    private String attendtime;   //参会时间
    private String isneedroom; //判断参加会议的时候，是否需要房间

    public Integer getMuid() {
        return muid;
    }

    public void setMuid(Integer muid) {
        this.muid = muid;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public String getAttendtime() {
        return attendtime;
    }

    public void setAttendtime(String attendtime) {
        this.attendtime = attendtime;
    }

    public String getIsneedroom() {
        return isneedroom;
    }

    @Override
    public String toString() {
        return "MeetingMember{" +
                "muid=" + muid +
                ", mid=" + mid +
                ", uid=" + uid +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", idnumber='" + idnumber + '\'' +
                ", attendtime='" + attendtime + '\'' +
                ", isneedroom='" + isneedroom + '\'' +
                '}';
    }

    public void setIsneedroom(String isneedroom) {
        this.isneedroom = isneedroom;

    }
}
