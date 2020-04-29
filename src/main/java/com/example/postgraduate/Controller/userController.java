package com.example.postgraduate.Controller;

import com.example.postgraduate.POJO.User;
import com.example.postgraduate.Server.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/User")
@CrossOrigin
public class userController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/regist")
    boolean regist(@RequestParam String username, @RequestParam String password){
        if(userService.find(username) != null){
            return false;
        }
        User user = new User(username, password);
        return userService.regist(user) != true;
    }

    @RequestMapping(value = "/isban")
    boolean isBan(@RequestParam Integer user_id, @RequestParam Integer isBan){
        return userService.userBan(user_id,isBan);
    }

    @RequestMapping(value = "/change_password")
    boolean changePassword(@RequestParam Integer user_id, @RequestParam String oldPassword, @RequestParam String newPassword){
        return userService.changePassword(user_id,oldPassword,newPassword);
    }

    @RequestMapping(value = "/login")
    boolean login(@RequestParam String username, @RequestParam String password){
        return userService.find(username).getPassword().compareTo(password) == 0;
    }
}
