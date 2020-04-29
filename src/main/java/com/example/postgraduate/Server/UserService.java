package com.example.postgraduate.Server;

import com.example.postgraduate.POJO.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    boolean regist(User user);

    boolean userBan(Integer user_id ,Integer isBan);

    boolean changePassword(Integer user_id, String oldPassword, String newPassword);

    void addInvitation(Integer user_id);

    void addComment(Integer user_id);

    User find(String username);

    User findById(Integer user_id);
}
