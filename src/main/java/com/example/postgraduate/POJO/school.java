package com.example.postgraduate.POJO;

import org.springframework.stereotype.Component;

@Component
public class school {
    private Integer school_id;
    private String school_name;
    private String school_tag;
    private Integer province_id;

    public Integer getSchool_id() {
        return school_id;
    }

    public void setSchool_id(Integer school_id) {
        this.school_id = school_id;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public String getSchool_tag() {
        return school_tag;
    }

    public void setSchool_tag(String school_tag) {
        this.school_tag = school_tag;
    }

    public Integer getProvince_id() {
        return province_id;
    }

    public void setProvince_id(Integer province_id) {
        this.province_id = province_id;
    }
}
