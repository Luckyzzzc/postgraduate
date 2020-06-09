package com.example.postgraduate.Server;

import com.example.postgraduate.POJO.Comment;
import com.example.postgraduate.POJO.Invitation;
import com.example.postgraduate.POJO.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    boolean regist(User user);

    boolean userBan(Integer user_id ,Integer isBan);

    boolean changePassword(Integer user_id, String oldPassword, String newPassword);

    boolean addInvitation(Integer user_id);

    boolean addComment(Integer user_id);

    List<User> findAll();

    User find(String username);

    User findById(Integer user_id);

    boolean changeSex(Integer user_id, Integer sex);

    boolean addFollow(Integer user_id);

    boolean changeNickname(Integer user_id, String nickname);

    List<Invitation> getAllInvitation(Integer user_id);

    List<Comment> getAllComment(Integer user_id);
    
    boolean changeSchoolId(Integer user_id, Integer school_id);
    
    boolean changeSubjectId(Integer user_id, Integer subject_id);
}
