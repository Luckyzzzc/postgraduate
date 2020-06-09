package com.example.postgraduate.Dao;

import com.example.postgraduate.POJO.School;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SchoolMapper {
    @Insert("INSERT INTO `postgraduate`.`school` (`school_name`, `school_tag`, `province_id`) VALUES (#{school_name}, #{school_tag}, #{province_id});")
    boolean addSchool(School school);

    @Delete("DELETE FROM `postgraduate`.`school` WHERE `school`.`school_id` = #{school_id}")
    boolean deleteSchool(Integer school_id);

    @Select("SELECT * FROM `postgraduate`.`school`")
    List<School> getAllSchool();

    @Select("SELECT * FROM `postgraduate`.`school` WHERE `school`.`school_id` = #{school_id}")
    List<School> getSchoolById(Integer school_id);
}
