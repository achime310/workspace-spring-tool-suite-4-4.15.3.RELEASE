<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>파일 업로드</title>

<!-- javaScript -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<style>
    *{padding:0;margin:0}
    html, body, .wrap{width: 100%;}
    .clear{clear:both;}
    .wrap>.fileBox{padding: 20px;}
    .fileBox input, textarea{width: 100%;}
    .fileBox textarea{resize:none;}
    .fileBox .fileDrop{display: inline-block;width: 700px;height: 75px;border: 1px solid #000;overflow: auto;}
    .fileDrop .fileList .fileName{padding-left: 20px;}
    .fileDrop .fileList .fileSize{padding-right: 20px; float:right;}
</style>
</head>
<body>

	<h3>파일 업로드 POST 요청: Multipart 인코딩</h3>
	<p>
		입력폼의 method를 POST으로 지정하고,<br> enctype 속성의 값을 multipart/form-data로
		설정합니다.
	</p>
	<form id="image_form"  name="image_form" 
		enctype="multipart/form-data">
		사진1: <input type="file" name="files" id="chooseF"><br> 
		<!-- 사진2: <input type="file" name="files"><br> 
		사진3: <input type="file" name="files"><br> 
		사진4: <input type="file" name="files"><br>  -->
		설명:
		<textarea name="description" cols="50" rows="3"></textarea>
		<div id="fileDrop" class="fileDrop" style="width:200px;height:200px;border:1px solid dimgray;"></div>
		<br> <input id="btn_submit" type="submit" value="추가"><br>
	</form>
	<hr>
	<div class="image-show" id="image-show"></div>
<script type="text/javascript">
$(function() {
	var fileList = []; //파일 정보를 담아 둘 배열
	 //드래그앤드랍
    $("#fileDrop").on("dragenter", function(e){
        e.preventDefault();
        e.stopPropagation();
    }).on("dragover", function(e){
        e.preventDefault();
        e.stopPropagation();
        $(this).css("background-color", "#FFD8D8");
    }).on("dragleave", function(e){
        e.preventDefault();
        e.stopPropagation();
        $(this).css("background-color", "#FFF");
    }).on("drop", function(e){
        e.preventDefault();

        var files = e.originalEvent.dataTransfer.files;
        if(files != null && files != undefined){
            var tag = "";
            for(i=0; i<files.length; i++){
                var f = files[i];
                fileList.push(f);
                var fileName = f.name;
                var fileSize = f.size / 1024 / 1024;
                fileSize = fileSize < 1 ? fileSize.toFixed(3) : fileSize.toFixed(1);
                /* 
                tag += 
                        "<div class='fileList'>" +
                            "<span class='fileName' name='files'>"+fileName+"</span>" +
                            "<span class='fileSize'>"+fileSize+" MB</span>" +
                            "<span class='clear'></span>" +
                        "</div>";
                         */
                tag += "<input type='file' name='files' id='chooseF'>"+fileName;
            }
            console.log($(this));
            //$(this).append(tag);
            $('#image_form').prepend(tag);
        }

        $(this).css("background-color", "#FFF");
    });
	
		
	$(document).on('submit', '#image_form',function(e){
		console.log(e.target.id);
		console.log(1111);
		//const formData = new FormData($('#image_form')[0]);
		//formData.append('attachment', $('[name="files"]').files[0]);
		const formData = new FormData($('#image_form')[0]);
		formData.append("files",$('#image_form')[0]);
		console.log(2222);
		 $.ajax({
			url:'upload',
			type:'POST',
			processData:false,	//파일전송시 반드시 false
			contentType:false,
			data:formData,
			success:function(jsonResult){
				 console.log('성공!!');
			}
		 });  
		e.preventDefault();
	   
	});
	
	 function showImage() { 
		$('#image-show:last-child').css("visibility","visible");
		$('#image-upload').css("visibility","hidden");
		$('#fileName').text("");
		console.log('showImage() function 실행!!');
	}
	
	//이미지가 업로드 되면
	$(document).on('change','#chooseF',function(e){

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
	
	
});
</script>
</body>
</html>
