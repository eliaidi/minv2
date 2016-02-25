$(function() {



	$("#getCheckRow").click(function() {
		//返回行索引数组
		var rowIndexArr = $.getCheckRowIndex("tbAddToRP");
		//获取选中行，删除行
		$.deleteTableRow("tbAddToRP", rowIndexArr);
	});

	//全选、反选
	$.checkAll("ckAll", "ckPj");



	$("#checkRepairBtn").click(function() {
		var pjdCodes = $("input[name='tdRepairValue'][value!='']");
		if(pjdCodes.length == 0){
			top.Dialog.alert("请输入配件编号");
			return;
		}
		

		var pjdCodesArr=new Array();
		pjdCodesArr.push(pjdCodes[0].value);
		for(var i=1;i<pjdCodes.length;i++){
			var isRepeat=false;
			for(var j=0;j<pjdCodesArr.length;j++){
				if(pjdCodes[i].value == pjdCodesArr[j]){
					isRepeat=true;
					break;
				}
			}
			if(!isRepeat){
				pjdCodesArr.push(pjdCodes[i].value);
			}
		}
		
		var url="findDynamicByPjdCodeForPjFixPjSDInfo.action?";
		$.each(pjdCodesArr,function(){
				url += "pjdCodes="+this+"&";
		});
			
		window.location.href=url;

	});
	
	
	

	//点击确定动态出现行
	$("#addRowBtn").click(function() {
		
		//生成表格<行、列>
		var tab = $("#tbAddToRP");
		var tr = $("<tr></tr>");
		tr.append("<td><input type='checkbox' name='ckPj' id='ckPj'></td>");
		var input=$("<input type='text' name='tdRepairValue' class='validate[custom[noSpecialCaracters]] textinput' id='tdRepairValue'>");
		input.keyup(function(){
//			var value=this.value;
//			var curObj=this;
//			$("input[name='tdRepairValue']").each(function(){
//				if(curObj != this && value == this.value ){
//					this.value="";
//				}
//				
//			});
		})
		
		tr.append($("<td></td>").append(input));
		tr.append("<td><button id='delRowOneBtn' onclick='deleteSimple();'><span>删除</span></button></td>");
		
		tab.append(tr);
	});

	//添加待修配件（动态配件库已存在）
	$("#addToRepairExistPjSDInfo").click(function(){
		var pjdCodes=$("input[name='existPjdCode']");
		
		
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
	})
	
	$("#addToRepairNotExist").click(function(){
		var pjdCodes=$("input[name='notExistPjdCode']");
		if(pjdCodes.length == 0){
			return;
		}
		var url=$("#rootPath").val()+"toAddPjSDInfoForRepairChildIframe.action?";
		var pars="";
		pjdCodes.each(function(){
			pars += "pjdCodes="+this.value+"&";
		});
		window.location.href=url + pars;
	});
	
});
//表格行单个删除
function deleteSimple() {
	$("table tbody tr button[id='delRowOneBtn']").each(function() {
		$(this).bind("click", function() {
			$(this).parent().parent().eq(0).remove();
		});
	});
}
