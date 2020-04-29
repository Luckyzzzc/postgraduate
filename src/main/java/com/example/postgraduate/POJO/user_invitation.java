package com.example.postgraduate.POJO;

import org.springframework.stereotype.Component;

@Component
public class user_invitation {
    private Integer user_id;
    private Integer invitation_id;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getInvitation_id() {
        return invitation_id;
    }

    public void setInvitation_id(Integer invitation_id) {
        this.invitation_id = invitation_id;
    }
}
