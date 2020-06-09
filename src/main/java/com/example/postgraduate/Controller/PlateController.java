package com.example.postgraduate.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.postgraduate.POJO.Plan;
import com.example.postgraduate.POJO.Plate;
import com.example.postgraduate.Server.PlateService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "/plate",produces = "application/json;charset=utf-8")
@CrossOrigin
@ResponseBody
@Api(tags = "分区类的api文档")
public class PlateController {
	@Autowired
	PlateService plateService;
	
	@PostMapping("/addplate")
    @ApiOperation(value = "用于添加分区的接口[参数:name]")
	Boolean  addPlate(@RequestBody Map<String, Object> map){
        Plate plate = new Plate((String)map.get("name"));
        return plateService.addPlate(plate);
    }
	
//	@PostMapping("/changeplatename")
//    @ApiOperation(value = "用于改变分区名称的接口")
//    boolean changeStatus(@RequestBody Plate changePlate){
//        return plateService.changeName(changePlate.getId(),changePlate.getName());
//    }

    @PostMapping("/deleteplate")
    @ApiOperation(value = "用于删除分区的接口[参数:id]")
    boolean deletePlan(@RequestBody Map<String, Object> map){
        return plateService.deletePlate((Integer)map.get("id"));
    }

    @PostMapping("/getPlate")
    @ApiOperation(value = "用于获得所有分区")
    List<Plate> getAllPlate(){
        return plateService.getAllPlates();
    }

    @PostMapping("/getplanbyid")
    @ApiOperation(value = "通过id获得分区[参数:id]")
    Plate getPlateById(@RequestBody Map<String, Object> map){
        return plateService.getPlateById((Integer)map.get("id"));
    }
}
