package com.example.postgraduate.Controller;

import com.example.postgraduate.POJO.Comment;
import com.example.postgraduate.Server.CommentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/comment")
@CrossOrigin
@Api(tags = "评论类的api文档")
public class commentController {
    @Autowired
    CommentService commentService;

    @RequestMapping("/addcomment")
    @ApiOperation(value = "用于添加帖子的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "content", value = "评论内容", defaultValue = "哈哈", required = true),
            @ApiImplicitParam(name = "comment_user", value = "评论用户", defaultValue = "1", required = true),
            @ApiImplicitParam(name = "comment_invitation", value = "评论的帖子", defaultValue = "1", required = true)
    })
    boolean addComment(@RequestParam String content, @RequestParam Integer comment_user, @RequestParam Integer comment_invitation){
        Comment comment = new Comment(content,comment_user,comment_invitation);
        return commentService.addComment(comment);
    }

    @RequestMapping("/changestatus")
    @ApiOperation(value = "用于改变帖子状态的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "comment_id", value = "评论用户", defaultValue = "1", required = true),
            @ApiImplicitParam(name = "comment_status", value = "评论的状态0为显示1为隐藏", defaultValue = "1", required = true)
    })
    boolean changeStatus(@RequestParam Integer comment_id, @RequestParam Integer comment_status){
        return commentService.changeStatus(comment_id,comment_status);
    }

    @RequestMapping("/addlike")
    @ApiOperation(value = "用于给帖子添加点赞数的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "comment_id", value = "评论用户", defaultValue = "1", required = true)
    })
    boolean addLike(@RequestParam Integer comment_id){
        return commentService.addLike(comment_id);
    }
}
