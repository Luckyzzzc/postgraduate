package com.example.postgraduate.Controller;

import com.example.postgraduate.POJO.Comment;
import com.example.postgraduate.POJO.Invitation;
import com.example.postgraduate.POJO.User;
import com.example.postgraduate.Server.UserService;
import com.example.postgraduate.Util.TokenUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/User",consumes = "application/json",produces = "application/json;charset=utf-8")
@CrossOrigin
@ResponseBody
@Api(tags = "用户管理类的api文档")
public class userController {
    @Autowired
    UserService userService;

    @PostMapping(value = "/regist",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "用于添加用户的接口")
    boolean regist(@RequestBody userRigistAndLogin userRigistAndLogin){
        if(userService.find(userRigistAndLogin.getUsername()) != null){
            return false;
        }
        User user = new User(userRigistAndLogin.getUsername(),userRigistAndLogin.getPassword());
        return userService.regist(user);
    }


    @PostMapping(value = "/isban")
    @ApiOperation(value = "用于改变用户封禁状态的接口")
    boolean isBan(@RequestBody changeDate changeDate){
        return userService.userBan(changeDate.getUser_id(), (Integer)changeDate.getDate());
    }

    @PostMapping(value = "/changepassword")
    @ApiOperation(value = "用于修改用户密码的接口")
    boolean changePassword(@RequestBody changePasswordTmp changePasswordTmp){
        return userService.changePassword(changePasswordTmp.getUser_id(),changePasswordTmp.getOldPassword(),changePasswordTmp.getNewPassword());
    }


    @PostMapping(value = "/login")
    @ApiOperation(value = "用于登录用户的接口")
    boolean login(HttpServletResponse response, @RequestBody userRigistAndLogin userRigistAndLogin){
        if(userService.find(userRigistAndLogin.getUsername()).getPassword().compareTo(userRigistAndLogin.getPassword()) == 0) {
            User user = new User(userRigistAndLogin.getUsername(),userRigistAndLogin.getPassword());
            String token = TokenUtil.sign(user);
            response.addHeader("token", token);
            return true;
        }
        return false;
    }

    @PostMapping(value = "/addinvitation")
    @ApiOperation(value = "用于添加帖子的接口")
    boolean addInvitation(@RequestBody Map<String, Object> map){
        return userService.addInvitation((Integer)map.get("user_id"));
    }

    @PostMapping(value = "/addcomment")
    @ApiOperation(value = "用于添加评论的接口")
    boolean addComment(@RequestBody Map<String, Object> map){
        return userService.addComment((Integer)map.get("user_id"));
    }

    @PostMapping(value = "/changesex")
    @ApiOperation(value = "用于更改性别的接口")
    boolean changeSex(@RequestBody changeDate changeDate){
        return userService.changeSex(changeDate.getUser_id(), (Integer) changeDate.getDate());
    }

    @PostMapping(value = "/addfollow")
    @ApiOperation(value = "用于添加关注的接口")
    boolean addFollow(@RequestBody Map<String, Object> map){
        return userService.addFollow((Integer)map.get("user_id"));
    }

    @PostMapping(value = "/changenickname")
    @ApiOperation(value = "用于更改昵称的接口")
    boolean changeNickname(@RequestBody changeDate changeDate){
        return userService.changeNickname(changeDate.getUser_id(), (String) changeDate.getDate());
    }

    @PostMapping(value = "/findall")
    @ApiOperation(value = "查询所有用户的接口")
    List<User> findAll(){
       return userService.findAll();
    }

    @PostMapping(value = "/findbyid")
    @ApiOperation(value = "通过id查询用户")
    User findById(@RequestBody Map<String, Object> map){
        return userService.findById((Integer)map.get("user_id"));
    }

    @PostMapping(value = "/findbyname")
    @ApiOperation(value = "通过用户名查询用户")
    User findByName(@RequestBody Map<String, Object> map){
        return userService.find((String) map.get("username"));
    }

    @PostMapping(value = "/getinvitation")
    @ApiOperation(value = "获得所有文章")
    List<Invitation> getAllInvitation(@RequestBody getDate getDate){
        return userService.getAllInvitation(getDate.getUser_id());
    }

    @PostMapping(value = "/getcomment")
    @ApiOperation(value = "获得所有评论")
    List<Comment> getAllComment(@RequestBody getDate getDate){
        return userService.getAllComment(getDate.getUser_id());
    }

}

class userRigistAndLogin{
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

class changePasswordTmp{
    public Integer user_id;
    public String oldPassword;
    public String newPassword;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}

class changeDate{
    Integer user_id;
    Object date;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Object getDate() {
        return date;
    }

    public void setDate(Object date) {
        this.date = date;
    }
}

class getDate{
    private Integer user_id;
    private Object index;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Object getIndex() {
        return index;
    }

    public void setIndex(Object index) {
        this.index = index;
    }
}