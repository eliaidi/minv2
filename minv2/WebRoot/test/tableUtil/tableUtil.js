/**
 * table ��ع���
 */

/**
 * ��ȡ���ѡ��������
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
* @Description: ���table������
* @author �����
* @version V1.0  
* @date 2015-9-21 ����2:28:44
 */

/**
 * ɾ�������
 * @param {Object} tableId		���IDֵ
 * @param {Object} rowIndexArr	����������
 */
$.deleteTableRow=function(tableId,rowIndexArr){
	if($.isEmptyObject($("#"+tableId))){
		return;
	}
	
	for(var i=0;i<rowIndexArr.length;i++){
		var rowSelector="#"+tableId+" tr:eq("+rowIndexArr[i]+")";
		$(rowSelector).remove();
		
		
		//ÿ�Ƴ�һ�У����ڴ��к����������Ӧ��һ
		for(var j=0;j<rowIndexArr.length;j++){
			//�����ǰɾ�������� С��rowIndexArr[j]����˵��rowIndexArr[j]�洢�������ǵ�ǰɾ������������ģ���Ϊ�Ƴ���һ�У����Լ�һ
			if(rowIndexArr[i] < rowIndexArr[j]){
				rowIndexArr[j] = rowIndexArr[j]-1;
			}
		}
	}
}
