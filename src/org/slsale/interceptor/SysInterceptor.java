package org.slsale.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.slsale.common.Constants;
import org.slsale.common.RedisAPI;
import org.slsale.pojo.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SysInterceptor extends HandlerInterceptorAdapter {
	private Logger logger = Logger.getLogger(SysInterceptor.class);
	@Resource
	private RedisAPI redisAPI;
	
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,
							Object handler) throws Exception {  
	   //intercept  
	   HttpSession session = request.getSession();  
	   User user =  ((User)session.getAttribute(Constants.SESSION_USER));
	   String targetId = request.getParameter("targetId");
	   session.setAttribute("targetId", targetId);
	   if(null == user){
		   response.sendRedirect("/");
		   return false;
	   }else{
		   
		   return true; 
		   /* 
		   String keyString = "Role"+user.getRoleId() + "UrlList";
		   String urlsString = "url:"+redisAPI.get(keyString);
		  
		   String urlPath = request.getRequestURI();
		   if(null != urlsString && !"".equals(urlsString) && urlsString.indexOf(urlPath) > 0){
			   return true;  
		   }else {
			   response.sendRedirect("/401.html");
			   return false;
		   }*/
	   }
	}
}
