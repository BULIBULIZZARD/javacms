package com.www.mapper;

import java.util.List;

import com.cms.pojo.Category;

public interface CategoryMapper {
	public List<Category> selectallcate() throws Exception;
	public Category getonecategory(int id) throws Exception;
	public int checkid(int id) throws Exception;
	public List<Category> selectcatebypid(int id) throws Exception;
	public void add(Category category) throws Exception;
	public void edit(Category category) throws Exception;
	public void listorder(Category category) throws Exception;
	public void delete(int id) throws Exception;
	public String getTotal() throws Exception;
	public List<Category> selectlimitcate(int start,int pagesize,int pid) throws Exception;
	public int getparent_id(int id) throws Exception;
	public List<Category> showcate(int num)throws Exception;
	public String getNameById(int id)throws Exception;
}
 