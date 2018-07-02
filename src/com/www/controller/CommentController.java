package com.www.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cms.pojo.Comment;
import com.common.tool.Validate;
import com.www.mapper.CommentMapper;
import com.www.mapper.SystemMapper;

@Controller
public class CommentController extends BaseController{
	@Autowired
	private CommentMapper commentMapper;
	@Autowired
	private SystemMapper systemMapper;
	
	
	@RequestMapping("/manage/comment/index")
	public String index(HttpServletRequest request) throws Exception {
		//数据库获取
		int pagesize = systemMapper.getpagesize();
		String pagetotal = commentMapper.getTotal();
		int start=this.page(request,pagetotal,pagesize);
		List<Comment> data = commentMapper.selectLimitComment(start,pagesize);
		request.setAttribute("commentlist", data);
		this.setpath(request);
		return "manage/view/comment/index";
	}
	@RequestMapping("/manage/comment/del")
	public String del(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (request.getMethod()=="GET") {
			String id =request.getParameter("id");
			if(Validate.isnull(id))return this.message(request, "badrequset");
			commentMapper.delete(Integer.parseInt(id));
			return "redirect:index";
		}
		return "";
	}
}
