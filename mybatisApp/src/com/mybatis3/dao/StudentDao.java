package com.mybatis3.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis3.domain.Student;

public class StudentDao {

	private SqlSessionFactory sqlSessionFactory;	//애플리케이션 실행하는 동안 존재

	public static final String NAMESPACE="com.mybatis3.dao.mapper.StudentMapper.";
	
	public StudentDao() {
		try {
			sqlSessionFactory = 
					new SqlSessionFactoryBuilder()/* 한번쓰고 버림 */
					.build(Resources.getResourceAsStream("mybatis-config.xml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**************************************************
	 * SELECT [student]
	 **************************************************/
	/*
	 * select sql의결과타입이 DTO[DTO List] 객체인경우 resultType : DTO
	 */
	public Student findStudentById(Integer studId) {
		
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		Student student=
		sqlSession.selectOne(NAMESPACE+"findStudentById",studId);
		
		sqlSession.close();
		// connection을 열어둬야함.... 나중에는!
		
		return student;
	}

	public List<Student> findAllStudents() {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		List<Student> studentList = sqlSession.selectList("com.mybatis3.dao.mapper.StudentMapper.findAllStudents");
		
		sqlSession.close();
		return studentList;
	}

	/*
	 * select sql의결과타입이 DTO[DTO List] 객체인경우 resultMap : DTO
	 */
	public Student findStudentByIdResultMap(Integer studId) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		Student student=
		sqlSession.selectOne(NAMESPACE+"findStudentByIdResultMap",studId);
		sqlSession.close();
		return student;
	}

	public List<Student> findAllStudentsResultMap() {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		List<Student> studentList=
		sqlSession.selectList(NAMESPACE+"findAllStudentsResultMap");
		sqlSession.close();
		return studentList;
	}

	/**************************************************
	 * SELECT[student + address JOIN]( 1 : 1 )
	 **************************************************/
	/*
	 * select sql의결과타입이 DTO,VO,Domain객체인경우 resultMap : studentWithAddressResultMap
	 */
	public Student findStudentByIdWithAddress(Integer studId) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		Student student=
		sqlSession.selectOne(NAMESPACE+"findStudentByIdWithAddress",studId);
		sqlSession.close();
		return student;
	}

	/*********************************************************
	 * SELECT[students + courses[course_enrollment] JOIN( 1 : N )
	 ********************************************************/
	/*
	 * select sql의결과타입이 DTO,VO,Domain객체인경우 resultMap : studentWithCoursesResultMap
	 */
	public Student findStudentByIdWithCourses(Integer studId) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		
		sqlSession.close();
		return null;
	}

	/**************************************************
	 * INSERT
	 ***************************************************/
	/*
	 * parameterType: DTO,VO,Domain
	 */
	public int insertStudent(Student student) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int rowCount=
				sqlSession.insert(NAMESPACE+"insertStudent",student);
		sqlSession.close();
		return rowCount;
	}

	public int insertStudentBySequence1(Student student) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		sqlSession.close();
		return 0;
	}

	public int insertStudentBySequence2(Student student) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		sqlSession.close();
		return 0;
	}

	/**************************************************
	 * UPDATE
	 ***************************************************/
	/*
	 * parameterType: DTO,VO,Domain
	 */
	public int updateStudentById(Student updateStudent) {
		SqlSession sqlSession = sqlSessionFactory.openSession(false);
		int rowCount=
		sqlSession.update(NAMESPACE+"updateStudentById",updateStudent);
		
		sqlSession.commit();//false이면 무조건 commit을 해줘야겠죠? 그러나 commit은 service에서 해야하잖아?
		//myBatis에서 설정을 하면 service단위로 commit을 하도록 해준다
		sqlSession.close();
		return rowCount;
	}

	/**************************************************
	 * DELETE
	 ***************************************************/
	/*
	 * parameterType: java.lang.Integer,java.lang.String
	 */
	public int deleteStudentById(Integer studId) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int rowCount=sqlSession.delete(NAMESPACE+"deleteStudentById",studId);
		sqlSession.close();
		return rowCount;
	}

}
