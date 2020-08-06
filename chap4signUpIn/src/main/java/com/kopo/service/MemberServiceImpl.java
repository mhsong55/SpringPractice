package com.kopo.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import com.kopo.dao.MemberDAO;
import com.kopo.dto.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	private MemberDAO dao;
	
	@Override
	public int insertMember(MemberVO member) throws Exception {
		String digestTargetString = member.getPw();
		member.setPw(digest(digestTargetString));
		
		return dao.insertMember(member);
	}
	
	
	/* ID duplication check method
	 * count the input id from DB
	 * @param: (String) id
	 * @return: (boolean) true if count number > 0
	 * 		   else (boolean) false
	 * */
	@Override
	public boolean isDuplicatedID(String id) throws Exception {
		int selectCountById = dao.selectCountById(id);
		if (selectCountById > 0) {
			return true;
		} 
		return false;
	}
	
	/* Method to encrypt password
	 * @param: (String) password
	 * @return: (String) Encrypted password
	 * */
	@Override
	public String digest(String target) {
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		messageDigest.update(target.getBytes());
		return String.format("%064x", new BigInteger(1, messageDigest.digest()));
	}

	/* Convert data received by HTTP to MemberVO instance */
	@Override
	public MemberVO requestToMember(HttpServletRequest request) {
		// get parameter form HTTP requests
		String id = (String) request.getParameter("id");
		String pw = (String) request.getParameter("pw");
		String name = (String) request.getParameter("name");
		String email = (String) request.getParameter("email");
		
		String phone1 = (String) request.getParameter("phone1");
		String phone2 = (String) request.getParameter("phone2");
		String phone3 = (String) request.getParameter("phone3");

		String phone = "error";
		StringBuffer stringBuffer = new StringBuffer();
		
		/* Since the phone number is divided into three, 
		 * all three input values are added together to make one number */
		if(phone1.length() <= 4 && phone2.length() <= 4 && phone2.length() <= 4) {
			phone = stringBuffer.append(phone1)
			    				.append(phone2)
								.append(phone3)
								.toString();
		}		
		
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPw(pw);
		member.setName(name);
		member.setEmail(email);
		member.setPhone(phone);
		
		return member;
	}


	@Override
	public boolean isMatchedIdAndPw(MemberVO member) throws Exception {
		int selectCountByIdAndPw = dao.selectCountByIdAndPw(member);
		if(selectCountByIdAndPw > 0) {
			return true;
		}
		
		return false;
	}


	@Override
	public MemberVO getUserInform(String id) throws Exception {
		return dao.selectUserInform(id);
	}
	
}
