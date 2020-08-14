package com.kopo.controller;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kopo.dto.BoardVO;
import com.kopo.service.BoardService;

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	private BoardService service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String list(Model model) throws Exception{

		logger.info("List");
		List<BoardVO> postList = service.selectAllPost();
		model.addAttribute("postList", postList);
		
		return "gongji_list";
	}
	
}