package com.kopo.timesTable;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class timesTableController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String timesTable(Model model) {
		return "main";
	}
	
	@RequestMapping("timesTable.do")
	public ModelAndView printCalculatedResult(String number, Model model) {
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("result");
		modelAndView.addObject("number", Integer.parseInt(number));
		
		return modelAndView;
	}
}
