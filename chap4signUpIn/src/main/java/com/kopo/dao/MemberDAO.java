package com.kopo.dao;

import java.util.List;

import com.kopo.dto.MemberVO;

public interface MemberDAO {
//	public List<MemberVO> selectMember() throws Exception;
	
	public int insertMember(MemberVO member) throws Exception;
}
