package com.itwill.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.itwill.user.Invitation;
import com.itwill.user.UserInfo;

@Mapper
public interface UserInfoMapper {
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
	public int createUser(UserInfo user);

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
	public int createAddress(UserInfo user);

	/*
	 * <insert id="createInvitation" parameterType="com.itwill.user.Invitation">
	 * insert into invitation(invi_no,invi_email,user_id)
	 * values(INVITATION_INVI_NO_SEQ.nextval,#{invi_email},#{user_id}) </insert>
	 */
	//@Insert("insert into invitation values(INVITATION_INVI_NO_SEQ.nextval,#{invi_email},#{user_id})")
	public int createInvitation(Invitation invitation);

	
	
	
	//@Update("update  userinfo set password=#{password},name=#{name},email=#{email} where user_id=#{user_id}")
	public int updateUser(UserInfo user);

	//@Delete("delete userinfo where user_id=#{user_id}")
	public int removeUser(String user_id);

	//@Select("select user_id,password,name,email from userinfo where user_id=#{user_id}")
	public UserInfo findUser(String user_id);

	//@Select("select user_id,password,name,email from userinfo")
	public List<UserInfo> findUserList();

	//@Select("select count(*) cnt from userinfo where user_id=#{user_id}")
	public int existedUser(String user_id);

}