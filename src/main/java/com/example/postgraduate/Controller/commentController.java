package com.example.postgraduate.Controller;

import com.example.postgraduate.POJO.Comment;
import com.example.postgraduate.Server.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/comment")
public class commentController {
    @Autowired
    CommentService commentService;

    @RequestMapping("/addcomment")
    boolean addComment(@RequestParam String content, @RequestParam Integer comment_user, @RequestParam Integer comment_invitation){
        Comment comment = new Comment(content,comment_user,comment_invitation);
        return commentService.addComment(comment);
    }

    @RequestMapping("/changestatus")
    boolean changeStatus(@RequestParam Integer comment_id, @RequestParam Integer comment_status){
        return commentService.changeStatus(comment_id,comment_status);
    }

    @RequestMapping("/addlike")
    boolean addLike(@RequestParam Integer comment_id){
        return commentService.addLike(comment_id);
    }
}
