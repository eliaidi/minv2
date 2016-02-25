//父窗口方法
$(function(){
	////点击父级输入框，进入父级配件的选择页面
	$("#showParentStoreInfo").click(function(){
		  top.Dialog.open({URL:"findAllPjStoreStaticInfo.action",Title:"选择父级配件",ShowCloseButton:true});
	});
	
	//单选按钮选择事件
	$("#enable").click(function(){
		//判断点击启用状态，拿到的值
		if(this.checked){
			$("#pjActivate").val("1");
		}else{
			$("#pjActivate").val("0");
		}
		
	});
});

//子窗口向父窗口传值得方法
//id : 传入的Id值
//name：传入的Name值
function changeParentStoreStatic(id,name){
	
	$("#showParentStoreInfo").val(name);
	$("#showParentStoreInfoId").val(id);
}

