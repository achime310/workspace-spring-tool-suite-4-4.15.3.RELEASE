package com.itwill.tomorrowHome.sql;

public class WishListsql {
	public static final String insert_wishList=
			"insert into wishlist(w_no,m_id,p_no)VALUES(WISHLIST_W_NO_SEQ.nextval,?,?)";
			
			//찜 목록 일부삭제
			public static final String delete_wish_by_no=
			"delete wishlist where w_no = ?"; 
			
			//찜 목록 전체 삭제
			public static final String delete_wish_by_id=
			"delete wishlist where m_id = ?";
			
			//찜목록에 이미 있는가
			public static final String select_wish_check_id_no=
			"select count(*) cnt from wishList where m_id=? and p_no=?";
			
			public static final String select_wish_detail =
			"select * from wishlist wl join product p on wl.p_no=p.p_no where w_no=?";
				
			//찜 목록 전체 출력
			public static final String select_wish_exist =
			"select w_no, m_id, p.p_no, p_name, p_price, min(im_name) im_name from wishlist w \r\n"
			+ "join product p on w.p_no = p.p_no "
			+ "left outer join image i on p.p_no = i.p_no "
			+ "where m_id=?"
			+ "group by w_no, m_id, p.p_no, p_name, p_price;";
}
