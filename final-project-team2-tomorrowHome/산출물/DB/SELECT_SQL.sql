--------------------------member----------------------------------------

-- 멤버 정보 조회
select * from member where m_id ='home1';

-- 회원 아이디 존재 확인
-- 아이디 중복체크 위해 필요
select count(*) cnt from member where m_id = 'home1'; 

-------------------------- order --------------------------------------

-- 멤버의 주문 전체 목록 조회
select * from orders where m_id = 'home1' order by o_no desc;

-- 주문 상세 정보 조회
select * from orders o
join order_item oi on o.o_no = oi.o_no
join product p on oi.p_no = p.p_no
where o.o_no = '4';

-- 멤버의 특정 상품 주문 여부 조회
-- 리뷰 작성 가능 여부 확인시 필요
select count(*) cnt 
from orders o 
join order_item oi on o.o_no = oi.o_no 
where o.m_id = 'home2' and oi.p_no = 9; 

---------------------------------- cart --------------------------------------

-- 특정 멤버의 카트 목록 조회
select c_no, c_qty, m_id, p.p_no, p_name, p_price, min(im_name) im_name from cart c 
join product p on c.p_no = p.p_no 
left outer join image i on p.p_no = i.p_no 
where m_id='home1'
group by c_no, c_qty, m_id, p.p_no, p_name, p_price;

-- 카트에 특정 상품 존재 여부 조회 
-- 이미 존재하는 상품일 경우 수량만 변경해주기 위해 필요
select count(*) cnt from cart where m_id=? and p_no=?

-- 카트아이템 1개의 정보
select * from cart c join product p on c.p_no=p.p_no where c_no=1

---------------------------------- wishList --------------------------------------

-- 특정 멤버의 위시리스트 목록 조회
select w_no, m_id, p,p_no, p_name, p_price, min(im_name) im_name from wishlist w 
join product p on w.p_no = p.p_no 
left outer join image i on p.p_no = i.p_no 
where m_id='home1'
group by w_no, m_id, p.p_no, p_name, p_price;

-- 위시리스트에 특정 상품 존재 여부 조회 
-- 동일 상품일 경우 중복 등록 방지위해 필요
select count(*) cnt from wishList where m_id=? and p_no=?;

---------------------------------- product ----------------------------------- 

-- 전체 상품 목록 조회
-- 조건 있을 경우 조건 추가
select * from product p left outer join image i on p.p_no = i.p_no ;

-- 상품 상세 정보 조회 
select * from product p 
left outer join image i on p.p_no = i.p_no
where p.p_no = '1'; 

-- 상품 가격 조건 정렬 (오름차순) 
select * from product p order by p.p_price; 

-- 상품 가격 조건 정렬 (내림차순) 
select * from product p order by p.p_price desc; 

-- 상품 평점 평균 조건 정렬 (내림차순) 
select * from product p order by p.p_avg_score desc; 

------------------------ review----------------------------------

-- 특정 상품의 리뷰 목록 조회 
select * from review where p_no = 1; 

-- 회원의 특정상품 리뷰 작성 여부 조회 
select count(*) cnt 
from review r 
where r.m_id = 'toto' and r.p_no = 10; 

-- 특정 리뷰 정보 조회
select * from review where r_no = 1; 

-- 특정 상품의 리뷰 평점 조회 
select round(avg(r_score), 1) s_avg from review where p_no=?

------------------------ qna----------------------------------

-- 게시글 1개 정보 
select q_no, q_title, q_content, q_date, q_count, q_group_no, q_step, q_depth, m_id from qna where q_no = ?

-- 전체 게시글 수 조회
select count(*) cnt from qna;

-- 게시글 리스트 조회
SELECT * 
FROM 
( SELECT rownum idx, s.* 	
	FROM ( SELECT q_no, q_title, m_id, q_date, q_count, q_group_no, q_step, q_depth 
			FROM qna 
			ORDER BY q_group_no DESC, q_step ASC ) s 
)
WHERE idx >= ? AND idx <= ? ;


