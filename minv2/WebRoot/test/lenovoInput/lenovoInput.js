var msg = new Array("Beijing ", "Tianjing ", "Shanghai ", "Guangdong ",
		"ShanDong ", "Shanxi ", "Hunan ", "Hubei ");
var msg2 = new Array("北京 ", "天津 ", "上海 ", "广东 ", "山东 ", "陕西 ", "湖南 ", "湖北 ");

function showTips(event) {
	
	//做兼容
	event = event || window.event;
	
	obj = event.srcElement || event.target;
	sel.length = 0;
	var re = new RegExp("^" + obj.value, "gi");
	var j = 0;
	for (i = 0; i < msg.length; i++) {
		if (re.test(msg[i]) == true) {
			sel.style.display = '';
			sel.add(new Option(msg[i], msg2[i]));
			j++
		}
	}
	sel.size = (j > 1) ? j : 2;
	
	var keyCode= event.keyCode || event.which;
	if(keyCode ==27)
		c();
}

function enterTips(e) {
	e = event.keyCode ;
	if (sel.style.display != 'none') {
		if (e == 13) {
			event.srcElement.value = sel.value;
			sel.style.display = 'none';
		}
		if (e == 40) {
			sel.focus();
		}
	}
}

function rv() {
	txt.value = sel.value;
	c();
}

function c() {
	sel.style.display = 'none';
	txt.focus();
}
document.onclick = function() {
	c();
}