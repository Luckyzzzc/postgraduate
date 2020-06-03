package com.example.postgraduate.POJO;

import io.swagger.annotations.Api;

@Api(value = "学校分数线")
public class SchoolScore {
    Integer id;
    Integer plate;
    String year;
    Integer type;
    Integer subject;
    Integer total_points;
    Integer politics;
    Integer english;
    Integer profession1;
    Integer profession2;
    Integer school_id;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPlate() {
        return plate;
    }

    public void setPlate(Integer plate) {
        this.plate = plate;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSubject() {
        return subject;
    }

    public void setSubject(Integer subject) {
        this.subject = subject;
    }

    public Integer getTotal_points() {
        return total_points;
    }

    public void setTotal_points(Integer total_points) {
        this.total_points = total_points;
    }

    public Integer getPolitics() {
        return politics;
    }

    public void setPolitics(Integer politics) {
        this.politics = politics;
    }

    public Integer getEnglish() {
        return english;
    }

    public void setEnglish(Integer english) {
        this.english = english;
    }

    public Integer getProfession1() {
        return profession1;
    }

    public void setProfession1(Integer profession1) {
        this.profession1 = profession1;
    }

    public Integer getProfession2() {
        return profession2;
    }

    public void setProfession2(Integer profession2) {
        this.profession2 = profession2;
    }
}
