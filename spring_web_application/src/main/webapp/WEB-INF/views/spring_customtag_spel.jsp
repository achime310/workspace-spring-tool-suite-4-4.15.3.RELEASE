<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="http://www.springframework.org/tags"%>
<%--
	request.setAttribute("price0", 123456);
	request.setAttribute("name0", "seo-young");
	request.setAttribute("married1", true);

	request.setAttribute("price1", 987456);
	request.setAttribute("name1", "young-seo");
	request.setAttribute("price2", 852963);
	request.setAttribute("name2", "choi");
	request.setAttribute("married2", false);
	request.setAttribute("guest",
			new Guest(1, "영서", "2022/08/31", "zero@dot.com", "zero.com","오늘은 수요일",
					"Spring Custom Tag,SPEL에 대해 공부합니다."));
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body >
<h1>Spring CustomTag ,SPEL</h1><hr/>
<p>
	- Spring CustomTag : Spring에서 정의한태그<br>
	- SPEL(Spring Expression Language)
	   --> Spring CustomTag(eval) 의 속성(expression)안에서 사용가능한 표현언어(식)
</p>
<ul>
	<li>문자열리터럴(EL): &dollar;{'KIM'.replace('K','N')}</li>
	<li>문자열리터럴(SPEL):<s:eval expression="'KIM'.replace('K','N')"></s:eval></li>
<br/>
	<li>숫자리터럴(EL):${123+123}</li>
	<li>숫자리터럴(SPEL):<s:eval expression="123+123"/></li>
<br/>
	<li>논리리터럴(EL):${true}</li>
	<li>논리리터럴(SPEL):<s:eval expression="true"/></li>
<br/>
	<li>변수1(EL String Wrapper):${price0},${name0},
									${price1},${name1},
									${married1}
									</li>
	<li>변수2(EL Bean):${guest.guest_name}, ${guest.guest_email}</li>
<br/>
	<li>
		변수1(SPEL String Wrapper): <s:eval expression="price2"/>,
									<s:eval expression="name2"/>,
									<s:eval expression="married2"/>
	</li>
	<li>
		변수2(SPEL Bean): <s:eval expression="guest.guest_name"/>,
		<s:eval expression="guest.getGuest_email().toUpperCase()"/>,
		<s:eval expression="guest.toString()"/>,
		
	</li>
<br/>
	<li>SPEL + EL(문자열리터럴):
		<s:eval expression="'${name0}'.subString(1)"/> ==
		<s:eval expression="name0.subString(1)"/>
	</li>
	<li>SPEL + EL(숫자리터럴):
		<s:eval expression="${price0}+3455"/>==
		<s:eval expression="price0+3455"/>
	</li>
<br/>
	<li>SPEL(SCOPE객체에 등록된 숫자변수(속성이름)):
		<s:eval expression="price0+price1/9*0.32342"/>
		
	</li>
	<li>SPEL(SCOPE객체에 등록된 문자열변수(속성이름)):
		<s:eval expression="name0.replace('seo','sooooooo').substring(4)"/>
	</li>
<br/>
	<li>EL(SCOPE객체에 등록된 빈객체(DTO):
		${guest.guest_name.subString(0,1) }		
	</li>
	<li>SPEL(SCOPE객체에 등록된 빈객체(DTO):
		<s:eval expression="guest.guest_name.subString(1,3)"/>
		
	</li>
<br/>
	<li>
		클래스생성자호출(EL에서는 호출불가능):<br>
		&dollar;{new java.text.DecimalFormat('###,###.0').format(price1)}
	</li>
	<li>
		클래스생성자호출(SPEL에서는 호출가능):<br>
		<s:eval expression="new java.ext.DecimalFormat('#,###.0').format(price1)"/>
		<br>
		
	</li>
<br/>
	<li>
		@를 이용해서 SpringContainer에 등록된 빈사용가능
		- @elBean:<s:eval expression="@elBean.toString()"/><br/>
		- @elBean.member1:<s:eval expression="@elBean.member1"/><br/>
		- @elBean.printMembers():<s:eval expression="@elBean.printMemebers()"/><br/>
	</li>
</ul>
</body>
</html>