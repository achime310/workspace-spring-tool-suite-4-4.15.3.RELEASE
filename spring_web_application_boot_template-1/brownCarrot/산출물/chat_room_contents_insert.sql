/* [chat_room] ******************/
desc chat_room;
/*
이름        널?       유형           
--------- -------- ------------ 
C_ROOM_NO NOT NULL NUMBER(10)   
FROM_ID            VARCHAR2(10) 
TO_ID              VARCHAR2(20) 
P_NO               NUMBER(20)  
*/

insert into chat_room(c_room_no, from_id, to_id,p_no) values(chat_room_c_room_no_seq.nextval,'carrot6', 'carrot1', 1);
--buyer='carrot1', p_no=1 // seller='carrot6'
insert into chat_contents(c_content_no, c_content,send_time,c_read,user_id,c_room_no)
values(chat_contents_c_content_no_SEQ.nextval, '안녕하세요',sysdate-10,1,'carrot1',chat_room_c_room_no_seq.currval);
insert into chat_contents(c_content_no, c_content,send_time,c_read,user_id,c_room_no)
values(chat_contents_c_content_no_SEQ.nextval, '네, 안녕하세요~',sysdate-10,1,'carrot6',chat_room_c_room_no_seq.currval);
insert into chat_contents(c_content_no, c_content,send_time,c_read,user_id,c_room_no)
values(chat_contents_c_content_no_SEQ.nextval, '아직 판매중이신가요?',sysdate-10,1,'carrot1',chat_room_c_room_no_seq.currval);
insert into chat_contents(c_content_no, c_content,send_time,c_read,user_id,c_room_no)
values(chat_contents_c_content_no_SEQ.nextval, '네 아직 판매중입니다.',sysdate-10,1,'carrot6',chat_room_c_room_no_seq.currval);
insert into chat_contents(c_content_no, c_content,send_time,c_read,user_id,c_room_no)
values(chat_contents_c_content_no_SEQ.nextval, '네고 가능한가요?',sysdate-10,1,'carrot1',chat_room_c_room_no_seq.currval);
insert into chat_contents(c_content_no, c_content,send_time,c_read,user_id,c_room_no)
values(chat_contents_c_content_no_SEQ.nextval, '아니요',sysdate-10,0,'carrot6',chat_room_c_room_no_seq.currval);



insert into chat_room(c_room_no, from_id, to_id,p_no) values(chat_room_c_room_no_seq.nextval, 'carrot2','carrot1', 1);
--buyer='carrot2', p_no=1 // seller='carrot1'
insert into chat_contents(c_content_no, c_content,send_time,c_read,user_id,c_room_no)
values(chat_contents_c_content_no_SEQ.nextval, '안녕하세요^^',sysdate-10,1,'carrot2',chat_room_c_room_no_seq.currval);
insert into chat_contents(c_content_no, c_content,send_time,c_read,user_id,c_room_no)
values(chat_contents_c_content_no_SEQ.nextval, '네~',sysdate-10,1,'carrot6',chat_room_c_room_no_seq.currval);
insert into chat_contents(c_content_no, c_content,send_time,c_read,user_id,c_room_no)
values(chat_contents_c_content_no_SEQ.nextval, '팔렸나요?',sysdate-9,1,'carrot2',chat_room_c_room_no_seq.currval);
insert into chat_contents(c_content_no, c_content,send_time,c_read,user_id,c_room_no)
values(chat_contents_c_content_no_SEQ.nextval, '예약중입니다',sysdate-9,0,'carrot6',chat_room_c_room_no_seq.currval);


insert into chat_room(c_room_no, from_id, to_id,p_no) values(chat_room_c_room_no_seq.nextval, 'carrot2','carrot3', 2);
-- buyer='carrot2', p_no=2 // seller='carrot5'
insert into chat_contents(c_content_no, c_content,send_time,c_read,user_id,c_room_no)
values(chat_contents_c_content_no_SEQ.nextval, '팔렸나요?',sysdate-8,1,'carrot2',chat_room_c_room_no_seq.currval);
insert into chat_contents(c_content_no, c_content,send_time,c_read,user_id,c_room_no)
values(chat_contents_c_content_no_SEQ.nextval, '아직이요',sysdate-8,1,'carrot3',chat_room_c_room_no_seq.currval);
insert into chat_contents(c_content_no, c_content,send_time,c_read,user_id,c_room_no)
values(chat_contents_c_content_no_SEQ.nextval, '택배거래 가능한가요?',sysdate-8,1,'carrot2',chat_room_c_room_no_seq.currval);
insert into chat_contents(c_content_no, c_content,send_time,c_read,user_id,c_room_no)
values(chat_contents_c_content_no_SEQ.nextval, '아니요, 판매물품 특성상 만나서만 거래 가능합니다',sysdate-8,1,'carrot3',chat_room_c_room_no_seq.currval);
insert into chat_contents(c_content_no, c_content,send_time,c_read,user_id,c_room_no)
values(chat_contents_c_content_no_SEQ.nextval, '아...',sysdate-8,0,'carrot2',chat_room_c_room_no_seq.currval);


insert into chat_room(c_room_no, user_id, p_no) values(chat_room_c_room_no_seq.nextval,'carrot7', 'carrot4', 4);
-- buyer='carrot7', p_no=4 // seller='carrot4'
insert into chat_contents(c_content_no, c_content,send_time,c_read,user_id,c_room_no)
values(chat_contents_c_content_no_SEQ.nextval, '거래가능한가요?',sysdate-7,1,'carrot7',chat_room_c_room_no_seq.currval);
insert into chat_contents(c_content_no, c_content,send_time,c_read,user_id,c_room_no)
values(chat_contents_c_content_no_SEQ.nextval, '네 아직 판매중입니다.',sysdate-7,1,'carrot4',chat_room_c_room_no_seq.currval);
insert into chat_contents(c_content_no, c_content,send_time,c_read,user_id,c_room_no)
values(chat_contents_c_content_no_SEQ.nextval, '하나만도 구매가능한가요?',sysdate-7,0,'carrot4',chat_room_c_room_no_seq.currval);

/*
insert into chat_room(c_room_no, user_id, p_no) values(chat_room_c_room_no_seq.nextval, 'carrot5', 1);
insert into chat_room(c_room_no, user_id, p_no) values(chat_room_c_room_no_seq.nextval, 'carrot2', 2);
insert into chat_room(c_room_no, user_id, p_no) values(chat_room_c_room_no_seq.nextval, 'carrot3', 2);
insert into chat_room(c_room_no, user_id, p_no) values(chat_room_c_room_no_seq.nextval, 'carrot4', 2);
insert into chat_room(c_room_no, user_id, p_no) values(chat_room_c_room_no_seq.nextval, 'carrot3', 3);
insert into chat_room(c_room_no, user_id, p_no) values(chat_room_c_room_no_seq.nextval, 'carrot4', 3);
insert into chat_room(c_room_no, user_id, p_no) values(chat_room_c_room_no_seq.nextval, 'carrot5', 3);
insert into chat_room(c_room_no, user_id, p_no) values(chat_room_c_room_no_seq.nextval, 'carrot5', 4);
insert into chat_room(c_room_no, user_id, p_no) values(chat_room_c_room_no_seq.nextval, 'carrot6', 4);
insert into chat_room(c_room_no, user_id, p_no) values(chat_room_c_room_no_seq.nextval, 'carrot6', 5);
insert into chat_room(c_room_no, user_id, p_no) values(chat_room_c_room_no_seq.nextval, 'carrot7', 5);
insert into chat_room(c_room_no, user_id, p_no) values(chat_room_c_room_no_seq.nextval, 'carrot8', 5);
insert into chat_room(c_room_no, user_id, p_no) values(chat_room_c_room_no_seq.nextval, 'carrot1', 6);
insert into chat_room(c_room_no, user_id, p_no) values(chat_room_c_room_no_seq.nextval, 'carrot2', 6);
insert into chat_room(c_room_no, user_id, p_no) values(chat_room_c_room_no_seq.nextval, 'carrot1', 7);
insert into chat_room(c_room_no, user_id, p_no) values(chat_room_c_room_no_seq.nextval, 'carrot3', 7);
insert into chat_room(c_room_no, user_id, p_no) values(chat_room_c_room_no_seq.nextval, 'carrot5', 7);
*/
/* [chat_contents] ******************/
desc chat_contents;
select * from address where user_id='carrot4';
/*
이름           널?       유형            
------------ -------- ------------- 
C_CONTENT_NO NOT NULL NUMBER(10)    
C_CONTENT             VARCHAR2(100) 
SEND_TIME             DATE          
C_READ                NUMBER(10)    
USER_ID               VARCHAR2(10)  
C_ROOM_NO             NUMBER(10)  
*/


/*
select * from chat_contents cc
join chat_room cr
on cc.c_room_no=cr.c_room_no
join product p
on cr.p_no=p.p_no
order by c_content_no asc
;
*/