package com.example.postgraduate.Server;

import com.example.postgraduate.Dao.CommentMapper;
import com.example.postgraduate.POJO.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceIml implements CommentService{
    @Autowired
    CommentMapper commentMapper;

    @Override
    public boolean addComment(Comment comment) {
        return commentMapper.addComment(comment);
    }

    @Override
    public boolean changeStatus(Integer comment_id, Integer status) {
        return commentMapper.changeStatus(comment_id,status);
    }

    @Override
    public boolean addLike(Integer comment_id) {
        return commentMapper.addLike(comment_id);
    }

    @Override
    public List<Comment> getInvitationComment(Integer invitation_id) {
        return commentMapper.getInvitationComment(invitation_id);
    }
}
