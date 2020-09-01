package com.kopo.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kopo.dto.HuboDTO;
import com.kopo.dto.TupyoDTO;
import com.kopo.service.VoteService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	private VoteService service;
	
	@RequestMapping(value = {"/registration", "/"}, method = RequestMethod.GET)
	public String registration(HttpServletRequest request) throws Exception{

		logger.info("Candidate registration");
		List<HuboDTO> huboList = service.selectAllHubo();
		int huboListLastIndex = huboList.size() - 1;
		int nextID = 1;
		if (huboListLastIndex != -1) {
			nextID = huboList.get(huboListLastIndex).getId() + 1;
		}
		
		request.setAttribute("huboList", huboList);
		request.setAttribute("nextID", nextID);
		
		return "A_01";
	}
	
	@RequestMapping(value = "/registration.do", method = RequestMethod.POST)
	public ModelAndView insert(HttpServletRequest request) throws Exception {
		logger.info("INSERT");
		HuboDTO hubo = new HuboDTO();
		String name = request.getParameter("name");
		hubo.setName(name);
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("A_03");
		modelAndView.addObject("result", service.insertHubo(hubo));
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView delete(int id) throws Exception {
		logger.info("DELETE");
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("A_02");
		modelAndView.addObject("result", service.deleteHubo(id));
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/vote", method = RequestMethod.GET)
	public ModelAndView voteScreenDisplay() throws Exception {
		logger.info("VOTE_SCREEN");
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("B_01");
		modelAndView.addObject("huboList", service.selectAllHubo());
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/vote.do", method = RequestMethod.POST)
	public ModelAndView vote(int id, int age) throws Exception {
		logger.info("VOTE");
		ModelAndView modelAndView = new ModelAndView();
		TupyoDTO tupyo = new TupyoDTO();
		tupyo.setId(id);
		tupyo.setAge(age);
		
		modelAndView.setViewName("B_02");
		modelAndView.addObject("result", service.vote(tupyo));
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public ModelAndView resultScreenDisplay() throws Exception {
		logger.info("VOTE_RESULT_SCREEN");
		ModelAndView modelAndView = new ModelAndView();
				
		modelAndView.setViewName("C_01");
		modelAndView.addObject("rateList", service.rateList());
		modelAndView.addObject("huboList", service.selectAllHubo());
		modelAndView.addObject("voteCountList", service.voteCountList());
		return modelAndView;
	}
	
	@RequestMapping(value="/oneView", method = RequestMethod.GET)
	public ModelAndView oneViewDisplay(HttpServletRequest request) throws Exception {
		logger.info("VOTE_ONEVIEW_RESULT_SCREEN");
		ModelAndView modelAndView = new ModelAndView();

			// C_01.jsp에서 key: id로 넘겨받은 후보 번호를 id 변수에 저장
		int id = Integer.parseInt(request.getParameter("id"));
		logger.info("id: " + id);
		
		// DB 내 id == 기호번호 인 후보자 정보 조회
		HuboDTO hubo = service.selectOneHubo(id);
				
		// 특정 후보에 대한 연령대별 득표수 정보 조회
		List<List<Integer>> ageTendency = service.ageTendency(id);
		
		// 해당 기호의 후보에게 투표한 연령대 정보 저장
		List<Integer> ageList = ageTendency.get(0);
		
		// 연령대별 득표수 정보 저장
		List<Integer> voteCountList = ageTendency.get(1);
		
		// 특정 후보에 대한 연령대별 득표율 = 연령대별 득표 수 / 해당 후보의 전체 득표수
		List<Double> tendencyRateList = service.tendencyRateList(id);
		
		modelAndView.setViewName("C_02");
		modelAndView.addObject("id", id);
		modelAndView.addObject("hubo", hubo);
		modelAndView.addObject("ageList", ageList);
		modelAndView.addObject("voteCountList", voteCountList);
		modelAndView.addObject("tendencyRateList", tendencyRateList);
		
		return modelAndView;
	}
}