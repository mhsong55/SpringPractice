package com.kopo.service;

import java.util.List;

import com.kopo.dto.MemberVO;

public interface MemberService {
	
	// public List<MemberVO> selectMember() throws Exception;
	
	public int insertMember(MemberVO member) throws Exception;
}
