
//function AjaxRequest(method, url,params) {
function AjaxRequest(method, url,callbackFunction,params) {
	/*
	1. XMLHttpRequest객체생성
	*/
	this.xhr = new XMLHttpRequest();		
	/*
	2. 요청속성설정 
	*/
	this.method = method;
	this.params = params
	this.url=url;
	
	if(this.method=='GET' &&this.params !=null){
		this.url=this.url+"?"+this.params;
	}
	/*
	3.응답이 도착했을때 실행되는 콜백함수등록(이벤트프로퍼티에함수등록)
	*/

	//this.xhr.onreadystatechange=function(){
	var xhr = this.xhr;
	this.xhr.onload=function(){
		callbackFunction(xhr);// function의 실행주체가 xhr이다. context가 this
	}
	
	/*
	//this.xhr.onload=callbackFunction; 에서 인자받으려고 아래와 같이 기술
	this.xhr.onreadystatechange=function(){
		callbackFunction(this);
	}
	*/
	
	
	//this.xhr.onload=callbackFunction;
	/*
	this.xhr.onload=function () {
		document.querySelector('#newsDiv').innerHTML=xhr.responseText;
	};
	*/
	
	this.xhr.open(this.method,this.url);
	this.xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
	/*
	3.요청
	*/
	this.xhr.send((this.method=='POST')? this.params:null);		
}
