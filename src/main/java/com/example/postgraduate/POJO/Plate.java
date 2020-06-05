package com.example.postgraduate.POJO;

import org.springframework.stereotype.Component;


@Component
public class Plate {
	private Integer id;
	private String name;
	
	public Plate() {
		
	}
	
	public Plate(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
