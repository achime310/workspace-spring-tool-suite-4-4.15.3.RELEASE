<%@page import="com.itwill.user.User"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	int code = 0;
	String url = "";
	String msg = "";
	StringBuffer jsonData = new StringBuffer();
	if(request.getMethod().equalsIgnoreCase("GET")){
		code=2;
		url="guest_main";
		msg="잘못된요청방식입니다.";
		jsonData.append("{");
		jsonData.append("\"msg\":\"\"");
		jsonData.append("},{");
		jsonData.append("\"userId\":\"\",");
		jsonData.append("\"password\":\"\",");
		jsonData.append("\"name\":\"\",");
		jsonData.append("\"email\":\"\"");
		jsonData.append("}");
		code=1;
		msg=" ";
	}else{
		String msgStr=(String)request.getAttribute("msg");	// [user_write_action]에서 forwarding하면, [user_write_action]와 request-response객체가 동일
		User fUser = (User)request.getAttribute("fuser");
		if(msgStr == null) msgStr="";
		if(fUser == null) fUser=new User("","","","");
		
		System.out.println("*********jQuery Ajax요청정보(user_write_form_json.jsp)*********");
		System.out.println("1.jQuery Ajax요청방식    :" + request.getMethod());
		System.out.println("2.jQuery Ajax요청파라메타:" + fUser);
		System.out.println("3.jQuery Ajax요청파라메타:" + msgStr);
		System.out.println("************************************************************");
  		/*
  			private String userId;
			private String password;
			private String name;
			private String email;
  		*/
		jsonData.append("{");
		jsonData.append("\"msg\":\"" + msgStr + "\"");
		jsonData.append("},{");
		jsonData.append("\"userId\":\"" + fUser.getUserId() + "\",");
		jsonData.append("\"password\":\"" + fUser.getPassword() + "\",");
		jsonData.append("\"name\":\"" + fUser.getName() + "\",");
		jsonData.append("\"email\":\"" + fUser.getEmail() + "\"");
		jsonData.append("}");
		code=1;
		msg="";
	}
%>
{
	"code":"1",
	"url":"user_write_form",
	"msg":"메세지",
	"data":[<%=jsonData.toString()%>]
}