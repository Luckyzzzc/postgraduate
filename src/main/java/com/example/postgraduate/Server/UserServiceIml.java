package com.example.postgraduate.Server;

import com.example.postgraduate.Dao.UserMapper;
import com.example.postgraduate.POJO.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceIml implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public boolean regist(User user) {
        if(userMapper.find(user.getUsername()) != null){
            return false;
        }
        return userMapper.regist(user);
    }

    @Override
    public boolean userBan(Integer user_id, Integer isBan) {
        return userMapper.userBan(user_id,isBan);
    }

    @Override
    public boolean changePassword(Integer user_id, String oldPassword, String newPassword) {
        if(userMapper.findById(user_id).getPassword().compareTo(oldPassword) != 0){
            return false;
        }
        return userMapper.changePassword(user_id, newPassword);
    }

    @Override
    public void addInvitation(Integer user_id) {

    }

    @Override
    public void addComment(Integer user_id) {

    }

    @Override
    public User find(String username) {
        return userMapper.find(username);
    }

    @Override
    public User findById(Integer user_id) {
        return userMapper.findById(user_id);
    }


}
