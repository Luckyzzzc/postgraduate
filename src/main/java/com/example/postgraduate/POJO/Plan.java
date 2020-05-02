package com.example.postgraduate.POJO;

import org.springframework.stereotype.Component;

@Component
public class Plan {
    private Integer plan_id;
    private Integer user_id;
    private String date;
    private Integer plan_status;
    private Integer plan_type;
    private String plan_content;
    private String create_time;
    private String end_time;

    public Plan(){}

    public Plan(Integer user_id, Integer plan_type, String plan_content){
        this.plan_id = 0;
        this.user_id = user_id;
        this.plan_type = plan_type;
        this.date = null;
        this.plan_status  = 0;
        this.plan_content = plan_content;
        this.create_time = null;
        this.end_time = null;
    }


    public Integer getPlan_id() {
        return plan_id;
    }

    public void setPlan_id(Integer plan_id) {
        this.plan_id = plan_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getPlan_status() {
        return plan_status;
    }

    public void setPlan_status(Integer plan_status) {
        this.plan_status = plan_status;
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

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }
}
