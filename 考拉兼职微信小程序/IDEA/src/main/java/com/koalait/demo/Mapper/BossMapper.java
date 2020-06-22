package com.koalait.demo.Mapper;

import com.koalait.demo.Entity.BossInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BossMapper {
    //查找工作
    @Select("SELECT * FROM `boss` where checkstate=0 order by boss_id desc")
    List<BossInfo> findBossInfo();

    //条件查找工作
    @Select("SELECT *\n" +
            "from koalait.boss\n" +
            "where boss_title like #{boss_title} order by boss_id desc")
    List<BossInfo> searchBossInfo(String boss_title);

    //新增工作
    @Insert("INSERT INTO `koalait`.`boss` (`user_id`, `price`, `boss_title`,`boss_detail`, `limited_time`,`create_time`,`checkstate`) " +
            "VALUES (#{user_id}, #{price}, #{boss_title}, #{boss_detail}, #{limited_time}, now(), #{checkstate});")
    Integer addBossInfo(BossInfo bossInfo);

    //修改工作：取值
    @Select("select * from boss where boss_id = #{boss_id}")
    BossInfo findBossInfoByID(Integer boss_id);

    //修改工作
    @Update("UPDATE `koalait`.`boss` SET  `boss_title`= #{boss_title}, `boss_detail`= #{boss_detail}, `limited_time`= #{limited_time}, `price` = #{price} WHERE (`boss_id` = #{boss_id});")
    Integer updateBossInfoByID(BossInfo bossInfo);

    //删除工作
    @Delete("DELETE FROM `koalait`.`boss` WHERE (`boss_id` = #{boss_id});")
    Integer delBossInfoByID(Integer boss_id);



    //预约工作
    @Update("UPDATE `koalait`.`boss` SET  `orderhunter`= #{orderhunter} WHERE (`boss_id` = #{boss_id});")
    Integer orderBossInfoByID(BossInfo bossInfo);


    @Select("select boss.*,`user`.user_name\n" +
            "from koalait.user join koalait.boss on boss.user_id=`user`.user_id\n" +
            "where boss.user_id=`user`.user_id and `user`.user_id=#{user_id}")
    List<BossInfo> getBossByUser(Integer user_id);

    //查找我预约的工作
    @Select("SELECT boss.*,bossconnect.`check`,checkconnect.state\n" +
            "from koalait.boss,koalait.bossconnect,koalait.checkconnect\n" +
            "where boss.boss_id=bossconnect.boss_id and checkconnect.`check`=bossconnect.`check` " +
            "and bossconnect.user_id = #{user_id}")
    List<BossInfo> findBossInfoByOrder(Integer user_id);

    //查找预约我的工作
    @Select("select *\n" +
            "from koalait.boss,koalait.user\n" +
            "where orderhunter IS not NULL and boss.user_id=`user`.user_id\n")
    List<BossInfo> getBossInfoByOrder(Integer user_id);





//    WEB
//    @Select("select boss.*,`user`.user_name\n" +     //回显
//            "from koalait.user join koalait.boss on boss.user_id=`user`.user_id")
//    List<BossInfo> getAllboss();
@Select("select boss.*,`user`.user_name\n" +     //回显
        "from koalait.user join koalait.boss on boss.user_id=`user`.user_id  order by create_time desc")
List<BossInfo> getBoss (Integer pageSize,Integer boss_id);

    @Select("select boss.*,`user`.user_name\n" +     //查询时回显
            "from koalait.user join koalait.boss on boss.user_id=`user`.user_id where boss_id=#{boss_id}")
    List<BossInfo> getbossByID (Integer pageIndex,Integer pageSize,Integer boss_id);

    @Delete("DELETE FROM boss WHERE boss_id=#{boss_id}")// 删除记录
    Integer delbossByID(Integer boss_id);

    @Select("select boss.*,`user`.user_name\n" +     //查询时回显
            "from koalait.user join koalait.boss on boss.user_id=`user`.user_id where boss_id=#{boss_id}")
    BossInfo getboByID(Integer boss_id);




    //以下为审核boss操作
    @Select("select *\n" +
            "from koalait.`boss` where checkstate=1  order by create_time desc")
    List<BossInfo> getAllboss();

    @Select("select * from koalait.boss where boss_id=#{boss_id}")
    BossInfo getBossByid(Integer boss_id);

    @Update("update koalait.boss \n" +
            "set `boss`.checkstate='0'\n" +
            "where boss.boss_id=#{boss_id} and boss.checkstate=1 ")
    Integer updateBossByID(BossInfo bossInfo);

    @Update(" update koalait.boss \n" +
            " set `boss`.checkstate='1'\n" +
            " where boss.boss_id=#{boss_id} and boss.checkstate=1")
    Integer updateBoss(BossInfo bossInfo);
}
