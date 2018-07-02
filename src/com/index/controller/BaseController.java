package com.index.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.cms.pojo.Adver;
import com.cms.pojo.Category;
import com.cms.pojo.Link;
import com.www.mapper.AdverMapper;
import com.www.mapper.CategoryMapper;
import com.www.mapper.LinkMapper;
import com.www.mapper.SystemMapper;
import com.www.mapper.UserMapper;


public class BaseController {
	@Autowired
	private CategoryMapper categoryMapper;
	@Autowired
	private SystemMapper systemMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private AdverMapper adverMapper;
	@Autowired
	private LinkMapper linkMapper;
	protected String path;
	protected String user;
	protected String id;
	protected void showcategory(HttpServletRequest request) throws Exception {
		String path = request.getRequestURI();
		int No = path.lastIndexOf("/");
		path = path.substring(0, No+1);
		int num = systemMapper.getnavnum();
		List<Category> data = categoryMapper.showcate(num);
		String show ="";
		for (Category category : data) {
			
			show += "<li><a href=\""+path+"artlist?id="+category.getId()+"\">"+category.getName()+"</a>";
			List<Category> kid= categoryMapper.selectcatebypid(category.getId());
			if (null==kid||kid.size()==0) {
				show +="</li>";
				continue;
			}
			show +="<ul>";
			for (Category category2 : kid) {
				show += "<li><a href=\""+path+"artlist?id="+category2.getId()+"\">"+category2.getName()+"</a></li>";
			}
			show +="</ul></li>";
			
		}
		request.setAttribute("show", show);
	}
	
	protected void showwebname(HttpServletRequest request) throws Exception{
		 String webname = systemMapper.getwebname();
		 request.setAttribute("webname", webname);
	}
	protected int page(HttpServletRequest request,String total,int pagesize) throws Exception{
		int datetotal = Integer.parseInt(total);
		int pagenum = (int)Math.ceil((double)datetotal/(double)pagesize);
		int page = this.getpage(request, pagenum);
		int start = (page-1)*pagesize;
		if(pagenum>1){
			this.showpage(request, pagenum,page);
		}
		return start;
		/*String limit = "limit "+start+","+pagesize;
		return limit;*/
	}
	protected int getpage(HttpServletRequest request,int pagenum)throws Exception{
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
	protected void showpage(HttpServletRequest request,int pagenum,int page) throws UnsupportedEncodingException{
		String id = request.getParameter("id");
		int start;
		if(page>5){
			start= page-5;
		}else if(pagenum-page<5&&pagenum>10){
			 start= pagenum-10;
		}else {
			 start = 0;
		}
		if(null==id || id==""){
			String find = request.getParameter("find");
			find = new String(find .getBytes("iso8859-1"),"utf-8");
			String pageli = "<div  style=\"padding-left:30px;\">";
			String url = request.getRequestURI();
			for (int i=start,j=0; i < pagenum; i++) {
				 if(j>10)break;
				 j++;
				 if(i==page-1){
					 pageli += "<a style=\"color:#f60\" href=\""+url+"?page="+(i+1)+"&find="+find+"\">"+(i+1)+"</a>　";
					 continue;
				 }
				 pageli += "<a href=\""+url+"?page="+(i+1)+"&find="+find+"\">"+(i+1)+"</a>　";
				 
			}
			pageli += "共"+pagenum+"页</div>";
			request.setAttribute("pageview", pageli);
		}else {
			String pageli = "<div  style=\"padding-left:30px;\">";
			String url = request.getRequestURI();
			for (int  i=start,j=0; i < pagenum; i++) {
				if(j>10)break;
				 j++;
				 if(i==page-1){
					 pageli += "<a style=\"color:#f60\" href=\""+url+"?page="+(i+1)+"&id="+id+"\">"+(i+1)+"</a>　";
					 continue;
				 }
				 pageli += "<a href=\""+url+"?page="+(i+1)+"&id="+id+"\">"+(i+1)+"</a>　";
			}
			pageli += "共"+pagenum+"页</div>";
			request.setAttribute("pageview", pageli);
		}
		
		
	}
	protected boolean checklogin(HttpServletRequest request) throws Exception {
		 Cookie[] cookies = request.getCookies();
		 String user ="";
		 String uniquecode ="";
		 String id="";
		 if(null==cookies||cookies.length==0) return false;
		 for (Cookie cookie : cookies) {
			 if(cookie.getName().equals("user"))user=cookie.getValue().toString();
			 if(cookie.getName().equals("uniquecode"))uniquecode=cookie.getValue().toString();
			 if(cookie.getName().equals("id"))id=cookie.getValue().toString();
			 this.user=user;
			 this.id =id;
		 }
		 if((null!=user&&!"".equals(user))&&(null!=uniquecode&&!"".equals(uniquecode))){
			 int flag= userMapper.checkcookie(user, uniquecode);
			 if(flag==1){
				 request.setAttribute("username", user);
				 request.setAttribute("userid", id);
				 return true;
			 } 
		 }
		 return false;
		 
	}
	protected void setpath(HttpServletRequest request){
		String path = request.getRequestURI();
		String req = path +"?"+request.getQueryString() ;
		int num = path.lastIndexOf("/");
		path = path.substring(0, num+1);
	    num=path.substring(0, num-1).lastIndexOf("/");;
	    String root =  path.substring(0, num+1);
		this.path=path;
		request.setAttribute("req", req);
		request.setAttribute("path", path);
		request.setAttribute("root", root);
	}
	protected String  message(HttpServletRequest request,String message) throws Exception {
		message = "<script type=\"text/javascript\">alert('"+message+"');history.go(-1);location.reload()</script>";
		request.setAttribute("message", message);
		return "/message";
	}
	protected String  success(HttpServletRequest request,String message,String url) throws Exception {
		message = "<script type=\"text/javascript\">alert('"+message+"');location.href=\""+url+"\"</script>";
		request.setAttribute("message", message);
		return "/message";
	}
	protected void showadver(HttpServletRequest request) throws Exception{
		//前台广告数
		int num=systemMapper.getadvernum();
		List<Adver> data  = adverMapper.getIndexAdver(num);
		request.setAttribute("adverlist", data);
	}
	protected void showlink(HttpServletRequest request) throws Exception{
		//前台广告数
		int num=systemMapper.getlinknum();
		List<Link> data  = linkMapper.getIndexLink(num);
		request.setAttribute("linklist", data);
	}
}
