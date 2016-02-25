//工人进入签认主页面
$(function() {
	var basePath=$("#basePath").val();
	var planDateId=$("#planDateId").val();
	
	var proteamId=$("#proteamId").val();
	var usersId=$("#usersId").val();
	var tab = new TabView( {
		containerId :'tab_menu',
		pageid :'page',
		cid :'tab',
		position :"top"
	});
	tab.add( {
		id :'tab_index0',
		title :"卡控签字",
		url :"",
		isClosed :false
	});
	tab.add( {
		id :'tab_index1',
		title :"报活签字",
		url: basePath + "report/listReportByCommitLead.action?planDateId=" + planDateId,
		isClosed :false
	});
	tab.add( {
		id :'tab_index2',
		title :"我的报活",
		url: basePath + "report/listMyReport.action?planDateId=" + planDateId,
		isClosed :false
	});
	tab.activate("tab_index0");
});