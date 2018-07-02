package com.www.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cms.pojo.Article;

public interface ArticleMapper {
	
	public List<Article> getallarticle()throws Exception;
	public void add(Article article) throws Exception;
	public void delete(int id) throws Exception;
	public int checkid(int id) throws Exception;
	public Article getonearticle(int id) throws Exception;
	public void edit(Article article) throws Exception;
	public List<Article> showindexarticle()throws Exception;
	public void setCategoryId(int id,int category_id)throws Exception;
	public void lookadd(int id)throws Exception;
	public void goodadd(int id)throws Exception;
	public int check_ip(@Param("id")String id,@Param("ip")String ip)throws Exception;
	public void good_ip(@Param("id")String id,@Param("ip")String ip)throws Exception;
	//分页查询
	public String getTotal() throws Exception;
	public List<Article> selectlimitArticle(int start,int pagesize) throws Exception;
	//前台分页查询
	public String getTotalByCategoryId(int id);
	public List<Article> showIndexArticleByCategoryId(int id,int start,int pagesize)throws Exception;
	//前台查询结果分页查询
	public String getTotalBySearch(@Param("find")String find);
	public List<Article> showIndexArticleBySearch(@Param("find")String find,@Param("start")int start,@Param("pagesize")int pagesize)throws Exception;
	
}
