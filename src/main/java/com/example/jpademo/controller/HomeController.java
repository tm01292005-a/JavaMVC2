package com.example.jpademo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.jpademo.repository.oracle2.CallFuncRepository;

@Controller
public class HomeController {
	@Autowired
	private CallFuncRepository callFuncRepository;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Model model) {
		Integer arg = 1;
		Integer res = 1;
		Integer a = callFuncRepository.plus1inout();

		model.addAttribute("id", "テスト");
		return "home";
	}

}
