//2015-8-17鍞愬�  楠岃瘉娣诲姞銆佷慨鏀归儴闂�
/*function checkDepart(){
	var dname = $.trim($("#_departName").val());
	var py = $.trim($("#_py").val());
	if(dname==null || dname.length==0){
		top.Dialog.alert("閮ㄩ棬鍚嶇О涓嶈兘涓虹┖");
		return false;
	}
	if(py==null || py.length==0){
		top.Dialog.alert("閮ㄩ棬鎷奸煶涓嶈兘涓虹┖");
		return false;
	}
	return true;
}*/

$(function(){
	$("#py").keyup(function(){
		for ( var int = 1; int <= $(this).val().length; int++) {
			if($(this).val().substring($(this).val().length-1)<'a' || $(this).val().substring($(this).val().length-1)>'z')
			{
				$("#checkpy").text("请填写小写字母!!");
			break;
			}
		}
		
	});
	$("#py").blur(function(){
		var flag=true;
		for ( var int = 1; int <= $(this).val().length; int++) {
			if($(this).val().substring($(this).val().length-1-i)>='a' && $(this).val().substring($(this).val().length-1-i)<='z')
			{
				$("#checkpy").text("");
			}else{
				$("#checkpy").text("请填写小写字母!!");
				break;
			}
		}
	});	
});