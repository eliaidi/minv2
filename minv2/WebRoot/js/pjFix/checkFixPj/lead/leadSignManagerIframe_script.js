//工长进入签认主页面
$(function() {
	var sdId=$("#sdId").val();
	var tab = new TabView( {
		containerId :'tab_menu',
		pageid :'page',
		cid :'tab',
		position :"top"
	});
	tab.add( {
		id :'tab_index0',
		title :"检查项目",
		url :"enterSignByLeadOfCheckForPjFix.action?id="+sdId,
		isClosed :false
	});
	tab.add( {
		id :'tab_index1',
		title :"检测项目",
		url :"enterSignByLeadOfJianCeForPjFix.action?id="+sdId,
		isClosed :false
	});
	tab.add( {
		id :'tab_index2',
		title :"探伤组项目",
		url :"enterSignByLeadOfInspectionForPjFix.action?id="+sdId,
		isClosed :false
	});
	tab.activate("tab_index0")
});