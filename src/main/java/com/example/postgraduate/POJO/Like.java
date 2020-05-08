package com.example.postgraduate.POJO;

import org.springframework.stereotype.Component;

@Component
public class Like {
    private Integer like_id;
    private Integer comment_id;
    private Integer invitation_id;
    private Integer user_id;

    public Like(){}

    public Like(Integer comment_id, Integer invitation_id, Integer user_id){
        this.comment_id = comment_id;
        this.invitation_id = invitation_id;
        this.user_id = user_id;
    }

    public Integer getLike_id() {
        return like_id;
    }

    public void setLike_id(Integer like_id) {
        this.like_id = like_id;
    }

    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }

    public Integer getInvitation_id() {
        return invitation_id;
    }

    public void setInvitation_id(Integer invitation_id) {
        this.invitation_id = invitation_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}
