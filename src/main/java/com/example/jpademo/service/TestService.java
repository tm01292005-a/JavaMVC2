package com.example.jpademo.service;

import java.util.List;

import com.example.jpademo.entity.oracle1.Table1;

public interface TestService {

	/**
	 * TABLE1の全てのデータを取得する
	 *
	 * @return TABLE1データ
	 */
	public List<Table1> getTable1();
	public Long addTable1();
	public Long updateTable1();

}
