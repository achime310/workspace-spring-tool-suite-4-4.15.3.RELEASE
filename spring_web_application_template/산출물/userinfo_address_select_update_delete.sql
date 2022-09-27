/************[userinfo],[address]***************/

/*********selectAll*********/
--selectAll_userinfo : 관리자가 회원전체List를 확인
select * from userinfo;

--selectAll_address : 관리자가 회원전체의 address List를 확인
select * from address;

--selectAll_address_userinfo: 관리자가 회원전체의 address와 회원 List를 확인
select * from address a
join userinfo u
on a.user_id=u.user_id;

/*********selectOne*********/
--selectByUserId : 1명의 회원이 회원정보를 확인
select * from userinfo where user_id='carrot3';

--selectByAddressNo : session에 회원이 선택한 본인의 address_no를 넘겨줘서, 그 해당 페이지를 보여줘야 함.
select * from address where address_no=3;

--selectByAddressNo : addressNo로 회원정보까지 확인
select * from userinfo u
join address a
on u.user_id=a.user_id
where a.address_no=3;

/*********selectList*********/
--selectByUserId_AddressAll : 1명의 회원의 주소list를 확인
select * from userinfo u
join address a
on u.user_id=a.user_id
where a.user_id='carrot4';

/*********update*********/
--updateByUserId : 회원 정보 수정
update userinfo set user_pw=222, user_name='이당당', user_email='karrot2@black.com', user_phone='010-2121-2121', user_freshness=37.6, user_point=1100, user_profile='image.jpg'
where user_id='carrot1';

--updateAddressByAddressNo : AddressNo로 회원 주소 수정
update address set address_name='서울특별시 강남구 논현동', address_lat=37.504517146836335, address_lng=127.02448255049796
where address_no=7;

/*********delete*********/
DELETE FROM userinfo where user_id ='';
DELETE FROM address where address_no=;

