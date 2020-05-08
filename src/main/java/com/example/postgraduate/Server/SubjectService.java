package com.example.postgraduate.Server;

import com.example.postgraduate.POJO.Subject;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Repository
public interface SubjectService {
    Boolean addSubject(String subject_name);

    Boolean deleteSubject(Integer subject_id);

    List<Subject> getAllSubject();
}
