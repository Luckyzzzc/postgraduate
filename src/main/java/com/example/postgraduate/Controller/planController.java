package com.example.postgraduate.Controller;

import com.example.postgraduate.POJO.Plan;
import com.example.postgraduate.Server.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/plan")
@CrossOrigin
public class planController {
    @Autowired
    PlanService planService;

    @RequestMapping("/addplan")
    boolean addPlan(@RequestParam Integer user_id, @RequestParam Integer plan_type, @RequestParam String plan_content){
        Plan plan = new Plan(user_id,plan_type,plan_content);
        return planService.addPlan(plan);
    }

    boolean changeStatus(Integer plan_id, Integer plan_status){
        return planService.changeStatus(plan_id,plan_status);
    }

    boolean deletePlan(Integer plan_id){
        return planService.deletePlan(plan_id);
    }
}
