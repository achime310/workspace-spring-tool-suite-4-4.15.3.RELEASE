package com.itwill.guest;

import java.util.ArrayList;

public interface GuestDao {

	ArrayList<Guest> selectAll() throws Exception;

	Guest selectByNo(int no) throws Exception;

	int insertGuest(Guest guest) throws Exception;

	int updateGuest(Guest guest) throws Exception;

	int deleteGuest(int no) throws Exception;

}