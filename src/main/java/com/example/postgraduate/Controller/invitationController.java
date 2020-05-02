package com.example.postgraduate.Controller;

import com.example.postgraduate.POJO.Invitation;
import com.example.postgraduate.Server.InvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/invitation")
@CrossOrigin
public class invitationController {
    @Autowired
    InvitationService invitationService;

    @RequestMapping(value = "/post")
    boolean post(@RequestParam Integer user_id, @RequestParam String invitation_title,
                 @RequestParam String invitation_content, @RequestParam Integer invitation_plate){
        Invitation invitation = new Invitation(invitation_title,invitation_content,invitation_plate,user_id);
        return invitationService.post(invitation);
    }

    @RequestMapping(value = "/changestatus")
    boolean changestatus(Integer invitation_id, Integer invitation_status){
        return invitationService.changeStatus(invitation_id, invitation_status);
    }

    @RequestMapping(value = "/addscan")
    boolean addScan(Integer invitation_id){
        return invitationService.addScan(invitation_id);
    }
}
