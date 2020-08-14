package com.koalait.demo.Mapper;


import com.koalait.demo.Entity.BossConnect;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BossConnectMapper {

    @Insert("INSERT INTO `koalait`.`bossconnect` (`boss_id`, `user_id`, `check`) VALUES (#{boss_id}, #{user_id}, #{check});")
    Integer addBossConnect(BossConnect bossConnect);

    @Select("select `user`.user_name,bossconnect.*,boss.boss_title,boss.price,boss.orderhunter,`checkconnect`.state\n" +
            "from  koalait.boss,koalait.user,koalait.checkconnect,koalait.bossconnect\n" +
            "where bossconnect.check=checkconnect.check and bossconnect.user_id=`user`.user_id and bossconnect.boss_id=boss.boss_id " +
            "and `boss`.user_id=#{user_id}")
    List<BossConnect> findBossByID(Integer user_id);

    @Delete("DELETE FROM `koalait`.`bossconnect` WHERE (`boss_id` = #{boss_id}, `user_id` = #{user_id})")
    Integer delBossConnect(BossConnect bossConnect);

    @Update("UPDATE `koalait`.`bossconnect` SET  `check`=#{check}\n" +
            "WHERE `boss_id` = #{boss_id} and `user_id` = #{user_id}")
    Integer addCheck(BossConnect bossConnect);

}
