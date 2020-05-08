package com.example.postgraduate.Server;

import com.example.postgraduate.Dao.SubjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.postgraduate.POJO.Subject;

import java.util.List;

@Service
public class SubjectServiceIml implements SubjectService{

    @Autowired
    SubjectMapper subjectMapper;

    @Override
    public Boolean addSubject(String subject_name) {
        return subjectMapper.addSubject(subject_name);
    }

    @Override
    public Boolean deleteSubject(Integer subject_id) {
        return subjectMapper.deleteSubject(subject_id);
    }

    @Override
    public List<Subject> getAllSubject() {
        return subjectMapper.getAllSubject();
    }
}
