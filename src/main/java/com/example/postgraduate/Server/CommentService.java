package com.example.postgraduate.Server;

import com.example.postgraduate.POJO.Comment;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {
    boolean addComment(Comment comment);

    boolean changeStatus(Integer comment_id, Integer status);

    boolean addLike(Integer comment_id);
}
