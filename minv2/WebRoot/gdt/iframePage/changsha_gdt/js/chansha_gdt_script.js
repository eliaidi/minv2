$(function() {
	var basePath = $("#basePath").val();

	//-1-新建 , 0-在修  1-待验  2-已交
	//var data=${jcJSON}; //在ReportAction中的findAllJC()方法中

	//定义数组，将所要参数变量放入数组中
	//var data=[{"gdh":21,"tw":5,"statue":-1,"jcnum":3333}];	 //-1-新建 	 颜色为红色
	//var data=[{"gdh":16,"tw":3,"statue":0,"jcnum":2222}];		 //0-在修 	 颜色为蓝色
	//var data=[{"gdh":13,"tw":1,"statue":1,"jcnum":1111}];		 //1-待验 	 颜色为橘黄色
	var data; //2-已交	 颜色为绿色

	var url = basePath + "zx/ajaxListUnOutJcPlanDate.action";
	$.ajax({
		"url": url,
		"dataType": "json",
		"success": function(retData) {
			data = eval(retData.retMsg);
		},
		"error": function() {
			top.Dialog.alert("请联系管理员");
		},
		"async": false
	});

	//var dd;

	//var gtimes={};
	for (var i =0; i < data.length; i++) {
		
		var stationRacksNumber = data[i].stationRacksNumber;
		var tar = $('div[group="'+stationRacksNumber+'"]').eq(data[i].stationNmber-1);
		if (data[i].jcPlanStatus == 1) { 
			tar.addClass('red');
		} else if (data[i].jcPlanStatus == 2) { 
			tar.addClass('blue');
		} else if(data[i].jcPlanStatus == 3){ 
			tar.addClass('green');
		}else{
			tar.addClass('yellow');
		}
		tar.html('<input type="hidden" id="rjhId" value="'+data[i].id+'"><a href="javascript:void(0);" title="【机车车型:'+data[i].jcTypeValue+'】--【机车编号:'+data[i].jcNumber+'】--【 机车修次:'+data[i].fixMileageValue+'】" id="jTip">'+data[i].jcNumber+'</a>');
	}
    
	/*点击对已股道上变颜色的台位号，连接进入的机车记录查询目录页面显示的信息
	 * 对已的班组信息  签认情况
	 * */
	$("a[id='jTip']").bind("click", function(event) {
		var id=$(this).prev().val();
		$(document).ready(function() {
			top.Dialog.open({URL:basePath+"zx/listByPlanDateId.action?id="+id,Title:"机车信息 ",Width:580,Height:550});
		});
	});

	//点击股道图台位触发的事件
	$("body").click(function(event) {
		var obj = ($(event.srcElement || event.target));
		var id = obj.parent().attr('id');
		if (obj.parent().attr('id') == "") {
			id = obj.parent().parent().attr('id')
		}
		
		//获取股道号
		var stationRacksNumber = obj.attr('group');
		if (stationRacksNumber == undefined) {
			stationRacksNumber = obj.parent().attr('group');
		}

		//获取台位号
		var stationNmber = parseInt(obj.html());
		if (stationNmber >= 100) {
			stationNmber = "";
		}
		if (id == "maps" && stationNmber != "" && !isNaN(stationNmber)) {
			var diag = new top.Dialog();
			diag.Title = "日计划制定窗口";
			if (stationRacksNumber != undefined) {
				diag.URL = basePath + "gdt/iframePage/alertDialog/planDate.jsp?stationRacksNumber=" + stationRacksNumber + "&stationNmber=" + stationNmber;
			} else {
				diag.URL = "<%=basePath%>planManage!addDailyPlanInput.action";
			}
			diag.Width = 450;
			diag.Height = 470;
			diag.show();
		}
	});

	
});