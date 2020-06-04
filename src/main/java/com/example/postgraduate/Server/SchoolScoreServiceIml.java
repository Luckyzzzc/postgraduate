package com.example.postgraduate.Server;

import com.example.postgraduate.Dao.SchoolScoreMapper;
import com.example.postgraduate.POJO.SchoolScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Repository
public class SchoolScoreServiceIml implements SchoolScoreService{
    @Autowired
    SchoolScoreMapper schoolScoreMapper;

    @Override
    public List<SchoolScore> selectSchoolScore() {
        return schoolScoreMapper.selectSchoolScore();
    }

    @Override
    public List<SchoolScore> selectSchoolScoreById(Integer school_id) {
        return schoolScoreMapper.selectSchoolScoreById(school_id);
    }

    @Override
    public boolean deleteSchoolScore(Integer school_id) {
        return schoolScoreMapper.deleteSchoolScore(school_id);
    }
}
