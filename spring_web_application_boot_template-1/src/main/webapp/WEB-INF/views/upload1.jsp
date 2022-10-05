<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<style type="text/css">
html {
    height: 100%;
}

body {
    font-family: sans-serif;
    height: 100%;
    margin: 0;
}

.container {
    display: flex;
    height: 100%;
    flex-direction: column;
}

.image-upload {
    flex: 1;
    display: flex;
    flex-direction: column;
    justify-content: center;
}

.button {
    display: flex;
    justify-content: center;
}

label {
    cursor: pointer;
    font-size: 1em;
}

#chooseFile {
    visibility: hidden;
}

.fileContainer {
    display: flex;
    justify-content: center;
    align-items: center;
}

.fileInput {
    display: flex;
    align-items: center;
    border-bottom: solid 2px black;
    width: 60%;
    height: 30px;
}

#fileName {
    margin-left: 5px;
}

.buttonContainer {
    width: 15%;
    display: flex;
    justify-content: center;
    align-items: center;
    margin-left: 10px;
    background-color: black;
    color: white;
    border-radius: 30px;
    padding: 10px;
    font-size: 0.8em;

    cursor: pointer;
}

.image-show {
    z-index: -1;
    display: flex;
    justify-content: center;
    align-items: center;
    /*position: absolute;*/
    width: 100%;
    height: 100%;
}

.img {
    position: absolute;
}
</style>


</head>
<body>

	<!-- <form name="fileForm" action="requestupload1" method="post" accept="image/*" enctype="multipart/form-data"> -->
	<form id="fileForm" name="fileForm" accept="image/*" enctype="multipart/form-data">
		<input type="file" name="file" id="chooseF"/>
		<input type="text" name="src" />
		<input type="button" value="전송" id="submitBtn"/>
		<!-- <input type="button" value="전송" id="submitBtn"/> -->
	</form>
	<br><hr>
	<div class="container">
        <div class="image-upload" id="image-upload">

            <form method="post" enctype="multipart/form-data">
                <div class="button">
                    <label for="chooseFile">
                        👉 CLICK HERE! 👈
                    </label>
                </div>
                <input type="file" id="chooseFile" name="chooseFile" accept="image/*" onchange="loadFile(this)">
            </form>

            <div class="fileContainer">
                <div class="fileInput">
                    <p>FILE NAME: </p>
                    <p id="fileName"></p>
                </div>
                <div class="buttonContainer">
                    <div class="submitButton" id="submitButton">SUBMIT</div>
                </div>
            </div>
        </div>
        <hr>
        <div class="image-show" id="image-show"></div>
    </div>
    
<script type="text/javascript">
	$(function() {
		
		$(document).on('click','#submitBtn',function(e){
			
			console.log(e.target.id);
			
			var formData = new FormData();
			formData.append('file',$('input[type=file]')[0].files[0]);
			
			
			//showImage();
			$.ajax({
				url:'requestupload1_json',
				type:'POST',
				processData:false,	//파일전송시 반드시 false
				contentType:false,
				data: formData
				,
				/*dataType:'json',*/
				success:function(jsonResult){
	
					console.log('성공!!');
					console.log(jsonResult);
				},
				error: function(jsonResult){
					console.log('error!!');
					console.log(jsonResult);
					console.log(jsonResult.code);
				}
			});
			e.preventDefault();
		});
		
		function showImage() { 
			$('#image-show:last-child').css("visibility","visible");
			//$('#image-upload').css("visibility","hidden");
			$('#fileName').text("");
			console.log('showImage() function 실행!!');
		}
		
		//이미지가 업로드 되면
		$(document).on('change','#chooseF',function(e){

			console.log($('#fileForm').serialize());
			
			
			console.log($('input[type=file]')[0].files[0]);	//파일정보
			console.log($('input[type=file]')[0].files[0].name);	//파일이름

			loadFile($('input[type=file]')[0]);	//첫번째 파일 로드
			
			e.preventDefault();
		});
		
		//화면에 load하기 위해 img태그 만들어서 삽입
		function loadFile(input) {
			var file = input.files[0];
			
		    var name = input.files[0].name;

		    var newImage = document.createElement("img");
		    newImage.setAttribute("class", 'img');

		    newImage.src = URL.createObjectURL(file);   

		    newImage.style.width = "70%";
		    newImage.style.height = "70%";
		    //newImage.style.visibility = "hidden";   //버튼을 누르기 전까지는 이미지 숨기기
		    newImage.style.objectFit = "contain";

		    var container = document.getElementById('image-show');
		    container.appendChild(newImage);
		}
		
	});//END
</script> 
<!-- 
<script type="text/javascript">
var submit = document.getElementById('submitButton');
submit.onclick = showImage;     //Submit 버튼 클릭시 이미지 보여주기

function showImage() {
    var newImage = document.getElementById('image-show').lastElementChild;
    newImage.style.visibility = "visible";
    
    document.getElementById('image-upload').style.visibility = 'hidden';

    document.getElementById('fileName').textContent = null;     //기존 파일 이름 지우기
}


function loadFile(input) {
    var file = input.files[0];

    var name = document.getElementById('fileName');
    name.textContent = file.name;

    var newImage = document.createElement("img");
    newImage.setAttribute("class", 'img');

    newImage.src = URL.createObjectURL(file);   

    newImage.style.width = "70%";
    newImage.style.height = "70%";
    newImage.style.visibility = "hidden";   //버튼을 누르기 전까지는 이미지 숨기기
    newImage.style.objectFit = "contain";

    var container = document.getElementById('image-show');
    container.appendChild(newImage);
};
</script>
 -->
</body>
</html>
