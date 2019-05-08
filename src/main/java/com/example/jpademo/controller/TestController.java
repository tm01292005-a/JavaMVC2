package com.example.jpademo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.jpademo.entity.oracle1.Table1;
import com.example.jpademo.entity.postgres.Item;
import com.example.jpademo.service.TestService;
import com.example.jpademo.service.TestService3;

@Controller
public class TestController {
	@Autowired
	private TestService testService;

	@Autowired
	private TestService3 testService3;


	@RequestMapping("/select")
	@ResponseBody
	public String select() {
		String returnStr = "";
		List<Table1> list = testService.getTable1();
		for (Table1 table1 : list) {
			returnStr += "id  :" + table1.getId() + " ";
			returnStr += "columnl:" + table1.getColumn1() + " ";
			returnStr += "column2:" + table1.getColumn2() + " ";
			returnStr += "column3:" + table1.getColumn3() + " ";
			returnStr += "<br>";
		}
		return returnStr;
	}

	@RequestMapping("/select3")
	@ResponseBody
	public String select3() {
		String returnStr = "";
		List<Item> list = testService3.getItem();
		for (Item item : list) {
			returnStr += "id  :" + item.getId() + " ";
			returnStr += "intval:" + item.getIntval() + " ";
			returnStr += "<br>";
		}
		return returnStr;
	}

	@RequestMapping("/insert")
	@ResponseBody
	public Long insert() {
		return testService.addTable1();
	}

	@RequestMapping("/update")
	@ResponseBody
	public Long update() {
		return testService.updateTable1();
	}

	@RequestMapping("/delete")
	@ResponseBody
	public int delete() {
		return 1;
	}

}
