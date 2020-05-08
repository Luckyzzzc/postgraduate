package com.example.postgraduate.Server;

import com.example.postgraduate.Dao.LikeMapper;
import com.example.postgraduate.POJO.Like;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
