/************[payment]***************/



/*********insert & update*********/

--###### point 충전
--insert : point 충전
insert into payment values('payment12345ertiujwkdsfg', 'naverpay', 3000, sysdate-5, 'carrot1');
--updatePointByUserinfo : 회원의 point 수정 - 누적
update userinfo set user_point=user_point+3000 where user_id='carrot1';

--###### point 취소
--[결제번호 유지하는 경우]update : point 취소
insert into payment values('payment12345ertiujwkdsfg', 'naverpay', -3000, sysdate-5, 'carrot1');
--[결제번호 바뀌는   경우]insert : point 취소
insert into payment values('payment12345ertiujwkds12', 'naverpay', -3000, sysdate-5, 'carrot1');
--updatePointByUserinfo : 회원의 point 수정 - 누적
update userinfo set user_point=user_point-3000 where user_id='carrot1';



/*********select*********/
--select : 회원의 현재point잔고를 보는 경우
select user_point from userinfo where user_id='carrot1';

--selectByUserId : 회원의 point충전내역 확인
select * from userinfo u
join payment p
on u.user_id=p.user_id
where u.user_id='carrot1';

--selectByPaymentNo : 충전내역의 상세를 보는 경우
select * from payment where payment_no='payment12345ertiujwkdsfg';


/*********delete*********필요한가??*/
delete from payment where payment_no='payment12345ertiujwkds12';