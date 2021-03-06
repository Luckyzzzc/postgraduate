package com.example.postgraduate.Dao;

import com.example.postgraduate.POJO.Invitation;
import com.example.postgraduate.POJO.PlateCounts;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface InvitationMapper {
    @Insert("INSERT INTO `postgraduate`.`invitation` (`invitation_title`, `content`, `plate`, `invitation_status`, `scan_number`, `post_user`, `update_time`, `create_time`,`invitation_type`,`school_id`) " +
            "VALUES (#{invitation_title}, #{content}, #{plate}, #{invitation_status}, #{scan_number}, #{post_user}, #{update_time}, #{create_time},#{invitation_type} ,#{school_id});")
    boolean post(Invitation invitation);

    @Update("UPDATE `postgraduate`.`invitation` SET `invitation`.`invitation_status` = #{invitation_status} WHERE `invitation`.`invitation_id` = #{invitation_id};")
    boolean changeStatus(Integer invitation_id, Integer invitation_status);

    @Update("UPDATE `postgraduate`.`invitation` SET `invitation`.`scan_number` = `invitation`.`scan_number` + 1 WHERE `invitation`.`invitation_id` = #{invitation_id};")
    boolean addScan(Integer invitation_id);

    @Select("SELECT * FROM `postgraduate`.`invitation` WHERE `invitation`.`invitation_type` = 0 ORDER BY `invitation`.`scan_number` desc;")
    List<Invitation> getHotInvitation();

    @Select("SELECT * FROM `postgraduate`.`invitation` WHERE `invitation`.`invitation_type` = 0 limit 0,10;")
    List<Invitation> getInvitation();

    @Select("SELECT * FROM `postgraduate`.`invitation` WHERE `invitation`.`invitation_type` = 1 limit 0,10;")
    List<Invitation> getCatalog();

    @Select("SELECT * FROM `postgraduate`.`invitation` WHERE `invitation`.`invitation_type` = 0;")
    List<Invitation> getAllInvitation();

    @Select("SELECT * FROM `postgraduate`.`invitation` WHERE `invitation`.`invitation_type` = 1;")
    List<Invitation> getAllCatalog();

    @Select("SELECT * FROM `postgraduate`.`invitation` WHERE `invitation`.`plate` = #{plate};")
    List<Invitation> getPlateInvitation(Integer plate);

    @Select("SELECT * FROM `postgraduate`.`invitation` WHERE `invitation`.`invitation_title` LIKE '%' #{condition} '%'")
    List<Invitation> queryInvitation(String condition);

    @Select("SELECT * FROM `postgraduate`.`invitation` WHERE `invitation`.`school_id` = #{school_id}")
    List<Invitation> getInvitationBySchool(Integer school_id);

    @Delete("DELETE FROM `postgraduate`.`invitation` WHERE `invitation`.`invitation_id` = #{invitation_id}")
    Boolean deleteInvitation(Integer invitation_id);

    @Select("SELECT * FROM `postgraduate`.`invitation` WHERE `invitation`.`invitation_id` = #{invitation_id}")
    List<Invitation> getInvitationById(Integer invitation_id);

    @Update("UPDATE `postgraduate`.`invitation` SET invitation_title = #{title}, content = #{content}, plate = #{plate} WHERE invitation_id = #{invitation_id};")
    boolean updateInvitation(Integer invitation_id, String title, String content, Integer plate);
    
    @Select("SELECT DISTINCT `invitation`.`plate` FROM `postgraduate`.`invitation`")
    List<Integer> getAllInvationPlateType();
    
    @Select("SELECT `postgraduate`.`invitation` .`plate`,`postgraduate`.`plate`.`name`,"
    		+ "COUNT(`postgraduate`.`invitation` .`invitation_id`) AS `counts`" + 
    		"FROM  `postgraduate`.`invitation` left join `postgraduate`.`plate`"
    		+ " on `postgraduate`.`invitation`.`plate` = `postgraduate`.`plate` .`id`"
    		+ "group by(`postgraduate`.`invitation`.`plate`)")
    List<PlateCounts> countinvitationbyplate();

    @Select("SELECT `postgraduate`.`user`.`username` FROM `postgraduate`.`user` WHERE `user`.`user_id` = #{post_user};")
    String getUsername(Integer post_user);

    @Delete("DELETE FROM `postgraduate`.`comment` WHERE `comment`.`comment_invitation` = #{comment_invitation}")
    boolean deleteComment(Integer comment_invitation);
}
