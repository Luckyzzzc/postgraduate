package com.example.postgraduate.Controller;

import com.example.postgraduate.POJO.UserRoot;
import com.example.postgraduate.Server.UserRootService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/userroot")
@CrossOrigin
@ResponseBody
@Api(tags = "权限管理类的api文档")
public class UserRootController {
    @Autowired
    UserRootService userRootService;

    @GetMapping("/findroot")
    @ApiOperation(value = "用于查询所有权限编号和对应权限名称(目前权限只有0游客1管理员)的接口")
    UserRoot findRoot(){
        return userRootService.findRoot();
    }

    @PostMapping("/addroot")
    @ApiOperation(value = "用于添加权限的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "root_name", value = "权限名称", defaultValue = "xxx", required = true)
    })
    boolean addRoot(@RequestBody String root_name){
        return userRootService.addRoot(root_name);
    }

    @PostMapping("/deleteroot")
    @ApiOperation(value = "用于删除权限的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "root_id", value = "权限id", defaultValue = "1", required = true)
    })
    boolean deleteRoot(@RequestBody Integer root_id){
        return userRootService.deleteRoot(root_id);
    }
}
