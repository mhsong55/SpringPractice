package com.kopo.timesTable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class calculatorController {
	@RequestMapping(value = "/calculatorEx", method = RequestMethod.GET)
	public String calculatorEx() {
		return "calculatorEx";
	}
	
	@RequestMapping("calculatorEx.do")
	public ModelAndView printCalculatedResult(String number1, String operation, String number2) {
		ModelAndView modelAndView = new ModelAndView();
		int num1 = Integer.parseInt(number1);
		int num2 = Integer.parseInt(number2);

		modelAndView.setViewName("calculatorResult");
		switch (operation) {
			case "plus" :
				modelAndView.addObject("result", (num1 + num2));
				break;
			case "minus" :
				modelAndView.addObject("result", (num1 - num2));
				break;
			case "multiple" :
				modelAndView.addObject("result", (num1 * num2));
				break;
			case "devide" :
				modelAndView.addObject("result", ((double)num1 / num2));
				break;
		}
		
		return modelAndView;
	}
}
