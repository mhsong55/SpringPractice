package com.kopo.hibernateExample.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kopo.hibernateExample.model.Items;
import com.kopo.hibernateExample.server.ItemsService;

@Controller
public class ItemsController {
	
	@Autowired
	ItemsService itemsService;
	
	@RequestMapping(value = "/items", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getItems(Model model) {
		
		List<Items> listOfItems = itemsService.getAllItems();
		model.addAttribute("items", new Items());
		model.addAttribute("listOfItems", listOfItems);
		return "itemsDetails";
	}
}
