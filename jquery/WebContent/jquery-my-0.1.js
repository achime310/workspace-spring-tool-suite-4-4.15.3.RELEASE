window.jQuery = function(arg) {
	console.log(typeof arg);
	
	if (typeof arg == 'string') {
		var elementNodeList=document.querySelectorAll(arg);
		var jqueryWrapperObject={
			/*********** wrapper객체 **************/
			'elementNodeList':elementNodeList,
			'css':function(propertyName,propertyValue){
				for(var i=0; i< this.elementNodeList.length; i++){
					this.elementNodeList[i].style.cssText+=`${propertyName}:${propertyValue}`;
				}
				//return한 결과를 이 객체로 만들면, 계속 호출 할 수 있다?
				return this;
			},
			'text':function(textArg){
				
				if(textArg==undefined){
					//get text
					var returnText="";
					for(var i=0; i< this.elementNodeList.length; i++){
						//단, 다른 하위 node의 존재는 고려하지 않는다.
						returnText+=this.elementNodeList[i].firstChild.nodeValue;
					}
					//text를 반환해야하므로, wrapper객체를 반환하지 않는다.
					return returnText;
					
				}else{
					//set text
					for(var i=0; i< this.elementNodeList.length; i++){
						//this.elementNodeList[i].innerHTML=textArg;
						this.elementNodeList[i].firstChild.nodeValue=textArg;
					}				
				}
				return this;
			}
			/*************************************/
		};
		return jqueryWrapperObject;
		
	}else if(typeof arg =='function'){
		/*
		인자로 대입된 함수를 DOM트리생성직후에 호출되도록
		window.onload이벤트에 등록
		*/
		window.addEventListener('load',arg);
	}else if(typeof arg =='object'){
		/*
		표준객체(Element,document,window,...)
			-> 각각의 element마다 method를 구분해서 실행가능..
			-> 객체를 넣는 이유는 jQueryObject를 얻기 위함이라고..
		*/
		var elementNodeList =new Array();
		elementNodeList.push(arg);
		var jQueryWrapperObject={
			/*********** wrapper객체 **************/
			'elementNodeList':elementNodeList,
			'css':function(propertyName,propertyValue){
				for(var i=0; i< this.elementNodeList.length; i++){
					this.elementNodeList[i].style.cssText+=`${propertyName}:${propertyValue}`;
				}
				//return한 결과를 이 객체로 만들면, 계속 호출 할 수 있다?
				return this;
			},
			'text':function(textArg){
				
				if(textArg==undefined){
					//get text
					var returnText="";
					for(var i=0; i< this.elementNodeList.length; i++){
						//단, 다른 하위 node의 존재는 고려하지 않는다.
						returnText+=this.elementNodeList[i].firstChild.nodeValue;
					}
					//text를 반환해야하므로, wrapper객체를 반환하지 않는다.
					return returnText;
					
				}else{
					//set text
					for(var i=0; i< this.elementNodeList.length; i++){
						//this.elementNodeList[i].innerHTML=textArg;
						this.elementNodeList[i].firstChild.nodeValue=textArg;
					}				
				}
				return this;
			}
			/*************************************/
		};
		return jQueryWrapperObject;
	}
	
};

/*******jQuery global function*************/
window.jQuery.each=function(array,funcArg){
	for(var i=0; i<array.length;i++){
		funcArg(i,array[i]);
	}											
};

window.$=window.jQuery;	//대부분 $로 사용