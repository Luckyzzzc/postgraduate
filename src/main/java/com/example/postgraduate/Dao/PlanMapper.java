package com.example.postgraduate.Dao;

import com.example.postgraduate.POJO.Plan;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PlanMapper {
    @Insert("INSERT INTO `postgraduate`.`plan` (`user_id`, `date`, `plan_status`, `plan_type`, `plan_content`, `create_time`, `end_time`)" +
            " VALUES (#{user_id}, #{date}, #{plan_status}, #{plan_type}, #{plan_content}, #{create_time}, #{end_time});")
    boolean addPlan(Plan plan);

    @Update("UPDATE `postgraduate`.`plan` SET `plan_status` = #{plan_status} WHERE (`plan_id` = #{plan_id});")
    boolean changeStatus(Integer plan_id, Integer plan_status);

    @Delete("DELETE FROM `postgraduate`.`plan` WHERE `plan`.`plan_id` = #{plan_id}")
    boolean deletePlan(Integer plan_id);
}
