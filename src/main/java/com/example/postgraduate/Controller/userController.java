package com.example.postgraduate.Controller;

import com.example.postgraduate.POJO.User;
import com.example.postgraduate.Server.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/User")
@CrossOrigin
@Api(tags = "用户管理类的api文档")
public class userController {
    @Autowired
    UserService userService;

    @PostMapping(value = "/regist")
    @ApiOperation(value = "用于添加用户的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", defaultValue = "admin", required = true),
            @ApiImplicitParam(name = "password", value = "密码", defaultValue = "admin", required = true)
    })
    boolean regist(@RequestParam String username, @RequestParam String password){
        if(userService.find(username) != null){
            return false;
        }
        User user = new User(username, password);
        return userService.regist(user) != true;
    }


    @PostMapping(value = "/isban")
    @ApiOperation(value = "用于改变用户封禁状态的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user_id", value = "用户id", defaultValue = "1", required = true),
            @ApiImplicitParam(name = "isBan", value = "封禁状态（1为封禁）", required = true)
    })
    boolean isBan(@RequestParam Integer user_id, @RequestParam Integer isBan){
        return userService.userBan(user_id,isBan);
    }

    @PostMapping(value = "/changepassword")
    @ApiOperation(value = "用于修改用户密码的接口")
    boolean changePassword(@RequestParam Integer user_id, @RequestParam String oldPassword, @RequestParam String newPassword){
        return userService.changePassword(user_id,oldPassword,newPassword);
    }


    @RequestMapping(value = "/login")
    @ApiOperation(value = "用于登录用户的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", defaultValue = "admin", required = true),
            @ApiImplicitParam(name = "password", value = "密码", defaultValue = "admin", required = true)
    })
    boolean login(@RequestParam String username, @RequestParam String password){
        return userService.find(username).getPassword().compareTo(password) == 0;
    }

    @RequestMapping(value = "/addinvitation")
    @ApiOperation(value = "用于添加帖子的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user_id", value = "用户id", defaultValue = "1", required = true)
    })
    boolean addInvitation(@RequestParam Integer user_id){
        return userService.addInvitation(user_id);
    }

    @RequestMapping(value = "/addcomment")
    @ApiOperation(value = "用于添加评论的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user_id", value = "用户id", defaultValue = "1", required = true)
    })
    boolean addComment(@RequestParam Integer user_id){
        return userService.addComment(user_id);
    }

    @RequestMapping(value = "/changesex")
    @ApiOperation(value = "用于更改性别的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user_id", value = "用户id", defaultValue = "1", required = true),
            @ApiImplicitParam(name = "sex", value = "性别", defaultValue = "1", required = true)
    })
    boolean changeSex(@RequestParam Integer user_id, @RequestParam Integer sex){
        return userService.changeSex(user_id, sex);
    }

    @RequestMapping(value = "/addfollow")
    @ApiOperation(value = "用于添加关注的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user_id", value = "用户id", defaultValue = "1", required = true)
    })
    boolean addFollow(@RequestParam Integer user_id){
        return userService.addFollow(user_id);
    }

    @RequestMapping(value = "/changenickname")
    @ApiOperation(value = "用于更改昵称的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user_id", value = "用户id", defaultValue = "1", required = true),
            @ApiImplicitParam(name = "nickname", value = "昵称", defaultValue = "xxx", required = true)
    })
    boolean changeNickname(@RequestParam Integer user_id, @RequestParam String nickname){
        return userService.changeNickname(user_id, nickname);
    }
}
