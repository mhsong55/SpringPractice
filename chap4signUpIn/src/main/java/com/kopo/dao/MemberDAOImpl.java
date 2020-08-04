package com.kopo.dao;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.kopo.dto.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Inject
	private SqlSession sqlSession;
	private static final String Namespace = "com.kopo.mapper.memberMapper";
	
	@Override
	public int insertMember(MemberVO member) throws Exception {
		return sqlSession.insert(Namespace + ".insert", member);
	}

	@Override
	public int selectCountById(String id) throws Exception {
		return sqlSession.selectOne(Namespace+".selectCountById", id);
	}
}
