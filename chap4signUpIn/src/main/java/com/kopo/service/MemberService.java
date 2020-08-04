package com.kopo.service;

import java.util.List;

import com.kopo.dto.MemberVO;

public interface MemberService {
	
	public boolean isDuplicatedID(String id) throws Exception;
	
	public int insertMember(MemberVO member) throws Exception;
}
