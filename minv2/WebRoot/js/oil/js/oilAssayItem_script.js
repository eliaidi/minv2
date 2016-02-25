//显示对应的子项目记录   
function showSubItem(mainItemId,planDateId){
	   $('#oilsubitem').attr("src","listOilAssayChildItemRec.action?mainItemId="+mainItemId+"&planDateId="+planDateId);
   }
   
   function fillValue(){
	    var subItemId="";
	    var subItems=top.frmright.oilsubitem.document.getElementsByName("subItem");
	    var recId=$("#recId").val();
	    for(var i=0;i<subItems.length;i++){
		  if(subItems[i].checked==true){
			  subItemId=subItems[i].id;
		  }
	    }
	    if(subItemId==""||subItemId==undefined||subItemId==null){
	    	top.Dialog.alert("请选择要填值的项目!");
	    }else{
	    	 var diag = new top.Dialog();
			 diag.Title = "填报值";
			 diag.URL = "oilAssay!updateOilRecorderDialog.do?recId="+recId;
			 diag.Width=420;
			 diag.Height=320;
			 diag.show();
	    }
   }
   
