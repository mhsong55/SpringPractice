package com.kopo.service;

import java.util.List;

import com.kopo.dto.HuboDTO;

public interface VoteService {
	
	public List<HuboDTO> selectAllHubo() throws Exception;
	
	public int insertHubo(HuboDTO hubo) throws Exception;
}
