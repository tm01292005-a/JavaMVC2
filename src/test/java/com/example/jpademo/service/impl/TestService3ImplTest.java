package com.example.jpademo.service.impl;

import java.io.File;
import java.sql.Connection;

import javax.sql.DataSource;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.excel.XlsDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.jpademo.App;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { App.class })
@TestPropertySource(locations = "/application-test.yml")
@ActiveProfiles("test")
public class TestService3ImplTest{

	@Autowired
	@Qualifier("postgresDataSource")
//	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;

//	@Autowired
//	ItemRepository itemRepository;


	private void tableSetUp(String excelName) throws Exception {
		// DBコネクション取得
		Connection conn = dataSource.getConnection();
		String schema = dataSource.getConnection().getSchema();
		//		Connection conn = jdbcTemplate.getDataSource().getConnection();
//		String schema = jdbcTemplate.getDataSource().getConnection().getSchema();
		IDatabaseConnection dbconn = new DatabaseConnection(conn, schema);

		// Excel用データセット作成
		File f = new File(ClassLoader.getSystemResource(excelName).getFile());
		IDataSet dataset = new XlsDataSet(f);

		// データの全削除
		DatabaseOperation.DELETE_ALL.execute(dbconn, dataset);

		// データの挿入
		DatabaseOperation.INSERT.execute(dbconn, dataset);
	}

	@Before
	public void setup() {
	}

	@Test
	public void testSelectAll() throws Exception {
		// 準備
		tableSetUp("com/example/jpademo/service/impl/findByCode/test_data.xlsx");

		// 実行
//		List<Item> items = itemRepository.findAll();
//		for (Item item : items) {
//			System.out.println(item.toString());
//		}
	}


}
