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
	public BoardVO selectOne(int id) throws Exception {
		return sqlSession.selectOne(Namespace + ".selectOne", id);
	}
	@Override
	public List<BoardVO> selectAllPost() throws Exception {
		return sqlSession.selectList(Namespace+".selectAllPost");
	}

	@Override
	public int insertPost(BoardVO post) throws Exception {
		return sqlSession.insert(Namespace + ".insertPost", post);
	}
	@Override
	public int lastInsertedPostId() throws Exception {
		return sqlSession.selectOne(Namespace + ".lastInsertedPostId");
	}
}
