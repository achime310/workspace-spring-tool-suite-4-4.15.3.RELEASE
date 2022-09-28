<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>사용자 관리</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet href="css/styles.css" type="text/css">
<link rel=stylesheet href="css/user.css" type="text/css">
<style type="text/css">
/*****************form validator css추가************/
	input.error,textarea.error{
		border: 1px solid red;
	}
	label.error{
		margin-left:10px;
		color:orange;
	}
	.valid{
		border: 1px solid green;
	}
</style>

<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/jquery.validate.js"></script>
<script type="text/javascript" src="js/UserHtmlContents.js"></script>
<script type="text/javascript">
    $(function() {
	/* validator객체변수선언 */
	var validator = null;
	/*validator객체 디폴트속성 설정*/
	$.validator.setDefaults({
	    rules : {
			userId : {
			    required : true,
			},
			password : {
			    required : true
			},
			password2 : {
			    required : true,
			    equalTo : "#password"
			},
			name : {
			    required : true,
			},
			email : {
			    required : true,
			    email : true
			}

	    },
	    messages:{
			userId : {
			    required: '아이디를 입력하세요'
			},
		  	password : {
		  	  	required: '패쓰워드를 입력하세요'
			},
			password2 : {
			    required : '패쓰워드확인을 입력하세요',
			    equalTo:'패쓰워드와 패쓰워드확인은 일치하여야 합니다'
			},
			name : {
			    required : '이름을 입력하세요'
			},
			email : {
			    required : '이메일을 입력하세요',
			    email : '이메일형식이 일치하지않습니다.'
			}
		},
		errorClass : 'error',
	    validClass : 'valid'
	});
	
	/************로딩시세션체크해서UI선택******************/
	$.ajax({
		url:'user_session_check_json',
		method:'POST',
		dataType:'json',
		success:function(jsonResult){
		    if(jsonResult.code==1){
			 	$('#navigation').html(UserHtmlContents.user_left_menu_login_content(jsonResult.data[0]));
				$('#content').html(UserHtmlContents.user_main_content());
		    }else if(jsonResult.code==2){
				$('#navigation').html(UserHtmlContents.user_left_menu_logout_content());
				$('#content').html(UserHtmlContents.user_main_content());
		    }
		   
		}
	});
	
	/****************user_logout******************/
	$(document).on('click', '#a_user_logout_action', function(e) {
	    $.ajax({
			url:'user_logout_action_json',
			method:'POST',
			dataType:'json',
			success:function(jsonResult){
			    $('#navigation').html(UserHtmlContents.user_left_menu_logout_content());
				$('#content').html(UserHtmlContents.user_main_content());
			}
		});
	   e.preventDefault();
	});
	/****************user_view******************/
	$(document).on('click', '#a_user_view',function(e){
	    $.ajax({
			url:'user_view_json',
			method:'POST',
			dataType:'json',
			success:function(jsonResult){
			    $('#content').html(UserHtmlContents.user_view_content(jsonResult.data[0]));
			}
		});
	    
	    e.preventDefault();
	});
	/****************user_modify_form******************/
	$(document).on('click', '#btn_user_modify_form',function(e){
	    $.ajax({
			url:'user_modify_form_json',
			method:'POST',
			dataType:'json',
			success:function(jsonResult){
			    $('#content').html(UserHtmlContents.user_modify_form_content(jsonResult.data[0]));
			    validator=$('#user_modify_form').validate();
			    
			}
		});
	    
	    e.preventDefault();
	});
	/****************user_modify_action******************/
	$(document).on('click',	'#btn_user_modify_action',function(e) {
	    if(validator.form()){
		    var param = $('#user_modify_form').serialize();
		    $.ajax({
				url : 'user_modify_action_json',
				method : 'POST',
				dataType : 'json',
				data : param,
				success : function(jsonResult) {
				    if (jsonResult.code == 1) {
					 	$('#content').html(UserHtmlContents.user_view_content(jsonResult.data[0]));
				    } else if (jsonResult.code == 2) {
						
				    }
				    console.log(jsonResult);
				}
		    });
	    }    
		e.preventDefault();
	});
	/****************user_remove_action******************/
	$(document).on('click',	'#btn_user_remove_action',function(e) {
	    $.ajax({
			url : 'user_remove_action_json',
			method : 'POST',
			dataType : 'json',
			success : function(jsonResult) {
			    if (jsonResult.code == 1) {
				 	$('#navigation').html(UserHtmlContents.user_left_menu_logout_content());
					$('#content').html(UserHtmlContents.user_main_content());
			    } else if (jsonResult.code == 2) {
					
			    }
			    console.log(jsonResult);
			}
	    });
		e.preventDefault();
	});
	
	/****************user_main******************/
	$(document).on('click', '#a_user_main', function(e) {
	    $('#content').html(UserHtmlContents.user_main_content());
	    e.preventDefault();
	});
	/****************user_login_form******************/
	$(document).on('click', '#a_user_login_form', function(e) {
	    $('#content').html(UserHtmlContents.user_login_form_content());
	    
	    validator=$('#user_login_form').validate();
	    e.preventDefault();
	});
	/****************user_write_form******************/
	$(document).on('click', '#a_user_write_form,#btn_user_write_form', function(e) {
	    $('#content').html(UserHtmlContents.user_write_form_content());
	    validator=$('#user_write_form').validate({
			rules:{
			    userId : {
				    required : true,
				    remote : {
						url : "user_id_check_json",
						dataType:'json',
						method:'post',
						data : {
							    userId : function() {
									return $("[name='userId']").val();
							    }
					}
				  }
				}
			    
			},
			messages:{
				userId : {
			    	remote: jQuery.validator.format("{0} 는 이미사용중인 아이디입니다.")
			  	}
			}
		
	    });
	    e.preventDefault();
	});
	/****************user_write_action******************/
	$(document).on('click',	'#btn_user_write_action',function(e) {
	    if(validator.form()){
		    var param = $('#user_write_form').serialize();
		    $.ajax({
				url : 'user_write_action_json',
				method : 'POST',
				dataType : 'json',
				data : param,
				success : function(jsonResult) {
				    if (jsonResult.code == 1) {
						$('#content').html(UserHtmlContents.user_login_form_content());
				    } else if (jsonResult.code == 2) {
						$('#msg1').html(jsonResult.msg);
				    }
				    console.log(jsonResult);
				}
		    });
	    }    
		e.preventDefault();
	});
	$(document).on('click', '#btn_user_login_action', function(e) {
	    if(validator.form()){
		   var param = $('#user_login_form').serialize();
		   $('#msg1').html("");
		   $('#msg2').html("");
			$.ajax({
				url:'user_login_action_json',
				method:'POST',
				dataType:'json',
				data:param,
				success:function(jsonResult){
				    if (jsonResult.code == 0) {
						console.log(jsonResult);
						$('#msg1').html(jsonResult.msg);
				    }else if (jsonResult.code == 1) {
						console.log(jsonResult);
						$('#msg2').html(jsonResult.msg);
				    }else if (jsonResult.code == 2) {
						$('#navigation').html(UserHtmlContents.user_left_menu_login_content(jsonResult.data[0]));
						$('#content').html(UserHtmlContents.user_main_content());
				    }
				}
			});
	    }
	    e.preventDefault();
	});
    });
</script>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0
	marginwidth=0 marginheight=0>
	<!-- container start-->
	<div id="container">
		<!-- header start -->
		<div id="header">
			<!-- include_common_top.jsp start-->
			<h1>
				<a href="">USER_SPRING_JQUERY</a>
			</h1>
			<!-- include_common_top.jsp end-->
		</div>
		<!-- header end -->
		<!-- navigation start-->
		<div id="navigation">
			<!-- include_common_left.jsp start-->
			<p>
				<strong>메뉴</strong>
			</p>
			<ul>
				<li><a href="user_main" id="a_user_main">회원홈</a></li>
				<li><a href="user_login_form" id="a_user_login_form">로그인</a></li>
				<li><a href="user_write_form" id="a_user_write_form">회원가입</a></li>
			</ul>
			<!-- include_common_left.jsp end-->
		</div>
		<!-- navigation end-->
		<!-- wrapper start -->
		<div id="wrapper">
			<!-- content start -->
			<!-- include_content.jsp start-->
			<div id="content">
				<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"
					codebase="http://active.macromedia.com/flash4/cabs/swflash.cab#version=4,0,0,0"
					width="540px" height="350px">
					<param name="movie" value="image/FI_main.swf">
					<param name="play" value="true">
					<param name="loop" value="true">
					<param name="quality" value="high">
					<embed src="image/enter.png" scale="exactfit" play="true"
						loop="true" quality="high" style="margin: 10px;"
						pluginspage="http://www.macromedia.com/shockwave/download/index.cgi?P1_Prod_Version=ShockwaveFlash"
						width="540px" height="350px"></embed>
				</object>
			</div>
			<!-- include_content.jsp end-->
			<!-- content end -->
		</div>
		<!--wrapper end-->
		<div id="footer">
			<!-- include_common_bottom.jsp start-->
			<p align="center">Copyright (&copy;) By Kimkyoungho.[김경호] All
				rights reserved.</p>
			<!-- include_common_bottom.jsp end-->
		</div>
	</div>
	<!--container end-->
</body>
</html>
