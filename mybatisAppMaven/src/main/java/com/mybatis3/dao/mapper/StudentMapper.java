package com.mybatis3.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.mybatis3.domain.Student;

public interface StudentMapper {
	/*
	 * 인터페이스의 풀네임은 StudentMapper.xml의 namespace와일치
	 * 메쏘드이름은 	StudentMapper.xml 파일의 id와일치
	 * 메쏘드인자타입은 StudentMapper.xml 파일의 parameterType 와일치
	 * 메쏘드리턴타입은 StudentMapper.xml 파일의 resultType 와일치(ResultSet이 1개이상일경우는 List)
	 */
	//아래의 annotation으로 .xml파일의 id가 필요없게 된다.
	@Select("select stud_id as studid,name,email,dob  from students where stud_id = #{studId}")
	public Student findStudentById( Integer studId);
	/*
	<select id="findStudentById" 
	        parameterType="java.lang.Integer"  
			resultType="com.mybatis3.domain.Student"  >
		select stud_id as studid,name,email,dob  from students where stud_id = #{studId} 
	</select>
	 */
	
	@Select("select stud_id as studid,name,email,dob from students")
	public List<Student> findAllStudents();
	/*
	<select id="findAllStudents" 
			resultType="com.mybatis3.domain.Student" >
		select stud_id as studid,name,email,dob from students
	</select>
	*/
	
	@Select("select stud_id,name,email,dob from students where stud_id=#{studId}")
	@ResultMap("studentResultMap")
	public Student findStudentByIdResultMap(Integer studId);
	/*
	<select id="findStudentByIdResultMap" 
			parameterType="int" 
			resultMap="studentResultMap">
		select stud_id,name,email,dob from students 
		where stud_id=#{studId}
	</select>
	 */
	@Select("select stud_id,name,email,dob from students")
	@ResultMap("studentResultMap")
	public List<Student> findAllStudentsResultMap();
	/*
	<select id="findAllStudentsResultMap" 
			resultMap="studentResultMap">
		select stud_id,name,email,dob from students
	</select>
	*/
	
	@Select("select stud_id, name, email,phone, a.addr_id, street, city, state, zip, country"
			+ "  		FROM students s"
			+ "      	left outer join addresses a"
			+ "      	on s.addr_id=a.addr_id"
			+ "			where s.stud_id=#{studId}")
	@ResultMap("studentWithAddressResultMap")
	public Student findStudentByIdWithAddress(Integer studId);
	/*
	 <select id="findStudentByIdWithAddress" 
	 		 parameterType="int"
	 		 resultMap="studentWithAddressResultMap">
	 	select stud_id, name, email,phone, a.addr_id, street, city, state, zip, country
  		FROM students s 
      	left outer join addresses a 
      	on s.addr_id=a.addr_id
      	where s.stud_id=#{studId}
	 </select>
	 */
	
	@Select("select  s.stud_id,s.name as student_name ,s.email,s.phone,s.dob,"
			+ "        c.course_id,c.name as course_name ,c.description,c.start_date,c.end_date"
			+ "		from students s"
			+ "		left outer join course_enrollment ce"
			+ "		on s.stud_id = ce.stud_id"
			+ "		left outer join courses c"
			+ "		on ce.course_id=c.course_id where s.stud_id=#{studId}")
	@ResultMap("studentWithCoursesResultMap")
	public Student findStudentByIdWithCourses(Integer studId);
	/*
	 <select id="findStudentByIdWithCourses" 
	 		 parameterType="int"
	 		 resultMap="studentWithCoursesResultMap">
	 	select  s.stud_id,s.name as student_name ,s.email,s.phone,s.dob ,
        c.course_id,c.name as course_name ,c.description,c.start_date,c.end_date
		from students s 
		left outer join course_enrollment ce
		on s.stud_id = ce.stud_id
		left outer join courses c
		on ce.course_id=c.course_id where s.stud_id=#{studId}
	 </select>
	 */
	
	@Insert("INSERT INTO STUDENTS (STUD_ID,NAME,EMAIL,DOB)"
			+ "		VALUES (STUDENTS_STUD_ID_SEQ.nextval,#{name},#{email},#{dob})")
	public int insertStudent(Student student);
	/*
	<insert id="insertStudent" parameterType="com.mybatis3.domain.Student">
	INSERT INTO STUDENTS (STUD_ID,NAME,EMAIL,DOB)
	VALUES (STUDENTS_STUD_ID_SEQ.nextval,#{name},#{email},#{dob})
	</insert>
	*/
	@Insert("insert into students (stud_id,name,email,dob)"
			+ "		values (#{studId},#{name},#{email},#{dob})")
	@SelectKey(statement = "select STUDENTS_STUD_ID_SEQ.nextval from dual",keyProperty = "studId", before = true,resultType = Integer.class)
	public int insertStudentBySequence1(Student student);
	/*	
	<insert id="insertStudentBySequence1" 
	 		 parameterType="com.mybatis3.domain.Student">
	 	<selectKey resultType="int" order="BEFORE" keyProperty="studId">
	 		select STUDENTS_STUD_ID_SEQ.nextval from dual
	 	</selectKey>
	 		 
	 	insert into students(stud_id,name,email,dob)
	 	values (#{studId},#{name},#{email},#{dob})
	</insert>
	 */
	@Update("update students set"
			+ "		name=#{name},"
			+ "		email=#{email},"
			+ "		dob=#{dob}"
			+ "		where stud_id=#{studId}")
	public int updateStudentById(Student updateStudent);
	/*
	<update id="updateStudentById" parameterType="com.mybatis3.domain.Student">
		update students set 
		name=#{name},
		email=#{email},
		dob=#{dob}
		where stud_id=#{studId}
	</update>
	 */
	@Delete("delete from students where stud_id=#{studId}")
	public int deleteStudentById(Integer studId);
	/*
	<delete id="deleteStudentById" parameterType="int">
		delete from students where stud_id=#{studId}	
	</delete> 
	 */
}
