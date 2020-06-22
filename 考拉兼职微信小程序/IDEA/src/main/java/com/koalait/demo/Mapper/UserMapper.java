package com.koalait.demo.Mapper;

import com.koalait.demo.Entity.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {
    //登入验证
    @Select("SELECT * FROM koalait.user WHERE password = #{password} AND user_name= #{user_name}")
    Integer userLogin(String password, String user_name);

    //查找用户信息
    @Select("select * from user where user_id = #{user_id}")
    UserInfo findUserByID(Integer user_id);

    //修改用户信息
    @Update("UPDATE `koalait`.`user` SET  `user_name`= #{user_name}, `password` = #{password}, `img_url` = #{img_url}, `birthday` = #{birthday}, `checkstate` = #{checkstate}, `user_sex` = #{user_sex}, `region` = #{region} " +
            "WHERE (`user_id` = #{user_id});")
    Integer updUserInfo(UserInfo userInfo);

    //关联user表和resume表
    @Update("UPDATE `koalait`.`user` SET  `resume_id`= #{resume_id}" +
            "            WHERE (`user_id` = #{user_id})")
    Integer updresumeInfo(UserInfo userInfo);

    //注册
    @Insert("INSERT INTO `koalait`.`user` (`user_name`, `password`) VALUES (#{user_name}, #{password});")
    Integer register(UserInfo userInfo);






    //WEB
    @Select("select * from koalait.user where password=='234' and user_id =='1'")
    UserInfo UserLogin(Integer user_id, String password);//登陆
    //以下为审核用户操作
    @Select("select *\n" +
            "from koalait.`user` where checkstate=1\n")
    List<UserInfo> getAllUser();

    @Select("select * from koalait.user where user_id=#{user_id}")
    UserInfo getUserByid(Integer user_id);

    @Update("update koalait.user \n" +
            "set `user`.checkstate='0'\n" +
            "where user.user_id=#{user_id} and user.checkstate=1")
    Integer updateUserByID(UserInfo userInfo);

    @Update(" update koalait.user \n" +
            " set `user`.checkstate='1'\n" +
            " where user.user_id=#{user_id} and user.checkstate=1")
    Integer updateUser(UserInfo userInfo);

}
