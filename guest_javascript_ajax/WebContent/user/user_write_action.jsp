<%@page import="java.net.URLEncoder"%>
<%@page import="com.itwill.user.User"%>
<%@page import="com.itwill.user.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	/*
	0  . GET방식요청일때 user_main.jsp로 redirection
	1  . 요청객체 인코딩설정
	2  . 파라메타 받기
	3  . UserService객체생성
	4  . UserService.create() 메쏘드실행
	5-1. 아이디중복이면 user_write_form.jsp  
	5-2. 가입성공이면   user_login_form.jsp 로 redierction
	*/
	
	if (request.getMethod().equalsIgnoreCase("GET")) {
		response.sendRedirect("user_write_form.jsp");
		return;
	}
	
	//request.setCharacterEncoding("UTF-8");
	
	String userId = request.getParameter("userId");
	String password = request.getParameter("password");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	
	User newUser = new User(userId, password, name, email);
	
	UserService userService = new UserService();
	int result= userService.create(newUser);
	
	//return을 받아서 하는 작업은 멋진 작업이 아니라고 함.
	if(result==-1){
		/*##################아이디중복#################*/
		//메세지를 인코딩한값을 반환
		String msg = userId + " 는 이미 존재하는 아이디입니다.";
		String msgEncoded = URLEncoder.encode(msg,"UTF-8");
		userId = URLEncoder.encode(userId,"UTF-8");
		email = URLEncoder.encode(email,"UTF-8");
		password = URLEncoder.encode(password,"UTF-8");
		name = URLEncoder.encode(name,"UTF-8");
		String queryString = "msg="+msgEncoded+
							"&userId="+userId+
							"&password="+password+
							"&name="+name+
							"&email="+email;
		/************case1 script***************/
/* 		 // 파라메타를 불러와서 넘겨주면된다~
		out.println("<script>");
		out.println("alert('"+msg+"');");
		//뿌린다음에 요청?
		out.println("location.href='user_write_form.jsp?"+queryString+"';");
		out.println("</script>");
		 */
		/***************************************/
		//(예정)데이터를 남겨주는 작업을 할 예정
		/*************case2 redirection*********/
			//redirection에 parameter를 넘겨주는 방법도 있긴함...
			//쿼리스트링에 정보가 다 노출되므로 보안상 위험.
			//요청하고 뿌림
			//response.sendRedirect("user_write_form.jsp?"+queryString);
		 
		/*************case3 forwarding***************/
		request.setAttribute("msg", msg); //msg는 URL에 붙여보낼때는 인코딩하고, msg를 인코딩해서 보내면, 값을 얻은 후 다시 디코딩해야함.
		request.setAttribute("fuser", newUser);
		
		RequestDispatcher rd = request.getRequestDispatcher("user_write_form.jsp");
		rd.forward(request, response);	//요청의 흐름이 "user_write_form.jsp"로 이동
		
		
	}else if(result==1){
		/*##################회원가입성공#################*/
		response.sendRedirect("user_login_form.jsp");
		
	}
	
%>















