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
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
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
		return "logIn";
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String logIn(HttpServletRequest request) {
		
		logger.info("LOG IN");
		// get parameter form HTTP requests
		String id = (String) request.getParameter("id");
		String pw = (String) request.getParameter("pw");
		MemberVO inputUserInform = new MemberVO();
		inputUserInform.setId(id);
		inputUserInform.setPw(service.digest(pw));
		try {
			if (service.isDuplicatedID(inputUserInform.getId())) {
				if (service.isMatchedIdAndPw(inputUserInform)) {
					logger.info("LOG IN: Success.");
					MemberVO logInUser = service.getUserInform(id);
					logger.info("LOG IN: " + logInUser.getName());
					request.setAttribute("result", "success");
					request.setAttribute("user", logInUser);
				} else {
					logger.info("LOG IN: Wrong Password.");
					request.setAttribute("result", "fail");
					request.setAttribute("reason", "pw");
				}
			} else {
				logger.info("LOG IN: ID does not exists.");
				request.setAttribute("result", "fail");
				request.setAttribute("reason", "id");
			}
		} catch (Exception e) {
			logger.info("LOG IN: Exception Occured. \n" + e.getMessage());
			e.printStackTrace();
		}
		
		return "login_result";
	}
	
	// Sign up page URL mapping
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup() {
		return "signup";
	}
	
	// enroll DB by insert Query
	@RequestMapping(value = "/memberList", method = RequestMethod.POST)
	public String insert(HttpServletRequest request) {

		logger.info("INSERT");
		MemberVO member = service.requestToMember(request);
		String result = "회원 가입 실패!\n";
			
		try {
			
			// phone number length check
			if (member.getPhone().length() > 12) {
				logger.info("[INSERT Failure] Phone number is too long");
				result = "휴대폰 번호는 12자리 이하로 입력해 주세요.";
	
			// ID duplication check
			} else if (service.isDuplicatedID(member.getId())) {
				logger.info("[INSERT Failure] The input ID is duplicated.");
				result = "이미 존재하는 ID 입니다.";
			} else {
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
	
	// Log on page URL mapping
	@RequestMapping(value = "/logon.do", method = RequestMethod.POST)
	public String logOn(HttpServletRequest request) {
		String getUserInfo = request.getParameter("user");
		MemberVO member = new MemberVO();
		JSONParser jsonParser = new JSONParser();
		
		try {
			// JSON 데이터를 넣어 JSON Object로 만들어준다.
			JSONObject jsonObject = (JSONObject) jsonParser.parse(getUserInfo);
			member.setId(jsonObject.get("id").toString());
			member.setName(jsonObject.get("name").toString());
			member.setEmail(jsonObject.get("email").toString());
			member.setPhone(jsonObject.get("phone").toString());
		} catch (org.json.simple.parser.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("user", member);
		
		return "logon";
	}
}