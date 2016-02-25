$(function() {
	   
	//调节table表格的宽度和高度
     $('.flexiStyle').flexigrid({
				height:240,
				width:1050,
				resizable: false,
				showToggleBtn: false
   });	
     
	//仓库人员
	if($("#storeUsersNameCkb").attr("checked")){
		$("#storeUsersNameDiv").css("display","inline" );
	}
	
	//配件编码
	if($("#pjdCodeCkb").attr("checked")){
		$("#pjdCodeDiv").css("display","inline" );
	}
	
	//配件名称
	if($("#pjNameCkb").attr("checked")){
		$("#pjNameDiv").css("display","inline" );
	}
	
	//专业名称
	if($("#firstUnitNameCkb").attr("checked")){
		$("#firstUnitNameDiv").css("display","inline" );
	}
	
	//配件仓库ID
	if($("#storePositionIdCkb").attr("checked")){
		$("#storePositionIdDiv").css("display","inline" );
	}
	
	//相关单位人员
	if($("#correlationNameCkb").attr("checked")){
		$("#correlationNameDiv").css("display","inline" );
	}
	
	//班组单位人员
	if($("#proteamUsersNameCkb").attr("checked")){
		$("#proteamUsersNameDiv").css("display","inline" );
	}
	
	//记录时间段
	if($("#recordTimeCkb").attr("checked")){
		$("#startRecordTimeDiv").css("display","inline" );
		$("#endRecordTimeDiv").css("display","inline" );
	}
	
	$("#queryStorePosition").click(function(){
		var url=$("#rootPath").val()+"queryPjSDInfoRecord.action?";
		//出库、入库
		var receivingDeliverStatus=$(":checkbox[name='receivingDeliverStatus']:checked");
		$.each(receivingDeliverStatus,function(){
			url += "receivingDeliverStatus="+this.value+"&";
		})
		//0、主仓库-班组仓库，出库入库；1、班组仓库-班组仓库，出库入库；2、主仓库-相关单位-出库入库
		var storeUnitProteamStatus=$(":checkbox[name='storeUnitProteamStatus']:checked");
		$.each(storeUnitProteamStatus,function(){
			url += "storeUnitProteamStatus="+this.value+"&";
		});
		
		
		//仓库人员
		var bool=$("#storeUsersNameCkb").attr("checked") &&   $("#storeUsersName").val() != "";
		if(bool){
			url += "storeUsersName="+$("#storeUsersName").val()+"&";
		}
		
		//配件编码
		bool=$("#pjdCodeCkb").attr("checked") &&  $("#pjdCode").val() != "";
		if(bool){
			url += "pjdCode="+$("#pjdCode").val()+"&";
		}
		
		//配件名称
		bool=$("#pjNameCkb").attr("checked") &&  $("#pjName").val() != "";
		if(bool){
			url += "pjName="+$("#pjName").val()+"&";
		}
		
		//专业名称
		bool=$("#firstUnitNameCkb").attr("checked") &&  $("#firstUnitName").val() != "";
		if(bool){
			url += "firstUnitName="+$("#firstUnitName").val()+"&";
		}
		
		//配件仓库ID
		bool=$("#storePositionIdCkb").attr("checked") &&  $("#storePositionId").val() != "";
		if(bool){
			url += "storePositionId="+$("#storePositionId").val()+"&";
		}
		
		//相关单位人员
		bool=$("#correlationNameCkb").attr("checked") &&  $("#correlationName").val() != "";
		if(bool){
			url += "correlationName="+$("#correlationName").val()+"&";
		}
		
		//班组单位人员
		bool=$("#proteamUsersNameCkb").attr("checked") &&  $("#proteamUsersName").val() != "";
		if(bool){
			url += "proteamUsersName="+$("#proteamUsersName").val()+"&";
		}
		
		//记录时间段
		bool=$("#recordTimeCkb").attr("checked");
		if(bool){
			if($("#startRecordTime").val() != ""){
				url += "startRecordTime="+$("#startRecordTime").val()+"&";
			}
			if($("#endRecordTime").val() != ""){
				url += "endRecordTime="+$("#endRecordTime").val()+"&";
			}
		}
		window.location.href=url;
	})
	
	
	
	
	
	
	
	
	
	
	
	
	$("#storeUsersNameCkb").click(function(){
		$("#storeUsersNameDiv").css("display",this.checked ? "inline" : 'none');
	})
	
	$("#pjdCodeCkb").click(function(){
		$("#pjdCodeDiv").css("display",this.checked ? "inline" : 'none');
	})
	
	$("#pjNameCkb").click(function(){
		$("#pjNameDiv").css("display",this.checked ? "inline" : 'none');
	})
	
	$("#firstUnitNameCkb").click(function(){
		$("#firstUnitNameDiv").css("display",this.checked ? "inline" : 'none');
	})
	
	
	$("#storePositionIdCkb").click(function(){
		$("#storePositionIdDiv").css("display",this.checked ? "inline" : 'none');
	})
	
	$("#correlationNameCkb").click(function(){
		$("#correlationNameDiv").css("display",this.checked ? "inline" : 'none');
	})
	
	
	$("#proteamUsersNameCkb").click(function(){
		$("#proteamUsersNameDiv").css("display",this.checked ? "inline" : 'none');
	})
	
	$("#recordTimeCkb").click(function(){
		$("#startRecordTimeDiv").css("display",this.checked ? "inline" : 'none');
		$("#endRecordTimeDiv").css("display",this.checked ? "inline" : 'none');
	})
	
	
	//配件名称文本框联想输入
	$.smartTips({
		"url":"findPjSSInfoListByNameOrPy.action",
		"txtId":"pjName"
	});
	
	
	//仓库人员文本框联想输入
	$.smartTips({
		"url":"findUsersListByNameOrPy.action",
		"txtId":"storeUsersName"
	});
	
	//班组单位人员文本框联想输入
	$.smartTips({
		"url":"findUsersListByNameOrPy.action",
		"txtId":"proteamUsersName"
	});
	
	
	//专业名称文本框联想输入
	$.smartTips({
		"url":"findDictPjFirstUnitListByNameOrPy.action",
		"txtId":"firstUnitName"
	});

})