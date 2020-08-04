package com.kopo.service;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.kopo.dao.MemberDAO;
import com.kopo.dto.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	private MemberDAO dao;
	
	@Override
	public int insertMember(MemberVO member) throws Exception {
		
		return dao.insertMember(member);
	}
	
	@Override
	public boolean isDuplicatedID(String id) throws Exception {
		int selectCountById = dao.selectCountById(id);
		if(selectCountById > 0) {
			return true;
		} else {
			return false;
		}
	}
}
