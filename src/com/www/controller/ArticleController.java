package com.www.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cms.pojo.Article;
import com.cms.pojo.Category;
import com.common.tool.Validate;
import com.www.mapper.ArticleMapper;
import com.www.mapper.CategoryMapper;
import com.www.mapper.SystemMapper;

import net.sf.json.JSONObject;

@Controller
public class ArticleController extends BaseController{
	@Autowired
	private ArticleMapper articleMapper;
	@Autowired
	private CategoryMapper categoryMapper;
	@Autowired
	private SystemMapper systemMapper;
	
	@RequestMapping("/manage/article/index")
	public String index(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//之后用配置数据库获取
		int pagesize = systemMapper.getpagesize();
		String pagetotal = articleMapper.getTotal();
		int start=this.page(request,pagetotal,pagesize);
		List<Article> article = articleMapper.selectlimitArticle(start,pagesize);
		request.setAttribute("article", article);
		setpath(request);
		return "manage/view/article/index";
	}
	
	
	@RequestMapping("/manage/article/add")
	public String add(Article article, Model md,HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (request.getMethod()=="POST") {
			if(Validate.isnull(article.getTitle())){
				return this.message(request, article, "标题不能为空");
			}else {
				Article data = new Article();
				data.setTitle(article.getTitle());
				this.message(request, article, "请选择一个分类 ");
				if(article.getCategory_id()==0) return this.message(request, article, "请选择一个分类 ");
				if (article.getKid_id()==0) {
					data.setCategory_id(article.getCategory_id());
				}else {
					int id =article.getKid_id();
					data.setCategory_id(id);
				}
				data.setAuthor(article.getAuthor());
				data.setContext(article.getContext());
				data.setText(article.getText());
				String dateStamp=Validate.getStringTime();
				data.setCreate_time(dateStamp);
				articleMapper.add(data);
				this.message(request, new Article(), "添加成功");
				return "redirect:index";
			}
		}
		this.showcategory(request);
		this.setpath(request);
		return "manage/view/article/add";
	}
	@RequestMapping("/manage/article/del")
	public String del(Article article,HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (request.getMethod()=="GET") {
			articleMapper.delete(article.getId());
			return "redirect:index";
		}
		return "";
	}
	
	@RequestMapping("/manage/article/edit")
	public String edit(Article article,HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (request.getMethod()=="POST") {
			if(Validate.isnull(article.getTitle())){
				return this.message(request, article, "标题不能为空");
			}else {
				Article data = new Article();
				data.setTitle(article.getTitle());
				this.message(request, article, "请选择一个分类 ");
				if(article.getCategory_id()==0) return this.message(request, article, "请选择一个分类 ");
				if (article.getKid_id()==0) {
					data.setCategory_id(article.getCategory_id());
				}else {
					int id =article.getKid_id();
					data.setCategory_id(id);
				}
				data.setId(article.getId());
				data.setAuthor(article.getAuthor());
				data.setContext(article.getContext());
				data.setText(article.getText());
				articleMapper.edit(data);
				return "redirect:edit?id="+article.getId();
			}
		}
		if (request.getMethod()=="GET") {
			int flag=articleMapper.checkid(article.getId());
			if(flag !=1)return "redirect:nofound";
			Article data = articleMapper.getonearticle(article.getId());
			request.setAttribute("id", data.getId());
			request.setAttribute("title", data.getTitle());
			request.setAttribute("category_id", data.getCategory_id());
			request.setAttribute("author", data.getAuthor());
			request.setAttribute("context", data.getContext());
			request.setAttribute("text", data.getText());
			int parent_id = categoryMapper.getparent_id(data.getCategory_id());
			if (parent_id == 0) {
				request.setAttribute("parent_id",data.getCategory_id());
				this.showchildcategory(request, data.getCategory_id());
			}else {
				request.setAttribute("parent_id",parent_id);
				this.showchildcategory(request, parent_id);
				request.setAttribute("child_id",data.getCategory_id());
			}
		}
		
		this.showcategory(request);
		return "manage/view/article/edit";
	}

	@RequestMapping("/manage/article/getchlidcategory")
	public void getchlidcategory(HttpServletRequest request, HttpServletResponse response)throws Exception {
		response.setContentType("text/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		String getid =  request.getParameter("id");
		int id =  Integer.parseInt(getid);
		List<Category> child = null;
		child = categoryMapper.selectcatebypid(id);
		JSONObject object = null;
		object=	new JSONObject();
		//JSONArray jsonArray =new  JSONArray();
		if (child==null|| child.size()==0 ) {
			object.put("status", 0);
		} else {
			object.put("status", 1);
		}
		object.put("data", child);
		out = response.getWriter();
		out.println(object);
	}
	
	private String  message(HttpServletRequest request,Article article,String message) throws Exception {
		request.setAttribute("article", article);
		message = "<script type=\"text/javascript\">alert('"+message+"');</script>";
		request.setAttribute("message", message);
		this.showcategory(request);
		this.setpath(request);
		return "manage/view/article/add";
	}
	private void showcategory(HttpServletRequest request) throws Exception{
		List<Category> catelist = categoryMapper.selectallcate();
		request.setAttribute("catelist", catelist);
	}
	private void showchildcategory(HttpServletRequest request,int parent_id) throws Exception{
		List<Category> chlidlist = categoryMapper.selectcatebypid(parent_id);
		request.setAttribute("chlidlist", chlidlist);
	}
}
