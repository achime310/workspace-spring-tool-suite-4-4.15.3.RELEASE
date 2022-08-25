package com.mybatis3.deep;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis3.dao.mapper.StudentMapper;
import com.mybatis3.domain.Student;

public class MapperInterfaceStudentDao {
	private SqlSessionFactory sqlSessionFactory;
	
	//private StudentMapper studentMapper;
	
	//public static final String NAMESPACE="com.mybatis3.dao.mapper.StudentMapper.";
	public MapperInterfaceStudentDao() {
		try {
			InputStream mybatisConfigInputStream = 
					Resources.getResourceAsStream("mybatis-config-mapper-interface.xml");
			SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
			this.sqlSessionFactory =
			//SqlSessionFactory sqlSessionFactory=
					sqlSessionFactoryBuilder.build(mybatisConfigInputStream);
			//SqlSession sqlSession=sqlSessionFactory.openSession(true);
			//this.studentMapper=sqlSession.getMapper(StudentMapper.class);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*
	 resultType Dto 
	*/
	public Student findStudentById(Integer studId) {
		SqlSession sqlSession =sqlSessionFactory.openSession(true);
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		Student student = studentMapper.findStudentById(studId);
		sqlSession.close();	//여기서 또 왜 닫아준거람?????
		return student;
	}
	public List<Student> findAllStudents() {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		List<Student> studentList = studentMapper.findAllStudents();
		sqlSession.close();
		return studentList;
	}
	public Student findStudentByIdWithAddress(Integer studId) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		Student student = studentMapper.findStudentByIdWithAddress(studId);
		sqlSession.close();
		return student;
	}
	
	
	
}
