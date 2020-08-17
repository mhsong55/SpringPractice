package com.kopo.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
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

		logger.info("GET/LIST");
		
		// Get the data of all posts in the DB and put it in the list.
		List<BoardVO> postList = service.selectAllPost();
		
		// Include in the response to be sent to the view.
		model.addAttribute("postList", postList);
		
		// Target view: "gongji_list.jsp"
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
		model.addAttribute("postId", service.lastInsertedPost().getId());
		return "gongji_write";
	}
	
	@RequestMapping(value = "/get/record", method = RequestMethod.GET)
	public String oneViewPost(@RequestParam int id, Model model) throws Exception {
		logger.info("ONE VIEW - POST ID: " + id);
		BoardVO post = service.selectOne(id);
		model.addAttribute("post", post);
		
		return "gongji_view";
	}
	
	@RequestMapping(value = "/put/record", method = RequestMethod.GET)
	public String updatePageMapping(@RequestParam int id, Model  model) throws Exception {
		logger.info("id: " + id);
		BoardVO post = service.selectOne(id);
		model.addAttribute("post", post);
		return "gongji_update";
	}
	
	@RequestMapping(value = "/put/record/{id}/register", method = RequestMethod.POST)
	public String update(@RequestParam HashMap<String, String> param
					   , @PathVariable int id, Model model) throws Exception {
		
		logger.info("UPDATE");
		String resultState = "게시글 수정 실패";
		
		if (service.update(param) == 1) {
			resultState = "게시글이 수정되었습니다.";
		}
		
		model.addAttribute("resultState", resultState);
		model.addAttribute("postId", param.get("id"));
		
		return "gongji_write";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@RequestParam int id, Model model) throws Exception {
		logger.info("DELETE - POST ID: " + id);
		String result  = "게시글 삭제 실패";
		
		if (service.delete(id) == 1) {
			result = "게시글이 삭제되었습니다.";
		}
		
		model.addAttribute("result", result);
		
		return "gongji_delete";
	}
}