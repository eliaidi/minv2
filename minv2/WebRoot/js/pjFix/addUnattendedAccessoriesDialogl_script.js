
//点击添加配件编码数据框触发的事件，点击按钮table表格中会出现新的一行
$(function(){
	var trCount=0;
	$("#addPjNum").click(function(){
		var pjSSInfoId=$("#pjSSInfoId").val();
	   //添加新行
		var obj=$("<tr></tr>");
		obj.append("<td width='10%'><input type='checkbox' name='seq'/>"+($("#addUnattendedAccessoriesDialogl_table tr").length+1)+"</td> ");
		obj.append("<td width='40%'><input type='text'  class='textinput'/></td> ");
		var btn=$("<button class='button' id='select' style='width: 60px;'>选择</button>");
		btn.click(function(){
			//var rowIndex=$(this).parent().parent().prevAll().length-1;
			var rowIndex= ++trCount;
			var url="toChoosePjSDInfo.action?pjSStInfoId="+pjSSInfoId+"&rowIndex="+rowIndex;
			top.Dialog.open({URL:url,Title:"选动态配件编码",Width:1355,Height:300});
		});
		obj.append($("<td width='50%'></td> ").append(btn));
	    //添加到table表格中
	    $("#addUnattendedAccessoriesDialogl_table").append(obj);
    });
	
	//点点击复选框触发的事件，全选和全不选
	/**var count = 0;
	 选项状态
	$("#tbe span input[id='all']").click(function() {
		var ckbs = $("#addUnattendedAccessoriesDialogl_table input[type=checkbox]");

		$.each(ckbs, function(index, obj) {
			var bool = count == 0;
			$(obj).attr("checked", bool);
		});
		count += 1;
		count %= 2;
	});
	*/
	$.checkAll("all","seq");
	$("#del").click(function(){
		$.deleteTableRow("addUnattendedAccessoriesDialogl_table",$.getCheckRowIndex("addUnattendedAccessoriesDialogl_table"));
		trCount=$("#addUnattendedAccessoriesDialogl_table tr").length;
	})
	
});


//子窗口向父窗口传值得方法
//id : 传入的Id值
//name：传入的Name值
function changePjCodeStatic(rowIndex,pjCode){
	//alert($("#addUnattendedAccessoriesDialogl_table tr").length);
	$("#addUnattendedAccessoriesDialogl_table tr:eq("+rowIndex+")").find("td:eq(1)").find("input").val(pjCode);
}


$(function(){
	//添加待修配件按钮
	$("#addBtn").click(function(){
		var pjdCodes=$("input[name='pjdCode']");
		
		if(pjdCodes.length == 0){
			return;
		}
		
		var url="addToRepairExistPjSDInfoForFix.action";
		var pars="";
		pjdCodes.each(function(){
			pars += "pjdCodes="+this.value+"&";
		});
		$.post(url,pars,function(data){
			top.Dialog.alert(data);
		});
		pjdCodes.each(function(){
			this.value="";
		})
	});
	
})
