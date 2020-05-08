package com.example.postgraduate.Server;

import com.example.postgraduate.POJO.Like;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Repository
public interface LikeService {
    boolean addLike(Like like);

    boolean deleteLike(Integer like_id);
}
