package com.example.postgraduate.Dao;

import com.example.postgraduate.POJO.Like;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LikeMapper {
    @Insert("INSERT INTO `postgraduate`.`like` (`comment_id`, `invitation_id`, `user_id`) VALUES (#{comment_id}, #{invitation_id}, #{user_id});")
    boolean addLike(Like like);

    @Delete("DELETE FROM `postgraduate`.`like` WHERE `like`.`like_id` = #{like_id}")
    boolean deleteLike(Integer like_id);

    @Select("SELECT * FROM `postgraduate`.`like` WHERE `like`.`like_id` = #{like_id}")
    List<Like> getLikeById(Integer like_id);

    @Select("SELECT * FROM `postgraduate`.`like` WHERE `like`.`comment_id` = #{comment_id} AND `like`.`user_id` = #{user_id}")
    Like judgeLike(Integer comment_id, Integer user_id);

    @Select("SELECT COUNT(*) FROM `postgraduate`.`like` WHERE `like`.`comment_id` = #{comment_id}")
    Integer countLikeByCommentId(Integer comment_id);
}
