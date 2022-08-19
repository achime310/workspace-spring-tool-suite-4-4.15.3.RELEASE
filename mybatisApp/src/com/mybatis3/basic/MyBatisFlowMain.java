package com.mybatis3.basic;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis3.domain.Student;

public class MyBatisFlowMain {

	public static void main(String[] args) throws Exception {
		/*
		 * 0. mybatis-config.xml --> InputStream
		 */
		InputStream myBatisConfigInputStream = Resources.getResourceAsStream("mybatis-config.xml");
		/*
		 * 1. SqlSessionFactoryBuilder
		 */
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

		/*
		 * 2. SqlSessionFactory
		 */
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(myBatisConfigInputStream);
		/*
		 * 3. SqlSession open (Connection) -> 최종결과로 얻어야할 것!
		 * 		-> sqlSession에서 [mybatis-config.xml]을 로딩(connection을 생성하기 위한 정보,mapper,sql)해서 가지고 있음
		 * 			-> [mybatis-config.xml]에는 [StudentBasicMapper.xml]을 mapper로 가지고 있다고?
		 */
		//SqlSession은 interface..
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		//true, false에 따라 auto-commit. true: auto-commit, false: commit이 안됨.(예, insert시 DB에 반영안됨)
		/*
		 * autocommit true
		 */
		System.out.println("#### SqlSession객체: "+sqlSession);
		/*
		 * 4. SqlSession사용(CRUD) -> SQL파일 이전에는 class파일로 만들었었지만, 이제는 xml파일로 빠진다~
		 * 		-> sqlSessionFactory...?
		 * 		-> 실행할때 리턴타입을 정해주면, 그에 맞춰서 반환해준다~
		 */
		List<Student> studentList=
		sqlSession.selectList("com.mybatis3.dao.mapper.StudentBasicMapper.findAllStudents");
		System.out.println("### studentList: "+studentList);
		
		Student student=
		sqlSession.selectOne("com.mybatis3.dao.mapper.StudentBasicMapper.findStudentById",1);
		//두번째 인자 1은 boxing되서 'new Integer(1)'로 들어감
		System.out.println("### student: "+student);	//toString()이 호출된 결과를 볼 수 있음.
		
		/*
		 * 5. SqlSession close
		 */
		sqlSession.close();
	}
}
