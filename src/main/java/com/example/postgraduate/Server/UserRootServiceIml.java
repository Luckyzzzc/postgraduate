package com.example.postgraduate.Server;

import com.example.postgraduate.Dao.UserRootMapper;
import com.example.postgraduate.POJO.UserRoot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRootServiceIml implements UserRootService {

    @Autowired
    UserRootMapper userRootMapper;

    @Override
    public UserRoot findRoot() {
        return userRootMapper.findRoot();
    }

    @Override
    public boolean addRoot(String str) {
        return userRootMapper.addRoot(str);
    }

    @Override
    public boolean deleteRoot(Integer root_id) {
        return userRootMapper.deleteRoot(root_id);
    }
    
}
