package org.rahner.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		if (request.getRequestURI().contains("/resources")) {
			System.out.println("Resources");
			return true;
		} else if (request.getRequestURI().equals(request.getContextPath() + "/")) {
			System.out.println("/");
			return true;
		} else if (request.getRequestURI().contains("login") || request.getRequestURI().contains("register")) {
			System.out.println("log or reg");
			return true;
		} else if (request.getSession().getAttribute("userId") == null) {
			System.out.println("userId is null");
			response.sendRedirect(request.getContextPath() + "/");
			return false;
		} else if ((!(request.getSession().getAttribute("permission").equals("U"))
				&& !(request.getSession().getAttribute("permission").equals("A")))) {
			System.out.println("No permission");
			response.sendRedirect(request.getContextPath() + "/");
			return false;
		} else {
			// System.out.println("else");
			return true;
		}
	}
}
