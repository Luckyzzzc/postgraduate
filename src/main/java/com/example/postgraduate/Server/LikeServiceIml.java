package com.example.postgraduate.Server;

import com.example.postgraduate.Dao.LikeMapper;
import com.example.postgraduate.POJO.Like;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeServiceIml implements LikeService {
    @Autowired
    LikeMapper likeMapper;

    @Override
    public boolean addLike(Like like) {
        return likeMapper.addLike(like);
    }

    @Override
    public boolean deleteLike(Integer like_id) {
        return likeMapper.deleteLike(like_id);
    }

    @Override
    public List<Like> getLikeById(Integer like_id) {
        return likeMapper.getLikeById(like_id);
    }

    @Override
    public Like judgeLike(Integer comment_id, Integer user_id) {
        return likeMapper.judgeLike(comment_id,user_id);
    }

    @Override
    public Integer countLikeByCommentId(Integer comment_id) {
        return likeMapper.countLikeByCommentId(comment_id);
    }


}
