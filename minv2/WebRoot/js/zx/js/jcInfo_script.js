//机车股道转移
function stationRacksTransfer ()
{
	top.Dialog.confirm("确定对机车股道进行转移？",function(){
		document.stationTransfer.submit();
	});
	
}

function showOrHide(){
	$("#bzFinishiInfo").show();
}
function move(rjhmId){
	var gdh = $("#gdh").val();
	var twh = $("#twh").val();
	if(gdh==null || gdh==""){
		alert("请输入股道号!");
	}else if(twh==null || twh==""){
		alert("请输入台位号!");
	}else{
		$.post("<%=basePath %>query!moveJC.do",{"rjhmId":rjhmId,"gdh":gdh,"twh":twh},function(text){
			if(text=="success"){
				alert("转移成功!");
				parent.location.reload();
			}else{
				alert("操作失败!");
			}
		});
	}
}
function searchJC(){
	var jcnum = $("#jcnum").val();
	if(jcnum!=''){
		window.parent.location.href="<%=basePath%>query!showHistory.do?jcNum="+jcnum;
	}
}