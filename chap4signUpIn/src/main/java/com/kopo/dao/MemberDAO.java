package com.kopo.dao;

import com.kopo.dto.MemberVO;

public interface MemberDAO {
	
	public int selectCountById (String id) throws Exception;
	
	public int insertMember (MemberVO member) throws Exception;
	
	public int selectCountByIdAndPw(MemberVO member) throws Exception;

	public MemberVO selectUserInform(String id) throws Exception;
	
}
