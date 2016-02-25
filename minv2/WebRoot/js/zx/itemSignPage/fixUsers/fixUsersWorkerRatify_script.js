//工人进入签认主页面
$(function() {
	var basePath=$("#basePath").val();
	var planDateId=$("#planDateId").val();
	//var proteamId=$("#proteamId").val();
	//var usersId=$("#usersId").val();
	var tab = new TabView( {
		containerId :'tab_menu',
		pageid :'page',
		cid :'tab',
		position :"top"
	});
	tab.add( {
		id :'tab_index0',
		title :"检查项目",
		url :basePath+"zx/fixUsers/viewFixUsersCheckItem.action?planDateId="+planDateId,
		isClosed :false
	});
	tab.add( {
		id :'tab_index1',
		title :"检测项目",
		url :basePath+"zx/fixUsers/viewFixUsersDetectionItem.action?planDateId="+planDateId,
		isClosed :false
	});
	tab.add( {
		id :'tab_index2',
		title :"报活项目",
		url :basePath+"report/listReportByFixUsers.action?planDateId="+planDateId,
		isClosed :false
	});
	tab.add( {
		id :'tab_index3',
		title :"我的报活",
		url :basePath+"report/listMyReport.action?planDateId="+planDateId,
		isClosed :false
	});
	tab.activate("tab_index0");
});