package com.mybatis3.basic;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis3.dao.mapper.StudentMapper;
import com.mybatis3.domain.Student;

public class MyBatisMapperInterfaceFlowMain {

	public static void main(String[] args) throws Exception{
		/*
		 * 0.mybatis-config-mapper-interface.xml --> InputStream
		 */
		InputStream myBatisConfigInputStream = Resources.getResourceAsStream("mybatis-config-mapper-interface.xml");
		/*
		 * 1. SqlSessionFactoryBuilder
		 */
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		/*
		 * 2. SqlSessionFactory
		 */
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(myBatisConfigInputStream);
		/*
		 * 3. SqlSession open
		 */
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		/*
		 * autocommit true
		 */
		/*
		 * 4. StudentMapper[MapperInterface]객체생성
		 */
		StudentMapper studentMapper= sqlSession.getMapper(StudentMapper.class);
		/*
		org.apache.ibatis.binding.MapperProxy(자동생성) -> interface StudentMapper를 implements
		 */
		System.out.println("MapperProxy: "+studentMapper);
		/*
		 * 5. StudentMapper[MapperInterface]객체사용[CRUD]
		 */
		List<Student> studentList=
		studentMapper.findAllStudents();
		System.out.println("#### findAllStudents(): "+studentList);
		
		Student student=
		studentMapper.findStudentById(3);
		System.out.println("#### findStudentById(): "+student);
		
		student=
		studentMapper.findStudentByIdWithAddress(2);
		System.out.println("#### findStudentByIdWithAddress(): "+student);
		
		/*
		 * 6. SqlSession close
		 */
	}
}













