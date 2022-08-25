package com.itwill.dao;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.itwill.guest.Guest;

public class SpringJdbcTemplateMain {

	public static void main(String[] args) {
		System.out.println("----Spring Container초기화시작[ApplicationContext객체생성시작]");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"com/itwill/dao/spring_jdbctemplate.xml");
		System.out.println("----Spring Container초기화끝[ApplicationContext객체생성끝]");

		// JdbcTemplate.class로 getBean하는 작업은 같은이름으로 상속받는 클래스가 2개이상이면 찾을 수 없다
		JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean(JdbcTemplate.class);
		System.out.println("1.JdbcTemplate객체얻기: " + jdbcTemplate);

		/*
		 * selectOne과 같은 것 SELECT ==> queryForObject
		 * 반환타입[(1개)String,Wrapper/(여러개)DTO,Map]
		 */
		
		/*
		 * queryForObject [반환타입 DTO]
		 */
		// 모든 ORM은 preparedStatement를 사용한다.
		String selectDtoSql = "select guest_no,guest_name,guest_date,guest_email,guest_homepage,guest_title,guest_content from guest where guest_no = ?";
		// String selectDtoSql = "select * from guest where guest_no = ?";

		/*
		 << BeanPropertyRowMapper 클래스>>
		 ResultSet으로부터 데이타를 컬럼이름으로 get해서 
		 Guest객체의 테이블컬럼이름과동일한이름의 property(멤버변수)에 대입(setter메쏘드호출)하는 객체
		 */
		BeanPropertyRowMapper<Guest> guestBeanPropertyRowMapper=
				new BeanPropertyRowMapper<Guest>(Guest.class);
		
		// parameterType, returnType을 알려줘야함 - parameterType - returnType
		Guest guest = jdbcTemplate.queryForObject(selectDtoSql, new Object[] { 65 }, guestBeanPropertyRowMapper);

		System.out.println(guest);

		/*
		 * query [반환타입 List<Guest>]
		 */
		String selectDtoListSql = "select * from guest";
		List<Guest> guestList=
				jdbcTemplate.query(selectDtoListSql, guestBeanPropertyRowMapper);
		System.out.println("##########query[List<Gueset>]: "+guestList);
		
		/*
		 * 	queryForList [반환타입 List<Map<String, Object>>]
		 * 		-> Key값 = String = column 이름, Value = Object = 해당 column데이터 
		 */
		List<Map<String, Object>> mapList = jdbcTemplate.queryForList(selectDtoListSql);
		System.out.println("##########queryForList[ List<Map<String, Object>> ]: "+mapList);
		
		/*
		 * queryForObject [반환타입 String]
		 */
		String selectStringSql = "select guest_name from guest where guest_no=?";
		String guest_name=
		jdbcTemplate.queryForObject(selectStringSql, new Object[] {65}, String.class);
		//반환값이 없는 경우 null을 반환하지 않고, error (Exception in thread "main" org.springframework.dao.EmptyResultDataAccessException: Incorrect result size: expected 1, actual 0)
		
		System.out.println("gueryForObject[String]: "+guest_name);
		
		/*
		 * queryForList [반환타입 List<String>]
		 */
		String selectStringListSql = "select guest_name from guest";
		List<String> guest_nameList=
				jdbcTemplate.queryForList(selectStringListSql, String.class);
		System.out.println("queryForList[List<String>]: "+guest_nameList);
	
		/*
		 * queryForObject [반환타입 Integer] (참고)int같이 기본형은 쓸 수 없음
		 */
		String selectIntegerSql = "select guest_no from guest where guest_name=?";
		int guest_no=
				jdbcTemplate.queryForObject(selectIntegerSql, new Object[] {"ㅋㅋ"}, Integer.class);
		System.out.println("gueryForObject[Integer]: "+guest_no);
		
		/*
		 * queryForList [반환타입 List<Integer>]
		 */
		String selectIntegerListSql = "select guest_no from guest";
		List<Integer> guest_noList=
				jdbcTemplate.queryForList(selectIntegerListSql, Integer.class);
		System.out.println("gueryForList[List<Integer>]: "+guest_noList);
		
		/*************************************
		 * update, delete, insert ==> update[ rowCount(int) ]
		 */
		String insertSql=
				"insert into guest values(guest_no_seq.nextval,?,sysdate,?,?,?,?)";
		//객체형태로 오면, 풀어서 넣어줘야한다.
		int rowCount = jdbcTemplate.update(insertSql, "인서트","email@dot.com","http://hompage.com","title","content");
		System.out.println("insert row count: "+rowCount);
		
		String updateSql=
				"update guest set  guest_name=?, guest_email=?, guest_homepage=?, guest_title=?, guest_content=? where guest_no=?";
		rowCount = jdbcTemplate.update(updateSql, "업데잇","(수정)email@dot.com","(수정)http://hompage.com","(수정)title","(수정)content",83);
		System.out.println("update row count: "+rowCount);
		
		String deleteSql=
				"delete from guest where guest_no=?";
		rowCount = jdbcTemplate.update(deleteSql, 81);
		System.out.println("delete row count: "+rowCount);
		
	}

}
