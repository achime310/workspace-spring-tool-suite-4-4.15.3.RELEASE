package com.itwill.hello;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

@Repository
public class HelloDao {
	@Autowired
	private DataSource dataSource;
	
	public List<String> hello() throws Exception {
		List<String> helloList = new ArrayList<String>();
		helloList.add("CHOI");
		helloList.add("KIM");
		helloList.add("LEE");
		//datasource가 잘 연결되었는지 확인하기 위함.
		//helloList.add(dataSource.getConnection().toString());
		//String getConnection=
		//(String)DataSourceUtils.getConnection(dataSource);
		//helloList.add(DataSourceUtils.getConnection(dataSource));
		
		return helloList;
	}
}
