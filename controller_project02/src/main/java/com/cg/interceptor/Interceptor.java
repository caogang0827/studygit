/**
 * 
 */
package com.cg.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.cg.entity.User;

/**
 * @作者：曹刚
 * @时间：2019年3月15日
 */
public class Interceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		
		String uri = request.getRequestURI();
		
		User user = (User) request.getSession().getAttribute("user");
		
		if(user!=null) {
			
			return true;
			
		}else if(uri.indexOf("login.do") > 0) {
			
			return true;
			
		}
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		return false;
	}

}
