package com.www.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cms.pojo.System;
import com.common.tool.Validate;
import com.www.mapper.SystemMapper;

@Controller
public class SystemController {
	@Autowired
	private SystemMapper systemMapper;
	@RequestMapping("/manage/system/index")
	public String index(HttpServletRequest request, HttpServletResponse response) throws Exception{
		System data = systemMapper.getall();
		request.setAttribute("webname",data.getWebname());
		request.setAttribute("frontpagesize",data.getFrontpagesize());
		request.setAttribute("pagesize",data.getPagesize());
		request.setAttribute("linknum", data.getLinknum());
		request.setAttribute("advernum", data.getAdvernum());
		request.setAttribute("navnum",data.getNavnum());
		return "manage/view/system/index";
	}
	@RequestMapping("/manage/system/edit")
	public String edit(System system,HttpServletRequest request, HttpServletResponse response) throws Exception{
		if (request.getMethod()=="POST") {
			if(Validate.isnull(system.getWebname())){
				this.message(request,"网站名不能为空");
				return "manage/view/system/edit";
			}
			if(Validate.isnull(request.getParameter("frontpagesize"))){
				this.message(request,"不能为空");
				return "manage/view/system/edit";
			}
			if(Validate.isnull(request.getParameter("pagesize"))){
				this.message(request,"不能为空");
				return "manage/view/system/edit";
			}
			if(Validate.isnull(request.getParameter("navnum"))){
				this.message(request,"不能为空");
				return "manage/view/system/edit";
			}
			if(Validate.isnull(request.getParameter("linknum"))){
				this.message(request,"不能为空");
				return "manage/view/system/edit";
			}
			if(Validate.isnull(request.getParameter("advernum"))){
				this.message(request,"不能为空");
				return "manage/view/system/edit";
			}
			System data = new System();
			data.setWebname(system.getWebname());
			data.setFrontpagesize(system.getFrontpagesize());
			data.setPagesize(system.getPagesize());
			data.setNavnum(system.getNavnum());
			data.setLinknum(system.getLinknum());
			data.setAdvernum(system.getAdvernum());
			systemMapper.update(data);
		}
		System data = systemMapper.getall();
		request.setAttribute("webname",data.getWebname());
		request.setAttribute("frontpagesize",data.getFrontpagesize());
		request.setAttribute("pagesize",data.getPagesize());
		request.setAttribute("navnum",data.getNavnum());
		request.setAttribute("linknum", data.getLinknum());
		request.setAttribute("advernum", data.getAdvernum());
		return "manage/view/system/edit";
	}
	private void  message(HttpServletRequest request,String message) throws Exception {
		message = "<script type=\"text/javascript\">alert('"+message+"');history.go(-1);location.reload()</script>";
		request.setAttribute("message", message);
	}
}
