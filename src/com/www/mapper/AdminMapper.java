package com.www.mapper;

import java.util.List;

import com.cms.pojo.Admin;

public interface AdminMapper {

	public void add(Admin admin) throws Exception;
	public void del(Admin admin) throws Exception;
	public int checkusername(Admin admin) throws Exception;
	public void listorder(Admin admin) throws Exception;
	public int checkid(int id) throws Exception;
	public Admin getoneadmin(int id) throws Exception;
	public void updateusername(Admin admin)throws Exception;
	public void update(Admin admin)throws Exception;
	public int login(Admin admin)throws Exception;
	//∑÷“≥≤È—Ø
	public String getTotal() throws Exception;
	public List<Admin> selectlimitadmin(int start,int pagesize) throws Exception;
}
