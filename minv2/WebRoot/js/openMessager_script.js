// JavaScript Document 自定义js文件
//弹出式提示框start    进入页面右下角上升出现消息提示对话框
	$(function(){
		setTimeout("openMsg()",1000)
	})
	function openMsg(){
	$.messager.lays(250, 140);
	$.messager.show(0,'<ul><li><a href="javascript:openWin()"><span class="icon_lightOn">系统消息：3条</span></a></li><div class="clear"></div>'+
	'<li><a href="javascript:openWin()"><span class="icon_lightOn">公共消息：10条</span></a></li><div class="clear"></div>'+
	'<li><a href="javascript:openWin()"><span class="icon_lightOn">私人消息：5条</span></a></li><div class="clear"></div>'+
	'<li><a href="javascript:openWin()"><span class="icon_lightOn">未读消息：15条</span></a></li><div class="clear"></div></ul>','stay');
	}
	function openWin(){
		alert(1);
		top.Dialog.open({URL:"templete/msgBox.html",Title:"信件箱"});
	}
//弹出式提示框end
	