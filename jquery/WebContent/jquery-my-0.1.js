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
				for(var i=0; i< this.elementNodeList.length; i++){
					//this.elementNodeList[i].innerHTML=textArg;
					this.elementNodeList[i].firstChild.nodeValue=textArg;
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
	}else if(typeof arg =='object'){
		/*
		표준객체(Element,document,window,...)
		*/
	}
	
};

/*******jQuery global function*************/
window.jQuery.each=function(array,funcArg){
	for(var i=0; i<array.length;i++){
		funcArg(i,array[i]);
	}											
};

window.$=window.jQuery;	//대부분 $로 사용