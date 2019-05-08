package com.example.jpademo.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpademo.entity.oracle1.Table1;
import com.example.jpademo.repository.oracle1.Table1Repository;
import com.example.jpademo.service.TestService;

@Service
public class TestServiceImpl implements TestService {
	@Autowired
	private Table1Repository table1Repository;

	@Override
	public List<Table1> getTable1() {
		List<Table1> list = new ArrayList<>();
		list = table1Repository.findByColumn1("1");
		return list;
	}

	@Override
	public Long addTable1() {
		Table1 table1 = new Table1();
		table1.setId(8989L);
		table1.setColumn1("8989");
		table1.setColumn2(new BigDecimal(999));
		table1.setColumn3(new Date());

		Table1 rtn = table1Repository.save(table1);
		return rtn.getId();
	}

	@Override
	public Long updateTable1() {
		Table1 table1 = new Table1();
		table1.setColumn1("TEST");
		table1.setId(9999L);
		Table1 rtn = table1Repository.save(table1);
		return rtn.getId();
	}
}
