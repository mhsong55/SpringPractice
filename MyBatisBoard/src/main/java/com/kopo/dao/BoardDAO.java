package com.kopo.dao;

import java.util.List;
import com.kopo.dto.BoardVO;

public interface BoardDAO {
	
	// Create
	public int insertPost(BoardVO post) throws Exception;
	
	// Read
	public BoardVO selectOne(int id) throws Exception;
	
	public List<BoardVO> selectAllPost() throws Exception;
	
	public int lastInsertedPostId() throws Exception;
	
	// Update
	public int update(BoardVO post) throws Exception;
	
	// Delete
	public int delete(int id) throws Exception;
}
