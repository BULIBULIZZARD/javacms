package com.www.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cms.pojo.Admin;
import com.cms.pojo.User;
import com.common.tool.Validate;
import com.www.mapper.AdminMapper;
import com.www.mapper.SystemMapper;
import com.www.mapper.UserMapper;

@Controller
public class AdminController extends BaseController{
	@Autowired
	private AdminMapper adminMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private SystemMapper systemMapper;
	
	
	@RequestMapping("/manage")
	public String manage(HttpServletRequest request) throws Exception {
		
		this.setpath(request);
		return "manage/view/index/index";
	}
	@RequestMapping("/door")
	public String login(Admin admin,HttpServletRequest request, HttpServletResponse response,HttpSession session) throws Exception{
		
		if (request.getMethod()=="POST") {
			Admin data =new Admin();
			data.setUsername(admin.getUsername());
			data.setPassword(Validate.md5Password(admin.getPassword()+"fsh"));
			int flag = adminMapper.login(data);
			if (flag==1) {
				session.setAttribute("username", admin.getUsername());
				return "redirect:/manage";
			}
		}
		return this.message(request,"用户名或密码错误");
	}
	@RequestMapping("/manage/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/manage";
	}
/*	@RequestMapping("/login.action")
	public String login(User user, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		boolean login = userMapper.login(user);
		if (login) {
			session.setAttribute("username", user.getUsername());
			return "admin/welcome";

		} else {
			System.out.println("````````````````````````````````````````````````````````````1");
			request.setAttribute("msg", "用户名或密码错误！发起");
			return "login";
		}
	}*/
	@RequestMapping("/manage/user/index")
	public String shwouser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//数据库获取
		int pagesize = systemMapper.getpagesize();
		
		String pagetotal = userMapper.getTotal();
		int start=this.page(request,pagetotal,pagesize);
		List<User> userlist = userMapper.selectlimituser(start,pagesize);
		request.setAttribute("userlist", userlist);
		this.setpath(request);
		return "manage/view/user/index";
	}
	@RequestMapping("/manage/admin/index")
	public String index(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//数据库获取
		int pagesize = systemMapper.getpagesize();
		String pagetotal = adminMapper.getTotal();
		int start=this.page(request,pagetotal,pagesize);
		List<Admin> adminlist = adminMapper.selectlimitadmin(start,pagesize);
		request.setAttribute("adminlist", adminlist);
		this.setpath(request);
		return "manage/view/admin/index";
	}
	
	@RequestMapping("/manage/admin/add")
	public String add(Admin admin,Model md,HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (request.getMethod()=="POST") {
			if(Validate.isnull(admin.getUsername())){
				return this.message(request, "账号不能为空");
			}
			if(Validate.isnull(admin.getPassword())){
				return this.message(request, "密码不能为空");
			}
			int flag = adminMapper.checkusername(admin);
			if(flag == 1)return this.message(request, "此账号已注册");
			Admin data = new Admin();
			data.setUsername(admin.getUsername());
			data.setPassword(Validate.md5Password(admin.getPassword()+"fsh"));
			String dateStamp=Validate.getStringTime();
			data.setCreate_time(dateStamp);
			data.setStatus(1);
			adminMapper.add(data);
			return this.message(request, "添加成功");
		}
		return "manage/view/admin/add";
	}
	
	@RequestMapping("/manage/admin/listorder")
	public void listorder(Admin admin,HttpServletRequest request, HttpServletResponse response) throws Exception {
		adminMapper.listorder(admin);
	}
	@RequestMapping("/manage/user/listorder")
	public void userorder(User user,HttpServletRequest request, HttpServletResponse response) throws Exception {
		userMapper.listorder(user);
	}
	@RequestMapping("/manage/admin/del")
	public String del(Admin admin,HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (request.getMethod()=="GET") {
			adminMapper.del(admin);
			return "redirect:index";
		}
		return "";
	}
	@RequestMapping("/manage/user/del")
	public String deluser(User user,HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (request.getMethod()=="GET") {
			userMapper.del(user);
			return "redirect:index";
		}
		return "";
	}
	@RequestMapping("/manage/admin/edit")
	public String edit(Admin admin,HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (request.getMethod()=="POST") {
			if(Validate.isnull(admin.getUsername())){
				this.message(request, "账号不能为空");
				return "manage/view/admin/edit";
			}
			String checkuser= request.getParameter("checkuser");
			if (!admin.getUsername().equals(checkuser)) {
				int flag = adminMapper.checkusername(admin);
				if(flag == 1){
					this.message(request, "用户名已被注册");
					return "manage/view/admin/edit";
				}
			}
			Admin data = new Admin();
			if(Validate.isnull(admin.getPassword())){
				data.setId(admin.getId());
				data.setUsername(admin.getUsername());
				adminMapper.updateusername(data);
			}else {
				data.setId(admin.getId());
				data.setUsername(admin.getUsername());
				data.setPassword(Validate.md5Password(admin.getPassword()+"fsh"));
				adminMapper.update(data);
			}
			request.setAttribute("username", data.getUsername());
			request.setAttribute("id", data.getId());
			this.message(request,"修改成功");
		}
		if(request.getMethod()=="GET"){
			int flag=adminMapper.checkid(admin.getId());
			if(flag != 1)return "redirect:notfound";
			Admin data = adminMapper.getoneadmin(admin.getId());
			request.setAttribute("username", data.getUsername());
			request.setAttribute("id", data.getId());
		}
		this.setpath(request);
		return "manage/view/admin/edit";
	}
	
	
}
