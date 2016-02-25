
//工人签认检测页面，改变检修情况输入框的值触发的事件
function fixConditionChange(obj){
	
	  var rowIndex=obj.parentElement.parentElement.rowIndex;
	  var jianceItemId=$("#table1  input[id='jianceItemId']:eq("+(rowIndex)+")").val();
	  var fixCondition=$("#table1  input[id='fixConditionId']:eq("+(rowIndex)+")").val();
	  //window.location.href="signFixItemByFixUsersForPjFix.action?ids="+jianceItemId+"&fixCondition="+fixCondition;
	  //+"&returnURL="+window.location.href
	  $.ajax({
		 type:"post",
		 url:"signFixItemByFixUsersForPjFix.action", 
		 data:{"ids":jianceItemId,"fixCondition":fixCondition},
		 dataType:"text",
		 success:function(data){
			 $.messager.show('提示信息',data);
		 }
	  });
}