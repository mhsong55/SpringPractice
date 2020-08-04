package com.kopo.service;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;

import com.kopo.dao.MemberDAO;
import com.kopo.dto.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	private MemberDAO dao;
	
//	@Override
//	public List<MemberVO> selectMember() throws Exception {
//
//		return dao.selectMember();
//	}
	
	@Override
	public int insertMember(MemberVO member) throws Exception {
		
		return dao.insertMember(member);
	}
}
