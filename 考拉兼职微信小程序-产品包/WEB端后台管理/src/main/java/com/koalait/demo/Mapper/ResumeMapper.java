package com.koalait.demo.Mapper;

import com.koalait.demo.Entity.Resume;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ResumeMapper {


    //新增简历
    @Insert("INSERT INTO `koalait`.`resume` (`resume_id`,`name`, `education`, `self_introduction`, `phone`, `email`) " +
            "VALUES (#{resume_id}, #{name}, #{education}, #{self_introduction}, #{phone}, #{email});")
    Integer addResumeInfo(Resume resume);

    //修改/查看简历,取值
    @Select("select * from resume where resume_id = #{resume_id}")
    Resume findResumeByID(Integer resume_id);

    @Update("UPDATE `koalait`.`resume` SET  `name`= #{name}, `education` = #{education}, `self_introduction` = #{self_introduction}, `phone` = #{phone}, `email` = #{email}" +
            "WHERE (`resume_id` = #{resume_id});")
    Integer updResumeByID(Resume resume);

    @Select("select resume.*,`user`.user_id,`user`.user_name\n" +
            "from koalait.`user`\n" +
            "join koalait.resume on `user`.resume_id=resume.resume_id\n" +
            "where `user`.user_name=#{user_name};")
    Resume findResumeByName(String user_name);
}
