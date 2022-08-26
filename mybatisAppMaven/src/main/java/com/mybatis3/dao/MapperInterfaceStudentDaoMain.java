package com.mybatis3.dao;

import java.util.Date;

import com.mybatis3.domain.Student;

public class MapperInterfaceStudentDaoMain {

	public static void main(String[] args) {
		MapperInterfaceStudentDao mapperInterfaceStudentDao=
				new MapperInterfaceStudentDao();
		System.out.println("<<<<<<<<<<<<<< StudentMapper Interface를 사용한Dao메쏘드호출 >>>>>>>>>");
		
		/**************************************************
	 	 SELECT 
		 **************************************************/
		/*
		  select sql의결과타입이 DTO[DTO List] 객체인경우
		  resultType :  DTO
		 */
		System.out.println("---------findStudentById-----------------------------");
		System.out.println(mapperInterfaceStudentDao.findStudentById(7));
		System.out.println("---------findAllStudents-----------------------------");
		System.out.println(mapperInterfaceStudentDao.findAllStudents());
		/*
		  select sql의결과타입이 DTO[DTO List] 객체인경우
		  resultMap :  DTO
		 */
		System.out.println("---------findStudentByIdResultMap--------------------");
		System.out.println(mapperInterfaceStudentDao.findStudentByIdResultMap(5));
		System.out.println("---------findAllStudentsResultMap--------------------");
		System.out.println(mapperInterfaceStudentDao.findAllStudentsResultMap());
		/**************************************************
	 	 SELECT[student + address JOIN]( 1 : 1 )
		 **************************************************/
		/*
		 * select sql의결과타입이 DTO,VO,Domain객체인경우
		 * resultMap : studentWithAddressResultMap
		 */
		System.out.println("---------findStudentByIdWithAddress------------------");
		System.out.println(mapperInterfaceStudentDao.findStudentByIdWithAddress(1));
		/*********************************************************
		 * SELECT[students + courses[course_enrollment] JOIN( 1 : N )
		 ********************************************************/
		/*
		 * select sql의결과타입이 DTO,VO,Domain객체인경우
		 * resultMap : studentWithCoursesResultMap
		 */
		System.out.println("---------findStudentByIdWithCourses------------------");
		System.out.println(mapperInterfaceStudentDao.findStudentByIdWithCourses(1));
		
		/**************************************************
		INSERT
		***************************************************/
		/*
		parameterType: DTO,VO,Domain
		*/
		System.out.println("---------insertStudent(Dto)--------------------------");
		System.out.println(mapperInterfaceStudentDao.insertStudent(new Student(null, "김가네", "kim@naver.com",new Date(), null)));
		System.out.println("---------insertStudentBySequence1--------------------");
		Student insertStudent=
			new Student(null, "시퀀스","sequence@naver.com" , new Date(), null);
		System.out.println("insert row count:"+mapperInterfaceStudentDao.insertStudentBySequence1(insertStudent));
		System.out.println("insert sequence:"+insertStudent.getStudId());
		
		
		/**************************************************
		 UPDATE
		 ***************************************************/
		/*
		 parameterType: DTO,VO,Domain
		 */
		System.out.println("---------updateStudentById---------------------------");
		Student student=mapperInterfaceStudentDao.findStudentById(1);
		student.setDob(new Date());
		student.setEmail("change222@gmail.com");
		student.setName("김윤수");
		System.out.println("update row count:"+mapperInterfaceStudentDao.updateStudentById(student));
		/**************************************************
		 DELETE
		 ***************************************************/
		/*
		parameterType: java.lang.Integer,java.lang.String
		*/
		System.out.println("---------deleteStudentById---------------------------");
		System.out.println("delete row count:"+
		mapperInterfaceStudentDao.deleteStudentById(51));
	}

}
