package com.koalait.demo.Mapper;


import com.koalait.demo.Entity.HunterConnect;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface HunterConnectMapper {

    @Insert("INSERT INTO `koalait`.`hunterconnect` (`hunter_id`, `user_id`, `check`) VALUES (#{hunter_id}, #{user_id}, #{check});")
    Integer addHunterConnect(HunterConnect hunterConnect);

    @Select("select `user`.user_name,hunterconnect.*,hunter.hunter_title,hunter.salary,hunter.orderboss,`checkconnect`.state\n" +
            "from  koalait.hunter,koalait.user,koalait.checkconnect,koalait.hunterconnect\n" +
            "where hunterconnect.check=checkconnect.check and hunterconnect.user_id=`user`.user_id and hunterconnect.hunter_id=hunter.hunter_id and `hunter`.user_id=#{user_id}")
    List<HunterConnect> findHunterByID(Integer user_id);

    @Delete("DELETE FROM `koalait`.`hunterconnect` WHERE (`hunter_id` = #{hunter_id}, `user_id` = #{user_id})")
    Integer delHunterConnect(HunterConnect hunterConnect);

    @Update("UPDATE `koalait`.`hunterconnect` SET  `check`=#{check}\n" +
            "WHERE `hunter_id` = #{hunter_id} and `user_id` = #{user_id}")
    Integer addCheck(HunterConnect hunterConnect);

}
