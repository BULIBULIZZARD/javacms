package com.www.mapper;


import java.util.List;

import com.cms.pojo.Comment;

public interface CommentMapper {

	public void add(Comment comment)throws Exception;
	public List<Comment> showCommentByArticleId(int id)throws Exception;
	public void delete(int id)throws Exception;
	//∑÷“≥≤È—Ø
	public String getTotal() throws Exception;
	public List<Comment> selectLimitComment(int start,int pagesize) throws Exception;
}
