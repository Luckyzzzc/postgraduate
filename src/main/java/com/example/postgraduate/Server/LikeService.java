package com.example.postgraduate.Server;

import com.example.postgraduate.POJO.Like;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Repository
public interface LikeService {
    boolean addLike(Like like);

    boolean deleteLike(Integer like_id);

    List<Like> getLikeById(Integer like_id);

    Like judgeLike(Integer comment_id, Integer user_id);

    Integer countLikeByCommentId(Integer comment_id);
}
