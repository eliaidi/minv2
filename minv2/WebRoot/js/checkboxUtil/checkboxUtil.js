/**
 * 
* @Description: 复选框（checkbox）工具类
* @author 周云韬
* @version V1.0  
* @date 2015-9-21 下午2:28:44
 */


/**
 * checkAll：方法名
 * 此函数功能为  选中所有复选框
 * @param checkAllEleId：选中所有复选框元素的ID，比如点击a 选中 所有name为childEleName的复选框，此处就是a的ID
 * @param childEleName：要选中的复选框的name值
 * 
 * 具体用法请参考check.html
 */
$.checkAll=function(checkAllEleId,childEleName){
	//如果是按钮  用来判断选中状态
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
 * 获取checkbox  name值以@param ckbName开头的，且选中的  checkbox值
 * @param ckbName：要获取的checkbox值的  name值
 * @param 返回数组类型
 */
$.getCheckedValue=function(ckbName){
	var arr=new Array();
	var ckbs=$(":checkbox[name^='"+ckbName+"']:checked");
	$.each(ckbs,function(index){
		if(this.value != "on"){
			arr.push(this.value);
		}
	})
	return arr;
}