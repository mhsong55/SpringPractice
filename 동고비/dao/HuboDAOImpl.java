package com.kopo.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kopo.dto.HuboDTO;

@Repository
public class HuboDAOImpl implements HuboDAO {
	@Inject
	private SqlSession sqlSession;
	private static final String Namespace = "com.kopo.mapper.memberMapper";
	
	@Override
	public List<HuboDTO> selectHubo() throws Exception {
		return sqlSession.selectList(Namespace+".select");
	}
	
	@Override
	public int insertHubo(HuboDTO hubo) throws Exception {
		return sqlSession.insert(Namespace + ".insert", hubo);
	}

}
