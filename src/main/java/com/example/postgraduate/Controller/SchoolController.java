package com.example.postgraduate.Controller;

import com.example.postgraduate.POJO.School;
import com.example.postgraduate.Server.SchoolService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/school")
@CrossOrigin
@ResponseBody
@Api(tags = "学校类的api文档")
public class SchoolController {
    @Autowired
    SchoolService schoolService;

    @PostMapping("/addschool")
    @ApiOperation(value = "用于添加学校")
    boolean addSchool(@RequestBody schoolTmp schoolTmp){
        School school = new School(schoolTmp.getSchool_name(),schoolTmp.getSchool_tag(),schoolTmp.getProvince_id());
        return schoolService.addSchool(school);
    }

    @PostMapping("/deleteschool")
    @ApiOperation(value = "用于删除学校[参数:school_id]")
    boolean deleteSchool(@RequestBody Map<String, Object> map){
        return schoolService.deleteSchool((Integer)map.get("school_id"));
    }

    @PostMapping("/getallschool")
    @ApiOperation(value = "用于获得所有学校")
    List<School> getAllSchool(){
        return schoolService.getAllSchool();
    }

    @PostMapping("/getschool")
    @ApiOperation(value = "通过id获得学校[参数：school_id]")
    List<School> getAllSchool(@RequestBody Map<String, Object> map){
        return schoolService.getSchoolById((Integer)map.get("school_id"));
    }
}

class schoolTmp{
    String school_name;
    String school_tag;
    Integer province_id;

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