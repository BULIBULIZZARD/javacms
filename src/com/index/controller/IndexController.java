package com.index.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cms.pojo.Article;
import com.cms.pojo.User;
import com.common.tool.Validate;
import com.www.mapper.ArticleMapper;
import com.www.mapper.UserMapper;

@Controller
public class IndexController extends BaseController{
	@Autowired
	private ArticleMapper articleMapper;
	@Autowired
	private UserMapper userMapper;
	@RequestMapping("/index")
	public String index(HttpServletRequest request)throws Exception {
		
		if(checklogin(request)){
			request.setAttribute("login", 1);
		}else {
			request.setAttribute("login", 0);
		}
		this.showcategory(request);
		this.showwebname(request);
		this.showIndexArticle(request);
		this.setpath(request);
		this.showadver(request);
		this.showlink(request);
		return "index/view/index/index";
	}
	
	@RequestMapping("/index/register")
	public String register(User user, HttpServletRequest request)throws Exception {
		if (request.getMethod()=="POST") {
			String flag = this.checkform(user, request);
			if(flag!="ok"||!flag.equals("ok"))return flag;
			User data = new User();
			data.setUsername(user.getUsername());
			data.setPassword(Validate.md5Password(user.getPassword()+"user"));
			long time = System.currentTimeMillis();
			data.setUniquecode(Validate.md5Password(Validate.md5Password(time+user.getUsername())));
			data.setEmail(user.getEmail());
			data.setQq(user.getQq());
			String dateStamp=Validate.getStringTime();
			data.setCreate_time(dateStamp);
			userMapper.register(data);
			setpath(request);
			return this.success(request,"ע��ɹ�", this.path);
		}
		this.showcategory(request);
		this.showwebname(request);
		this.setpath(request);
		return "index/view/register/page";
	}
	private String checkform(User user, HttpServletRequest request) throws Exception {
		if(Validate.min(user.getUsername(), 2))return this.message(request, "�û������Ȳ���С����λ");
		if(Validate.max(user.getUsername(), 20))return this.message(request, "�û������Ȳ��ܴ��ڶ�ʮλ");
		if(userMapper.checkusername(user.getUsername())==1)return this.message(request, "���û���ע��");
		if(Validate.min(user.getPassword(), 6))return this.message(request, "���볤�Ȳ���С����λ");
		if(Validate.max(user.getPassword(), 20))return this.message(request, "���볤�Ȳ��ܴ��ڶ�ʮλ");
		if(!Validate.checkeqs(user.getPassword(), user.getRepassword()))return this.message(request, "�������벻һ�� ");
		if(!Validate.checkemail(user.getEmail()))return this.message(request, "�����ʽ����");
		if(Validate.max(user.getEmail(), 100))return this.message(request, "����������������");
		if(!Validate.isnull(user.getQq())){
			if(!Validate.checkqq(user.getQq()))return this.message(request, "qq��ʽ���Ϸ�");
		}
		return "ok";
	}
	
	private void showIndexArticle(HttpServletRequest request) throws Exception{
		List<Article> data = articleMapper.showindexarticle();
		request.setAttribute("articlelist", data);
	}
}
