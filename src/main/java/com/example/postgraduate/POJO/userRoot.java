package com.example.postgraduate.POJO;

import org.springframework.stereotype.Component;

@Component
public class userRoot {
    private Integer root_id;
    private String root_name;

    public Integer getRoot_id() {
        return root_id;
    }

    public void setRoot_id(Integer root_id) {
        this.root_id = root_id;
    }

    public String getRoot_name() {
        return root_name;
    }

    public void setRoot_name(String root_name) {
        this.root_name = root_name;
    }
}
