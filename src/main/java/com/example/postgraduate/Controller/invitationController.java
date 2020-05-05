package com.example.postgraduate.Controller;

import com.example.postgraduate.POJO.Invitation;
import com.example.postgraduate.Server.InvitationService;

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
@RequestMapping(value = "/invitation")
@CrossOrigin
@Api(tags = "发帖类的api文档")
public class invitationController {
    @Autowired
    InvitationService invitationService;

    @RequestMapping(value = "/post")
    @ApiOperation(value = "用于添加帖子的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user_id", value = "用户id", defaultValue = "1", required = true),
            @ApiImplicitParam(name = "invitation_title", value = "帖子标题", defaultValue = "福大考研心得", required = true),
            @ApiImplicitParam(name = "invitation_content", value = "帖子内容", defaultValue = "我的心得内容", required = true),
            @ApiImplicitParam(name = "invitation_plate", value = "帖子分区", defaultValue = "1", required = true)
    })
    boolean post(@RequestParam Integer user_id, @RequestParam String invitation_title,
                 @RequestParam String invitation_content, @RequestParam Integer invitation_plate){
        Invitation invitation = new Invitation(invitation_title,invitation_content,invitation_plate,user_id);
        return invitationService.post(invitation);
    }

    @RequestMapping(value = "/changestatus")
    @ApiOperation(value = "用于改变帖子的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "invitation_id", value = "帖子id", defaultValue = "1", required = true),
            @ApiImplicitParam(name = "invitation_status", value = "帖子标题", defaultValue = "福大考研心得", required = true)
    })
    boolean changestatus(Integer invitation_id, Integer invitation_status){
        return invitationService.changeStatus(invitation_id, invitation_status);
    }

    @RequestMapping(value = "/addscan")
    @ApiOperation(value = "用于增加帖子浏览数的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "invitation_id", value = "帖子id", defaultValue = "1", required = true)
    })
    boolean addScan(Integer invitation_id){
        return invitationService.addScan(invitation_id);
    }
}
