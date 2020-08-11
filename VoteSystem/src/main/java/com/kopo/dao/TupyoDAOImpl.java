package com.kopo.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kopo.dto.TupyoDTO;

@Repository
public class TupyoDAOImpl implements TupyoDAO {
	@Inject
	private SqlSession sqlSession;
	private static final String Namespace = "com.kopo.mapper.voteMapper";
	
	@Override
	public int insertTupyo(TupyoDTO tupyo) throws Exception {
		
		return sqlSession.insert(Namespace + ".insertTupyo", tupyo);
	}

	@Override
	public int selectOneCountTupyoById(int id) throws Exception {
		
		return sqlSession.selectOne(Namespace + ".selectOneCountTupyoById", id);
	}

	@Override
	public int selectAllCountTupyo() throws Exception {
		
		return sqlSession.selectOne(Namespace + ".selectAllCountTupyo");
	}
	
}
