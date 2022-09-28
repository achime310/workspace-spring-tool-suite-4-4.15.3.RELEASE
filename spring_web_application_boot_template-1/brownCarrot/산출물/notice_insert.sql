/* [notice] **************************************************/
desc notice;
/*
이름             널?       유형             
-------------- -------- -------------- 
NOTICE_NO      NOT NULL NUMBER(10)     
NOTICE_TITLE            VARCHAR2(100)  
NOTICE_CONTENT          VARCHAR2(1000) 
NOTICE_DATE             DATE           
NOTICE_COUNT            NUMBER(10)  
*/
insert into notice(notice_no,notice_title,notice_content,notice_date,notice_count)
    values(NOTICE_NOTICE_NO_SEQ.nextval,'안녕하세요, 흙당근마켓입니다.');