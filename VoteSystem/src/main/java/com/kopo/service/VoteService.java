package com.kopo.service;

import java.util.List;
import java.util.Map;

import com.kopo.dto.HuboDTO;
import com.kopo.dto.TupyoDTO;

public interface VoteService {
	
	public List<HuboDTO> selectAllHubo() throws Exception;
	
	public String insertHubo(HuboDTO hubo) throws Exception;
	
	public String deleteHubo(int id) throws Exception;
	
	public String vote(TupyoDTO tupyo) throws Exception;
	
	public List<Double> rateList() throws Exception;
	
	public List<Integer> voteCountList() throws Exception;
}
