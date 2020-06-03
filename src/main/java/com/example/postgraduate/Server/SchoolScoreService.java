package com.example.postgraduate.Server;

import com.example.postgraduate.POJO.SchoolScore;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Repository
public interface SchoolScoreService {
    List<SchoolScore> selectSchoolScore();

    List<SchoolScore> selectSchoolScoreById(Integer school_id);

    boolean deleteSchoolScore(Integer school_id);
}
