package com.example.postgraduate.Controller;

import com.example.postgraduate.POJO.Comment;
import com.example.postgraduate.POJO.Invitation;
import com.example.postgraduate.Server.CommentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping(value = "/comment",produces = "application/json;charset=utf-8")
@CrossOrigin
@ResponseBody
@Api(tags = "评论类的api文档")
public class commentController {
    @Autowired
    CommentService commentService;

    @PostMapping("/addcomment")
    @ApiOperation(value = "用于添加评论的接口")
    boolean addComment(@RequestBody postComment postComment){
        Comment comment = new Comment(postComment.content,postComment.comment_user,postComment.comment_invitation);
        return commentService.addComment(comment);
    }

    @PostMapping("/changestatus")
    @ApiOperation(value = "用于改变评论状态的接口")
    boolean changeStatus(@RequestBody changeComment changeComment){
        return commentService.changeStatus(changeComment.getComment_id(), (Integer)changeComment.date);
    }

    @PostMapping("/addlike")
    @ApiOperation(value = "用于给评论添加点赞数的接口")
    boolean addLike(@RequestBody Integer comment_id){
        return commentService.addLike(comment_id);
    }

    @PostMapping("/getinvitationcomment")
    @ApiOperation(value = "用于获得某个帖子的评论")
    List<Comment> getInvitationComment(@RequestBody HashMap<String, Object> map){
        return commentService.getInvitationComment((Integer)map.get("invitation_id") );
    }
}

class changeComment{
    Integer comment_id;
    Object date;

    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }

    public Object getDate() {
        return date;
    }

    public void setDate(Object date) {
        this.date = date;
    }
}

class postComment{
    String content;
    Integer comment_user;
    Integer comment_invitation;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getComment_user() {
        return comment_user;
    }

    public void setComment_user(Integer comment_user) {
        this.comment_user = comment_user;
    }

    public Integer getComment_invitation() {
        return comment_invitation;
    }

    public void setComment_invitation(Integer comment_invitation) {
        this.comment_invitation = comment_invitation;
    }
}