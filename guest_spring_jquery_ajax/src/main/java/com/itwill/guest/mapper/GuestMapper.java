package com.itwill.guest.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.itwill.guest.Guest;

public interface GuestMapper {
	/*
	 * 인터페이스의 풀네임은 GuestMapper.xml의 namespace와일치
	 * 메쏘드이름은 	GuestMapper.xml 파일의 id와일치
	 * 메쏘드인자타입은 GuestMapper.xml 파일의 parameterType 와일치
	 * 메쏘드리턴타입은 GuestMapper.xml 파일의 resultType 와일치
	 */
	@Select("SELECT * FROM GUEST")
	public List<Guest> selectAll();
	/*
	 <select id="selectAll" resultType="com.itwill.guest.Guest">
		SELECT * FROM GUEST
	</select>
	*/
	@Select("SELECT * FROM GUEST WHERE guest_no=#{guest_no}")
	public Guest selectByNo(Integer guest_no);
	/*
	<select id="selectByNo" 
			parameterType="java.lang.Integer" 
			resultType="com.itwill.guest.Guest">
		SELECT * FROM GUEST
		WHERE guest_no=#{guest_no}
	</select>
	*/
	@Insert("insert into guest "
			+ "		values( #{guest_no},#{guest_name},"
			+ "		 		sysdate,#{guest_email},"
			+ "		 		#{guest_homepage},#{guest_title},"
			+ "		 		#{guest_content})")
	@SelectKey(statement = "SELECT guest_no_seq.nextval FROM DUAL",
			   keyColumn = "guest_no",
			   keyProperty = "guest_no",
			   before = true,
			   resultType = Integer.class
			)
	public int insertGuest(Guest guest);
	/*
	<insert id="insertGuest" parameterType="com.itwill.guest.Guest">
		<selectKey resultType="java.lang.Integer"
			keyProperty="guest_no" order="BEFORE">
			SELECT guest_no_seq.nextval FROM DUAL
		</selectKey>
		insert into guest 
		values( #{guest_no},#{guest_name},
		 		sysdate,#{guest_email},
		 		#{guest_homepage},#{guest_title},
		 		#{guest_content})
	</insert>
	*/
	@Delete("delete from guest where guest_no = #{guest_no}")
	public int deleteGuest(int guest_no);
	/*
	<delete id="deleteGuest" parameterType="java.lang.Integer">
		delete from guest where guest_no = #{guest_no}
	</delete>
	*/
	@Update("update guest set  guest_name=#{guest_name}, guest_email=#{guest_email},"
			+ "		                  guest_homepage=#{guest_homepage}, guest_title=#{guest_title}, "
			+ "		                  guest_content=#{guest_content} "
			+ "		where guest_no = #{guest_no}")
	public int updateGuest(Guest guest);
	/*
	<update id="updateGuest" parameterType="com.itwill.guest.Guest">
		update guest set  guest_name=#{guest_name}, guest_email=#{guest_email},
		                  guest_homepage=#{guest_homepage}, guest_title=#{guest_title}, 
		                  guest_content=#{guest_content} 
		where guest_no = #{guest_no}
	</update>
	 */
}
