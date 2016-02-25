/**
 * table 相关工具
 */

/**
 * 获取表格选中行索引
 * @param {Object} tableId
 * @return Array
 */
$.getCheckRowIndex=function(tableId){
	var rowSelector="#"+tableId+" tr";
	var ckbs=$(rowSelector).find("td:eq(0)").find(":checkbox:checked");
	
	var arr=new Array();
	
	for(var i=0;i<ckbs.length;i++){
		var rowIndex=$(ckbs[i]).parent().parent().prevAll().length;
		arr.push(rowIndex);
	}
	
	return arr;
}


/**
 * 
* @Description: 表格（table）工具
* @author 周云韬
* @version V1.0  
* @date 2015-9-21 下午2:28:44
 */

/**
 * 删除表格行
 * @param {Object} tableId		表格ID值
 * @param {Object} rowIndexArr	行索引数组
 */
$.deleteTableRow=function(tableId,rowIndexArr){
	if($.isEmptyObject($("#"+tableId))){
		return;
	}
	
	for(var i=0;i<rowIndexArr.length;i++){
		var rowSelector="#"+tableId+" tr:eq("+rowIndexArr[i]+")";
		$(rowSelector).remove();
		
		
		//每移除一行，排在此行后面的索引相应减一
		for(var j=0;j<rowIndexArr.length;j++){
			//如果当前删除行索引 小于rowIndexArr[j]，则说明rowIndexArr[j]存储的索引是当前删除行索引后面的，因为移除了一行，所以减一
			if(rowIndexArr[i] < rowIndexArr[j]){
				rowIndexArr[j] = rowIndexArr[j]-1;
			}
		}
	}
}
