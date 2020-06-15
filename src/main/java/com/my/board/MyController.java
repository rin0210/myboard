package com.my.board;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.my.DTO.BoardDTO;
import com.my.service.ControllerToModelBoard;
import com.my.service.ControllerToModelMember;

@Controller
public class MyController {
	

	@Autowired // bean을 주입하는 방식, 이때 ControllerToModel 타입으로 주입
	ControllerToModelBoard ctmb;

	@Autowired // bean을 주입하는 방식, 이때 ControllerToModel 타입으로 주입
	ControllerToModelMember ctmm;

	@RequestMapping("boardlist")
	public String list(Model model) {
		model.addAttribute("list", ctmb.selectAll());
		model.addAttribute("img", ctmb.selectImg());
		return "list";
	}

	@RequestMapping("boardjoin")
	public String join() {
		return "join";
	}

	@RequestMapping("joinProcess")
	public String inputMember(HttpServletRequest request) {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		System.out.println("joinProcess : " + id + " / " + name + " / " + pwd);
		ctmm.insertMember(id, name, pwd);

		return "redirect:boardlist"; // redirect: 다시 list 컨트롤러에게 넘어가라
	}

	@RequestMapping("boardwrite")
	public String write() {
		return "write";
	}

	@RequestMapping("writeProcess")
	public String inputBoard(@ModelAttribute BoardDTO bdto, MultipartHttpServletRequest mhsr) throws Exception {
		ctmb.insertBoard(bdto, mhsr);

		return "redirect:boardlist";
	}
	
	@RequestMapping("boarddetail")
	public String detail(@RequestParam("no") int no, Model model) {
		model.addAttribute("detail", ctmb.selectOne(no));
		model.addAttribute("img", ctmb.selectImgOne(no));
		
		return "detail";
	}
	
	@RequestMapping("boarddel")
	public String del(HttpServletRequest request) {
		int no = Integer.valueOf(request.getParameter("no"));
		ctmb.deleteBoard(no);
		
		return "redirect:boardlist";
	}
	
	@RequestMapping("boardmod")
	public String mod(@RequestParam("no") int no, Model model) {
		model.addAttribute("detail", ctmb.selectOne(no));
		model.addAttribute("img", ctmb.selectImgOne(no));
		
		return "modify";
		
	}
	
	@RequestMapping("modProcess")
	public String modBoard(@ModelAttribute BoardDTO bdto, MultipartHttpServletRequest mhsr, @RequestParam("mod_f_no") int mod_f_no) throws Exception {
		ctmb.modifyBoard(bdto, mhsr, mod_f_no);
		
		return "redirect:boarddetail?no="+bdto.getNo();
	}
}
