package com.springboot.practice.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RootController {
	
	@RequestMapping(value = "/")
	public String index(Model model) {
		model.addAttribute("message","hello spring boot from controller");
		model.addAttribute("name","Mariom");
		model.addAttribute("result",72);
		List<String> items = new ArrayList<>();
		items.add("Apple");
		items.add("Banana");
		items.add("Orange");
		items.add("Grape");
		items.add("Liche");
		model.addAttribute("list",items);
		return "index";
	}

}
