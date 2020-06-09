package com.example.postgraduate.Controller;

import com.example.postgraduate.POJO.Subject;
import com.example.postgraduate.Server.SubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

@ResponseBody
@Controller
@CrossOrigin
@RequestMapping(value = "/subject",produces = "application/json;charset=utf-8")
@Api(tags = "学科类的api文档")
public class SubjectController {
    @Autowired
    SubjectService subjectService;

    @PostMapping(value = "/addsubject")
    @ApiOperation(value = "用于添加学科[参数:subject_name]")
    boolean addSubject(@RequestBody Map<String, Object> map){
        return subjectService.addSubject((String)map.get("subject_name"));
    }

    @PostMapping(value = "/deletesubject")
    @ApiOperation(value = "用于删除学科[参数:subject_id]")
    boolean deleteSubject(Map<String, Object> map){
        return subjectService.deleteSubject((Integer)map.get("subject_id"));
    }

    @PostMapping(value = "/getallsubject")
    @ApiOperation(value = "用于获得所有学科")
    List<Subject> getAllSubjcet(){
        return subjectService.getAllSubject();
    }
    
    @PostMapping(value = "/getsubjectbyid")
    @ApiOperation(value = "按照学科id获得学科")
    Subject getSubjectById(Map<String, Object> map) {
    	return subjectService.getSubjectById((Integer)map.get("id"));
    }
}
