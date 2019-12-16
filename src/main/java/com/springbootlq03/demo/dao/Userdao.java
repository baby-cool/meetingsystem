package com.springbootlq03.demo.dao;

import com.springbootlq03.demo.entites.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface Userdao {


    @Options(useGeneratedKeys = true, keyProperty = "uid")
    @Insert("insert into user(username,password) " +
            "values(#{username},#{password} )")
    void insertUser(@Param("username") String username,@Param("password") String password);

    /**
     * 通过用户名查询用户信息，返回User对象
     *
     */
    @Select("SELECT * FROM user WHERE username = #{username}")
    User findUserByUsername(@Param("username") String username);

    /**
     * 通过id查询用户信息，返回User对象
     */
    @Select("SELECT * FROM user WHERE uid = #{uid}")
    User findUserById(@Param("uid") Integer uid);

    /**
     * 查询所有用户信息
     */
    @Select("SELECT * FROM user")
    List<User> findAllUser();

    /**
     * 通过 uid在表中删除多条数据
     */
    @Delete("DELETE from user WHERE uid = #{uid}")
    void deleteUserByNid(@Param("uid") Integer uid);

}