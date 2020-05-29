package com.example.postgraduate.Server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.postgraduate.Dao.CarouselMapper;
import com.example.postgraduate.POJO.Carousel;

public class CarouselServiceIml implements CarouselService {

	@Autowired
	CarouselMapper carouselMapper;
	
	public boolean addCarousel(Carousel carousel) {
		// TODO Auto-generated method stub
		return carouselMapper.addCarousel(carousel);
	}

	public boolean updateCarousel(Integer carousel_id, String url, String title, String content) {
		// TODO Auto-generated method stub
		return carouselMapper.updateCarousel(carousel_id, url, title, content);
	}

	public boolean deleteCarousel(Integer carousel_id) {
		// TODO Auto-generated method stub
		return carouselMapper.deleteCarousel(carousel_id);
	}

	public Carousel getCarousel(Integer carousel_id) {
		// TODO Auto-generated method stub
		return carouselMapper.getCarousel(carousel_id);
	}
	
	public List<Carousel> getAllCarousels(){
		return carouselMapper.getAllCarousels();
	}

}
