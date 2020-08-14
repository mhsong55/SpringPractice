package com.kopo.service;

import java.util.List;

import com.kopo.dto.BoardVO;

public interface BoardService {
	
	public List<BoardVO> selectAllPost() throws Exception;
}
