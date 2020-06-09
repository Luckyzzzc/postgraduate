package com.example.postgraduate.Controller;

import com.example.postgraduate.POJO.SchoolScore;
import com.example.postgraduate.Server.SchoolScoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/score",produces = "application/json;charset=utf-8")
@CrossOrigin
@ResponseBody
@Api(tags = "学校分数线类的api文档")
public class SchoolScoreController {
    @Autowired
    SchoolScoreService schoolScoreService;

    @PostMapping("/select")
    @ApiOperation(value = "用于获得全部学校信息的接口")
    public List<SchoolScore> selectAll () {
        return schoolScoreService.selectSchoolScore();
    }

    @PostMapping("/selectbyid")
    @ApiOperation(value = "用于获得某个学校分数信息的接口[参数:school_id]")
    public List<SchoolScore> selectById(@RequestBody Map<String, Object> map){
        return schoolScoreService.selectSchoolScoreById((Integer)map.get("school_id"));
    }

    @PostMapping("/delete")
    @ApiOperation(value = "用于删除某条信息得接口[参数:school_id]")
    public boolean deleteScore(@RequestBody Map<String, Object> map){
        return schoolScoreService.deleteSchoolScore((Integer)map.get("school_id"));
    }
}
