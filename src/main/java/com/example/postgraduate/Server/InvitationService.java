package com.example.postgraduate.Server;

import com.example.postgraduate.POJO.Invitation;
import com.example.postgraduate.POJO.PlateCounts;

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

    List<Invitation> getInvitationBySchool(Integer school_id);

    Boolean deleteInvitation(Integer invitation_id);

    List<Invitation> getInvitationById(Integer invitation_id);

    boolean updateInvitation(Integer invitation_id, String title, String content, Integer plate);
    
    List<Integer> getAllPlateList();
    
    List<PlateCounts> countinvitationbyplate();

    String getUsername(Integer post_user);

    List<Invitation> getCatalog();

    List<Invitation> getAllInvitation();

    List<Invitation> getAllCatalog();

    boolean deleteComment(Integer comment_invitation);
}
