//配件记录详情 点击打印按钮触发的事件
$(function(){
	//点击按钮，出现打印窗体
	$("#go").click(function(){
		$("#print").jqprint();
	});
});