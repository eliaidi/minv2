//子窗口方法
$(function(){
	
    //拿到子窗口的值
	$(":radio").click(function(){
	     var radioId=$(this).val();	 
		//调用父窗口的方法
		parent.document.getElementById("_DialogFrame_0").contentWindow
						.changeParentStoreStatic(radioId,$("label[for="+this.id+"]").text());
		//点击事件关闭页面
		top.Dialog.close();
    });
	
});