package com.example.postgraduate.POJO;

import org.springframework.stereotype.Component;

@Component
public class province_school {
    private Integer province_id;
    private Integer school_id;

    public Integer getProvince_id() {
        return province_id;
    }

    public void setProvince_id(Integer province_id) {
        this.province_id = province_id;
    }

    public Integer getSchool_id() {
        return school_id;
    }

    public void setSchool_id(Integer school_id) {
        this.school_id = school_id;
    }
}
