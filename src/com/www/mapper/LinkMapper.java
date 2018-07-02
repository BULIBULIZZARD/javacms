package com.www.mapper;


import java.util.List;

import com.cms.pojo.Link;

public interface LinkMapper {

	public void add(Link link)throws Exception;
	public void delete(int id)throws Exception;
	public void listorder(Link link)throws Exception;
	public int checkid(int id)throws Exception;
	public Link getOneLinkById(int id)throws Exception;
	public void edit(Link link)throws Exception;
	public List<Link> getIndexLink(int num)throws Exception;
	//∑÷“≥≤È—Ø
	public String getTotal() throws Exception;
	public List<Link> selectLimitLink(int start,int pagesize) throws Exception;
}
