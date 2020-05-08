package com.example.postgraduate.Server;

import com.example.postgraduate.POJO.Plan;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Repository
public interface PlanService {
    boolean addPlan(Plan plan);

    boolean changeStatus(Integer plan_id, Integer plan_status);

    boolean deletePlan(Integer plan_id);

    List<Plan> getAllPlan(Integer user_id);
}
