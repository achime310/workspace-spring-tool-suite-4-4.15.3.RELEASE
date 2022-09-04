/**
 * 
 */
function userCreateForm() {
	location.href = "user_write_form";
}

function login() {
	if (document.f.userId.value == "") {
		alert("사용자 아이디를 입력하십시요.");
		document.f.userId.focus();
		return false;
	}
	if (document.f.password.value == "") {
		alert("비밀번호를 입력하십시요.");
		document.f.password.focus();
		return false;
	}

	document.f.action = "user_login_action";
	document.method = 'POST';
	document.f.submit();
}

function userCreate() {
	if (document.f.userId.value == "") {
		alert("사용자 아이디를 입력하십시요.");
		f.userId.focus();
		return false;
	}
	if (document.f.password.value == "") {
		alert("비밀번호를 입력하십시요.");
		f.password.focus();
		return false;
	}
	if (document.f.password2.value == "") {
		alert("비밀번호확인을 입력하십시요.");
		f.password2.focus();
		return false;
	}
	if (document.f.name.value == "") {
		alert("이름을 입력하십시요.");
		f.name.focus();
		return false;
	}
	if (document.f.email.value == "") {
		alert("이메일 주소를 입력하십시요.");
		f.email.focus();
		return false;
	}
	if (document.f.password.value != document.f.password2.value) {
		alert("비밀번호와 비밀번호확인은 일치하여야합니다.");
		f.password.focus();
		f.password.select();
		return false;
	}
	document.f.action = "user_write_action";
	document.f.method = 'POST';
	document.f.submit();
}


function userModifyForm() {
	document.f.action = "user_modify_form";
	document.f.submit();
}
function userModifyAction() {
	document.f.action = "user_modify_action";
	document.f.submit();
}

function userRemove() {
	if (confirm("정말 탈퇴하시겠습니까?")) {
		document.f.action = "user_remove_action";
		document.f.submit();
	}
}