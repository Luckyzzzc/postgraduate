package com.example.postgraduate.Server;

import com.example.postgraduate.Dao.SchoolMapper;
import com.example.postgraduate.POJO.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Repository
public class SchoolServiceIml implements SchoolService{
    @Autowired
    SchoolMapper schoolMapper;

    @Override
    public boolean addSchool(School school) {
        return schoolMapper.addSchool(school);
    }

    @Override
    public boolean deleteSchool(Integer school_id) {
        return schoolMapper.deleteSchool(school_id);
    }

    @Override
    public List<School> getAllSchool() {
        return schoolMapper.getAllSchool();
    }
}
