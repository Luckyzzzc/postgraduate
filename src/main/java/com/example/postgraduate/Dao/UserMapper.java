package com.example.postgraduate.Dao;

import com.example.postgraduate.POJO.Comment;
import com.example.postgraduate.POJO.Invitation;
import com.example.postgraduate.POJO.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    @Insert("INSERT INTO `postgraduate`.`user` (`username`, `password`, `phone`, `root`, `sex`, `isBan`, `invitation_number`, `comment_number`, `follow`, `head_sculpture`, `nickname`,`school_id`,`subject_id`)" +
            " VALUES (#{username}, #{password}, #{phone}, #{root}, #{sex}, #{isBan}, #{invitation_number}, #{comment_number}, #{follow}, #{head_sculpture}, #{nickname}, #{school_id}, #{subject_id});")
    boolean regist(User user);

    @Update("UPDATE `postgraduate`.`user` SET `user`.`isBan` = #{isBan} WHERE `user`.`user_id` = #{user_id};")
    boolean userBan(Integer user_id, Integer isBan);

    @Update("UPDATE `postgraduate`.`user` SET `user`.`password` = #{newPassword} WHERE `user`.`user_id` = #{user_id};")
    boolean changePassword(Integer user_id, String newPassword);

    @Update("UPDATE `postgraduate`.`user` SET `user`.`invitation_number` = `user`.`invitation_number` + 1 WHERE `user`.`user_id` = #{user_id};")
    boolean addInvitation(Integer user_id);

    @Update("UPDATE `postgraduate`.`user` SET `user`.`comment_number` = `user`.`comment_number` + 1 WHERE `user`.`user_id` = #{user_id};")
    boolean addComment(Integer user_id);

    @Select("SELECT * FROM `postgraduate`.`user`;")
    List<User> findAll();

    @Select("SELECT * FROM `postgraduate`.`user` WHERE `user`.`username` = #{username};")
    User find(String username);

    @Select("SELECT * FROM `postgraduate`.`user` WHERE `user`.`user_id` = #{user_id};")
    User findById(Integer user_id);

    @Update("UPDATE `postgraduate`.`user` SET `user`.`sex` = #{sex} WHERE `user`.`user_id` = #{user_id};")
    boolean changeSex(Integer user_id, Integer sex);

    @Update("UPDATE `postgraduate`.`user` SET `user`.`follow` = `user`.`follow` + 1 WHERE `user`.`user_id` = #{user_id};")
    boolean addFollow(Integer user_id);

    @Update("UPDATE `postgraduate`.`user` SET `user`.`nickname` = #{nickname} WHERE `user`.`user_id` = #{user_id};")
    boolean changeNickname(Integer user_id, String nickname);

    @Update("UPDATE `postgraduate`.`user` SET `user`.`subject_id` = #{subject_id} WHERE `user`.`user_id` = #{user_id};")
    boolean changeSubjectId(Integer user_id, Integer subject_id);
    
    @Update("UPDATE `postgraduate`.`user` SET `user`.`school_id` = #{school_id} WHERE `user`.`user_id` = #{user_id};")
    boolean changeSchoolId(Integer user_id, Integer school_id);
    
    @Select("SELECT * FROM `postgraduate`.`invitation` WHERE `invitation`.`post_user` = #{user_id};")
    List<Invitation> getAllInvitation(Integer user_id);

    @Select("SELECT * FROM `postgraduate`.`comment` WHERE `comment`.`comment_user` = #{user_id};")
    List<Comment> getAllComment(Integer user_id);
}
