package com.example.postgraduate.Dao;

import com.example.postgraduate.POJO.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    @Insert("INSERT INTO `postgraduate`.`user` (`user_id`, `username`, `password`, `phone`, `root`, `sex`, `isBan`, `invitation_number`, `comment_number`, `follow`, `head_sculpture`)" +
            " VALUES (#{user_id}, #{username}, #{password}, #{phone}, #{root}, #{sex}, #{isBan}, #{invitation_number}, #{comment_number}, #{follow}, #{head_sculpture});")
    boolean regist(User user);

    @Update("UPDATE `postgraduate`.`user` SET `user`.`isBan` = #{isBan} WHERE `user`.`user_id` = #{user_id};")
    boolean userBan(Integer user_id, Integer isBan);

    @Update("UPDATE `postgraduate`.`user` SET `user`.`password` = #{newPassword} WHERE `user`.`user_id` = #{user_id};")
    boolean changePassword(Integer user_id, String newPassword);

    void addInvitation(Integer user_id);

    void addComment(Integer user_id);

    @Select("SELECT * FROM `postgraduate`.`user` WHERE `user`.`username` = #{username};")
    User find(String username);

    @Select("SELECT * FROM `postgraduate`.`user` WHERE `user`.`user_id` = #{user_id};")
    User findById(Integer user_id);
}
