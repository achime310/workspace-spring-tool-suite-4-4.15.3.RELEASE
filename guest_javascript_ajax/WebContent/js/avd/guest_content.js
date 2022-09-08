
function addJavaScript(jsFilePath){
	var headElement = document.getElementsByTagName('head')[0];
	var newScriptElement = document.createElement('script');
	newScriptElement.setAttribute('type','text/javascript');
	newScriptElement.setAttribute('src',jsFilePath);
	headElement.appendChild(newScriptElement);
}
addJavaScript('js/guest_list_content.js');
addJavaScript('js/guest_main_content.js');
addJavaScript('js/guest_modify_form_content.js');
addJavaScript('js/guest_view_content.js');
addJavaScript('js/guest_write_form_content.js');
