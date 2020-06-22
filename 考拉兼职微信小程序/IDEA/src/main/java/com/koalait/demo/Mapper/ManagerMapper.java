package com.koalait.demo.Mapper;

import com.koalait.demo.Entity.BossInfo;
import com.koalait.demo.Entity.ManagerInfo;
import com.koalait.demo.Entity.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

import static jdk.nashorn.internal.parser.TokenType.CASE;

@Mapper
public interface ManagerMapper {
//    @Select("select * from koalait.user")
////页面显示所有用户信息
//    List<ManagerInfo> getAlluser();
//    @Insert("insert into koalait.user(user_id,user_name,img_url,password)\n" +
//            "values(#{user_id},#{user_name},#{img_url},#{password});")
//    Integer saveUser(ManagerInfo user);  //添加新用户
//    @Select("select * from koalait.user where password=#{password} and user_id =#{user_id}")
//    UserInfo userLogin(String user_id, String password);//登陆
    @Select("select * from koalait.user where password=='234' and user_id =='1'")
    UserInfo userLogin(Integer user_id, String password);//登陆

    @Select("select * from user where user_id=#{user_id}")
        //按照id进行相关查询
    List<ManagerInfo> getUserByID(Integer pageIndex, Integer pageSize, Integer user_id);

    @Select("select * from user")
    List<ManagerInfo> getUser(Integer pageSize, Integer user_id);

    @Delete("DELETE FROM user WHERE (user_id=#{user_id})")
        //删除操作
    Integer delUserByID(Integer user_id);


    //main页面回显
    @Select("SELECT count(hunter_title)\n" +
            "from koalait.hunter")
    Integer hu();

    @Select("SELECT count(boss_title)\n" +
            "from koalait.boss")
    Integer bos();

    @Select("select count(`user`.user_sex)\n" +   //性别
            "from koalait.user\n" +
            "where `user`.user_sex=1")
    Integer male();

    @Select("select count(`user`.user_sex)\n" +
            "from koalait.user\n" +
            "where `user`.user_sex=0")
    Integer female();      //性别


    //以下为图表
    @Select("select \n" +   //柱形图
            "COUNT(boss_title) as number \n" +
            "from koalait.boss \n" +
            "group by \n" +
            "CASE \n" +
            "when limited_time>=1 and limited_time<=30 then '工时限制在1-30天' \n" +
            "when limited_time>30 and limited_time<=60 then '工时限制在30-60天' \n" +
            "when limited_time>60 and limited_time<=90 then '工时限制在60-90天' \n" +
            "end;"
    )
    List<Integer> getBossTimeByTitle();   //横向柱形图

    @Select("select COUNT(hunter_title) from koalait.hunter where work_time>0 and work_time<=3")
    Integer firsttime();

    @Select("select COUNT(hunter_title) from koalait.hunter where work_time>3 and work_time<=5\n")
    Integer secondtime();

    @Select("select COUNT(hunter_title) from koalait.hunter where work_time>5 and work_time<=8\n")
    Integer thirdtime();

    @Select("select COUNT(hunter_title) from koalait.hunter where work_time>8 and work_time<=10\n")
    Integer forthtime();

    @Select("select COUNT(hunter_title) from koalait.hunter where work_time>10 and work_time<=15\n")
    Integer fifthtime();


    @Select("select \n" +            //以下为折线图
            "COUNT(boss_title) as number \n" +
            "from koalait.boss \n" +
            "group by \n" +
            "CASE \n" +
            "when daily_wage>=0 and  daily_wage<=500 then '日薪为0-500元' \n" +
            "when daily_wage>500 and  daily_wage<=1000 then '日薪为500-1000元' \n" +
            "when daily_wage>1000 and  daily_wage<=1500 then '日薪为1000-1500元' \n" +
            "when daily_wage>1500 and  daily_wage<=2000 then '日薪为1500-2000元' \n" +
            "end;"
    )
    List<Integer> getBossWageByTitle();

//    @Select("select count(`user`.user_sex=1)\n" +   //性别
//            "from koalait.user\n" +
//            "where `user`.user_sex=1")
//    Integer male();
//    @Select("select count(`user`.user_sex=1)\n" +
//            "from koalait.user\n" +
//            "where `user`.user_sex=0")
//    Integer female();


    //饼图
    @Select("select COUNT(boss_title) from koalait.boss where daily_wage>=500 and  daily_wage<=900 ")
    Integer miniwage();

    @Select("select COUNT(boss_title) from koalait.boss where daily_wage>=900 and  daily_wage<=1300 \n")
    Integer mediumwage();

    @Select("select COUNT(boss_title) from koalait.boss where daily_wage>=1300 and  daily_wage<=1700")
    Integer maxwage();

    @Select("select COUNT(boss_title) from koalait.boss where daily_wage>=1700 and  daily_wage<=2100 \n")
    Integer topwage();
}

