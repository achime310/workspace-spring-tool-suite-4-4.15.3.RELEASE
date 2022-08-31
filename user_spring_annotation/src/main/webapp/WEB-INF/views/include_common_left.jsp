<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	boolean isLogin=false;
	String sUserId=(String)session.getAttribute("sUserId");
	if(sUserId==null){
		isLogin=false;
	}else if(sUserId!=null){
		isLogin=true;
	}
%>    			
<p>
	<strong>메 뉴</strong>
</p>
<ul>
	<%if(isLogin){ %>
		<li><a href=''><%=sUserId %>님</a></li>
		<li><a href='user_view'>내정보</a></li>
		<li><a href="user_logout_action">로그아웃</a></li>
	<%}else{ %>
		<li><a href="user_login_form">로그인</a></li>
		<li><a href="user_write_form">회원가입</a></li>
	<%} %>	
</ul>
