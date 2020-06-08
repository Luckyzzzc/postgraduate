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

import com.example.postgraduate.POJO.Carousel;
import com.example.postgraduate.Server.CarouselService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "/carousel",produces = "application/json;charset=utf-8")
@CrossOrigin
@ResponseBody
@Api(tags = "轮播图类的api文档")
public class carouselController {
	@Autowired
	CarouselService carouselService;
	
	@PostMapping("/addCarousel")
	@ApiOperation(value = "用于添加轮播图的接口")
	public boolean addCarousel(@RequestBody postCarousel carousel) {
		Carousel addCarousel = new Carousel(carousel.url, carousel.title, carousel.content);
		return carouselService.addCarousel(addCarousel);
	}
	
	@PostMapping("/updateCarousel")
	@ApiOperation(value = "用于改变轮播图状态")
	public boolean updateCarousel(@RequestBody updateCarousel updateCarousel) {
		return carouselService.updateCarousel(updateCarousel.carousel_id, updateCarousel.url, updateCarousel.title, updateCarousel.content);
	}
	
	
	@PostMapping("/deleteCarousel")
	@ApiOperation(value = "用于删除轮播图[参数 carousel_id]")
	public boolean deleteCarousel(@RequestBody Map<String, Object> map) {
		return carouselService.deleteCarousel((Integer)map.get("carousel_id"));
	}
	
	@PostMapping("/getCarousel")
	@ApiOperation(value = "用于获得指定id的轮播图[参数 carousel_id]")
	public Carousel getCarousel(@RequestBody Map<String, Object> map) {
		return carouselService.getCarousel((Integer)map.get("carousel_id"));
	}
	
	@PostMapping("/getAllCarousels")
	@ApiOperation(value = "获得所有轮播图")
	public List<Carousel> getAllCarousels(){
		return carouselService.getAllCarousels();
	}
		
}

class postCarousel{
	String url;
	String title;
	String content;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}

class updateCarousel{
	Integer carousel_id;
	String url;
	String title;
	String content;
	
	public Integer getCarousel_id() {
		return carousel_id;
	}
	public void setCarousel_id(Integer carousel_id) {
		this.carousel_id = carousel_id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}