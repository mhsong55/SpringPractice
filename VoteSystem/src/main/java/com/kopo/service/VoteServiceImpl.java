package com.kopo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import org.springframework.stereotype.Service;

import com.kopo.dao.HuboDAO;
import com.kopo.dao.TupyoDAO;
import com.kopo.dto.HuboDTO;
import com.kopo.dto.TupyoDTO;

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
	public String insertHubo(HuboDTO hubo) throws Exception {
		if (huboDao.insertHubo(hubo) == 1) {
			return "후보등록 결과 : 후보가 추가되었습니다.";
		}
		return "후보등록 결과 : 후보등록 실패";
	}
	
	@Override
	public String deleteHubo(int id) throws Exception {
		if (huboDao.deleteHubo(id) == 1) {
			return "후보등록 결과 : 후보가 삭제되었습니다.";
		}
		return "후보등록 결과 : 후보삭제 실패";
	}

	@Override
	public String vote(TupyoDTO tupyo) throws Exception {
		if (tupyoDao.insertTupyo(tupyo) == 1) {
			return "투표 결과 : 투표하였습니다.";
		}
		return "투표 결과 : 투표 실패";
	}

	@Override
	public List<Double> rateList() throws Exception {
		// 해당 id의 득표 수
		int voteCountById;
		
		// typyo table의 전체 record Count 수
		int totalVoteCount = tupyoDao.selectAllCountTupyo();
		List<Double> rateList = new ArrayList<>();
		
		double voteRate;
		for(HuboDTO hubo : selectAllHubo()) {
			voteCountById = tupyoDao.selectOneCountTupyoById(hubo.getId());
			voteRate = (double) voteCountById / totalVoteCount * 10000;
			voteRate = Math.round(voteRate) / 100.0;
			rateList.add(voteRate);
		}
		return rateList;
	}
	
	@Override
	public List<Integer> voteCountList() throws Exception {
		List<Integer> voteCountList = new ArrayList<>();
		
		for(HuboDTO hubo : selectAllHubo()) {
			voteCountList.add(tupyoDao.selectOneCountTupyoById(hubo.getId()));
		}
		return voteCountList;
	}
	
}
