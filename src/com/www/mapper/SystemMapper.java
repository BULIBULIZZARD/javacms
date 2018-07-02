package com.www.mapper;

import com.cms.pojo.System;

public interface SystemMapper {

	public void update(System system) throws Exception;
	public String getwebname() throws Exception;
	public int getpagesize()throws Exception;
	public int getfrontpagesize()throws Exception;
	public int getnavnum()throws Exception;
	public int getlinknum()throws Exception;
	public int getadvernum()throws Exception;
	public System getall()throws Exception;
}
