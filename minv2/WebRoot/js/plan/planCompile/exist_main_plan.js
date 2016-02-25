var basePath;
	$(function(){
		basePath=$("#basePath").val();
	})
   //查看计划详情信息
   function findMainPlanDetail(mainPlanId){
	   var diag = new top.Dialog();
	   diag.Title = "计划详情信息";
	   diag.URL = basePath+"plan/findMPRecorderByMainPlanId.action?mainPlanId="+mainPlanId;
	   diag.Width=1300;
	   diag.Height=600;
	   diag.show();
   }

   //查看计划兑现信息
   function findCashDetail(mainPlanId){
	   var diag = new top.Dialog();
	   diag.Title = "计划兑现信息";
	   diag.URL = basePath+"plan/findCashMPRecorderByMainPlanId.action?mainPlanId="+mainPlanId;
	   diag.Width=1300;
	   diag.Height=600;
	   diag.show();
   }

   function closeDialog(){
	   top.Dialog.close();
   }