package com.kopo.chap4Controller;

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

import com.kopo.dto.MemberVO;
import com.kopo.service.MemberService;

/**
 * Handles requests for the application home page.
 */
@Controller

public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	private MemberService service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping(value = "/memberList", method = RequestMethod.POST)
	public String insert(HttpServletRequest request) {

		logger.info("[Insert controller]");
		String id = (String) request.getParameter("id");
		String pw = (String) request.getParameter("pw");
		String name = (String) request.getParameter("name");
		String email = (String) request.getParameter("email");
		String phone = (String) request.getParameter("phone");
		String result;
		
		if(id == null || pw == null || name == null || email == null || phone == null) {
			logger.info("home - Parameter isNull");
			result = "write a value.";
			request.setAttribute("result", result);
		} else {
			MemberVO member = new MemberVO();
			member.setId(id);
			member.setPw(pw);
			member.setName(name);
			member.setEmail(email);
			member.setPhone(phone);
			try {
				int insertResult = service.insertMember(member);
				if(insertResult == 1) {
					result = "insert success.";
					request.setAttribute("member", member);
				} else {
					result = "insert failure.";
				}
				request.setAttribute("result", result);
			} catch (Exception e) {
				logger.info("[INSERT FAIL] " + e.getMessage());
				e.printStackTrace();
			}
		}
		return "insertResult";
	}
}