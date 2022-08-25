package com.mybatis3.dao.mapper;

import java.util.List;

import com.mybatis3.domain.Student;

public interface StudentMapper {
	/*
	 * 인터페이스의 풀네임은 StudentMapper.xml의 namespace와일치
	 * 메쏘드이름은 	StudentMapper.xml 파일의 id와일치
	 * 메쏘드인자타입은 StudentMapper.xml 파일의 parameterType 와일치
	 * 메쏘드리턴타입은 StudentMapper.xml 파일의 resultType 와일치(ResultSet이 1개이상일경우는 List)
	 */
	public Student findStudentById(Integer studId);
	/*
	<select id="findStudentById" 
	        parameterType="java.lang.Integer"  
			resultType="com.mybatis3.domain.Student"  >
		select stud_id as studid,name,email,dob  from students where stud_id = #{studId} 
	</select>
	 */
	public List<Student> findAllStudents();
	/*
	<select id="findAllStudents" 
			resultType="com.mybatis3.domain.Student" >
		select stud_id as studid,name,email,dob from students
	</select>
	*/
	
	public Student findStudentByIdWithAddress(Integer studId);
	/*
	<select id="findStudentByIdWithAddress"
	 		 parameterType="int" 
	 		 resultMap="studentWithAddressResultMap">
	 
	 select stud_id, name, email,phone, a.addr_id, street, city, state, zip, country
	  FROM students s 
     left outer join addresses a 
     on s.addr_id=a.addr_id
     where s.stud_id=${studId}
	 
	 </select>
	*/
}
