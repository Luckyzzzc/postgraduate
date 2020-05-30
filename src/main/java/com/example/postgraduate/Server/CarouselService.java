package com.example.postgraduate.Server;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.postgraduate.POJO.Carousel;

@Service
public interface CarouselService {

    boolean addCarousel(Carousel carousel);

    boolean updateCarousel(Integer carousel_id, String url, String title,String content);

    boolean deleteCarousel(Integer carousel_id);

    Carousel getCarousel(Integer carousel_id);
    
    List<Carousel> getAllCarousels();
}
