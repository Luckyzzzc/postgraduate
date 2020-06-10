package com.example.postgraduate.Controller;

import com.example.postgraduate.POJO.Invitation;
import com.example.postgraduate.POJO.PlateCounts;
import com.example.postgraduate.Server.InvitationService;

import com.example.postgraduate.Util.ResultUtil;
import com.example.postgraduate.Util.TokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/invitation",produces = "application/json;charset=utf-8")
@CrossOrigin
@ResponseBody
@Api(tags = "发帖类的api文档")
public class invitationController {
    @Autowired
    InvitationService invitationService;

    @PostMapping(value = "/post")
    @ApiOperation(value = "用于添加帖子的接口")
    Object post(@RequestBody postInvitation postInvitation, HttpServletRequest request){
        Invitation invitation = new Invitation(postInvitation.getInvitation_title(),postInvitation.getContent(),postInvitation.getPlate(),postInvitation.getPost_user(),postInvitation.getInvitation_type(),postInvitation.getSchool_id());
        String username = invitationService.getUsername(postInvitation.getPost_user());
        if(request.getHeader("token") == null || username.compareTo(TokenUtil.getUsername(request.getHeader("token"))) != 0)
            return ResultUtil.error(500,"用户未登陆");
        return invitationService.post(invitation);
    }

    @PostMapping(value = "/changestatus")
    @ApiOperation(value = "用于改变帖子的接口")
    boolean changestatus(@RequestBody changeInvitation changeInvitation){
        return invitationService.changeStatus(changeInvitation.getInvitation_id(), (Integer)changeInvitation.getDate());
    }

    @PostMapping(value = "/addscan")
    @ApiOperation(value = "用于增加帖子浏览数的接口[参数:invitation_id]")
    boolean addScan(@RequestBody Map<String, Object> map){
        return invitationService.addScan((Integer)map.get("invitation_id"));
    }

    @PostMapping(value = "/gethot")
    @ApiOperation(value = "用于获得热门帖子")
    List<Invitation> getHotInvitation(){
        return invitationService.getHotInvitation();
    }

    @PostMapping(value = "/getinvitation")
    @ApiOperation(value = "获得帖子")
    List<Invitation> getInvitation(){
        return invitationService.getInvitation();
    }

    @PostMapping(value = "/getcatalog")
    @ApiOperation(value = "获得简章")
    List<Invitation> getCatalog(){
        return invitationService.getCatalog();
    }
    
    @PostMapping(value = "/getPlateTypes")
    @ApiOperation(value = "获取全部板块信息")
    List<Integer> getAllInvitationPlates(){
    	return invitationService.getAllPlateList();
    }

    @PostMapping(value = "/getplateinvition")
    @ApiOperation(value = "根据板块获得帖子[参数:plate]")
    List<Invitation> getPlateInvitation(@RequestBody Map<String, Object> map){
        return invitationService.getPlateInvitation((Integer)map.get("plate"));
    }

    @PostMapping(value = "/getinvitationbyschool")
    @ApiOperation(value = "根据学校获得帖子[参数:school_id]")
    List<Invitation> getInvitationBySchool(@RequestBody Map<String, Object> map){
        return invitationService.getInvitationBySchool((Integer)map.get("school_id"));
    }

    @PostMapping(value = "/query")
    @ApiOperation(value = "帖子查询[参数:invitation_title]")
    List<Invitation> queryInvitation(@RequestBody Map<String, Object> map){
        return invitationService.queryInvitation((String)map.get("invitation_title"));
    }

    @PostMapping(value = "/delete")
    @ApiOperation(value = "删除帖子[参数:invitation_id]")
    Boolean deleteInvitation(@RequestBody Map<String, Object> map){
        return invitationService.deleteInvitation((Integer) map.get("invitation_id"));
    }

    @PostMapping(value = "/getinvitationbyid")
    @ApiOperation(value = "根据id获得帖子[参数:invitation_id]")
    List<Invitation> getInvitationById(@RequestBody Map<String, Object> map){
        return invitationService.getInvitationById((Integer) map.get("invitation_id"));
    }

    @PostMapping(value = "/update")
    @ApiOperation(value = "修改帖子内容")
    boolean updateInvitation(UpdateInvitation updateInvitation){
        return invitationService.updateInvitation(updateInvitation.getId(),updateInvitation.getTitle(),updateInvitation.getContent(),updateInvitation.getPlate());
    }
    
    @PostMapping(value ="/countinvitationbyplate")
    @ApiOperation(value = "根据板块类型统计帖子数量")
    List<PlateCounts> countinvitationbyplate(){
    	return invitationService.countinvitationbyplate();
    }

    @PostMapping(value = "/getallinvitation")
    @ApiOperation(value = "获得全部帖子")
    List<Invitation> getAllInvitation(){
        return invitationService.getAllInvitation();
    }

    @PostMapping(value = "/getallcatalog")
    @ApiOperation(value = "获得全部简章")
    List<Invitation> getAllCatalog(){
        return invitationService.getAllCatalog();
    }
}

class changeInvitation{
    Integer invitation_id;
    Object date;

    public Integer getInvitation_id() {
        return invitation_id;
    }

    public void setInvitation_id(Integer invitation_id) {
        this.invitation_id = invitation_id;
    }

    public Object getDate() {
        return date;
    }

    public void setDate(Object date) {
        this.date = date;
    }
}

class postInvitation{
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

    public Integer getPost_user() {
        return post_user;
    }

    public void setPost_user(Integer post_user) {
        this.post_user = post_user;
    }

    
    
    public Integer getInvitation_type() {
		return invitation_type;
	}

	public void setInvitation_type(Integer invitation_type) {
		this.invitation_type = invitation_type;
	}

	public Integer getSchool_id() {
		return school_id;
	}

	public void setSchool_id(Integer school_id) {
		this.school_id = school_id;
	}



	String invitation_title;
    String content;
    Integer plate;
    Integer post_user;
    Integer invitation_type;
    Integer school_id;
}

class UpdateInvitation{
    Integer id;
    String title;
    String content;
    Integer plate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
}