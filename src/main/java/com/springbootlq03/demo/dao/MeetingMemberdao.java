package com.springbootlq03.demo.dao;
import com.springbootlq03.demo.entites.MeetingMember;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MeetingMemberdao {

    /**
     * 通过  uid 在表中查询该用户所参加的会议
     */
    @Select("SELECT * FROM meetingmember WHERE uid = #{uid} ")
    List<MeetingMember> findByUid(@Param("uid") Integer uid);

    /**
     * 通过  mid 在表中查询该会议的成员
     */
    @Select("SELECT * FROM meetingmember WHERE mid = #{mid} ")
    List<MeetingMember> findByMid(@Param("mid") Integer mid);

    /**
     * 通过 mid 和 uid 在表中查询一条数据
     */
    @Select("SELECT * FROM meetingmember WHERE uid = #{uid} and mid = #{mid}")
    MeetingMember findByUM(@Param("ud") Integer uid, @Param("mid") Integer mid);


    /**
     * 向meetingmember表中插入数据
     */
//    private Integer muid;           //会议成员信息的唯一号码
//    private Integer mid;        //参加的会议的唯一表示号码
//    private Integer munumber;   //会议唯一编号
//    private Integer uid;      //参加该会议用户的id
//    private String name;      //姓名
//    private String sex;      //性别
//    private String idnumber;   //身份证号码，规定为18位数
//    private String attedtime;   //参会时间
//    private String isneedroom; //判断参加会议的时候，是否需要房间
//    private  String mark;       //连接数字
    @Options(useGeneratedKeys = true, keyProperty = "muid")
    @Insert("insert into meetingmember(mid,uid,name,sex,idnumber,attendtime,isneedroom) values(#{mid},#{uid},#{name},#{sex},#{idnumber},#{attendtime},#{isneedroom})")
    void insertmeetingmember(@Param("mid") Integer mid,
                  @Param("uid") Integer uid,@Param("name") String name,
                  @Param("sex") String sex,@Param("idnumber") String idnumber,
                  @Param("attendtime") String attendtime,@Param("isneedroom") String isneedroom);

    /**
     * 通过 mid在表中删除多条数据
     */
    @Delete("DELETE from meetingmember WHERE mid = #{mid}")
    void deleteUMBymid(@Param("mid") Integer mid);

    /**
     * 通过 uid在表中删除多条数据
     */
    @Delete("DELETE from meetingmember WHERE uid = #{uid}")
    void deleteUMByUid(@Param("uid") Integer uid);



}