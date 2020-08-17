package com.kopo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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

	@Override // 해당 id의 후보 정보를 DB에서 조회
	public HuboDTO selectOneHubo(int id) throws Exception {
		return huboDao.selectOne(id);
	}

	@Override // 특정 후보에 대한 연령대 별 득표수를 조회
	public List<List<Integer>> ageTendency(int id) throws Exception {
		List<List<Integer>> ageTendency = new ArrayList<List<Integer>>();
		ageTendency.add(tupyoDao.selectAgeTupyoWhereIdGroupByAge(id));
		ageTendency.add(tupyoDao.selectCountTupyoWhereIdGroupByAge(id));
		return ageTendency;
	}

	@Override // 연령대에 따른 득표율을 계산하여 return
	public List<Double> tendencyRateList(int id) throws Exception {
		// 특정 후보의 득표 수를 Database에서 조회
		int voteCount = tupyoDao.selectOneCountTupyoById(id);
		
		// 특정 후보의 특정 연령대에 따른 득표 수를 조회해서 List에 저장
		List<Integer> tendencyCountList = tupyoDao.selectCountTupyoWhereIdGroupByAge(id);
		List<Double> tendencyRateList = new ArrayList<>();
		double tendencyRate;
		for(int tendencyCount : tendencyCountList) {
			// 연령대별 득표율 = 연령대 별 득표 수 / 전체 득표수 * 100
			tendencyRate = (double) tendencyCount / voteCount * 10000;
			// 소수점 셋째자리에서 반올림
			tendencyRate = Math.round(tendencyRate) / 100.0;
			tendencyRateList.add(tendencyRate);
		}
		// 계산된 연령대별 득표율 List를 return
		return tendencyRateList;
	}
	
	
}
