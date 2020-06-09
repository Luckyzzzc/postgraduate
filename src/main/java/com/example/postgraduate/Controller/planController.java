package com.example.postgraduate.Controller;

import com.example.postgraduate.POJO.Plan;
import com.example.postgraduate.Server.PlanService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/plan",produces = "application/json;charset=utf-8")
@CrossOrigin
@ResponseBody
@Api(tags = "计划类的api文档")
public class planController {
    @Autowired
    PlanService planService;

    @PostMapping("/addplan")
    @ApiOperation(value = "用于添加用户计划的接口")
    Plan addPlan(@RequestBody postPlan postPlan){
        Plan plan = new Plan(postPlan.getUser_id(), postPlan.getPlan_type(),postPlan.getPlan_content(), postPlan.getDate());
        planService.addPlan(plan);
        return plan;
    }

    @PostMapping("/changestatus")
    @ApiOperation(value = "用于改变计划状态的接口")
    boolean changeStatus(@RequestBody changePlan changePlan){
        return planService.changeStatus(changePlan.getPlan_id(), (Integer) changePlan.getDate());
    }

    @PostMapping("/deleteplan")
    @ApiOperation(value = "用于删除计划的接口[参数:post_id]")
    boolean deletePlan(@RequestBody Map<String, Object> map){
        return planService.deletePlan((Integer)map.get("post_id"));
    }

    @PostMapping("/getPlan")
    @ApiOperation(value = "用于获得用户计划[参数:user_id]")
    List<Plan> getAllPlan(@RequestBody Map<String, Object> map){
        return planService.getAllPlan((Integer)map.get("user_id"));
    }

    @PostMapping("/getplanbyid")
    @ApiOperation(value = "通过id获得计划[参数:plan_id]")
    Plan getPlanById(@RequestBody Map<String, Object> map){
        return planService.getPlanById((Integer)map.get("plan_id"));
    }
}

class postPlan{
    Integer user_id;
    Integer plan_type;
    String plan_content;
    String date;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getPlan_type() {
        return plan_type;
    }

    public void setPlan_type(Integer plan_type) {
        this.plan_type = plan_type;
    }

    public String getPlan_content() {
        return plan_content;
    }

    public void setPlan_content(String plan_content) {
        this.plan_content = plan_content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

class changePlan{
    Integer plan_id;
    Object date;

    public Integer getPlan_id() {
        return plan_id;
    }

    public void setPlan_id(Integer plan_id) {
        this.plan_id = plan_id;
    }

    public Object getDate() {
        return date;
    }

    public void setDate(Object date) {
        this.date = date;
    }
}