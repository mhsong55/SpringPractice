package com.kopo.service;

import javax.servlet.http.HttpServletRequest;

import com.kopo.dto.MemberVO;

public interface MemberService {
	
	public boolean isDuplicatedID (String id) throws Exception;
	
	public int insertMember (MemberVO member) throws Exception;
	
	public String digest(String target);
	
	public MemberVO requestToMember(HttpServletRequest request);
	
	public boolean isMatchedIdAndPw(MemberVO member) throws Exception;
	
	public MemberVO getUserInform(String id) throws Exception;
}
