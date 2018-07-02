package com.index.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cms.pojo.Article;
import com.cms.pojo.Category;
import com.www.mapper.ArticleMapper;
import com.www.mapper.CategoryMapper;
import com.www.mapper.SystemMapper;

@Controller
public class ListController extends BaseController{
	@Autowired
	private ArticleMapper articleMapper;
	@Autowired
	private SystemMapper systemMapper;
	@Autowired
	private CategoryMapper categoryMapper;
	
	@RequestMapping("/index/artlist")
	public String index(Category category,HttpServletRequest request) throws Exception
	{
		if (request.getMethod()!="GET") {
			return this.message(request,"错误的打开方式");
		}	
		int flag = categoryMapper.checkid(category.getId());
		if(flag != 1)return "";
		
		int pagesize = systemMapper.getfrontpagesize();
		String pagetotal = articleMapper.getTotalByCategoryId(category.getId());
		int start=this.page(request,pagetotal,pagesize);
		List<Article>  data = articleMapper.showIndexArticleByCategoryId(category.getId(),start,pagesize);
		if (null==data ||data.size()==0) {
			request.setAttribute("noarticle","<div class=\"xh_post_h_3 ofh\"><span style=\"font-size:20px;\">此分类下暂无文章</span></div>");
		}
		request.setAttribute("articlelist", data);
		this.shownav(category.getId(), request);
		this.showcategory(request);
		this.showwebname(request);
		this.setpath(request);
		this.showadver(request);
		return "index/view/artlist/artlist";
	}
	@RequestMapping("/index/search")
	public String search(HttpServletRequest request) throws Exception{
		if (request.getMethod()!="GET") {
			return this.message(request,"错误的打开方式");
		}
		String find = request.getParameter("find");
		find = new String(find .getBytes("iso8859-1"),"utf-8");
		
		int pagesize = systemMapper.getfrontpagesize();
		String pagetotal = articleMapper.getTotalBySearch(find);
		int start=this.page(request,pagetotal,pagesize);
		List<Article>  data = articleMapper.showIndexArticleBySearch(find, start, pagesize);
		for (Article article : data) {
			article.setTitle(article.getTitle().replaceAll("(?i)"+find,"<span style=\"color:#f00\">"+find+"</span>"));
			article.setContext(article.getContext().replaceAll("(?i)"+find,"<span style=\"color:#f00\">"+find+"</span>"));
		}
		request.setAttribute("articlelist", data);
		this.showcategory(request);
		this.showwebname(request);
		this.setpath(request);
		this.showadver(request);
		request.setAttribute("search", "以下是\""+find+"\"的查找结果");
		
		return "index/view/artlist/artlist";
	}
	
	
	private void shownav(int id,HttpServletRequest request) throws Exception{
		int parent_id=categoryMapper.getparent_id(id);
		if(parent_id==0){
			request.setAttribute("parent_id", id);
			request.setAttribute("parent_name",categoryMapper.getNameById(id));
			request.setAttribute("child_id", "");
			request.setAttribute("child_name","");
		}else {
			request.setAttribute("parent_id", parent_id);
			request.setAttribute("parent_name",categoryMapper.getNameById(parent_id));
			request.setAttribute("child_id", id);
			request.setAttribute("child_name",categoryMapper.getNameById(id));
		}
	}
	
}
