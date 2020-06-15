package com.my.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthenticationInterceptor extends HandlerInterceptorAdapter {
	// HandlerInterceptorAdapter : interceptor를 사용하기 위해서 상속받아야함

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object hander) throws Exception {
		System.out.println("preHandle start");
		HttpSession session = request.getSession();
		// session 객체를 가져옴
		Object obj = session.getAttribute("userId");
		// 사용자 정보를 담고 있는 객체를 가져옴

		if (obj == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			// 로그인이 안되어 있는 상태임으로 로그인 폼으로 다시 돌려보냄(redirect)
			return false; // 더이상 컨트롤러 요청으로 가지 않도록 false로 반환함
		}

		System.out.println("preHandle end");

		return true;
		// preHandle의 return은 컨트롤러 요청 uri로 가도 되냐 안되냐를 허가하는 의미임
		// 따라서 true로하면 컨트롤러 uri로 가게 됨.
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
		System.out.println("postHandle end");
	}

}
