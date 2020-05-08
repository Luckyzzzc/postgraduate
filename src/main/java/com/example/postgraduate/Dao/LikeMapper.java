package com.example.postgraduate.Dao;

import com.example.postgraduate.POJO.Like;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LikeMapper {
    @Insert("INSERT INTO `postgraduate`.`like` (`comment_id`, `invitation_id`, `user_id`) VALUES (#{comment_id}, #{invitation_id}, #{user_id});")
    boolean addLike(Like like);

    @Delete("DELETE FROM `postgraduate`.`like` WHERE `like`.`like_id` = #{like_id}")
    boolean deleteLike(Integer like_id);
}
