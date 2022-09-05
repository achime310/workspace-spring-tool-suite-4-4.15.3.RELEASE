function hello(name, funcArg) {
	document.write(">>> kQuery --> hello(name,funcArg)실행<br>");
	var msg = name + " 님 안녕하세요<br>";
	funcArg(msg);
}
function forEach(array, userCallbackFunction) {
	document.write(">>> kQuery --> forEach(array,userCallbackFunction)실행<br>");
	for (var i = 0; i < array.length; i++) {
		userCallbackFunction(i, array[i]);
	}

}