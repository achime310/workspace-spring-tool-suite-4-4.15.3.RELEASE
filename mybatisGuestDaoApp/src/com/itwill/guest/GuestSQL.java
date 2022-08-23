package com.itwill.guest;

public class GuestSQL {

	//public final static이므로 객체생성하지않고, 클래스에서 접근한다.
	
	//private생성자를 통해, 아예 객체생성을 못하도록 한다.
	private GuestSQL() {
	}
	
	public final static String GUEST_SELECT_ALL
	="select * from guest";
	public final static String GUEST_SELECT_BY_NO
	="select * from guest where guest_no=?";
	public final static String GUEST_INSERT
	="insert into guest values(guest_no_seq.nextval,?,sysdate,?,?,?,?)";
	
	//수정해야할 데이터만 sql문에 작성하여 수정한다
	public final static String GUEST_UPDATE
	="update guest set  guest_name=?, guest_email=?, guest_homepage=?, guest_title=?, guest_content=? where guest_no=?";
	public final static String GUEST_DELETE
	="delete from guest where guest_no=?";
}
