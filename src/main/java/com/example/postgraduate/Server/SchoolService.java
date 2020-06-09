package com.example.postgraduate.Server;

import com.example.postgraduate.POJO.School;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Repository
public interface SchoolService {
    boolean addSchool(School school);

    boolean deleteSchool(Integer school_id);

    List<School> getAllSchool();

    List<School> getSchoolById(Integer school_id);
}
