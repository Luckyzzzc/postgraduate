package com.example.postgraduate.Controller;

import com.example.postgraduate.POJO.Comment;
import com.example.postgraduate.Server.CommentService;

import com.example.postgraduate.Util.ResultUtil;
import com.example.postgraduate.Util.TokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    Object addComment(@RequestBody postComment postComment, HttpServletRequest request){
        Comment comment = new Comment(postComment.content,postComment.comment_user,postComment.comment_invitation);
        String username = null;
        if(commentService.getUsername(postComment.getComment_user()) == null){
            return ResultUtil.error(500,"用户不存在");
        }else{
            username = commentService.getUsername(postComment.getComment_user());
        }
        String token = TokenUtil.sign(username);
        if(request.getHeader("token") == null || token.compareTo(request.getHeader("token")) != 0){
            return ResultUtil.error(500,"用户未登陆");
        }
        return commentService.addComment(comment);
    }

    @PostMapping("/changestatus")
    @ApiOperation(value = "用于改变评论状态的接口")
    boolean changeStatus(@RequestBody changeComment changeComment){
        return commentService.changeStatus(changeComment.getComment_id(), (Integer)changeComment.date);
    }

    @PostMapping("/addlike")
    @ApiOperation(value = "用于给评论添加点赞数的接口[参数:comment_id]")
    boolean addLike(@RequestBody  HashMap<String, Object> map){
        return commentService.addLike((Integer)map.get("comment_id"));
    }

    @PostMapping("/getinvitationcomment")
    @ApiOperation(value = "用于获得某个帖子的评论[参数:invitation_id]")
    List<Comment> getInvitationComment(@RequestBody HashMap<String, Object> map){
        return commentService.getInvitationComment((Integer)map.get("invitation_id") );
    }

    @PostMapping("deletecomment")
    @ApiOperation(value = "删除某个评论[参数:comment_id]")
    boolean deleteComment(@RequestBody HashMap<String, Object> map){
        return commentService.deleteComment((Integer)map.get("comment_id"));
    }

    @PostMapping("getallcomment")
    @ApiOperation(value = "获取所有评论根据帖子序号排列")
    List<Comment> getAllComment(){
        return commentService.getAllComment();
    }

    @PostMapping("getcommentbyuser")
    @ApiOperation(value = "获取某用户所有评论[参数:comment_user]")
    List<Comment> getCommentByUser(@RequestBody HashMap<String, Object> map){
        return commentService.getCommentByUser((Integer)map.get("comment_user"));
    }

    @PostMapping("getcommentbyid")
    @ApiOperation(value = "根据评论id获得评论[参数:comment_id]")
    List<Comment> getCommentById(@RequestBody HashMap<String, Object> map){
        return commentService.getCommentById((Integer)map.get("comment_id"));
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