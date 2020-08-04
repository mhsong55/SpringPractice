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
		String result = "회원 가입 실패!\n";
		boolean isSuccess = false;
		try {
			if(id == null || pw == null || name == null || email == null || phone == null) {
				logger.info("insert - Parameter isNull");
				result = "입력 칸에 공란이 존재합니다.";
			} else if(phone.length() > 11) {
				logger.info("[INSERT Failure] Phone number is too long");
				result = "휴대폰 번호는 11자리 이하로 입력해 주세요.";
			} else if(service.isDuplicatedID(id)) {
				logger.info("[INSERT Failure] The input ID is duplicated.");
				result = "이미 존재하는 ID 입니다.";
			} else {
				MemberVO member = new MemberVO();
				member.setId(id);
				member.setPw(pw);
				member.setName(name);
				member.setEmail(email);
				member.setPhone(phone);
				
				int insertResult = service.insertMember(member);
				if(insertResult == 1) {
					result = name + " 님의 회원 가입이 완료되었습니다.\n"
							+ "ID : " + id
							+ "\nE-mail : " + email
							+ "\nPhone number : " + phone;
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