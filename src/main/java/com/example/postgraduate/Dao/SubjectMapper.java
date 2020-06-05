package com.example.postgraduate.Dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import com.example.postgraduate.POJO.Subject;

import java.util.List;

@Mapper
@Repository
public interface SubjectMapper {
    @Insert("INSERT INTO `postgraduate`.`subject` (`subject_name`) VALUES (#{subject_name});")
    Boolean addSubject(String subject_name);

    @Delete("DELETE FROM `postgraduate`.`subject` WHERE `subject`.`subject_id` = #{subject_id}")
    Boolean deleteSubject(Integer subject_id);

    @Select("SELECT * FROM `postgraduate`.`subject`;")
    List<Subject> getAllSubject();
    
    @Select("SELECT *  FROM `postgraduate`.`subject` WHERE `subject`.`subject_id` = #{subject_id}")
    Subject getSubjectById(Integer subject_id);
}
