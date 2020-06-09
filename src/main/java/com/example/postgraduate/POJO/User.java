package com.example.postgraduate.POJO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

@Api(value = "用户表")
public class User {
    private Integer user_id;
    private String username;
    private String password;
    private String phone;
    private String nickname;
    private Integer root;
    private Integer sex;
    private Integer isBan;
    private Integer invitation_number;
    private Integer comment_number;
    private Integer follow;
    private String head_sculpture;
    private Integer school_id;
    private Integer subject_id;
    
    public User(){}

    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.phone = null;
        this.nickname = null;
        this.root = 0;
        this.sex = 0;
        this.isBan = 0;
        this.invitation_number = 0;
        this.comment_number = 0;
        this.follow = 0;
        this.head_sculpture = null;
        this.school_id = 0;
        this.subject_id = 0;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setRoot(Integer root) {
        this.root = root;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public void setIsBan(Integer isBan) {
        this.isBan = isBan;
    }

    public void setInvitation_number(Integer invitation_number) {
        this.invitation_number = invitation_number;
    }

    public void setComment_number(Integer comment_number) {
        this.comment_number = comment_number;
    }

    public void setFollow(Integer follow) {
        this.follow = follow;
    }

    public void setHead_sculpture(String head_sculpture) {
        this.head_sculpture = head_sculpture;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getNickname() {
        return nickname;
    }

    public Integer getRoot() {
        return root;
    }

    public Integer getSex() {
        return sex;
    }

    public Integer getIsBan() {
        return isBan;
    }

    public Integer getInvitation_number() {
        return invitation_number;
    }

    public Integer getComment_number() {
        return comment_number;
    }

    public Integer getFollow() {
        return follow;
    }

    public String getHead_sculpture() {
        return head_sculpture;
    }

	public Integer getSchool_id() {
		return school_id;
	}

	public void setSchool_id(Integer school_id) {
		this.school_id = school_id;
	}

	public Integer getSubject_id() {
		return subject_id;
	}

	public void setSubject_id(Integer subject_id) {
		this.subject_id = subject_id;
	}

}
