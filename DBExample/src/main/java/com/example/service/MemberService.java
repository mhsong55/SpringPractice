package com.example.service;

import java.util.List;

import com.example.dto.MemberVO;

public interface MemberService {
	
	public List<MemberVO> selectMember() throws Exception;
	
	public int insertMember(MemberVO member) throws Exception;
}
