package com.kopo.chap4Controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.kopo.dto.MemberVO;
import com.kopo.service.MemberService;

/**
 * Handles requests for the application home page. */
@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	private MemberService service;
	
	// initial page URL mapping
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	// enroll DB by insert Query
	@RequestMapping(value = "/memberList", method = RequestMethod.POST)
	public String insert(HttpServletRequest request) {

		logger.info("[Insert controller]");
		
		// get parameter form HTTP requests
		String id = (String) request.getParameter("id");
		String pw = (String) request.getParameter("pw");
		String name = (String) request.getParameter("name");
		String email = (String) request.getParameter("email");
		
		String phone1 = (String) request.getParameter("phone1");
		String phone2 = (String) request.getParameter("phone2");
		String phone3 = (String) request.getParameter("phone3");
		
		String result = "회원 가입 실패!\n";
		String phone = "error";
		
		/* Since the phone number is divided into three, 
		 * all three input values are added together to make one number */
		if(phone1.length() <= 4 && phone2.length() <= 4 && phone2.length() <= 4) {
			StringBuffer stringBuffer = new StringBuffer();
			phone = stringBuffer.append(phone1)
			    				.append(phone2)
								.append(phone3)
								.toString();
		}		
		try {
			
			// phone number length check
			if (phone.length() > 12) {
				logger.info("[INSERT Failure] Phone number is too long");
				result = "휴대폰 번호는 12자리 이하로 입력해 주세요.";
	
			// ID duplication check
			} else if (service.isDuplicatedID(id)) {
				logger.info("[INSERT Failure] The input ID is duplicated.");
				result = "이미 존재하는 ID 입니다.";
			} else {
				MemberVO member = new MemberVO();
				member.setId(id);
				member.setPw(pw);
				member.setName(name);
				member.setEmail(email);
				member.setPhone(phone);
				
				// insert service operate
				int insertResult = service.insertMember(member);
				
				/* On successful insertion, execution always returnes 1
				 * because the operation performed on a unit member basis*/
				if (insertResult == 1) {
					result = "success";
					request.setAttribute("member", member);
					logger.info(result);
				}
			}
		
		} catch (Exception e) {
			logger.info("[INSERT FAIL] \n" + e.getMessage());
			e.printStackTrace();
			result += e.getMessage();
		}
		
		request.setAttribute("result", result);
		return "insertResult";
	}
}