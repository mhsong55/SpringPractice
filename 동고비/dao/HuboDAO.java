package com.kopo.dao;

import java.util.List;

import com.kopo.dto.HuboDTO;

public interface HuboDAO {
	public List<HuboDTO> selectHubo() throws Exception;
	
	public int insertHubo(HuboDTO hubo) throws Exception;
}
