package com.itwill.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.itwill.user.Invitation;
import com.itwill.user.User;

@Mapper
public interface UserMapper {
	/*
	 * <insert id="createUser" parameterType="com.itwill.user.User"> INSERT INTO
	 * userinfo VALUES (#{user_id}, #{user_pw}, #{user_name}, #{user_email},
	 * #{user_phone}, #{user_freshness}, #{user_point}, #{user_profile})
	 * </insert>
	 */
	/*
	 * @Insert("INSERT INTO userinfo VALUES (#{user_id}, #{user_pw}, #{user_name}, #{user_email}, #{user_phone},"
	 * + "#{user_freshness}, #{user_point}, #{user_profile})")
	 */
	public int createUser(User user);

	/*
	 * <insert id="createAddress" parameterType="com.itwill.user.Address">
	 * insert into address(address_no, address_name, address_lat,address_lng,
	 * address_range,user_id) values(address_address_no_seq.nextval,
	 * #{address_name}, #{address_lat}, #{address_lng},
	 * #{address_range},#{user_id}) </insert>
	 */
	/*
	 * @Insert("insert into address values(address_address_no_seq.nextval, #{address_name}, #{address_lat}, #{address_lng},"
	 * + " #{address_range},#{user_id})")
	 */
	public int createAddress(User user);

	/*
	 * <insert id="createInvitation" parameterType="com.itwill.user.Invitation">
	 * insert into invitation(invi_no,invi_email,user_id)
	 * values(INVITATION_INVI_NO_SEQ.nextval,#{invi_email},#{user_id}) </insert>
	 */
	//@Insert("insert into invitation values(INVITATION_INVI_NO_SEQ.nextval,#{invi_email},#{user_id})")
	public int createInvitation(Invitation invitation);

	
	
	
	//@Update("update  userinfo set password=#{password},name=#{name},email=#{email} where userid=#{userId}")
	public int updateUser(User user);

	//@Delete("delete userinfo where userid=#{userId}")
	public int removeUser(String userId);

	//@Select("select userid,password,name,email from userinfo where userid=#{userId}")
	public User findUser(String userId);

	//@Select("select userid,password,name,email from userinfo")
	public List<User> findUserList();

	//@Select("select count(*) cnt from userinfo where userid=#{userId}")
	public int existedUser(String userId);

}