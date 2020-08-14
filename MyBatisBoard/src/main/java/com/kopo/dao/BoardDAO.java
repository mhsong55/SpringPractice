package com.kopo.dao;

import java.util.List;
import com.kopo.dto.BoardVO;

public interface BoardDAO {
	public List<BoardVO> selectAllPost() throws Exception;
}
