package com.www.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cms.pojo.Adver;
import com.common.tool.Validate;
import com.www.mapper.AdverMapper;
import com.www.mapper.SystemMapper;

@Controller
public class AdverController extends BaseController {
	@Autowired
	private AdverMapper adverMapper;
	@Autowired
	private SystemMapper systemMapper;

	@RequestMapping("/manage/adver/index")
	public String index(HttpServletRequest request) throws Exception {
		// 数据库获取
		int pagesize = systemMapper.getpagesize();
		String pagetotal = adverMapper.getTotal();
		int start = this.page(request, pagetotal, pagesize);
		List<Adver> data = adverMapper.selectLimitAdver(start, pagesize);
		request.setAttribute("adverlist", data);
		this.setpath(request);
		return "manage/view/adver/index";
	}

	@RequestMapping("/manage/adver/add")
	public String add(Adver adver, HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (request.getMethod() == "POST") {
			if (Validate.isnull(adver.getTitle()))
				return message(request, "标题不能为空");
			if (Validate.isnull(adver.getUrl()))
				return message(request, "url不能为空");
			Adver data = new Adver();
			data.setTitle(adver.getTitle());
			data.setUrl(adver.getUrl());
			data.setCreate_time(Validate.getStringTime());
			adverMapper.add(data);
			return message(request, "添加成功");
		}
		return "manage/view/adver/add";
	}

	@RequestMapping("/manage/adver/del")
	public String del(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (request.getMethod() == "GET") {
			String id = request.getParameter("id");
			if (Validate.isnull(id))
				return this.message(request, "badrequset");
			adverMapper.delete(Integer.parseInt(id));
			return "redirect:index";
		}
		return "";
	}

	@RequestMapping("/manage/adver/listorder")
	public void listorder(Adver adver, HttpServletRequest request, HttpServletResponse response) throws Exception {
		adverMapper.listorder(adver);
	}

	@RequestMapping("/manage/adver/edit")
	public String edit(Adver adver, HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (request.getMethod() == "POST") {
			if (Validate.isnull(adver.getTitle()))
				return message(request, "标题不能为空");
			if (Validate.isnull(adver.getUrl()))
				return message(request, "url不能为空");
			Adver data = new Adver();
			data.setId(adver.getId());
			data.setTitle(adver.getTitle());
			data.setUrl(adver.getUrl());
			adverMapper.edit(data);
			return message(request, "修改成功");
		}
		if (request.getMethod() == "GET") {
			int flag = adverMapper.checkid(adver.getId());
			if (flag != 1)
				return "redirect:notfound";
			Adver data = adverMapper.getOneAdverById(adver.getId());
			request.setAttribute("id", data.getId());
			request.setAttribute("title", data.getTitle());
			request.setAttribute("url", data.getUrl());
			return "manage/view/adver/edit";
		}
		return "";
	}
}
