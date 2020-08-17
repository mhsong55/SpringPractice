package com.kopo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kopo.dto.BoardVO;

public interface BoardService {
	
	public BoardVO selectOne(int id) throws Exception;
	
	public List<BoardVO> selectAllPost() throws Exception;
	
	public String insert(Map<String, String> postDataMap) throws Exception;
	
	public BoardVO lastInsertedPost() throws Exception;
	
	public int update(HashMap <String, String> postDataMap) throws Exception;
	
	public int delete(int id) throws Exception;
}
