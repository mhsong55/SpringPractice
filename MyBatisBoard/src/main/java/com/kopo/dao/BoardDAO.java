package com.kopo.dao;

import java.util.List;
import com.kopo.dto.BoardVO;

public interface BoardDAO {
	
	public BoardVO selectOne(int id) throws Exception;
	
	public List<BoardVO> selectAllPost() throws Exception;
	
	public int insertPost(BoardVO post) throws Exception;
	
	public int lastInsertedPostId() throws Exception;
	
	public int update(BoardVO post) throws Exception;
}
