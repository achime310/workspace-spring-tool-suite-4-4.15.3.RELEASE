<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"  %>
<p>
	<strong>메 뉴</strong>
</p>
<ul>
	<li><a href="guest_main">방명록홈</a></li>
	<li><a href="guest_list">방명록리스트</a></li>
	<li><a href="guest_write_form">방명록쓰기폼</a></li>
</ul>
<ul>
	<c:if test="${sUserId!=null}">
		<li><a href='user_view'>정보보기</a></li>
		<li><a href="user_logout_action">로그아웃</a></li>
	</c:if>	
	<c:if test="${empty sUserId }">
		<li><a href="user_login_form">로그인</a></li>
		<li><a href="user_write_form">회원가입</a></li>
	</c:if>
</ul>