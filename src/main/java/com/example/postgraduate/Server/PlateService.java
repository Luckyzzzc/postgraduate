package com.example.postgraduate.Server;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.postgraduate.Dao.PlateMapper;
import com.example.postgraduate.POJO.Plate;

@Service
@Repository
public interface PlateService {
	
	boolean addPlate(Plate plate);
	
	boolean changeName(Integer id, String name);
	
	boolean deletePlate(Integer id);

	List<Plate> getAllPlates();

	Plate getPlateById(Integer id);
}
