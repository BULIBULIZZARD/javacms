package com.index.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cms.pojo.User;
import com.common.tool.Validate;
import com.www.mapper.UserMapper;

@Controller
public class UserController extends BaseController{
	@Autowired
	private UserMapper userMapper;
	@RequestMapping("/index/login")
	public String index(User user,HttpServletRequest request,HttpServletResponse response)throws Exception {
		user.setPassword(Validate.md5Password(user.getPassword()+"user"));
		int flag = userMapper.checklogin(user);
		if(flag==1){
			 User data = userMapper.getuserdata(user.getUsername());
			 Cookie idcoo = new Cookie("id", data.getId()+"");
			 Cookie usercoo = new Cookie("user", data.getUsername());
		     Cookie uniquecodecoo = new Cookie("uniquecode", data.getUniquecode());
		     idcoo.setMaxAge(60*60*24);
		     usercoo.setMaxAge(60*60*24);
		     uniquecodecoo.setMaxAge(60*60*24);
		     response.addCookie(idcoo);
		     response.addCookie(usercoo);
		     response.addCookie(uniquecodecoo);
		     this.setpath(request);
		     return success(request, "登陆成功", this.path);
		}
		return message(request, "用户名或密码错误,请重试!");
	}
	@RequestMapping("/index/logout")
	public String logout(HttpServletRequest request,HttpServletResponse response) throws Exception{
		Cookie user = new Cookie("user", null);
		user.setMaxAge(0);
		Cookie id = new Cookie("id", null);
		id.setMaxAge(0);
		Cookie uniquecodecoo = new Cookie("uniquecode",null);
		uniquecodecoo.setMaxAge(0);
		response.addCookie(id);
	    response.addCookie(user);
	    response.addCookie(uniquecodecoo);
		this.setpath(request);
		return success(request, "退出登陆成功", this.path);
	}
}
