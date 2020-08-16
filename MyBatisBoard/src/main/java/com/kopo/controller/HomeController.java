package com.kopo.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kopo.dto.BoardVO;
import com.kopo.service.BoardService;

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	private BoardService service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String list(Model model) throws Exception{

		logger.info("LIST");
		List<BoardVO> postList = service.selectAllPost();
		model.addAttribute("postList", postList);
		
		return "gongji_list";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(Model model) throws Exception {
		logger.info("INSERT");
		model.addAttribute("localDate", LocalDate.now());
		
		return "gongji_insert";
	}
	
	@RequestMapping(value = "/insert-do", method = RequestMethod.POST)
	public String insertDo(@RequestParam HashMap<String, String> param, Model model) throws Exception {
		logger.info("INSERT.DO");
		// String key = "INSERT";
		
		for ( String key : param.keySet() ) {
			System.out.println(String.format("key: %s, value: %s", key, param.get(key)));
		}
		return "gongji_write";
	}
}