package com.kopo.controller;

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
		int nextID = 0;
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
		String result = service.insertHubo(hubo);
		
		modelAndView.setViewName("A_03");
		modelAndView.addObject("result", result);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView delete(int id) throws Exception {
		logger.info("DELETE");
		ModelAndView modelAndView = new ModelAndView();
		String result = service.deleteHubo(id);
		
		modelAndView.setViewName("A_02");
		modelAndView.addObject("result", result);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/vote", method = RequestMethod.GET)
	public ModelAndView voteScreenDisplay() throws Exception {
		logger.info("VOTE_SCREEN");
		ModelAndView modelAndView = new ModelAndView();
		List<HuboDTO> huboList = service.selectAllHubo();
		
		modelAndView.setViewName("B_01");
		modelAndView.addObject("huboList", huboList);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/vote.do", method = RequestMethod.POST)
	public ModelAndView vote(int id, int age) throws Exception {
		logger.info("VOTE");
		ModelAndView modelAndView = new ModelAndView();
		TupyoDTO tupyo = new TupyoDTO();
		tupyo.setId(id);
		tupyo.setAge(age);
		String result = service.vote(tupyo);
		
		modelAndView.setViewName("B_02");
		modelAndView.addObject("result", result);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public ModelAndView resultScreenDisplay() throws Exception {
		logger.info("VOTE_RESULT_SCREEN");
		ModelAndView modelAndView = new ModelAndView();
		List<HuboDTO> huboList = service.selectAllHubo();
		List<Double> rateList = service.rateList();
		List<Integer> voteCountList = service.voteCountList();
		for(int i=0; i < huboList.size(); i++) {
			logger.info(huboList.get(i).getName() + " : " + rateList.get(i));
		}
		modelAndView.setViewName("C_01");
		modelAndView.addObject("rateList", rateList);
		modelAndView.addObject("huboList", huboList);
		modelAndView.addObject("voteCountList", voteCountList);
		return modelAndView;
	}
}