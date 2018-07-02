package com.www.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;

@Controller
public class BaseController {
	
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
	protected void showpage(HttpServletRequest request,int pagenum,int page){
		int start;
		if(page>5){
			start= page-5;
		}else if(pagenum-page<5&&pagenum>10){
			 start= pagenum-10;
		}else {
			 start = 0;
		}
		String pageli = "<div  style=\"padding-left:30px;\">";
		String url = request.getRequestURI();
		for (int i = start ,j=0; i < pagenum; i++) {
			if(j>10)break;
			 j++;
			 if(i==page-1){
				 pageli += "<a style=\"color:#f60\" href=\""+url+"?page="+(i+1)+"\">"+(i+1)+"</a>¡¡";
				 continue;
			 }
			 pageli += "<a href=\""+url+"?page="+(i+1)+"\">"+(i+1)+"</a>¡¡";
		}
		pageli += "¹²"+pagenum+"Ò³</div>";
		request.setAttribute("pageview", pageli);
	}
	protected void setpath(HttpServletRequest request){
		String path = request.getRequestURI();
		String req = path +"?"+request.getQueryString() ;
		int num = path.lastIndexOf("/");
		path = path.substring(0, num+1);
		
		request.setAttribute("req", req);
		request.setAttribute("path", path);
	}
	protected String  message(HttpServletRequest request,String message) throws Exception {
		message = "<script type=\"text/javascript\">alert('"+message+"');history.go(-1);location.reload()</script>";
		request.setAttribute("message", message);
		return "/message";
	}
}
