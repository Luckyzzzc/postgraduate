package com.example.postgraduate.Controller;

import com.example.postgraduate.POJO.Like;
import com.example.postgraduate.POJO.Result;
import com.example.postgraduate.Server.LikeService;
import com.example.postgraduate.Util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping(value = "/like",produces = "application/json;charset=utf-8")
@CrossOrigin
@ResponseBody
@Api(tags = "点赞的api文档")
public class LikeController {
    @Autowired
    LikeService likeService;

    @PostMapping("/addlike")
    @ApiOperation("用于点赞,若有则删除，若无则增加")
    Object addLike(@RequestBody LikeTmp likeTmp){
        Like like = null;
        if (likeService.judgeLike(likeTmp.getComment_id(),likeTmp.getUser_id()) != null){
            like = likeService.judgeLike(likeTmp.getComment_id(),likeTmp.getUser_id());
            likeService.deleteLike(like.getLike_id());
            return ResultUtil.success(200,"取消点赞成功");
        }else{
            Like like1 = new Like(likeTmp.getComment_id(),likeTmp.getInvitation_id(),likeTmp.getUser_id());
            if(likeService.addLike(like1))
                return ResultUtil.success(200,"点赞成功");
            else
                return ResultUtil.error(500,"点赞失败");
        }
    }

    @PostMapping("/countlike")
    @ApiOperation("用于获取某个评论的点赞信息[参数：comment_id]")
    Integer countLike(@RequestBody Map<String, Object> map){
        return likeService.countLikeByCommentId((Integer) map.get("comment_id"));
    }

    @PostMapping("/judgelike")
    @ApiOperation("用于获取某用户对某评论是否点赞[参数：comment_id user_id]")
    boolean judgeLike(@RequestBody Map<String, Object> map){
        return likeService.judgeLike((Integer)map.get("comment_id"), (Integer)map.get("user_id")) == null? false:true;
    }

//    @PostMapping("/addlike")
//    @ApiOperation("用于添加点赞信息")
//    boolean addLike(@RequestBody LikeTmp likeTmp){
//        Like like = new Like(likeTmp.getComment_id(),likeTmp.getInvitation_id(),likeTmp.getUser_id());
//        return likeService.addLike(like);
//    }
//
//    @PostMapping("/deletelike")
//    @ApiOperation("/用于删除点赞信息[参数:like_id]")
//    boolean deleteLike(@RequestBody Map<String, Object> map){
//        return likeService.deleteLike((Integer)map.get("like_id"));
//    }
}

class LikeTmp{
    private Integer comment_id;
    private Integer invitation_id;
    private Integer user_id;

    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }

    public Integer getInvitation_id() {
        return invitation_id;
    }

    public void setInvitation_id(Integer invitation_id) {
        this.invitation_id = invitation_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}
