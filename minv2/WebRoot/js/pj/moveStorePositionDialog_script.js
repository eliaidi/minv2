/**
 * @author:lxb
 * @data:2015-9-10 16：00
 * @description:moveStorePositionDialog.jsp
 */
$(function(){
	
	//配件库移入班组仓库
	$("#recordSpSubmitFirBtn").click(function(){
		var url="addPjSDInfoRecordSp.action?returnUrl="+parent.document.getElementById("_DialogFrame_0").src;
		
		moveStore(url,false);
		
		return false;
	});
	
	//班组库移入配件仓库
	$("#recordSpSubmitSecBtn").click(function(){
		var url="addPjSDInfoRecordSp.action?returnUrl="+parent.document.getElementById("_DialogFrame_0").src;
		moveStore(url);
		return false;
	});
	
	$("#recordSpSubmitThrBtn").click(function(){
		var url="addStorePjSDInfoRecordPp.action?returnUrl="+parent.document.getElementById("_DialogFrame_0").src;
		var checkId=$(":radio[name='rdCheck']:checked").attr("id");
		var data="dictStorePositionId="+$("#dictStorePositionId_"+checkId+"").val()+"&";
		
		var pssiIds=$("input[id='pjStoreDynamicInfoId_"+checkId+"']");
		$.each(pssiIds,function(){
			data += "pjStoreDynamicInfoId="+this.value+"&";
		});
		
		var proteamUsersIds=$("input[name='proteamUsersBIDS']");
		$.each(proteamUsersIds,function(){
			data += "proteamUsersB.id="+this.value+"&";
		});
		
		data += "proteamUsersA.id="+$("#proteamUsersId_"+checkId).val();
		alert(data);
		$.ajax({
			url:url,
			data:data,
			type:"post",
			async:false,
			success:function(d){
				parent.document.getElementById("_DialogFrame_0").contentWindow.location.reload(true);
				top.Dialog.close();
			}
		});
		return false;
	});
	
	function moveStore(url){
		var checkId=$(":radio[name='rdCheck']:checked").attr("id");
		var data="dictStorePositionId="+$("#dictStorePositionId_"+checkId+"").val()+"&";
		
		var pssiIds=$("input[id='pjStoreDynamicInfoId_"+checkId+"']");
		$.each(pssiIds,function(){
			data += "pjStoreDynamicInfoId="+this.value+"&";
		});
		
		if(checkId == 'rdCheck_1'){
			data += "proteamUsersId="+$("#proteamUsersId_"+checkId).val()+"&";
		}else{
			var proteamUsersIds=$("input[id='proteamUsersId_"+checkId+"']");
			$.each(proteamUsersIds,function(){
				data += "proteamUsersId="+this.value+"&";
			});
		}
		
		data += "storeUsersId="+$("#storeUsersId_"+checkId).val();
		$.ajax({
			url:url,
			data:data,
			type:"post",
			async:false,
			success:function(d){
				parent.document.getElementById("_DialogFrame_0").contentWindow.location.reload(true);
				top.Dialog.close();
			}
		});
	}
	
	//通过判断当前存储的仓库是平库、立库、还是班祖库
	$(":radio[id='rdCheck_1']").attr("checked",($("#rdCheck_1").val()==0 || $("#rdCheck_1").val()==1) ?true:false);
	$(":radio[id='rdCheck_2']").attr("checked",$("#rdCheck_2").val()==2 ?true:false);
	$(":radio[id='rdCheck_3']").attr("checked",$("#rdCheck_3").val()==3 ?true:false);
	
	if($(":radio[id='rdCheck_1']").attr("checked"))
	{
		//当是主仓库时，将班组库移库配件仓库  、班组库移库班祖库单选按钮设为不可用
		$(":radio[id='rdCheck_2']").attr("disabled",true);
		$(":radio[id='rdCheck_3']").attr("disabled",true);
		$("div[id='rdCheckDivProPj']").css("display","none");
		$("div[id='rdCheckDivProPro']").css("display","none");
	}
	if(!$(":radio[id='rdCheck_1']").attr("checked"))
	{
		//当前存储仓位不是主仓库，则设置单选按钮不可用
		$(":radio[id='rdCheck_1']").attr("disabled",true);
	}
	//现在有两种情况，一种是班组库移至配件仓库(主仓库),还有一种就是班组库移至班组库
	if($(":radio[id='rdCheck_2']").attr("checked") || $(":radio[id='rdCheck_3']").attr("checked")){
		//主仓库移至班组库隐藏
		$("div[id='rdCheckDivPjPro']").css("display","none");
		//判断班组库移至配件仓库(主仓库),班组库移至班组库 是否被选中
		if($(":radio[id='rdCheck_2']").attr("checked")){
			$("div[id='rdCheckDivProPj']").css("display","");
			$("div[id='rdCheckDivProPro']").css("display","none");
		}
		
		if($(":radio[id='rdCheck_3']").attr("checked")){
			$("div[id='rdCheckDivProPro']").css("display","");
			$("div[id='rdCheckDivProPj']").css("display","none");
		}
	}
	//单选按钮点击事件，判断是否显示和隐藏
	$("#rdCheck_3").click(function(){
			$("div[id='rdCheckDivProPro']").css("display","");
			$("div[id='rdCheckDivProPj']").css("display","none");
	});
	
	$("#rdCheck_2").click(function(){
		$("div[id='rdCheckDivProPro']").css("display","none");
		$("div[id='rdCheckDivProPj']").css("display","");
	});
	
	
	$("select[id*='dictStorePositionId']").change(function(){
		var sel=$(this);
		var id=sel.attr("id").substring(sel.attr("id").indexOf("rdCheck"));
		var childeSel={};
		if(id == "rdCheck_2"){
			childeSel=$("#storeUsersId_"+id);
		}else{
			childeSel=$("#proteamUsersId_"+id);
		}
		$.post("findUsersListByStorePositionId.action",{"dictStorePositionId":this.value},function(data){
			childeSel.attr("length",0);
			var json=eval(data);
			if(json.length == 0){
				return;
			}
			
			for(var i=0;i<json.length;i++){
				childeSel.append("<option value='"+json[i].id+"'>"+json[i].name+"</option>");
			}
		})
	});
	
});