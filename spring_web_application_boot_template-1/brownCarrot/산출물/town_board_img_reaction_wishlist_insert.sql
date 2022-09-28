--#############[town_board],[town_img],[town_reaction]
desc town_board;
desc town_img;
desc town_reaction;
/*
이름         널?       유형             
---------- -------- -------------- 
T_NO       NOT NULL NUMBER(10)     
T_TITLE             VARCHAR2(300)  
T_CONTENT           VARCHAR2(1000) 
T_DATE              DATE           
T_COUNT             NUMBER(10)     
T_CTGR_NO           NUMBER(10)     
ADDRESS_NO          NUMBER(10) 
*/
--****** 3개의 table에 insert를 각각 하는 경우
--[town_board]carrot4, 역삼동, 동네소식
insert into town_board(t_no, t_title, t_content, t_date, t_count, t_ctgr_no,address_no)
values(TOWN_BOARD_T_NO_SEQ.nextval, '날씨가 좋아요~','바람도 불고 시원하고 걷기 좋은 날씨에요~',sysdate-6,10,1,8);
--[town_img]
insert into town_img(t_img_no, t_img_name, t_no) values(TOWN_IMG_T_IMG_NO_SEQ.nextval,'날씨가좋아요.jpg',1);
--[town_reaction]
insert into town_reaction(t_reac_no,t_reac_type,t_no,user_id) values(TOWN_REACTION_T_REAC_NO_SEQ.nextval,1,1,'carrot3');
insert into town_reaction(t_reac_no,t_reac_type,t_no,user_id) values(TOWN_REACTION_T_REAC_NO_SEQ.nextval,1,1,'carrot2');
insert into town_reaction(t_reac_no,t_reac_type,t_no,user_id) values(TOWN_REACTION_T_REAC_NO_SEQ.nextval,1,1,'carrot1');
insert into town_reaction(t_reac_no,t_reac_type,t_no,user_id) values(TOWN_REACTION_T_REAC_NO_SEQ.nextval,4,1,'carrot5');
insert into town_reaction(t_reac_no,t_reac_type,t_no,user_id) values(TOWN_REACTION_T_REAC_NO_SEQ.nextval,4,1,'carrot6');
insert into town_reaction(t_reac_no,t_reac_type,t_no,user_id) values(TOWN_REACTION_T_REAC_NO_SEQ.nextval,4,1,'carrot7');
insert into town_reaction(t_reac_no,t_reac_type,t_no,user_id) values(TOWN_REACTION_T_REAC_NO_SEQ.nextval,4,1,'carrot8');

--****** 3개의 table에 insert를 동시에 하는 경우
--[town_board]carrot7, 서초동, 동네소식
insert into town_board(t_no, t_title, t_content, t_date, t_count, t_ctgr_no,address_no)
values(TOWN_BOARD_T_NO_SEQ.nextval, '미용실 추천해주세요','기분전환 겸 염색하고 싶은데 추천할만한 곳 있을까요?',sysdate-5,10,1,13);
--[town_img]
insert into town_img(t_img_no, t_img_name, t_no) values(TOWN_IMG_T_IMG_NO_SEQ.nextval,'미용실.jpg',TOWN_BOARD_T_NO_SEQ.currval);
--[town_reaction]
insert into town_reaction(t_reac_no,t_reac_type,t_no,user_id) values(TOWN_REACTION_T_REAC_NO_SEQ.nextval,1,TOWN_BOARD_T_NO_SEQ.currval,'carrot1');
insert into town_reaction(t_reac_no,t_reac_type,t_no,user_id) values(TOWN_REACTION_T_REAC_NO_SEQ.nextval,1,TOWN_BOARD_T_NO_SEQ.currval,'carrot2');
insert into town_reaction(t_reac_no,t_reac_type,t_no,user_id) values(TOWN_REACTION_T_REAC_NO_SEQ.nextval,1,TOWN_BOARD_T_NO_SEQ.currval,'carrot3');
insert into town_reaction(t_reac_no,t_reac_type,t_no,user_id) values(TOWN_REACTION_T_REAC_NO_SEQ.nextval,4,TOWN_BOARD_T_NO_SEQ.currval,'carrot4');
insert into town_reaction(t_reac_no,t_reac_type,t_no,user_id) values(TOWN_REACTION_T_REAC_NO_SEQ.nextval,4,TOWN_BOARD_T_NO_SEQ.currval,'carrot5');
insert into town_reaction(t_reac_no,t_reac_type,t_no,user_id) values(TOWN_REACTION_T_REAC_NO_SEQ.nextval,4,TOWN_BOARD_T_NO_SEQ.currval,'carrot6');
insert into town_reaction(t_reac_no,t_reac_type,t_no,user_id) values(TOWN_REACTION_T_REAC_NO_SEQ.nextval,4,TOWN_BOARD_T_NO_SEQ.currval,'carrot8');

--select & join
select * from town_board tb
join address a
on tb.address_no=a.address_no
join town_reaction tr
on tb.t_no=tr.t_no;
-- >>>>image는 1장만 넣을까..? JOIN...
-- >>>> title이 필요한가??? -> 일단은 넣어두는 걸로


--######################[town_wishlist]
desc town_wishlist;

/*
이름      널?       유형           
------- -------- ------------ 
T_WL_NO NOT NULL NUMBER(10)   
USER_ID          VARCHAR2(10) 
T_NO             NUMBER(10) 
*/
select * from town_wishlist;

insert into town_wishlist(t_wl_no,user_id,t_no) values(TOWN_WISHLIST_T_WL_NO_SEQ.nextval,'carrot3',1);
insert into town_wishlist(t_wl_no,user_id,t_no) values(TOWN_WISHLIST_T_WL_NO_SEQ.nextval,'carrot2',1);
insert into town_wishlist(t_wl_no,user_id,t_no) values(TOWN_WISHLIST_T_WL_NO_SEQ.nextval,'carrot1',1);

insert into town_wishlist(t_wl_no,user_id,t_no) values(TOWN_WISHLIST_T_WL_NO_SEQ.nextval,'carrot3',2);
insert into town_wishlist(t_wl_no,user_id,t_no) values(TOWN_WISHLIST_T_WL_NO_SEQ.nextval,'carrot2',2);
insert into town_wishlist(t_wl_no,user_id,t_no) values(TOWN_WISHLIST_T_WL_NO_SEQ.nextval,'carrot1',2);







--######################[town_reply]
--[town_reply] --> 미완료. 은비가 마무리할 예정
desc town_reply;
/*
이름              널?       유형             
--------------- -------- -------------- 
T_REPLY_NO      NOT NULL NUMBER(10)     
T_REPLY_TITLE            VARCHAR2(300)  
T_REPLY_CONTENT          VARCHAR2(1000) 
T_REPLY_DATE             DATE           
GROUPNO                  NUMBER(10)     
STEP                     NUMBER(10)     
DEPTH                    NUMBER(10)     
USER_ID                  VARCHAR2(10)   
T_NO                     NUMBER(10)  
*/
select * from town_board;
insert into town_reply(T_REPLY_NO, T_REPLY_TITLE, T_REPLY_CONTENT,T_REPLY_DATE ,GROUPNO,STEP,DEPTH,user_id, t_no)
values(TOWN_REPLY_T_REPLY_NO_SEQ.nextval,'맞아요~','한강가기 좋은날씨에요~',sysdate-5,1,1,1,'carrot3',1);