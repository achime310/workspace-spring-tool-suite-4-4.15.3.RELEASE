----------------------------------- member --------------------------------------  

-- 멤버 비밀번호 변경 
update member set m_password='1234' where m_id='home1';

-- 멤버 정보 수정 
update member set m_password=?, m_name=?, m_email=?, m_address=?, m_post=?, m_phone=? where m_id=?

---------------------------------- cart --------------------------------------

-- 카트 상품 수량 변경 
update cart set c_qty=2 where c_no=1;

-- 존재하는 상품 중복 추가시 수량 변경 
update cart set c_qty=c_qty+? where p_no=1 and m_id='home1'

-------------------------- QNA----------------------------------

-- 답글입력 전 게시글 순서 변경 
update qna SET step = step + 1 where step >= 2 and groupno = 1;

-- 조회수 증가 
update notice set n_count = n_count + 1 where n_no = ?;

-- 게시글 수정 
update qna set q_title=?, q_content=? where q_no = ?;

-------------------------- product----------------------------------

-- 상품의 평균 평점 수정 
update product p set p_avg_score=? where p_no=?

-- 상품의 click count 수정 
update product set p_count = p_count+1 where p_no=1; 

-------------------------- review ----------------------------------

-- 리뷰 수정 
update review set r_score=?, r_content=? where r_no=?