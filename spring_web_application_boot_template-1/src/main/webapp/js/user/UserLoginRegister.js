$(function() {
		/* login_check ***********************/
		$.ajax({
			url:'user_session_check_json',
			method:'POST',
			dataType:'json',
			success:function(jsonResult){
			    if(jsonResult.code==1){
			    	$(".account-area").html(UserHtmlContents.user_thumbnail());
			    }else if (jsonResult.code==2) {
			    	$(".account-area").html(UserHtmlContents.user_thumbnail_login(jsonResult.data[0]));
				}
			}
		});
		/*************************************/
		

		/* validator객체변수선언 */
		var validator = null;
		/*validator객체 디폴트속성 설정*/
	/* 	 validator=$('#user_write_form').validate({
				rules:{
				    user_id : {
					    required : true,
					    remote : {
							url : "user_id_check_json",
							dataType:'json',
							method:'post',
							data : {
								    user_id : function() {
										//return $("[name='user_id']").val();
										return $("#user_id").val();
								    }
						}
					  }
					}
				    
				},
				messages:{
					user_id : {
				    	remote: jQuery.validator.format("{0} 는 이미사용중인 아이디입니다.")
				  	}
				}
		 }); */
		 
		 $(document).on("click", "#address_name",function(e){
		/**********************************************************/
			console.log('click!! - #address_name');
		    	// 주소-좌표 변환 객체를 생성합니다
		    	var geocoder = new kakao.maps.services.Geocoder();
				
				// HTML5의 geolocation으로 사용할 수 있는지 확인합니다 
				if (navigator.geolocation) {
				    
				    // ***GeoLocation을 이용해서 접속 위치를 얻어옵니다
				    navigator.geolocation.getCurrentPosition(function(position) {
				        
				        var lat = position.coords.latitude, // 위도
				            lon = position.coords.longitude; // 경도
				        
				        var locPosition = new kakao.maps.LatLng(lat, lon), // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성합니다
				            message = '<div style="padding:5px;">여기에 계신가요?!</div>'; // 인포윈도우에 표시될 내용입니다
				        
				            console.log("locPosition: "+locPosition.getLat(),locPosition.getLng());
				            console.log(message);
							$("#address_lat").val(lat);
							$("#address_lng").val(lon);
							
							/*좌표->주소 변환*********************************************************/
							 searchDetailAddrFromCoords(locPosition, function(result, status) {
							 if (status === kakao.maps.services.Status.OK) {
							    	//console.log('도로명주소 : ' + result[0].road_address.address_name);
							    	//console.log('지번 주소 : ' + result[0].address.address_name);
							            var detailAddr = !!result[0].road_address ? result[0].road_address.address_name  : '';
							           		 detailAddr += result[0].address.address_name;
							            
							           		//주소를 동까지만 자릅니다.
							           		subStr = detailAddr.lastIndexOf(" ");
							           		detailAddr=detailAddr.substring(0,subStr);
										$("#address_name").val(detailAddr);
							        }
							 });
							/**********************************************************/
				      });
				} else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다
				    
				    var locPosition = new kakao.maps.LatLng(33.450701, 126.570667),    
				        message = 'geolocation을 사용할수 없어요..'
						$("#address_name").val(message);
				}
				/*좌표->주소 변환*********************************************************/
				function searchAddrFromCoords(coords, callback) {
				    // 좌표로 행정동 주소 정보를 요청합니다
				    geocoder.coord2RegionCode(coords.getLng(), coords.getLat(), callback);         
				}
				function searchDetailAddrFromCoords(coords, callback) {
				    // 좌표로 법정동 상세 주소 정보를 요청합니다
				    geocoder.coord2Address(coords.getLng(), coords.getLat(), callback);
				}
		/**********************************************************/
			 
		 });
		 
		/************ save_login_data -> Cookie에 id저장(노골적 저장중..) ***********************/
		var cookie_user_id=getLogin();	//Cookie값 가져오기
		/* Cookie값 존재시, id에 Cookie에서 가져온 id할당 -> 체크박스 상태 체크로 변경*/
		if(cookie_user_id){
			$("#login_user_id").val(cookie_user_id);
			$("customChe").attr("checked",true);
		}
		/* id저장 체크시 */
		$("#customChe").on("click",function(){
			var _this = this;
			var isRemember;
			if($(_this).is(":checked")){
				isRemember = confirm("이 PC에 로그인 정보를 저장하시겠습니까? PC방등의 공공장소에서는 개인정보가 유출될 수 있으니 주의해주십시오.");
				if(!isRemember){ $(_this).attr("checked",false); }
			}
		});
		/* 로그인 버튼 클릭시 -> login_action에 기술*/
		/* 로그인 정보 저장 */
		function saveLogin(id){
			if(id != ""){
				setSave("user_id",id,7);
			}else {
				setSave("user_id",id,-1);
			}
		}
		/* Cookie에 user_id 저장 */
		function setSave(name, value, expiredays){
			var today=new Date();
			today.setDate(today.getDate()+expiredays);
			document.cookie=name+"="+escape(value)+";path=/;expires="+today.toGMTString()+";"
		}
		/* Cookie값 가져오기 */
		function getLogin(){
			var cook = document.cookie+";";
			var idx = cook.indexOf("user_id",0);
			var val = "";
			
			if(idx!=-1){
				cook = cook.substring(idx, cook.length);
				begin = cook.indexOf("=",0)+1;
				end = cook.indexOf(";",begin);
				val = unescape(cook.substring(begin,end));
			}
			return val;
		}
		/*****************************************/
		 
		/* user_login_action ************************************/
		$(document).on("click", "#btn_user_login_action",function(e){
			if ($("#login_user_id").val() == "") {
				alert("사용자 아이디를 입력하십시요.");
				$("#login_user_id").focus();
				return;
			}
			if ($("#login_user_pw").val() == "") {
				alert("비밀번호를 입력하십시요.");
				$("#login_user_pw").focus();
				return;
			}
			   $('#msg1').html("");
			   $('#msg2').html("");
			   /* 로그인 정보 저장 */
			   if($("#customChe").is(":checked")){	//저장 체크시
				   saveLogin($("#login_user_id").val());
			   }else {	//체크 해제시
					saveLogin("");
				}
			   
			   console.log($('#user_login_form').serialize());
				$.ajax({
					url:'user_login_action_json',
					method:'POST',
					dataType:'json',
					data:$('#user_login_form').serialize(),
					success:function(jsonResult){
					    if (jsonResult.code == 0) {
							console.log(jsonResult);
							$('#msg1').html(jsonResult.msg);
					    }else if (jsonResult.code == 1) {
							console.log(jsonResult);
							$('#msg2').html(jsonResult.msg);
					    }else if (jsonResult.code == 2) {
					    	
					    	location.href = "user_my_account";	//(수정필요)main으로 보내야 할듯
					    }
					}
				});
			e.preventDefault();
		});
		
		/****************user_write_action******************/
		$(document).on('click',	'#btn_user_write_action',function(e) {
		    console.log('click!! - #btn_user_write_action');
		    /************ 유효성체크 ************/
			if ($("#user_id").val() == "") {
				alert("사용자 아이디를 입력하십시요.");
				$("#user_id").val().focus();
				return false;
			}
			if ($("#user_pw").val() == "") {
				alert("비밀번호를 입력하십시요.");
				$("#user_pw").focus();
				return false;
			}
			if ($("#user_pw2").val() == "") {
				alert("비밀번호확인을 입력하십시요.");
				$("#user_pw2").focus();
				return false;
			}
			if ($("#user_name").val() == "") {
				alert("이름을 입력하십시요.");
				$("#user_name").focus();
				return false;
			}
			if ($("#user_email").val() == "") {
				alert("이메일 주소를 입력하십시요.");
				$("#user_email").focus();
				return false;
			}
			if ($("#user_pw").val() != $("#user_pw2").val()) {
				alert("비밀번호와 비밀번호확인은 일치하여야합니다.");
				$("#user_pw").focus();
				$("#user_pw").select();
				return false;
			}
		    //if(validator.form()){
			    $.ajax({
					url : 'user_write_action_json',
					method : 'POST',
					dataType : 'json',
					data : $('#user_write_form').serialize(),
					success : function(jsonResult) {
					    if (jsonResult.code == 1) {
							//회원가입 부분 clear
							$('#user_write_form')[0].reset();
							$('#msg1').html("회원가입성공! 로그인해보세요!");
							$("#login_user_id").focus();
							
					     console.log(">>>>>>> 성공!!:"+jsonResult.msg);
					    } else if (jsonResult.code == 2) {
							$('#msg3').html(jsonResult.msg);
					    }
					    console.log(jsonResult);
					}
			    });
		    //}    
			e.preventDefault();
		});
		
	});
	/*************************************************/
	