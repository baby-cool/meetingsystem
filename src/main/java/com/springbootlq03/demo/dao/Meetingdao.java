package com.springbootlq03.demo.dao;


import com.springbootlq03.demo.entites.Meeting;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface Meetingdao {


    /**
     * 查询所有会议信息
     */
    @Select("SELECT * FROM meeting")
    List<Meeting> findAllMeeting();

    /**
     * 通过会议的mid来查meeting
     */
    @Select("SELECT * FROM meeting WHERE mid = #{mid}")
    Meeting findMeetingByMid(@Param("mid") Integer mid);


    /**
     * 通过会议的uid来查meeting
     */
    @Select("SELECT * FROM meeting WHERE uid = #{uid}")
    List<Meeting> findMeetingByUid(@Param("uid") Integer uid);
    /**
     * 通过会议的munumber来查meeting
     */
    @Select("SELECT * FROM meeting WHERE munumber = #{munumber}")
    Meeting findMeetingByMunumber(@Param("munumber") String munumber);
    /**
     * 插入会议信息
     *
     */
//    private String mid; //会议唯一编号
//    private Integer uid; //创建该会议的用户id
//    private String theme;//会议主题
//    private  String  time;//会议开始时间
//    private String lasttime;//会议总时长
//    private  Integer maxnumber;//会议总人数
//    private  String place;//会议地点
//    private  String  sponor;//会议主办方
//    private  String request;//特殊要求
//    private  Integer munumber;//会议唯一编号
//    private  String mark;//连接数字
    @Options(useGeneratedKeys = true, keyProperty = "mid")
    @Insert("insert into meeting(uid, theme, time, lasttime, maxnumber, place, sponor, request,munumber,mark)" +
            "values(#{uid}, #{theme}, #{time}, #{lasttime}, #{maxnumber}, #{place}, #{sponor}, #{request},#{munumber},#{mark})")
    void InsertMeeting(@Param("uid") Integer uid, @Param("theme") String theme, @Param("time") String time,
                       @Param("lasttime") String lasttime, @Param("maxnumber") String maxnumber,
                       @Param("place") String place, @Param("sponor") String sponor, @Param("request") String request,
                       @Param("munumber") String munumber, @Param("mark") String mark);


    /**
     * 通过 mid在表中删除一条数据
     */
    @Delete("DELETE from meeting WHERE mid = #{mid}")
    void deleteMeetingByMid(@Param("mid") Integer mid);

    /**
     * 通过 uid在表中删除一条数据
     */
    @Delete("DELETE from meeting WHERE uid = #{uid}")
    void deleteMeetingByUid(@Param("uid") Integer uid);

}
