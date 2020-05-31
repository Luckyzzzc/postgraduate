package com.example.postgraduate.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.example.postgraduate.POJO.Carousel;


@Mapper
@Repository
public interface CarouselMapper {
	@Insert("INSERT INTO `postgraduate`.`carousel` (`url`, `title`, `content`,`create_time`) " +
            "VALUES (#{url}, #{title}, #{content}, #{create_time});")
    boolean addCarousel(Carousel carousel);

    @Update("UPDATE `postgraduate`.`carousel` SET "
    		+ "`carousel`.`url` = #{url},"
    		+ "`carousel`.`title` = #{title},"
    		+ "`carousel`.`content` = #{content} "
    		+ " WHERE `carousel`.`carousel_id` = #{carousel_id}")
    boolean updateCarousel(@Param("carousel_id") Integer carousel_id,@Param("url") String url,@Param("title") String title,@Param("content") String content);

    @Delete("DELETE FROM `postgraduate`.`carousel` WHERE `carousel`.`carousel_id` = #{carousel_id}")
    boolean deleteCarousel(Integer carousel_id);

    @Select("SELECT * FROM `postgraduate`.`carousel` WHERE `carousel`.`carousel_id` = #{carousel_id}")
    Carousel getCarousel(Integer carousel_id);
    
    @Select("SELECT * FROM `postgraduate`.`carousel`")
    List<Carousel> getAllCarousels();
}
