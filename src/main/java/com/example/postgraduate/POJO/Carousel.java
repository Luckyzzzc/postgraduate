package com.example.postgraduate.POJO;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Carousel {
	private  Integer carousel_id;
	private  String url;
	private  String title;
	private  String content;
	private  String create_time;
	
	public Carousel() {
		
	}
	
	public Carousel(String url, String title,String content) {
		this.url = url;
		this.title = title;
		this.content =content;
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());

        this.create_time = formatter.format(date);
		
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

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public Integer getCarousel_id() {
		return carousel_id;
	}

	public void setCarousel_id(Integer carousel_id) {
		this.carousel_id = carousel_id;
	}
	
}
