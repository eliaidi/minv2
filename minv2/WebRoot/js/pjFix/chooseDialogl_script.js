//点击选择按钮触发的事件
$(function(){
	$("#tbe button[id='choose']").click(function(){
		 var rowIndex=this.parentElement.parentElement.rowIndex;
    	 var pjdCode=$("#tbe  input[id='pjdCode']:eq("+(rowIndex-1)+")").val();
    	 //alert(pjdCode);
    		//调用父窗口的方法
			parent.document.getElementById("frmright").contentWindow
							.changePjCodeStatic($("#rowIndex").val(),pjdCode);
			//点击事件关闭页面
			top.Dialog.close();
    	   //alert(top.frmright)
	});
});