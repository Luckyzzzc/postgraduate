package com.example.postgraduate.Dao;

import com.example.postgraduate.POJO.Plan;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Select("SELECT * FROM `postgraduate`.`plan` WHERE `plan`.`user_id` = #{user_id};")
    List<Plan> getAllPlan(Integer user_id);

    @Select("SELECT * FROM `postgraduate`.`plan` WHERE `plan`.`plan_id` = #{plan_id};")
    Plan getPlanById(Integer plan_id);
}
