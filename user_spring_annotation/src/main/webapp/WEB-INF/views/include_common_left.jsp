<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
 --%>
<p>
	<!-- <strong><s:message code="menu.title" /></strong> -->
	<strong><a href="user_main">user_spring_annotation</strong>
</p>
<ul>
	<c:if test="${sUserId!=null}">
		<li><a href="">${sUserId } 님</a></li>
		<li><a href="user_view">내정보</a></li>
		<li><a href="user_logout_action">로그아웃</a></li>
	</c:if>
	<c:if test="${empty sUserId }">
		<li><a href="user_login_form">로그인</a></li>
		<li><a href="user_write_form">회원가입</a></li>
	</c:if>
</ul>