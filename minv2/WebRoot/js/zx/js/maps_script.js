//定义的路径
var basePath;
$(function(){
	top.Dialog.close();
	basePath=$("#basePath").val();
	
	$("#tabs1").switchable('#panels1 >div');
})

/**
 * 删除扣车计划信息
 * @param id  日计划id
 */
function deleteDatePlan(id)
{
	top.Dialog.confirm("确定删除扣车计划？",function(){
		window.location.href=basePath+"zx/deleteJcPlanDate.action?id="+id;
	});
}

/**
 * 扣车成功后进行接车
 */
function pickCarJcPlanDate(id)
{
	top.Dialog.confirm("确定进行接车？",function(){
		var url=basePath+"zx/ajaxPickCarJcPlanDate.action";
		$.post(url,{"id":id},function(data){
			top.Dialog.alert(data.retMsg);
			if(data.errCode == 0){
				window.location.href=basePath+"zx/listUnOutJcPlanDate.action";
			}
		})
	});
}	

/**
 * 查询对应的日计划扣车信息
 * @param id 日计划id
 */
function findJcPlanDateById(id)
{
		top.Dialog.open({URL:basePath+"zx/findJcPlanDateById.do?id="+id,Title:"日计划制定窗口 ",Width:450,Height:470});
}


/**
 * 报活
 * @param id 日计划id
 */
function report(id)
{
	top.Dialog.open({URL:basePath+"report/iframePage/alertDialog/reportOperateDialog.jsp?planDateId="+id,Title:"报活 ",Width:1000,Height:900});
}



