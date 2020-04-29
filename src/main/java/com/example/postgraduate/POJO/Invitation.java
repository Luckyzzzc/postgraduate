package com.example.postgraduate.POJO;

import org.springframework.stereotype.Component;

@Component
public class Invitation {
    private Integer invitation_id;
    private String invitation_title;
    private String content;
    private Integer plate;
    private Integer invitation_status;
    private Integer scan_number;
    private Integer post_user;
    private String update_time;
    private String create_time;

    public Integer getInvitation_id() {
        return invitation_id;
    }

    public void setInvitation_id(Integer invitation_id) {
        this.invitation_id = invitation_id;
    }

    public String getInvitation_title() {
        return invitation_title;
    }

    public void setInvitation_title(String invitation_title) {
        this.invitation_title = invitation_title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getPlate() {
        return plate;
    }

    public void setPlate(Integer plate) {
        this.plate = plate;
    }

    public Integer getInvitation_status() {
        return invitation_status;
    }

    public void setInvitation_status(Integer invitation_status) {
        this.invitation_status = invitation_status;
    }

    public Integer getScan_number() {
        return scan_number;
    }

    public void setScan_number(Integer scan_number) {
        this.scan_number = scan_number;
    }

    public Integer getPost_user() {
        return post_user;
    }

    public void setPost_user(Integer post_user) {
        this.post_user = post_user;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }
}
