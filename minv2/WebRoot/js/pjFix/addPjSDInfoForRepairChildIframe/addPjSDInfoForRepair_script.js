$(function(){
	$("#getCheckRow").click(function(){
		//返回行索引数组
		var rowIndexArr=$.getCheckRowIndex("tbRepairParts");
		//获取选中行，删除行
		$.deleteTableRow("tbRepairParts",rowIndexArr);
	});
	//全选、反选
	$.checkAll("ckAll","ckPj");
	
	
	$.ganged({
		"firstSelName":"dictJcTypeId",
		"secondSelName":"pjStoreStaticInfoId",
		"url":"findPjSSInfoListByDictJcTypeId.action"
	})
});