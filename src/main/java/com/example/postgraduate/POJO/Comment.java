package com.example.postgraduate.POJO;

import org.springframework.stereotype.Component;

@Component
public class Comment {
    private Integer comment_id;
    private String content;
    private Integer comment_user;
    private Integer comment_invitation;
    private Integer comment_status;
    private Integer like_number;
    private String create_time;
    private String update_time;

    public Comment(){}

    public Comment(String content, Integer comment_user, Integer comment_invitation){
        this.comment_id = 0;
        this.content = content;
        this.comment_user = comment_user;
        this.comment_invitation = comment_invitation;
        this.comment_status = 0;
        this.like_number = 0;
        this.create_time = null;
        this.update_time = null;
    }

    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getComment_user() {
        return comment_user;
    }

    public void setComment_user(Integer comment_user) {
        this.comment_user = comment_user;
    }

    public Integer getComment_status() {
        return comment_status;
    }

    public void setComment_status(Integer comment_status) {
        this.comment_status = comment_status;
    }

    public Integer getLike_number() {
        return like_number;
    }

    public void setLike_number(Integer like_number) {
        this.like_number = like_number;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public Integer getComment_invitation() {
        return comment_invitation;
    }

    public void setComment_invitation(Integer comment_invitation) {
        this.comment_invitation = comment_invitation;
    }
}
