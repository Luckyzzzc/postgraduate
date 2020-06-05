package com.example.postgraduate.Server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.postgraduate.Dao.PlateMapper;
import com.example.postgraduate.POJO.Plate;

@Service
public class PlateServiceIml implements PlateService{

	@Autowired
	PlateMapper plateMapper;
	
	@Override
	public boolean addPlate(Plate plate) {
		// TODO Auto-generated method stub
		return plateMapper.addPlate(plate);
	}

	@Override
	public boolean changeName(Integer id, String name) {
		// TODO Auto-generated method stub
		return plateMapper.changeName(id, name);
	}

	@Override
	public boolean deletePlate(Integer id) {
		// TODO Auto-generated method stub
		return plateMapper.deletePlate(id);
	}

	@Override
	public List<Plate> getAllPlates() {
		// TODO Auto-generated method stub
		return plateMapper.getAllPlates();
	}

	@Override
	public Plate getPlateById(Integer id) {
		// TODO Auto-generated method stub
		return plateMapper.getPlateById(id);
	}
	
}
