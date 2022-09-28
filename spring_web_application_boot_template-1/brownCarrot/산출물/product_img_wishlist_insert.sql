/* [product] & [product_img]**************************************************/
desc product;
desc product_img;
select * from product;
select * from product_img;

/*
이름         널?       유형            
---------- -------- ------------- 
P_NO       NOT NULL NUMBER(20)    
P_TITLE             VARCHAR2(500) 
P_DESC              VARCHAR2(500) 
P_PRICE             NUMBER(20)    
P_DATE              DATE          
P_SELL              NUMBER(10)    
P_COUNT             NUMBER(10)    
P_WISH              NUMBER(10)    
ADDRESS_NO          NUMBER(10)    
P_CTGR_NO           NUMBER(10) 
*/
/*
insert into product values(PRODUCT_P_NO_SEQ.nextval, '양심을 팝니다', '양심 팝니다.', 10000000, sysdate, null, 123, 10, null ,null);
insert into product values(PRODUCT_P_NO_SEQ.nextval, '개구리 팝니다', '개구리 팝니다.', 43250, sysdate, null, 456, 52, null ,null);
insert into product values(PRODUCT_P_NO_SEQ.nextval, '프라다백 팝니다', '프라다백 팝니다.', 8000000, sysdate, null, 789, 102, null ,null);
insert into product values(PRODUCT_P_NO_SEQ.nextval, '얼굴을 팝니다', '얼굴 팝니다.', 32400000, sysdate, null, 0, 167, null ,null);

insert into product_img values(PRODUCT_IMG_PI_NO_SEQ.nextval, '양심.jpg', '1');
insert into product_img values(PRODUCT_IMG_PI_NO_SEQ.nextval, '개구리.jpg', '2');
insert into product_img values(PRODUCT_IMG_PI_NO_SEQ.nextval, '프라다백.jpg', '3');
insert into product_img values(PRODUCT_IMG_PI_NO_SEQ.nextval, '얼굴.jpg', '4');
*/

insert into product values(PRODUCT_P_NO_SEQ.nextval, '(미개봉)키보드', '선물받았는데 필요없어져서 팝니다. 직거래환영', 20000, sysdate-30, null, 10, 5, 1,1);
insert into product_img values(PRODUCT_IMG_PI_NO_SEQ.nextval, 'keyboard1.jpg', PRODUCT_P_NO_SEQ.currval);
insert into product_img values(PRODUCT_IMG_PI_NO_SEQ.nextval, 'keyboard2.jpg', PRODUCT_P_NO_SEQ.currval);

insert into product values(PRODUCT_P_NO_SEQ.nextval, '(미개봉)마우스', '선물받았는데 필요없어져서 팝니다. 직거래환영', 30000, sysdate-30, null, 10, 5, 1,1);
insert into product_img values(PRODUCT_IMG_PI_NO_SEQ.nextval, 'mouse1.jpg', PRODUCT_P_NO_SEQ.currval);
insert into product_img values(PRODUCT_IMG_PI_NO_SEQ.nextval, 'mouse2.jpg', PRODUCT_P_NO_SEQ.currval);

insert into product values(PRODUCT_P_NO_SEQ.nextval, '최신형 청소기', '선물받았는데 필요없어져서 팝니다. 직거래환영', 30000, sysdate-30, null, 10, 5, 2,2);
insert into product_img values(PRODUCT_IMG_PI_NO_SEQ.nextval, 'vacuum1.jpg', PRODUCT_P_NO_SEQ.currval);
insert into product_img values(PRODUCT_IMG_PI_NO_SEQ.nextval, 'vacuum2.jpg', PRODUCT_P_NO_SEQ.currval);

insert into product values(PRODUCT_P_NO_SEQ.nextval, '전자레인지 팝니다', '선물받았는데 필요없어져서 팝니다. 직거래환영', 30000, sysdate-30, null, 10, 5, 2,2);
insert into product_img values(PRODUCT_IMG_PI_NO_SEQ.nextval, 'microwave.jpg', PRODUCT_P_NO_SEQ.currval);

insert into product values(PRODUCT_P_NO_SEQ.nextval, '푹신한 의자', '앉으면 일어날 수 없어요', 30000, sysdate-30, null, 10, 5, 3,2);
insert into product_img values(PRODUCT_IMG_PI_NO_SEQ.nextval, 'chair.jpg', PRODUCT_P_NO_SEQ.currval);

insert into product values(PRODUCT_P_NO_SEQ.nextval, '어린이용 책상', '아이가 커져서 팝니다.', 30000, sysdate-30, null, 10, 5, 3,2);
insert into product_img values(PRODUCT_IMG_PI_NO_SEQ.nextval, 'desk.jpg', PRODUCT_P_NO_SEQ.currval);

insert into product values(PRODUCT_P_NO_SEQ.nextval, '라면냄비', '2번사용했습니다.', 30000, sysdate-30, null, 10, 5, 4,3);
insert into product_img values(PRODUCT_IMG_PI_NO_SEQ.nextval, 'pot.jpg', PRODUCT_P_NO_SEQ.currval);

insert into product values(PRODUCT_P_NO_SEQ.nextval, '후라이팬', '계란후라이에 딱입니다.', 30000, sysdate-30, null, 10, 5, 4,3);
insert into product_img values(PRODUCT_IMG_PI_NO_SEQ.nextval, 'pan.jpg', PRODUCT_P_NO_SEQ.currval);

insert into product values(PRODUCT_P_NO_SEQ.nextval, '딸랑이 세트', '깔끔하게 소독했어요', 30000, sysdate-30, null, 10, 5, 5,4);
insert into product_img values(PRODUCT_IMG_PI_NO_SEQ.nextval, 'toy1.jpg', PRODUCT_P_NO_SEQ.currval);
insert into product_img values(PRODUCT_IMG_PI_NO_SEQ.nextval, 'toy2.jpg', PRODUCT_P_NO_SEQ.currval);
insert into product values(PRODUCT_P_NO_SEQ.nextval, '신생아 양말', '미착용했습니다.', 30000, sysdate-30, null, 10, 5, 5,4);
insert into product_img values(PRODUCT_IMG_PI_NO_SEQ.nextval, 'toddler_socks1.jpg', PRODUCT_P_NO_SEQ.currval);
insert into product_img values(PRODUCT_IMG_PI_NO_SEQ.nextval, 'toddler_socks2.jpg', PRODUCT_P_NO_SEQ.currval);

insert into product values(PRODUCT_P_NO_SEQ.nextval, '동화책3권팝니다', '낱권 구매가능합니다.', 30000, sysdate-30, null, 10, 5, 6,5);
insert into product_img values(PRODUCT_IMG_PI_NO_SEQ.nextval, 'book1.jpg', PRODUCT_P_NO_SEQ.currval);
insert into product_img values(PRODUCT_IMG_PI_NO_SEQ.nextval, 'book2.jpg', PRODUCT_P_NO_SEQ.currval);
insert into product values(PRODUCT_P_NO_SEQ.nextval, '가나다 한글책', '깨끗합니다.', 30000, sysdate-30, null, 10, 5, 6,5);
insert into product_img values(PRODUCT_IMG_PI_NO_SEQ.nextval, 'book3.jpg', PRODUCT_P_NO_SEQ.currval);
insert into product_img values(PRODUCT_IMG_PI_NO_SEQ.nextval, 'book4.jpg', PRODUCT_P_NO_SEQ.currval);

insert into product values(PRODUCT_P_NO_SEQ.nextval, '무지 흰 반팔티', '미착용상품입니다.', 30000, sysdate-30, null, 10, 5, 7,6);
insert into product values(PRODUCT_P_NO_SEQ.nextval, '무지 검정 반팔티', '미착용상품입니다.', 30000, sysdate-30, null, 10, 5, 7,6);






--#### <<join>> product - product_img - address(user_id,판매자)
select * from product p
join product_img pi
on p.p_no=pi.p_no
join address a
on p.address_no=a.address_no;



/* [wishlist] **************************************************/
desc wishlist;
/*
이름          널?       유형           
----------- -------- ------------ 
WISHLIST_NO NOT NULL NUMBER(10)   
P_NO                 NUMBER(20)   
USER_ID              VARCHAR2(10) 
*/
select * from wishlist;

insert into wishlist(wishlist_no,p_no,user_id) values(wishlist_wishlist_no_seq.nextval,1,'carrot6');
insert into wishlist(wishlist_no,p_no,user_id) values(wishlist_wishlist_no_seq.nextval,1,'carrot7');
insert into wishlist(wishlist_no,p_no,user_id) values(wishlist_wishlist_no_seq.nextval,1,'carrot8');
insert into wishlist(wishlist_no,p_no,user_id) values(wishlist_wishlist_no_seq.nextval,2,'carrot4');
insert into wishlist(wishlist_no,p_no,user_id) values(wishlist_wishlist_no_seq.nextval,2,'carrot5');
insert into wishlist(wishlist_no,p_no,user_id) values(wishlist_wishlist_no_seq.nextval,2,'carrot6');
insert into wishlist(wishlist_no,p_no,user_id) values(wishlist_wishlist_no_seq.nextval,3,'carrot6');
insert into wishlist(wishlist_no,p_no,user_id) values(wishlist_wishlist_no_seq.nextval,3,'carrot1');
insert into wishlist(wishlist_no,p_no,user_id) values(wishlist_wishlist_no_seq.nextval,3,'carrot2');
insert into wishlist(wishlist_no,p_no,user_id) values(wishlist_wishlist_no_seq.nextval,4,'carrot1');
insert into wishlist(wishlist_no,p_no,user_id) values(wishlist_wishlist_no_seq.nextval,4,'carrot2');
insert into wishlist(wishlist_no,p_no,user_id) values(wishlist_wishlist_no_seq.nextval,4,'carrot3');
insert into wishlist(wishlist_no,p_no,user_id) values(wishlist_wishlist_no_seq.nextval,4,'carrot4');
insert into wishlist(wishlist_no,p_no,user_id) values(wishlist_wishlist_no_seq.nextval,4,'carrot5');
insert into wishlist(wishlist_no,p_no,user_id) values(wishlist_wishlist_no_seq.nextval,5,'carrot1');
insert into wishlist(wishlist_no,p_no,user_id) values(wishlist_wishlist_no_seq.nextval,5,'carrot2');
insert into wishlist(wishlist_no,p_no,user_id) values(wishlist_wishlist_no_seq.nextval,5,'carrot3');
insert into wishlist(wishlist_no,p_no,user_id) values(wishlist_wishlist_no_seq.nextval,5,'carrot4');
insert into wishlist(wishlist_no,p_no,user_id) values(wishlist_wishlist_no_seq.nextval,5,'carrot5');
insert into wishlist(wishlist_no,p_no,user_id) values(wishlist_wishlist_no_seq.nextval,6,'carrot1');
insert into wishlist(wishlist_no,p_no,user_id) values(wishlist_wishlist_no_seq.nextval,6,'carrot3');
insert into wishlist(wishlist_no,p_no,user_id) values(wishlist_wishlist_no_seq.nextval,6,'carrot5');

--#### <<join>> product - address(user_id,판매자) - wishlist(user_id,구매자)
select * from product p
join address a
on p.address_no=a.address_no
join wishlist w
on p.p_no=p.p_no;