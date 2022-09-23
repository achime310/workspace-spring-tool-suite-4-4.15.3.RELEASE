---------------------------------- member -----------------------------------   
insert into member(m_id,m_password,m_name,m_email,m_address,m_post,m_phone) values ('home1','1234','조홍규','home1@naver.com','서울시 구로구','152-774','010-1234-5678');
insert into member(m_id,m_password,m_name,m_email,m_address,m_post,m_phone) values ('home2','5678','김홍규','home2@naver.com','서울시 강남구','148-645','010-7743-1575');
insert into member(m_id,m_password,m_name,m_email,m_address,m_post,m_phone) values ('home3','1472','이홍규','home3@naver.com','서울시 마포구','176-294','010-3576-7815');
insert into member(m_id,m_password,m_name,m_email,m_address,m_post,m_phone) values ('home4','2583','박홍규','home4@naver.com','서울시 서초구','136-914','010-1357-6458');
insert into member(m_id,m_password,m_name,m_email,m_address,m_post,m_phone) values ('home5','3691','최홍규','home5@naver.com','서울시 성북구','248-556','010-6542-1574');
insert into member(m_id,m_password,m_name,m_email,m_address,m_post,m_phone) values ('home6','7894','강홍규','home6@naver.com','서울시 강동구','276-357','010-9985-0542');
insert into member(m_id,m_password,m_name,m_email,m_address,m_post,m_phone) values ('home7','4561','백홍규','home7@naver.com','서울시 영등포구','246-175','010-8545-6423');
insert into member(m_id,m_password,m_name,m_email,m_address,m_post,m_phone) values ('toto', 1111, '토토', '투투@', '서울 성북구', 1234, '010-3433-9999');

---------------------------------- category -----------------------------------   
insert into category values (category_cg_no_SEQ.nextval, '화분');
insert into category values (category_cg_no_SEQ.nextval, '조명');
insert into category values (category_cg_no_SEQ.nextval, '장식소품');
insert into category values (category_cg_no_SEQ.nextval, '캔들');
insert into category values (category_cg_no_SEQ.nextval, '시계');

---------------------------------- product ----------------------------------- 
insert into product values (product_p_no_SEQ.nextval, '화분1', 54000, '빨간화분', sysdate, 3.5, 'red', 'a', 0, 'special', 1);
insert into product values (product_p_no_SEQ.nextval, '화분2', 44000, '주황화분', sysdate, 4.5, 'orange', null, 0, 'fun', 1);
insert into product values (product_p_no_SEQ.nextval, '화분3', 34000, '노랑화분', sysdate, 5.0, 'yellow', null, 0, 'special',1);
insert into product values (product_p_no_SEQ.nextval, '화분4', 24000, '초록화분', sysdate, 3.0, 'green', 'b', 0, 'special',1);

insert into product values (product_p_no_SEQ.nextval, '조명1', 54000, '빨간조명', sysdate, 1.5, 'red', 'a', 0, 'fun', 2);
insert into product values (product_p_no_SEQ.nextval, '조명2', 44000, '주황조명', sysdate, 5.0, 'orange', null, 0, 'good', 2);
insert into product values (product_p_no_SEQ.nextval, '조명3', 34000, '노랑조명', sysdate, 2.5, 'yellow', null, 0, 'good', 2);
insert into product values (product_p_no_SEQ.nextval, '조명4', 24000, '초록조명', sysdate, 3.0, 'green', 'b', 0, 'fun', 2);

insert into product values (product_p_no_SEQ.nextval, '장식소품1', 54000, '빨간장식소품', sysdate, 4.5, 'red', 'a', 0, 'good', 3);
insert into product values (product_p_no_SEQ.nextval, '장식소품2', 44000, '주황장식소품', sysdate, 5.0, 'orange', null, 0, 'comfortable', 3);
insert into product values (product_p_no_SEQ.nextval, '장식소품3', 34000, '노랑장식소품', sysdate, 3.5, 'yellow', null, 0, 'comfortable', 3);
insert into product values (product_p_no_SEQ.nextval, '장식소품4', 24000, '초록장식소품', sysdate, 2.0, 'green', 'b', 0, 'good', 3);

---------------------------------- image ----------------------------------- 
insert into image(im_no, im_div, im_name, p_no) values(IMAGE_IM_NO_SEQ.nextval, 'IMG', 'a.jpg', 1);
insert into image(im_no, im_div, im_name, p_no) values(IMAGE_IM_NO_SEQ.nextval, 'IMG', 'b.jpg', 1);
insert into image(im_no, im_div, im_name, p_no) values(IMAGE_IM_NO_SEQ.nextval, 'IMG', 'c.jpg', 1);
insert into image(im_no, im_div, im_name, p_no) values(IMAGE_IM_NO_SEQ.nextval, 'DESC', 'd.jpg', 1);

---------------------------------- cart ----------------------------------- 
insert into cart(c_no, m_id, p_no, c_qty) values(CART_C_NO_SEQ.nextval,'home1', 3, 5);
insert into cart(c_no, m_id, p_no, c_qty)values(CART_C_NO_SEQ.nextval, 'home1', 1, 1);
insert into cart(c_no, m_id, p_no, c_qty)values(CART_C_NO_SEQ.nextval, 'home2', 1, 1);
insert into cart(c_no, m_id, p_no, c_qty)values(CART_C_NO_SEQ.nextval, 'home2', 2, 2);
insert into cart(c_no, m_id, p_no, c_qty)values(CART_C_NO_SEQ.nextval, 'home3', 1, 1);
insert into cart(c_no, m_id, p_no, c_qty)values(CART_C_NO_SEQ.nextval, 'home3', 2, 2);
insert into cart(c_no, m_id, p_no, c_qty)values(CART_C_NO_SEQ.nextval, 'home3', 3, 3);
insert into cart(c_no, m_id, p_no, c_qty)values(CART_C_NO_SEQ.nextval, 'home4', 1, 1);
insert into cart(c_no, m_id, p_no, c_qty)values(CART_C_NO_SEQ.nextval, 'home4', 2, 2);
insert into cart(c_no, m_id, p_no, c_qty)values(CART_C_NO_SEQ.nextval, 'home4', 3, 3);
insert into cart(c_no, m_id, p_no, c_qty)values(CART_C_NO_SEQ.nextval, 'home4', 4, 4);
insert into cart(c_no, m_id, p_no, c_qty)values(CART_C_NO_SEQ.nextval, 'home5', 1, 1);
insert into cart(c_no, m_id, p_no, c_qty)values(CART_C_NO_SEQ.nextval, 'home5', 2, 2);
insert into cart(c_no, m_id, p_no, c_qty)values(CART_C_NO_SEQ.nextval, 'home5', 3, 3);
insert into cart(c_no, m_id, p_no, c_qty)values(CART_C_NO_SEQ.nextval, 'home5', 4, 4);
insert into cart(c_no, m_id, p_no, c_qty)values(CART_C_NO_SEQ.nextval, 'home5', 5, 5);
insert into cart(c_no, m_id, p_no, c_qty)values(CART_C_NO_SEQ.nextval, 'home6', 1, 1);
insert into cart(c_no, m_id, p_no, c_qty)values(CART_C_NO_SEQ.nextval, 'home6', 2, 2);
insert into cart(c_no, m_id, p_no, c_qty)values(CART_C_NO_SEQ.nextval, 'home6', 3, 3);
insert into cart(c_no, m_id, p_no, c_qty)values(CART_C_NO_SEQ.nextval, 'home6', 4, 4);
insert into cart(c_no, m_id, p_no, c_qty)values(CART_C_NO_SEQ.nextval, 'home6', 5, 5);
insert into cart(c_no, m_id, p_no, c_qty)values(CART_C_NO_SEQ.nextval, 'home6', 6, 6);
insert into cart(c_no, m_id, p_no, c_qty)values(CART_C_NO_SEQ.nextval, 'home7', 1, 1);
insert into cart(c_no, m_id, p_no, c_qty)values(CART_C_NO_SEQ.nextval, 'home7', 2, 2);
insert into cart(c_no, m_id, p_no, c_qty)values(CART_C_NO_SEQ.nextval, 'home7', 3, 3);
insert into cart(c_no, m_id, p_no, c_qty)values(CART_C_NO_SEQ.nextval, 'home7', 4, 4);
insert into cart(c_no, m_id, p_no, c_qty)values(CART_C_NO_SEQ.nextval, 'home7', 5, 5);
insert into cart(c_no, m_id, p_no, c_qty)values(CART_C_NO_SEQ.nextval, 'home7', 6, 6);
insert into cart(c_no, m_id, p_no, c_qty)values(CART_C_NO_SEQ.nextval, 'home7', 7, 7);

---------------------------------- wishlist ----------------------------------- 
insert into wishlist(w_no,m_id,p_no)VALUES(WISHLIST_W_NO_SEQ.nextval, 'home1', 1);
insert into wishlist(w_no,m_id,p_no)values(WISHLIST_W_NO_SEQ.nextval, 'home2', 2);
insert into wishlist(w_no,m_id,p_no)values(WISHLIST_W_NO_SEQ.nextval, 'home3', 3);
insert into wishlist(w_no,m_id,p_no)values(WISHLIST_W_NO_SEQ.nextval, 'home4', 4);

---------------------------------- order ----------------------------------- 
insert into orders(o_no,o_desc,o_date,o_price, o_pay_method, o_status,o_rv_name,o_rv_phone,o_rv_address,o_rv_post,o_message,m_id)
values(orders_o_no_SEQ.nextval,'소파 외 1개',sysdate,95000, 'CARD', '결제완료','장동혁','010-3533-3423','서울시 강동구','05307','안전하게보내주세요','home2');

---------------------------------- order item ----------------------------------- 
insert into order_item(oi_no,oi_qty,o_no,p_no) 
values(order_item_oi_no_SEQ.nextval,3,orders_o_no_SEQ.currval,11); 

--------------------------------- review --------------------------------------
insert into review (r_no, r_date, r_content, r_score, m_id, p_no) values (REVIEW_R_NO_SEQ.nextval, sysdate, '리뷰내용', 5, 'toto', 6); 
insert into review (r_no, r_date, r_content, r_score, m_id, p_no) values (REVIEW_R_NO_SEQ.nextval, sysdate, '리뷰내용', 4, 'toto', 6); 
insert into review (r_no, r_date, r_content, r_score, m_id, p_no) values (REVIEW_R_NO_SEQ.nextval, sysdate, '리뷰내용', 3, 'toto', 6); 

----------------------------------- qna---------------------------------------
-- 새 글 입력 
INSERT INTO 
qna(q_no, q_title, q_content, q_date, q_count, q_group_no, q_step, q_depth, m_id) 
VALUES(QNA_Q_NO_SEQ.nextval,
        '게시판타이틀'||QNA_Q_NO_SEQ.currval,
        'content'||QNA_Q_NO_SEQ.currval,
        sysdate,
        0,
        QNA_Q_NO_SEQ.currval,    
        1,          
        0,          
        'toto' 
        );      
    
--답글 입력 
 INSERT INTO qna(q_no, q_title, q_content, q_date, q_count, q_group_no, q_step, q_depth, m_id) 
   VALUES
            (QNA_Q_NO_SEQ.nextval,
                '1번답글1',
                '1번답글내용',
                sysdate, 
                0,
                1,
                2,
                0,
                'toto'
              );   
