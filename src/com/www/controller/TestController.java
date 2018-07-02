package com.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.www.mapper.ArticleMapper;

@Controller
public class TestController {
	@Autowired
	private static ArticleMapper articleMapper;
	
	public static void main(String[] args) throws Exception {
		int [] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34};
		//产生0-(arr.length-1)的整数值,也是数组的索引
		for (int i = 807; i < 3519; i++) {
			
			int index=(int)(Math.random()*arr.length);
			int rand = arr[index];
			articleMapper.setCategoryId(i,rand);
		}
		
	}
	
	
	
	
}
