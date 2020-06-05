package com.example.postgraduate.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.example.postgraduate.POJO.Plan;
import com.example.postgraduate.POJO.Plate;

@Mapper
@Repository
public interface PlateMapper {
	@Insert("INSERT INTO `postgraduate`.`plate` (`name`) VALUES (#{name});")
    boolean addPlate(Plate plate);

    @Update("UPDATE `postgraduate`.`plate` SET `name` = #{name} WHERE (`id` = #{id});")
    boolean changeName(Integer id, String name);

    @Delete("DELETE FROM `postgraduate`.`plate` WHERE `plate`.`id` = #{id}")
    boolean deletePlate(Integer id);

    @Select("SELECT * FROM `postgraduate`.`plate`;")
    List<Plate> getAllPlates();

    @Select("SELECT * FROM `postgraduate`.`plate` WHERE `plate`.`id` = #{id};")
    Plate getPlateById(Integer id);
	
	
}
