<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Spring MessageConverter를 사용한 XML,JSON,TEXT 응답</h1><hr>
<ol>
	<li><a href='response_string1'>String response1[MessageConverter]</a></li>
	<li><a href='response_string2'>String response2[MessageConverter]</a></li>
	<br/>
	<li><a href='newsTitleXML'>XML response[MessageConverter]News</a></li>
	<li><a href='newsTitlesListXML'>XML List response[MessageConverter]List</a></li>
	<li><a href='newsTitlesMapXML'>XML response[MessageConverter] Map </a></li>
	<br/>
	<li><a href='newsTitleJson'>JSON <b>News</b> response[MessageConverter] News </a></li>
	<li><a href='newsTitlesListJson'>JSON <b>List</b> response[MessageConverter] List </a></li>
	<li><a href='newsTitlesMapJson'>JSON <b>Map</b> response[MessageConverter] Map </a></li>
</ol>
</body>
</html>