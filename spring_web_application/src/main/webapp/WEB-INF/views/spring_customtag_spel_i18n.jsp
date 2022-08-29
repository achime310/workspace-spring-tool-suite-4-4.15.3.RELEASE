<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Spring I18N[Internationalization]국제화</h1><hr>
<xmp>
	1. application-config.xml에 MessageSource빈설정
	 <bean id="messageSource" class="org.springframework.context.support.ResourceBundleMessageSource">
    	<property name="basenames" value="messages/guest,messages/messages,messages/user"/>
     </bean>
</xmp>
<ol>
	<li></li>
	<li></li>
	<!-- 
		<< user_ko.properties>>
		exception.userexisted={0} 사용자가 존재합니다..!!
		<< user_en.properties>>
		exception.userexisted = {0} user existed...!!
	 -->
	<li></li>
	<li></li>
	<!-- 
	<< user_ko.properties>>
		nv.bc=홈 < {0} < {1}
	<< user_en.properties>>
		nv.bc=HOME < {0} < {1}
	 -->
	 <li></li> 
	 <li></li> 
	 <li>Spring Container에 등록된 MessageSource 빈객체를 @를 이용해서 JSP에서직접호출</li>
	 <li></li>
	 <li></li> 
	 <li>
	 <li>Controller에서 생성한 메세지:</li>
	 <li>Service에서 생성한 메세지:</li>
</ol>

</body>
</html>