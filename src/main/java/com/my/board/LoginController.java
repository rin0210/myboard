package com.my.board;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.my.DTO.MemberDTO;
import com.my.service.ControllerToModelMember;

@Controller
public class LoginController {

	@Autowired // bean을 주입하는 방식 이때 ControllerToModel 타입으로 주입
	ControllerToModelMember ctm;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm() {
		System.out.println("Login Controller");
		return "login";
	}

	@RequestMapping(value = "/loginPro", method = RequestMethod.POST)
	public String loginProcess(HttpSession session, @RequestParam("id") String id, @RequestParam("pwd") String pwd) {
		System.out.println("loginPro Controller : " + id);
		String returnURL = "";

		if (session.getAttribute("userId") != null) {
			// 기존에 user란 세션 값이 존재한다면
			session.removeAttribute("userId"); // 기존 값 제거
			session.removeAttribute("userName");
		}
		MemberDTO mdto = ctm.selectOne(id);
		if (mdto != null) {
			session.setAttribute("userId", mdto.getId()); // 세션에 아이디 저장
			session.setAttribute("userName", mdto.getName()); // 세션에 이름 저장
			returnURL = "redirect:/boardlist"; // 로그인 성공시 게시글 목록으로 이동
		} else {
			returnURL = "redirect:/login"; // 실패시 로그인 폼으로 다시 이동
		}

		return returnURL;
	}

	@RequestMapping(value = "/logoutPro", method = RequestMethod.GET)
	public String logoutProcess(HttpSession session) {
		session.invalidate(); // 세션 전체를 날려버림

		return "redirect:/login";
	}

}
