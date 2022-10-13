<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>index</h1>
<<<<<<< HEAD
=======
<!-- <h3><a href="user_main">user_main</a></h3>
<h3><a href="my-account.html">my-account.html</a></h3> -->
>>>>>>> branch 'master' of https://github.com/achime310/workspace-spring-tool-suite-4-4.15.3.RELEASE.git
<img src="images/eunbi.jpg">
<br/><hr><br/>
<h3>테스트 중입니다.</h3>
<br>
<<<<<<< HEAD
<h3><a href="user_login_form">user_login_form</a></h3>
<h3><a href="mail_test.html">mail보내기</a></h3>
<br>

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
        
        <div class="image-show" id="image-show"></div>
    </div>


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

=======
<!-- <h3><a href="user_login_form">user_login_form</a></h3> -->
<h3><a href="image_test.html">image_test.html</a></h3>
<br>
<h3><a href="upload1">upload1</a></h3>
<<<<<<< HEAD
<h3><a href="upload_dragndrop">upload_dragndrop</a></h3>
=======
>>>>>>> branch 'master' of https://github.com/achime310/workspace-spring-tool-suite-4-4.15.3.RELEASE.git
>>>>>>> branch 'master' of https://github.com/achime310/workspace-spring-tool-suite-4-4.15.3.RELEASE.git
</body>
</html>