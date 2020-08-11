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
	private static final String Namespace = "com.kopo.mapper.voteMapper";
	
	@Override
	public List<HuboDTO> selectAllHubo() throws Exception {
		return sqlSession.selectList(Namespace + ".selectHubo");
	}
	
	@Override
	public int insertHubo(HuboDTO hubo) throws Exception {
		return sqlSession.insert(Namespace + ".insertHubo", hubo);
	}
	
	@Override
	public int deleteHubo(int id) throws Exception {
		return sqlSession.delete(Namespace + ".deleteHubo", id);
	}
}
