package com.example.postgraduate.Server;

import com.example.postgraduate.POJO.UserRoot;
import org.springframework.stereotype.Service;

@Service
public interface UserRootService {
    UserRoot findRoot();

    boolean addRoot(String str);

    boolean deleteRoot(Integer root_id);
}
