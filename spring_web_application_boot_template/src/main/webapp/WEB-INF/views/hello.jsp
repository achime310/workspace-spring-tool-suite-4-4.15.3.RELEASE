<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>hello.jsp</h4>
<ol>
<c:forEach items="${helloList}" var="hello">

<li>
${hello}
</li>

</c:forEach>
<hr/>
${helloList }

</ol>
<hr/>
<a href="index.jsp">돌아가기</a>
</body>
</html>