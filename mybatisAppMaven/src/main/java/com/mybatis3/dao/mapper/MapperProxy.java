package com.mybatis3.dao.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis3.domain.Student;

public class MapperProxy implements StudentMapper {
	
	private SqlSession sqlSession;
	@Override
	public Student findStudentById(Integer studId) {
		String namespace = StudentMapper.class.getName();
		Student student=sqlSession.selectOne(namespace+".findStudentById",studId);
		return student;
	}

	@Override
	public List<Student> findAllStudents() {
		String namespace = StudentMapper.class.getName();
		return sqlSession.selectList(namespace+".findAllStudents");
		
	}

	@Override
	public Student findStudentByIdWithAddress(Integer studId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student findStudentByIdResultMap(Integer studId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findAllStudentsResultMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student findStudentByIdWithCourses(Integer studId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertStudent(Student student) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertStudentBySequence1(Student student) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateStudentById(Student updateStudent) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteStudentById(Integer studId) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
