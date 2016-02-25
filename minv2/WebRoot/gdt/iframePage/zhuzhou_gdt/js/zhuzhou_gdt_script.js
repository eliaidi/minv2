 $(function(){
		//-1-新建 , 0-在修  1-待验  2-已交
	 	//var data=${jcJSON};
		var dd;
		var data=[{"gdh":36,"tw":2,"statue":-1,"jcnum":3333}];	 //-1-新建 	 颜色为红色
	 	//var data=[{"gdh":19,"tw":3,"statue":0,"jcnum":22222}];		 //0-在修 	 颜色为蓝色
		//var data=[{"gdh":13,"tw":1,"statue":1,"jcnum":1111}];		 //1-待验 	 颜色为橘黄色
		//var data=[{"gdh":17,"tw":2,"statue":2,"jcnum":4444}];		 //2-已交	 颜色为绿色
		$(document).ready(function(){
			//var gtimes={};
			for(var i=0;i<data.length;i++){
				var gdh=data[i].gdh;
				var tar=$('div[group="'+gdh+'"]').eq(data[i].tw-1);
				if(data[i].statue==2){//已交
					tar.addClass('green');
				}else if(data[i].statue==1){//待验
					tar.addClass('yellow');
				}else if(data[i].statue==0){
					tar.addClass('blue');
				}else{//新建
					tar.addClass('red');
				}
				tar.html('<a href="javascript:void(0);"id="'+data[i].jcnum+'" class="jTip" name="<%=basePath %>report!getInfoDetail.do?rjhmId='+data[i].rjhmId+'">'+data[i].jcnum+'</a>');
			}
	
			$('.jTip').bind('click',function(event){
				var url=$(event.target).attr('name');
				 $(document).ready(function () {
	            	dd =$.dialog({
		                title:"机车信息",
		                content:'url:'+url+'&temp='+new Date().getTime(),
		                height:500,
		                width:568,
		                max:false,
		                min:false
		            });
	        	});
			});
			
			$("body").click(function(event){
				
					var obj=($(event.srcElement || event.target));
					var id = obj.parent().attr('id');
					if(obj.parent().attr('id')==""){
						id = obj.parent().parent().attr('id')
					}
					//获取股道号
					var gdh = obj.attr('group');
					if(gdh == undefined){
						gdh = obj.parent().attr('group');
					}
					
					//获取台位号
					var twh = obj.html();
					if(twh >= 100){
						twh = "";
					}
					if(id == "maps" && twh != "" && !isNaN(twh)){
						var diag = new top.Dialog();
						diag.Title = "日计划制定窗口";
						if(gdh != undefined){
							diag.URL = "../alertDialog/dailyplanoperate.jsp?gdh="+gdh+"&twh="+twh;
						}else{
							diag.URL = "<%=basePath%>planManage!addDailyPlanInput.action";
						}
						diag.Width=450;
						diag.Height=470;
						diag.show();
					}
				});
		});
 });
