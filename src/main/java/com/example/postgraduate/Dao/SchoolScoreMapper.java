package com.example.postgraduate.Dao;

import com.example.postgraduate.POJO.SchoolScore;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SchoolScoreMapper {
    @Select("SELECT * FROM `postgraduate`.`school_score`;")
    List<SchoolScore> selectSchoolScore();

    @Select("SELECT * FROM `postgraduate`.`school_score` WHERE `school_score`.`school_id` = #{school_id};")
    List<SchoolScore> selectSchoolScoreById(Integer school_id);

    @Delete("DELETE FROM `postgraduate`.`school_score` WHERE `school_score`.`school_id` = #{school_id};")
    boolean deleteSchoolScore(Integer school_id);
}
