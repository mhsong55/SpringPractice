package com.kopo.service;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;

import com.kopo.dao.HuboDAO;
import com.kopo.dao.TupyoDAO;
import com.kopo.dto.HuboDTO;

@Service
public class VoteServiceImpl implements VoteService {

	@Inject
	private HuboDAO huboDao;
	@Inject
	private TupyoDAO tupyoDao;
	
	@Override
	public List<HuboDTO> selectAllHubo() throws Exception {

		return huboDao.selectAllHubo();
	}
	
	@Override
	public int insertHubo(HuboDTO hubo) throws Exception {
		
		return huboDao.insertHubo(hubo);
	}
}
