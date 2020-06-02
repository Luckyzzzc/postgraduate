package com.example.postgraduate.Server;

import com.example.postgraduate.POJO.Invitation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InvitationService {
    boolean post(Invitation invitation);

    boolean changeStatus(Integer invitation_id, Integer invitation_status);

    boolean addScan(Integer invitation_id);

    List<Invitation> getHotInvitation();

    List<Invitation> getInvitation();

    List<Invitation> getPlateInvitation(Integer plate);

    List<Invitation> queryInvitation(String condition);
}
