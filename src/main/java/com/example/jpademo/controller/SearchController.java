package com.example.jpademo.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SearchController {

	final static Map<String, String> SELECT_ITEMS = Collections.unmodifiableMap(new LinkedHashMap<String, String>() {
		{
			put("select_A", "A");
			put("select_B", "B");
			put("select_C", "C");
			put("select_D", "D");
			put("select_E", "E");
		}
	});

	final static Map<String, String> RADIO_ITEMS = Collections.unmodifiableMap(new LinkedHashMap<String, String>() {
		{
			put("VISA", "select_A");
			put("MASTER", "select_B");
			put("DC", "select_C");
			put("AMAX", "select_D");
			put("Ady", "select_E");
		}
	});

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
/*
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String init(SearchForm form, Model model) {
		model.addAttribute("selectItems", SELECT_ITEMS);
		model.addAttribute("radioItems", RADIO_ITEMS);
		return "search";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String search(@ModelAttribute SearchForm form, BindingResult result, Model model) {
		String selectValue = form.getFselect();
		System.out.println(selectValue);
		model.addAttribute("selectItems", SELECT_ITEMS);
		model.addAttribute("radioItems", RADIO_ITEMS);

		Result list = new Result();
		list.setId(1);
		list.setName("aaa");
		list.setWritedate(new Date());
		Result list2 = new Result();
		list2.setId(2);
		list2.setName("bbb");
		list2.setWritedate(new Date());
		Result list3 = new Result();
		list3.setId(3);
		list3.setName("ccc");
		list3.setWritedate(new Date());
		List<Result> lists = Arrays.asList(list, list2, list3);
		model.addAttribute("resultList", lists);

		return "search";
	}
*/
	@RequestMapping(value = "/searchResult", method = RequestMethod.GET)
	public String searchResult(Model model) {
		model.addAttribute("selectItems", SELECT_ITEMS);

		Result list = new Result();
		list.setId(1);
		list.setName("aaa");
		list.setWritedate(new Date());
		Result list2 = new Result();
		list2.setId(2);
		list2.setName("bbb");
		list2.setWritedate(new Date());
		Result list3 = new Result();
		list3.setId(3);
		list3.setName("ccc");
		list3.setWritedate(new Date());
		List<Result> lists = Arrays.asList(list, list2, list3);
		model.addAttribute("resultList", lists);

		return "search_result";
	}

	public class Result {
		private Integer id;
		private String name;
		private Date writedate;

		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}

		public Date getWritedate() {
			return writedate;
		}
		public void setWritedate(Date writedate) {
			this.writedate = writedate;
		}
	}

}
