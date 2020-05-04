package com.example.postgraduate.Controller;

import com.example.postgraduate.POJO.UserRoot;
import com.example.postgraduate.Server.UserRootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/userroot")
@CrossOrigin
public class UserRootController {
    @Autowired
    UserRootService userRootService;

    @RequestMapping("/findroot")
    UserRoot findRoot(){
        return userRootService.findRoot();
    }

    @RequestMapping("/addroot")
    boolean addRoot(String root_name){
        return userRootService.addRoot(root_name);
    }

    @RequestMapping("/deleteroot")
    boolean deleteRoot(Integer root_id){
        return userRootService.deleteRoot(root_id);
    }
}
