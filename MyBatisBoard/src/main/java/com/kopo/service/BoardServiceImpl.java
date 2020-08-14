package com.kopo.service;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.kopo.dao.BoardDAO;
import com.kopo.dto.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO dao;
	
	@Override
	public List<BoardVO> selectAllPost() throws Exception {

		return dao.selectAllPost();
	}
}