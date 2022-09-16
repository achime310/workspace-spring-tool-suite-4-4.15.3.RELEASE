function GuestService() {
	
	this.sendRequest=function(method,url,callbackFunction,params) {
		var xhr = new XMLHttpRequest();
		if (method == 'GET' && params != null) {
			url = url + "?" + params;
		}
		xhr.onload=function(){
			callbackFunction(JSON.parse(xhr.responseText));
		};
		xhr.open(method, url);
		xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		xhr.send(method == 'POST' ? params : null);
	}
}

	
	




