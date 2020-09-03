package com.kopo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kopo.dto.BoardVO;

public interface BoardService {
	
	// Create
	public String insert(Map<String, String> postDataMap) throws Exception;
	
	// Read
	public BoardVO selectOne(int id) throws Exception;
	
	public List<BoardVO> selectAllPost() throws Exception;
	
	public BoardVO lastInsertedPost() throws Exception;
	
	// Update
	public String update(HashMap <String, String> postDataMap) throws Exception;
	
	// Delete
	public String delete(int id) throws Exception;
}
