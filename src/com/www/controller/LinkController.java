package com.www.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cms.pojo.Link;
import com.common.tool.Validate;
import com.www.mapper.LinkMapper;
import com.www.mapper.SystemMapper;

@Controller
public class LinkController extends BaseController{
	@Autowired
	private LinkMapper linkMapper;
	@Autowired
	private SystemMapper systemMapper;
	
	
	@RequestMapping("/manage/link/index")
	public String index(HttpServletRequest request) throws Exception {
		//数据库获取
		int pagesize = systemMapper.getpagesize();
		String pagetotal = linkMapper.getTotal();
		int start=this.page(request,pagetotal,pagesize);
		List<Link> data = linkMapper.selectLimitLink(start,pagesize);
		request.setAttribute("linklist", data);
		this.setpath(request);
		return "manage/view/link/index";
	}
	
	@RequestMapping("/manage/link/add")
	public String add(Link link,HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (request.getMethod()=="POST") {
			if(Validate.isnull(link.getName()))return message(request, "标题不能为空");
			if(Validate.isnull(link.getLink()))return message(request, "url不能为空");
			Link data = new Link();
			data.setName(link.getName());
			data.setLink(link.getLink());
			data.setCreate_time(Validate.getStringTime());
			linkMapper.add(data);
			return message(request, "添加成功");
		}
		return "manage/view/link/add";
	}
	
	@RequestMapping("/manage/link/del")
	public String del(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (request.getMethod()=="GET") {
			String id =request.getParameter("id");
			if(Validate.isnull(id))return this.message(request, "badrequest");
			linkMapper.delete(Integer.parseInt(id));
			return "redirect:index";
		}
		return "";
	}
	
	@RequestMapping("/manage/link/listorder")
	public void listorder(Link link,HttpServletRequest request, HttpServletResponse response) throws Exception {
		linkMapper.listorder(link);
	}
	
	@RequestMapping("/manage/link/edit")
	public String edit(Link link,HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (request.getMethod()=="POST") {
			if(Validate.isnull(link.getName()))return message(request, "标题不能为空");
			if(Validate.isnull(link.getLink()))return message(request, "url不能为空");
			int flag = linkMapper.checkid(link.getId());
			if(flag!=1)return "redirect:notfound";
			Link data = new Link();
			data.setId(link.getId());
			data.setName(link.getName());
			data.setLink(link.getLink());
			linkMapper.edit(data);
			return message(request, "修改成功");
		}
		if(request.getMethod()=="GET"){
			int flag = linkMapper.checkid(link.getId());
			if(flag!=1)return "redirect:notfound";
			
			Link data = linkMapper.getOneLinkById(link.getId());
			request.setAttribute("id", data.getId());
			request.setAttribute("name", data.getName());
			request.setAttribute("linkurl", data.getLink());
			return "manage/view/link/edit";
		}
		return "";
	}
}
