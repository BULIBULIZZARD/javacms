package com.common.controller;

import org.springframework.stereotype.Controller;

@Controller
public class ImageController {

	
//	@RequestMapping("/manage/article/getchlidcategory")
//	public @ResponseBody JsonResult<List<Category>> getchildcate(HttpServletRequest request) throws NumberFormatException, Exception{
//		String id =  request.getParameter("id");
//		List<Category> child =  categoryMapper.selectcatebypid(Integer.parseInt(id));
//		//JsonResult<Map<String, Integer>> result = new JsonResult<>();
//		JsonResult<List<Category>>  result= new JsonResult<List<Category>>();
//		result.setData(child);
//		result.setStatus(1);
//		return result;
//	}
	
/*	@RequestMapping("/image.upload")
	public JSONObject upload(@RequestParam MultipartFile photo  ,HttpServletRequest request) throws Exception {
	    ServletContext sc = request.getSession().getServletContext();  
	    String dir = sc.getRealPath("/upload/");    
	    String fileName = photo.getOriginalFilename();  
	    JSONObject result = new JSONObject();
	    
	    result.put("status", 1);
	    result.put("message", "haha");
	    result.put("data", "/static/upload");
	    'status'=>intval($status),
	            'message'=>$message,
	            'data'=>$data,
	    //vo.setPpic("/upload/"+fileName);   
		
			//return "manage/view/article/add";
	    return result;
	}*/
	
}
