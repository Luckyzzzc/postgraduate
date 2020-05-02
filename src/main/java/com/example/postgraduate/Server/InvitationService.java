package com.example.postgraduate.Server;

import com.example.postgraduate.POJO.Invitation;
import org.springframework.stereotype.Service;

@Service
public interface InvitationService {
    boolean post(Invitation invitation);

    boolean changeStatus(Integer invitation_id, Integer invitation_status);

    boolean addScan(Integer invitation_id);
}
