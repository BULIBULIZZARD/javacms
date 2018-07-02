package com.www.mapper;


import java.util.List;

import com.cms.pojo.Adver;

public interface AdverMapper {

	public void add(Adver adver)throws Exception;
	public void delete(int id)throws Exception;
	public void listorder(Adver adver)throws Exception;
	public int checkid(int id)throws Exception;
	public Adver getOneAdverById(int id)throws Exception;
	public void edit(Adver adver)throws Exception;
	public List<Adver> getIndexAdver(int num)throws Exception;
	//∑÷“≥≤È—Ø
	public String getTotal() throws Exception;
	public List<Adver> selectLimitAdver(int start,int pagesize) throws Exception;
}
