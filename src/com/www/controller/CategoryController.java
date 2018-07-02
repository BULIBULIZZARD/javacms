package com.www.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cms.pojo.Category;
import com.common.tool.Validate;
import com.www.mapper.CategoryMapper;
import com.www.mapper.SystemMapper;

@Controller
public class CategoryController extends BaseController{
	@Autowired
	private CategoryMapper categoryMapper;
	@Autowired
	private SystemMapper systemMapper;
	
	
	
	@RequestMapping("/manage/category/edit")
	public String edit(Category category,Model md,HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (request.getMethod()=="POST") {
			if(category.getName()==null||category.getName()==""){
				md.addAttribute("msg", "<script type=\"text/javascript\">alert('分类名不能为空')</script>");
			}else {
				Category cate = new Category();
				cate.setId(category.getId());
				cate.setName(category.getName());
				cate.setParent_id(category.getParent_id());
				categoryMapper.edit(cate);
				md.addAttribute("msg", "<script type=\"text/javascript\">alert('修改成功');</script>");
				category=cate;
			}
		}
		int id = category.getId();
		if(categoryMapper.checkid(id)!=1)return "redirect:notfound";;
		Category data=categoryMapper.getonecategory(id);
		request.setAttribute("name", data.getName());
		request.setAttribute("parent_id", data.getParent_id());
		request.setAttribute("edit_id", data.getId());
		this.showallcate(request);
		this.setpath(request);
		return "manage/view/category/edit";
	}
	@RequestMapping("/manage/category/del")
	public String del(Category category,HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (request.getMethod()=="GET") {
			categoryMapper.delete(category.getId());
			return "redirect:index";
		}
		return "";
		
	}
	@RequestMapping("/manage/category/add")
	public String categoryview(Category category, Model md,HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (request.getMethod()=="POST") {
			if(category.getName()==null||category.getName()==""){
				md.addAttribute("msg", "<script type=\"text/javascript\">alert('分类名不能为空')</script>");
			}else {
				Category cate = new Category();
				cate.setName(category.getName());
				cate.setParent_id(category.getParent_id());
				cate.setStatus(1);
				String dateStamp=Validate.getStringTime();
				cate.setCreate_time(dateStamp);
				categoryMapper.add(cate);
				md.addAttribute("msg", "<script type=\"text/javascript\">alert('添加成功');</script>");
			}
		}
		this.showallcate(request);
		this.setpath(request);
		return "manage/view/category/add";
	}
	@RequestMapping("/manage/category/listorder")
	public void listorder(Category category,Model md,HttpServletRequest request,HttpServletResponse response) throws Exception{
		JSONObject result = new JSONObject();
		if(request.getMethod()=="POST"){
			Category cate = new Category();
			cate.setId(category.getId());
			cate.setListorder(category.getListorder());
			categoryMapper.listorder(cate);
			result.put("code", 1);
		}  else {
			result.put("code", 0);
		}
	}
	@RequestMapping("/manage/category/index")
	public String categoryindex(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//之后用配置数据库获取
		int pagesize = systemMapper.getpagesize();
		String pagetotal = categoryMapper.getTotal();
		
		this.setpath(request);
		int start=this.page(request,pagetotal,pagesize);
		String getpid=request.getParameter("pid");
		int pid = 0;
		if(!Validate.isnull(getpid)){
			pid = Integer.parseInt(getpid) ;
		}
		List<Category> catelist = categoryMapper.selectlimitcate(start,pagesize,pid);
		request.setAttribute("catelist", catelist);
		return "manage/view/category/index";
	}
	private void showallcate(HttpServletRequest request) throws Exception{
		List<Category> catelist = categoryMapper.selectallcate();
		request.setAttribute("catelist", catelist);
	}
	
/*	private void setpath(HttpServletRequest request){
		String path = request.getRequestURI();
		int num = path.lastIndexOf("/");
		path = path.substring(0, num+1);
		request.setAttribute("path", path);
	}
	
	private int page(HttpServletRequest request,String total,int pagesize) throws Exception{
		int datetotal = Integer.parseInt(total);
		int pagenum = datetotal/pagesize;
		int page = this.getpage(request, pagenum);
		int start = (page-1)*pagesize;
		this.showpage(request, pagenum,page);
		return start;
		String limit = "limit "+start+","+pagesize;
		return limit;
	}
	private int getpage(HttpServletRequest request,int pagenum)throws Exception{
		int page = 1;
		if(request.getMethod()=="GET"){
		   String getPage = request.getParameter("page");
		   if(getPage==null||getPage==""){
			   return 1;
		   }
		   int getpage  = Integer.parseInt(getPage);
		   if(getpage < page)return 1;
		   if(getpage > pagenum)return pagenum;
		   page = getpage;
		}else {
			page = 1;
		}
		return page;
	}
	private void showpage(HttpServletRequest request,int pagenum,int page){
		String pageli = "<div  style=\"padding-left:30px;\">";
		String url = request.getRequestURI();
		for (int i = 0; i < pagenum; i++) {
			 if(i==page-1){
				 pageli += "<a style=\"color:#f60\" href=\""+url+"?page="+(i+1)+"\">"+(i+1)+"</a>　";
				 continue;
			 }
			 pageli += "<a href=\""+url+"?page="+(i+1)+"\">"+(i+1)+"</a>　";
		}
		pageli += "</div>";
		request.setAttribute("pageview", pageli);
		
	}*/

}

