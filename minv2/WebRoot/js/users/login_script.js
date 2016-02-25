$(function(){
	$('.login_main').center();
})
	
	
// JavaScript Document 自定义js文件
//2015-7-31 唐倩  登录验证
function checkLogin(){
		var uname = $.trim($("#_username").val());
		var pwd = $.trim($("#_password").val());
		if(uname==null || uname.length==0){
			top.Dialog.confirm("用户名不能为空");
			return false;
		}
		if(pwd==null || pwd.length==0){
			top.Dialog.confirm("密码不能为空");
			return false;
		}
		$(".login_info").text("");
		//去掉登录用户名密码中的空格
		$("#_username").val(uname.replace(/[ ]/g,""));
		$("#_password").val(pwd.replace(/[ ]/g,""));
		
		return true;
}	