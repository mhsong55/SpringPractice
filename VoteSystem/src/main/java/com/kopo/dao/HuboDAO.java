package com.kopo.dao;

import java.util.List;

import com.kopo.dto.HuboDTO;

public interface HuboDAO {
	public List<HuboDTO> selectAllHubo() throws Exception;
	
	public int insertHubo(HuboDTO hubo) throws Exception;
	
	public int deleteHubo(int id) throws Exception;
	
	public HuboDTO selectOne(int id) throws Exception;
}
