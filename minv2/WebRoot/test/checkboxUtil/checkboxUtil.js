/**
 * 
* @Description: ��ѡ��checkbox��������
* @author �����
* @version V1.0  
* @date 2015-9-21 ����2:28:44
 */


/**
 * checkAll��������
 * �˺�������Ϊ  ѡ�����и�ѡ��
 * @param checkAllEleId��ѡ�����и�ѡ��Ԫ�ص�ID��������a ѡ�� ����nameΪchildEleName�ĸ�ѡ�򣬴˴�����a��ID
 * @param childEleName��Ҫѡ�еĸ�ѡ���nameֵ
 * 
 * �����÷���ο�check.html
 */
$.checkAll=function(checkAllEleId,childEleName){
	//����ǰ�ť  �����ж�ѡ��״̬
	var count=0;
	var checkAll=$("#"+checkAllEleId);
	if($.isEmptyObject(checkAll)){
		return;
	}
	
	checkAll.click(function(event){
		target = event.srcElement || event.target;
		if(target.tagName.toUpperCase() != "INPUT" && target.tagName.toUpperCase() != "BUTTON"){
			return;
		}
		if($(this).attr("type") == "checkbox"){
			$(":checkbox[name='"+childEleName+"']").attr("checked",this.checked);
		}else{
			
			$(":checkbox[name='"+childEleName+"']").attr("checked",count == 0);
			count += 1;
			count %= 2;
		}
	})
}


/**
 * ��ȡcheckbox  nameֵΪ@param ckbName����ѡ�е�  checkboxֵ
 * @param ckbName��Ҫ��ȡ��checkboxֵ��  nameֵ
 * @param ������������
 */
$.getCheckedValue=function(ckbName){
	var arr=new Array();
	var ckbs=$(":checkbox[name='"+ckbName+"']:checked");
	$.each(ckbs,function(index){
		if(this.value != "on"){
			arr.push(this.value);
		}
	})
	return arr;
}