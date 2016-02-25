<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
$(function(){
      
     $('.flexiStyle').flexigrid({
				height:330,
				width:1050,
				resizable: false,
				showToggleBtn: false
   });	

   //弹出窗口关闭
   top.Dialog.close();
    <c:if test="${!empty message}">
		top.Dialog.alert('${message}');
	</c:if> 
	
	//隐藏输入框和下拉框
	$("#storePositionNameDiv").css("display","none");
	$("#dictAreaIdDiv").css("display","none");
	$("#storePositionTypeDiv").css("display","none");
	
	//当点击查询时，保留当前的条件
	var bool=$("#storePositionName").val() != "" ;
	$("#selByStorePositionName").attr("checked", bool ? true : false);
	$("#storePositionNameDiv").css("display", bool ? 'inline' : 'none' );
	
	//当点击查询时，保留当前条件
	var bool=$("#dictAreaIdSec").val() != "";
	$("#selByDictArea").attr("checked",bool ? true : false);
	$("#dictAreaIdDiv").css("display",bool ? "inline":"none");

	//当点击查询时，保留当前条件
	var bool=$("#storePositionTypeSec").val() != -1;
	$("#selBystorePositionType").attr("checked",bool ? true : false);
	$("#storePositionTypeDiv").css("display",bool ? "inline":"none");
	
	//复选框改变事件
	$("#selByStorePositionName").change(function(){
		$("#storePositionNameDiv").css("display",this.checked ? "inline":"none");
		$("#storePositionName").val("");
	});
	$("#selByDictArea").change(function(){
		$("#dictAreaIdDiv").css("display",this.checked ? "inline":"none");
	});
	$("#selBystorePositionType").change(function(){
		$("#storePositionTypeDiv").css("display",this.checked ? "inline":"none");
	});
	
	//多条件查询
	$("#queryStorePosition").click(function(){
		var url="queryDictStorePosition.action?";
		var bool = $("#selByStorePositionName").attr("checked") && $("#storePositionName").val() != "";
		if(bool){
		 	url += "storePositionName="+$("#storePositionName").val()+"&";
		}
		var bool = $("#selByDictArea").attr("checked") && $("#dictAreaId").val() !="请选择";
		if(bool){
			url += "dictArea.id="+$("#dictAreaId").val()+"&";
		}
		var bool = $("#selBystorePositionType").attr("checked") && $("#storePositionType").val() != "请选择";
		if(bool){
		 	url +="&storePositionType="+$("#storePositionType").val();
		}
		window.location.href=url;
	});
	//判断当前仓库下有没有配件
	$("button#deleteBtnByStorePosition").click(function(){
	    var storePositionId = $(this).val();
	    if($(this).val() != ""){
	    	$.post("findDictStorePositionByIdToPj.action",
	    			{storePositionId: $(this).val()},
	    			function(data){
		    			if(data != ""){
		    				top.Dialog.alert(data);
		    			}else{
		    				top.Dialog.confirm("确定删除吗？",function(){
		    					window.location.href="deleteDictStorePosition.action?id="+storePositionId+
		    						"&returnUrl="+window.location.href;
		    					
		    				});
		    			}
	    			});
	    }
	});
});	

//删除session中存在的值
<c:remove var="message" scope="session"/>