//父窗口方法
$(function(){
	//点击父级输入框，进入父级配件的选择页面
	$("#showParentStoreInfo").click(function(){
		  top.Dialog.open({URL:"findAllPjStoreStaticInfo.action",Title:"选择父级配件",ShowCloseButton:true});
	});
});

//子窗口向父窗口传值得方法
//id : 传入的Id值
//name：传入的Name值
function changeParentStoreStatic(id,name){
	
	$("#showParentStoreInfo").val(name);
	$("#showParentStoreInfoId").val(id);
}


//修改时完毕后，表单提交的数据
function formSubmit(){
	//判断点击启用状态，拿到的值
	if($("#enable").attr("checked")){
		$("#enable").val("1");
	}else{
		$("#enable").val("0");
	}
	document.updatePjStoreStaticInfo.submit();
	
}