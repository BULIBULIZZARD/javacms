package com.index.controller;



import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cms.pojo.Article;
import com.cms.pojo.Comment;
import com.common.tool.Validate;
import com.www.mapper.ArticleMapper;
import com.www.mapper.CategoryMapper;
import com.www.mapper.CommentMapper;

import net.sf.json.JSONObject;

@Controller
public class FrountArticleController extends BaseController{
	@Autowired
	private CategoryMapper categoryMapper;
	@Autowired
	private ArticleMapper articleMapper;
	@Autowired
	private CommentMapper commentMapper;

	@RequestMapping("/index/article")
	public String article(Article article,HttpServletRequest request) throws Exception{
		if (request.getMethod()!="GET") {
			return this.message(request,"错误的打开方式");
		}
		int flag = articleMapper.checkid(article.getId());
		if(flag != 1)return "";
		Article data = articleMapper.getonearticle(article.getId());
		request.setAttribute("a_id", data.getId());
		request.setAttribute("title", data.getTitle());
		request.setAttribute("time", data.getCreate_time());
		request.setAttribute("author", data.getAuthor());
		request.setAttribute("text", data.getText());
		request.setAttribute("thegood", data.getGood());
		articleMapper.lookadd(data.getId());
		this.showComment(data.getId(), request);
		this.shownav(data.getCategory_id(),request);
		this.showwebname(request);
		this.setpath(request);
		this.showcategory(request);
		this.showadver(request);
		return "index/view/article/article";
	}
	@RequestMapping("/index/good")
	public void good(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String id = request.getParameter("goodid");
		String ip = Validate.getIPAddress(request);
		int flag=articleMapper.check_ip(id, ip);
		response.setContentType("text/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		JSONObject object =new JSONObject();
		if(flag==1){
			object.put("message", "已为此文章点赞");
		}else {
			articleMapper.goodadd(Integer.parseInt(id));
			articleMapper.good_ip(id, ip);
			object.put("message", "点赞成功");
		}
		out = response.getWriter();
		out.println(object);
	}
	private void showComment(int id,HttpServletRequest request) throws Exception{
		List<Comment> data=commentMapper.showCommentByArticleId(id);
		request.setAttribute("commentlist", data);
		if(null==data ||data.size()==0)request.setAttribute("nocomment", "暂无评论");
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
