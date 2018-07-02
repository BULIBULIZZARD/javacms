package com.www.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cms.pojo.User;

public interface UserMapper {

	public void register(User user) throws Exception;
	public int checkusername(@Param("username")String username)throws Exception;
	public int checkcookie(@Param("username")String username,@Param("uniquecode")String uniquecode)throws Exception;
	public int checklogin(User user)throws Exception;
	public User getuserdata(@Param("username")String username)throws Exception;
	public void del(User user) throws Exception;
	public void listorder(User user) throws Exception;
	//∑÷“≥≤È—Ø
	public String getTotal() throws Exception;
	public List<User> selectlimituser(int start,int pagesize) throws Exception;
}
