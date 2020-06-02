package com.example.postgraduate.Dao;

import com.example.postgraduate.POJO.Invitation;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Select("SELECT * FROM `postgraduate`.`invitation` ORDER BY `invitation`.`scan_number` desc;")
    List<Invitation> getHotInvitation();

    @Select("SELECT * FROM `postgraduate`.`invitation`;")
    List<Invitation> getInvitation();

    @Select("SELECT * FROM `postgraduate`.`invitation` WHERE `invitation`.`plate` = #{plate};")
    List<Invitation> getPlateInvitation(Integer plate);
}
