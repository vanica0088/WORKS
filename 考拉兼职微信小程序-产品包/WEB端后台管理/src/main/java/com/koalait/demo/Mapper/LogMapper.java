package com.koalait.demo.Mapper;

import com.koalait.demo.Entity.LogInfo;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Select;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Mapper
public interface LogMapper {

    //从数据库取所有用户日志数据
    @Select("SELECT sys_log.*,user.`user_name` FROM koalait.user join koalait.sys_log on sys_log.user_id=user.user_id" )
    List<LogInfo> getAllLog(Integer pageIndex, Integer pageSize);

    //根据id和姓名查询用户日志
    @Select("SELECT sys_log.*,user.`user_name`\n" +
            "FROM koalait.user\n" +
            "join koalait.sys_log on sys_log.user_id=user.user_id\n" +
            "where sys_log.user_id=#{user_id} and user_name like '%${user_name}%'")
    List<LogInfo> getLogByIDName(Integer pageIndex, Integer pageSize,String user_name);

    //根据id查询用户日志
    @Select("SELECT sys_log.*,user.`user_name` FROM koalait.user join koalait.sys_log on sys_log.user_id=user.user_id where `user`.user_id=#{user_id}")
    List<LogInfo> getLogByID(Integer pageIndex, Integer pageSize, String user_name);

    //根据姓名查询日志
    @Select("SELECT sys_log.*,user.`user_name` FROM koalait.user join koalait.sys_log on sys_log.user_id=user.user_id where user.user_name like '%${user_name}%'")
    List<LogInfo> getLogByDateName(Integer PageIndex, Integer PageSize, String user_name,Date CreateDate);

    //插入一条日志信息
    @Insert("INSERT INTO sys_log \n" +
            "(user_id,IP_Address,OS,IE,CreatDate)" +
            "VALUE(#{user_id)},#{IP_Address},#{OS},#{IE},sysdate())")
    Integer addLog(LogInfo logInfo);
}

