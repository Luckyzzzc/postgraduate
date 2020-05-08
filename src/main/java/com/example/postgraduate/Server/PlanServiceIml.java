package com.example.postgraduate.Server;

import com.example.postgraduate.Dao.PlanMapper;
import com.example.postgraduate.POJO.Plan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanServiceIml implements PlanService {

    @Autowired
    PlanMapper planMapper;

    @Override
    public boolean addPlan(Plan plan) {
        return planMapper.addPlan(plan);
    }

    @Override
    public boolean changeStatus(Integer plan_id, Integer plan_status) {
        return planMapper.changeStatus(plan_id,plan_status);
    }

    @Override
    public boolean deletePlan(Integer plan_id) {
        return planMapper.deletePlan(plan_id);
    }

    @Override
    public List<Plan> getAllPlan(Integer user_id) {
        return planMapper.getAllPlan(user_id);
    }
}
