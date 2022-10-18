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
.drag-over {
	background-color: #ff0;
}

.thumb {
	width: 200px;
	padding: 5px;
	float: left;
}

.thumb>img {
	width: 100%;
}

.thumb>.close {
	position: absolute;
	background-color: red;
	cursor: pointer;
}
</style>
</head>
<body>

	<input type="button" id="btnSubmit" value="업로드" />
	<div id="drop"
		style="border: 1px solid black; width: 800px; height: 300px; padding: 3px">
		여기로 drag & drop
		<div id="thumbnails"></div>
	</div>
	<script>
		var uploadFiles = [];
		var $drop = $("#drop");
		$drop.on("dragenter", function(e) { //드래그 요소가 들어왔을떄 
			$(this).addClass('drag-over');
		}).on("dragleave", function(e) {  //드래그 요소가 나갔을때  
				$(this).removeClass('drag-over');
		}).on("dragover", function(e) { 
			e.stopPropagation();  e.preventDefault();
			}).on('drop', function(e) {  //드래그한 항목을 떨어뜨렸을때
				e.preventDefault(); 
			$(this).removeClass('drag-over'); 
			var files = e.originalEvent.dataTransfer.files;  //드래그&드랍 항목 
			for(var i = 0; i < files.length; i++) {
				var file = files[i];   
				var size = uploadFiles.push(file);  //업로드 목록에 추가 
				preview(file, size - 1);  //미리보기 만들기 
				} 
			});
		function preview(file, idx) { 
			var reader = new FileReader();
			reader.onload = (function(f, idx) { 
				return	function(e) { 
					var div = "<div class='thumb'><div class='close' data-idx=" + idx + ">X</div><img src=" + e.target.result + " title=" + escape(f.name) + "/></div>";  
					$("#thumbnails").append(div);  
					}; 
				})(file, idx); 
			reader.readAsDataURL(file);
			}

					
		$(document).on('click', '#btnSubmit', function(e) {
			console.log(1111);
			
			var formData = new FormData();
			
			$.each(uploadFiles, function(i, file) {
				if(file.upload != 'disable')  //삭제하지 않은 이미지만 업로드 항목으로 추가     
				//formData.append('upload-file', file, file.name); 
				formData.append('files', file); 
			});
			
			
			console.log(2222);
			$.ajax({
				url : 'upload',
				type : 'POST',
				processData : false, //파일전송시 반드시 false
				contentType : false,
				data : formData,
				success : function(jsonResult) {
					console.log('성공!!');
				},
				error : function() {
					console.log('error!!');
				}
			});
			e.preventDefault();

		});
		
		$("#thumbnails").on("click", ".close", function(e) {
			var $target = $(e.target);  var idx = $target.attr('data-idx');
			uploadFiles[idx].upload = 'disable';  //삭제된 항목은 업로드하지 않기 위해 플래그 생성
			$target.parent().remove();  //프리뷰 삭제
		});
			
	</script>
	
</body>
</html>
