package com.example.postgraduate.Controller;

import com.example.postgraduate.POJO.Plan;
import com.example.postgraduate.Server.PlanService;

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
@RequestMapping("/plan")
@CrossOrigin
@Api(tags = "计划类的api文档")
public class planController {
    @Autowired
    PlanService planService;

    @RequestMapping("/addplan")
    @ApiOperation(value = "用于添加用户计划的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user_id", value = "用户id", defaultValue = "1", required = true),
            @ApiImplicitParam(name = "plan_type", value = "计划类型(科目)", defaultValue = "软件工程实践", required = true),
            @ApiImplicitParam(name = "plan_content", value = "计划内容", defaultValue = "查看计划类API文档", required = true)
    })
    boolean addPlan(@RequestParam Integer user_id, @RequestParam Integer plan_type, @RequestParam String plan_content){
        Plan plan = new Plan(user_id,plan_type,plan_content);
        return planService.addPlan(plan);
    }
    
    @RequestMapping("/changestatus")
    @ApiOperation(value = "用于改变计划状态的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "plan_id", value = "计划id", defaultValue = "xx", required = true),
            @ApiImplicitParam(name = "plan_status", value = "计划状态(0表示未完成1表示完成)", defaultValue = "1", required = true)         
    })
    boolean changeStatus(@RequestParam Integer plan_id, @RequestParam Integer plan_status){
        return planService.changeStatus(plan_id,plan_status);
    }
    
    @RequestMapping("/deletestatus")
    @ApiOperation(value = "用于删除计划的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "plan_id", value = "计划id", defaultValue = "xx", required = true)
    })
    boolean deletePlan(@RequestParam Integer plan_id){
        return planService.deletePlan(plan_id);
    }
}
