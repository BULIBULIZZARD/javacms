package com.www.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SessionInterceptor implements HandlerInterceptor {
	public boolean preHandle(HttpServletRequest request,
		HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("username");
		if (user != null) {
			return true;
		} else {
			String path = request.getRequestURI();
			int num = path.lastIndexOf("/");
			path = path.substring(0, num);
			num = path.lastIndexOf("/");
			path = path.substring(0, num+1);
			request.setAttribute("path", path);
			request.getRequestDispatcher("/adminlogin.jsp").forward(request,
					response);
			return false;
		}
	}
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub

	}

}
