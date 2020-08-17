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
	
	@RequestMapping(value = {"/", "/get/list"}, method = RequestMethod.GET)
	public String list(Model model) throws Exception{

		logger.info("GET/LIST");
		List<BoardVO> postList = service.selectAllPost();
		model.addAttribute("postList", postList);
		
		return "gongji_list";
	}
	
	@RequestMapping(value = "/get/new", method = RequestMethod.GET)
	public String insert(Model model) throws Exception {
		logger.info("GET/new");
		model.addAttribute("localDate", LocalDate.now());
		
		return "gongji_insert";
	}
	
	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public String insertDo(@RequestParam HashMap<String, String> param, Model model) throws Exception {
		logger.info("POST");
		String resultState = service.insert(param);
		
		model.addAttribute("resultState", resultState);
		model.addAttribute("lastInsertedPostId", service.lastInsertedPost().getId());
		return "gongji_write";
	}
	
	@RequestMapping(value = "/get/record", method = RequestMethod.GET)
	public String oneViewPost(@RequestParam int id, Model model) throws Exception {
		logger.info("ONE VIEW - POST ID: " + id);
		BoardVO post = service.selectOne(id);
		model.addAttribute("post", post);
		
		return "gongji_view";
	}
	
	@RequestMapping(value = "/put/record", method = RequestMethod.PUT)
	public String update(@RequestParam int id, Model  model) throws Exception {
		return null;
	}
}