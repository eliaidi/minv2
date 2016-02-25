function vlidate(){
	  if($("#recesamTime").val()==""){
		  top.Dialog.alert("来样日期不能为空!");
		  return false;
	  }
	  if($("#receiptPeo").val()==""){
		  top.Dialog.alert("接样人不能为空!");
		  return false;
	  }
	  return true;
  }
  
  function show(obj){
	  if(obj.value==0){
		  $("#advice").hide();
	  }else{
		  $("#advice").show();
	  }
  }
  