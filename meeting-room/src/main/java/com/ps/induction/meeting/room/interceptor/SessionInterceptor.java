/**
 * 
 */
package com.ps.induction.meeting.room.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ps.induction.meeting.room.domain.entity.Function;
import com.ps.induction.meeting.room.domain.entity.Role;
import com.ps.induction.meeting.room.domain.entity.User;

/**
 * 
 * @author Loai AlTamimi
 *
 */
public class SessionInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession httpSession = request.getSession();
		
		if(httpSession != null){
			User user = (User) httpSession.getAttribute("loggedUser");
			if(user != null){
				String requestedPage = request.getServletPath();
				Role role = user.getRole();
				List<Function> functionLst = role.getFunction();	
				
				for (Function function2 : functionLst) {
					if(function2.getPageName().equals(requestedPage)){
						return true;
					}
				}
				
			}else{
				request.getRequestDispatcher("/login").forward(request, response);
				return false;
			}
		}else{
			request.getRequestDispatcher("/login").forward(request, response);
			return false;
		}
		return false;
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

}
