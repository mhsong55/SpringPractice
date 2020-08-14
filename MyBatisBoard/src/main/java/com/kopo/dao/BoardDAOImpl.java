package com.kopo.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kopo.dto.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	@Inject
	private SqlSession sqlSession;
	private static final String Namespace = "com.kopo.mapper.boardMapper";
	
	@Override
	public List<BoardVO> selectAllPost() throws Exception {
		return sqlSession.selectList(Namespace+".selectMember");
	}

}
