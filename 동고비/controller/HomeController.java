package com.kopo.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kopo.dto.HuboDTO;
import com.kopo.service.VoteService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	private VoteService service;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request, Model model) throws Exception{

		logger.info("Candidate registration");
		List<HuboDTO> huboList = service.selectAllHubo();
		int huboListLastIndex = huboList.size() - 1;
		int nextID = huboList.get(huboListLastIndex).getId() + 1;
		request.setAttribute("huboList", huboList);
		request.setAttribute("nextID", nextID);
		
		return "home";
	}
	
//	@RequestMapping("insert.do")
//	public ModelAndView insert(String id, String pw, String name) throws Exception {
//		logger.info("insert");
//		MemberVO member = new MemberVO();
//		ModelAndView modelAndView = new ModelAndView();
//		String result;
//		member.setId(id);
//		member.setPw(pw);
//		member.setName(name);
//		
//		int insertResult = service.insertMember(member);
//		if(insertResult == 1) {
//			result = "insert 성공";
//		} else {
//			result = "insert 실패";
//		}
//		
//		modelAndView.setViewName("insertResult");
//		modelAndView.addObject("member", member);
//		modelAndView.addObject("result", result);
//		return modelAndView;
//	}
}