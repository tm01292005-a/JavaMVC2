package com.example.jpademo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TopController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		return "index";
	}

	@RequestMapping(value="/", method=RequestMethod.POST)
	public String start() {
		return "index";
	}
}
