$(function() {
	
	   //批量删除
	$("#deleteDynamicOther").click(function(){
		var pars="";
		var flag;
		var checkpjStatic=$("input:checkbox[name=ckPjStatic]:checked");
		$.each(checkpjStatic,function(i){
		   flag=true;
           pars += "ids="+$(this).val()+"&";
     	});
     	if(flag){
     		top.Dialog.confirm("确定删除吗？",function(){
     			parent.window.location.href="deletePjStoreDynamicByFirstUnitInfo.action?"+pars;
     		});
     	}else{
     	   top.Dialog.alert("请至少选择一个用户！");
     	}
	});
	
	//当点击查询时，保留原来的查询条件--配件编码
	var bool=$("#pjdCode").val() != "" ;
	$("#pjdCodeCkb").attr("checked", bool ? true : false );
	$("#didDiv").css("display", bool ? 'inline' : 'none' );
	
	//当点击查询时，保留原来的查询条件--配件名称
	var bool=$("#pjName").val() != "" ;
	$("#pjNameCkb").attr("checked", bool ? true : false );
	$("#pjNameDiv").css("display", bool ? 'inline' : 'none' );
	
	
	//当点击查询时，保留原来的查询条件--仓库
	var bool=$("#storePositionId").val() != "" ;
	$("#spidCkb").attr("checked", bool ? true : false );
	$("#spidDiv").css("display", bool ? 'inline' : 'none' );
	
	//当点击查询时，保留原来的查询条件--专业名称
	var bool=$("#unitName").val() != "" ;
	$("#unitCkb").attr("checked", bool ? true : false );
	$("#unitDiv").css("display", bool ? 'inline' : 'none' );
	
	
	var bool=$("#recordTime").val() != "" ;
	$("#dateCkb").attr("checked", bool ? true : false );
	$("#dateDiv").css("display", bool ? 'inline' : 'none' );
	
	//给选择框添加单击事件
	$("#pjdCodeCkb").click(function() {
		$("#didDiv").css("display", this.checked ? 'inline' : 'none');
	});
	$("#pjNameCkb").click(function() {
		$("#pjNameDiv").css("display", this.checked ? 'inline' : 'none');
	});
	$("#spidCkb").click(function() {
		$("#spidDiv").css("display", this.checked ? 'inline' : 'none');
	});
	$("#dateCkb").click(function() {
		$("#dateDiv").css("display", this.checked ? 'inline' : 'none');
	});
	$("#unitCkb").click(function() {
		$("#unitDiv").css("display", this.checked ? 'inline' : 'none');
	});
	
	
	$("#find").click(function(){
		var url = "queryPjStoreStaticInfo.action?flag=jctype&";
		//如果专业复选框选中
		if($("#unitCkb").attr("checked") && $("#unitName").val() != ""){
			url += "firstUnitName="+$("#unitName").val()+"&";
		}
		//如果配件编码复选框选中
		if($("#pjdCodeCkb").attr("checked") && $("#pjdCode").val() != ""){
			url += "pjdCode="+$("#pjdCode").val()+"&";
		}
		//如果配件名称复选框选中
		if($("#pjNameCkb").attr("checked") && $("#pjName").val() != ""){
			url += "pjName="+$("#pjName").val()+"&";
		}
		//如果仓库复选框选中
		if($("#spidCkb").attr("checked") && $("storePositionId").val() != ""){
			url += "storePositionId="+$("#storePositionId").val()+"&";
		}
		//如果入库时间选中
		if($("#dateCkb").attr("checked") && $("#recordDate").val() != ""){
			url += "recordTime="+$("#recordTime").val();
		}
	
		if($("#jcType").val() != ""){
			url += "jcType="+$("#jcType").val();
		}
		
		
		window.location.href=url;
	});
	//智能提示
	$.smartTips({
		"url":"findPjSSInfoListByNameOrPy.action",
		"txtId":"pjName",
		"valEleId":"pjStoreStaticInfoId"
	});
	
	//专业名称文本框联想输入
	$.smartTips({
		"url":"findDictPjFirstUnitListByNameOrPy.action",
		"txtId":"unitName"
	});
	
})


//获取动态配件信息列表
function getDynamicInfo(pssiId){
	var url="findPjSDInfoListByPssiId.action?pssiId="+pssiId;
	
	var diag = new top.Dialog();
	diag.Title = "动态配件信息列表";
	diag.URL = url;
	diag.Width="100";
	diag.Height="100";
	diag.CancelEvent = function(){
		top.frmright.location.reload();
		diag.close();
	};
	diag.show();
	
}