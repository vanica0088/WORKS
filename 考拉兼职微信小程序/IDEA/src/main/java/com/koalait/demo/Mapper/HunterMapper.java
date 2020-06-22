package com.koalait.demo.Mapper;

import com.koalait.demo.Entity.BossInfo;
import com.koalait.demo.Entity.HunterInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface HunterMapper {
    //查找所有的求职
    @Select("SELECT * FROM `hunter` where checkstate=0 order by hunter_id desc")
    List<HunterInfo> findHunterInfo();

    //新增求职
    @Insert("INSERT INTO `koalait`.`hunter` (`user_id`,`capacity`, `hunter_detail`, `salary`, `company`, `hunter_state`, `hunter_title`, `work_time`, `daily_wage`,`checkstate`) " +
            "VALUES (#{user_id}, #{capacity}, #{hunter_detail}, #{salary}, #{company}, #{hunter_state}, #{hunter_title}, #{work_time}, #{daily_wage}, #{checkstate});")
    Integer addHunterInfo(HunterInfo hunterInfo);

    //修改求职：取值
    @Select("select * from hunter where hunter_id = #{hunter_id}")
    HunterInfo findHunterInfoByID(Integer hunter_id);

    //修改求职
    @Update("UPDATE `koalait`.`hunter` SET  `capacity`= #{capacity}, `hunter_detail` = #{hunter_detail}, `salary` = #{salary}, `company` = #{company}, `hunter_state` = #{hunter_state}, `hunter_title` = #{hunter_title}, `work_time` = #{work_time}, `daily_wage` = #{daily_wage} WHERE (`hunter_id` = #{hunter_id});")
    Integer updateHunterInfoByID(HunterInfo hunterInfo);

    //删除求职
    @Delete("DELETE FROM `koalait`.`boss` WHERE (`hunter_id` = #{hunter_id});")
    Integer delHunterInfoByID(Integer hunter_id);

    //添加预约状态
    @Update("UPDATE `koalait`.`hunter` SET  `orderboss`= #{orderboss} WHERE (`hunter_id` = #{hunter_id});")
    Integer orderHunterInfoByID(HunterInfo hunterInfo);

    //查找我预约的求职
    @Select("select hunter.*,`user`.user_name\n" +
            "from koalait.user join koalait.hunter on hunter.user_id=`user`.user_id\n" +
            "where hunter.user_id=`user`.user_id and `user`.user_id=#{user_id}")
    List<HunterInfo> getHunterByUser(Integer user_id);

    @Select("SELECT hunter.*,hunterconnect.`check`,checkconnect.state\n" +
            "from koalait.hunter,koalait.hunterconnect,koalait.checkconnect\n" +
            "where hunter.hunter_id=hunterconnect.hunter_id and checkconnect.`check`=hunterconnect.`check` \n" +
            "and hunterconnect.user_id = #{user_id}")
    List<HunterInfo> findHunterInfoByOrder(Integer user_id);

    //查找预约我的求职
    @Select("select *\n" +
            "from koalait.hunter,koalait.user\n" +
            "where orderboss IS not NULL and hunter.user_id=`user`.user_id")
    List<HunterInfo> getHunterInfoByOrder(Integer user_id);





    //WEB
    @Select("select hunter.*,`user`.user_name\n" +
            "from koalait.user join koalait.hunter on hunter.user_id=`user`.user_id  order by create_time desc")
    List<HunterInfo> getHunter (Integer pageSize,Integer hunter_id);    //回显

    @Select("select hunter.*,`user`.user_name\n" +   //查询回显用户名
            "from koalait.user join koalait.hunter on hunter.user_id=`user`.user_id where hunter_id=#{hunter_id}")
    List<HunterInfo> getHunterByID(Integer pageIndex,Integer pageSize,Integer hunter_id);

    @Delete("DELETE FROM hunter WHERE hunter_id=#{hunter_id}")
    Integer delhunterByID(Integer hunter_id);

    @Select("select hunter.*,`user`.user_name\n" +     //详细回显
            "from koalait.user join koalait.hunter on hunter.user_id=`user`.user_id where hunter_id=#{hunter_id}")
    HunterInfo gethuByID(Integer hunter_id);




    //审核hunter
    @Select("select *\n" +
            "from koalait.`hunter`\n" +
            "where `hunter`.checkstate=1 order by create_time desc")
    List<HunterInfo> getAllHunter();

    @Select("select * from koalait.hunter where hunter_id=#{hunter_id}")
    HunterInfo getHunterByid(Integer hunter_id);

    @Update("update koalait.hunter \n" +
            "set `hunter`.checkstate=0\n" +
            "where hunter.checkstate=1 and hunter_id=#{hunter_id}")
    Integer updateHunterByID(HunterInfo hunterInfo);

    @Update(" update koalait.hunter \n" +
            " set `hunter`.checkstate='1'\n" +
            " where `hunter`.checkstate=1 and hunter_id=#{hunter_id}")
    Integer updateHunter(HunterInfo hunterInfo);



}
