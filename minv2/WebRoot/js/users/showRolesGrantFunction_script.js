
$(function(){
	 
	$("a[id='show']").click(function(){
		   var rowIndex=this.parentElement.parentElement.rowIndex;
    	  
    	   var roleId=$("#table1  input[id='roleid']:eq("+(rowIndex-1)+")").val();
    	   
    	});   
});