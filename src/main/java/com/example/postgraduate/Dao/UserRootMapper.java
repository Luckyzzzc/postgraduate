package com.example.postgraduate.Dao;

import com.example.postgraduate.POJO.UserRoot;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserRootMapper {
    @Select("SELECT * FROM `postgraduate`.`userroot`")
    UserRoot findRoot();

    @Insert("INSERT INTO `postgraduate`.`userroot` (`root_name`) VALUES (#{str});")
    boolean addRoot(String str);

    @Delete("DELETE FROM `postgraduate`.`userroot` WHERE `userroot`.`root_id` = #{root_id}")
    boolean deleteRoot(Integer root_id);
}
