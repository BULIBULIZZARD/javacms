package com.index.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cms.pojo.Comment;
import com.common.tool.Validate;
import com.www.mapper.CommentMapper;

@Controller
public class FrountCommentController extends BaseController{

	@Autowired
	private CommentMapper commentMapper;
	
	@RequestMapping("/index/comment")
	private String comment(HttpServletRequest request) throws Exception{
		if(request.getMethod()!="POST")return message(request, "bad_request");
		if(!this.checklogin(request))return message(request, "���¼��������");
		String context=request.getParameter("context").trim();
		context=context.replace("<", "&lt");
		context=context.replace(">", "&gt");
		if(Validate.isnull(context))return message(request, "���۲���Ϊ��");
		if(Validate.max(context, 255))return message(request, "���۹���");
		String article_id=request.getParameter("article_id");
		if(Validate.isnull(article_id))return message(request, "����Ĵ򿪷�ʽ");
		Comment data= new Comment();
		data.setContext(context);
		data.setArticle_id(Integer.parseInt(article_id));
		data.setUserid(Integer.parseInt(this.id));
		data.setUsername(this.user);
		data.setCreate_time(Validate.getStringTime());
		commentMapper.add(data);
		return message(request,"���۳ɹ�");
	}
	
}
