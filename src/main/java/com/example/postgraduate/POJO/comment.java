package com.example.postgraduate.POJO;

import org.springframework.stereotype.Component;

@Component
public class comment {
    private Integer comment_id;
    private String content;
    private Integer comment_user;
    private Integer comment_status;
    private Integer like_number;

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

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public String getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(String update_date) {
        this.update_date = update_date;
    }

    private String create_date;
    private String update_date;
}
