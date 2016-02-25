$(function(){
	//top.Dialog.close();
	if($("#message").val() !=""  && $("#message").val() !=undefined){
		top.Dialog.alert($("#message").val());
	}
	//当点击查询时，保留原来的查询条件
	var bool = $("#pjdCode").val() != "";
	$("#pjdCodeCkb").attr("checked", bool ? true : false);
	$("#pjdCodeDiv").css("display", bool ? 'inline' : 'none');
	
	//当点击查询时，保留原来的查询条件
	var bool = $("#pjdStatus").val() !="请选择";
	$("#pjdStatusCkb").attr("checked", bool ? true : false);
	$("#pjdStatusDiv").css("display", bool ? 'inline' : 'none');
	
	//当点击查询时，保留原来的查询条件
	var bool = $("#jcTypeId").val() != "请选择";
	$("#dictJcTypeCkb").attr("checked", bool ? true : false);
	$("#dictJcTypeIdDiv").css("display", bool ? 'inline' : 'none');
	
	//复选框添加单击事件
	$("#pjdCodeCkb").click(function(){
		$("#pjdCodeDiv").css("display", this.checked ? 'inline' : 'none');
	});
	
	//复选框添加单击事件
	$("#pjdStatusCkb").click(function(){
		$("#pjdStatusDiv").css("display", this.checked ? 'inline' : 'none');
	});
	
	//复选框添加单击事件
	$("#dictJcTypeCkb").click(function(){
		$("#dictJcTypeIdDiv").css("display", this.checked ? 'inline' : 'none');
	});
	
	//查询按钮跳转路径
	$("#queryFindSDInfo").click(function(){
		var url = "queryPjSDInfoByChooseFixPjForPjFix.action?";
		
		if($("#pjName").val() != ""){
			url +="pjName=" +$("#pjName").val() + "&";
		}
		if($("#pjSSInfoId").val() != ""){
			url +="pjSSInfoId=" +$("#pjSSInfoId").val() + "&";
		}
		//如果配件编码复选框选中
		if ($("#pjdCodeCkb").attr("checked") && $("#pjdCode").val() != "") {
			url += "pjdCode=" + $("#pjdCode").val() + "&";
		}
		
		//如果配件状态复选框选中
		if($("#pjdStatusCkb").attr("checked") && $("#pjdStatus").val() != "请选择") {
			url += "pjdStatus=" + $("#pjdStatus").val() + "&";
		}
		
		//如果车型复选框选中
		if($("#dictJcTypeCkb").attr("checked") && $("#jcTypeId").val() != "请选择") {
			url += "jcTypeId=" + $("#jcTypeId").val() + "&";
		}
		window.location.href=url;
	});
	});
//点击选择按钮检触发的事件
	
function chooseFix(id){
	top.Dialog.confirm("是否检修当前配件？",function(){
		//alert(window.location.href);
		window.location.href="sureFixPjStoreDynamicInfo.action?id="+id+"&returnUrl="+window.location.href;
	});
}
