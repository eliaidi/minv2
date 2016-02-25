/**
 * 自定义函数，自动提示组件
 * @param   args：json格式参数
 * 可选参数：url、dataArr、txtId、valEleId
 * {
 * 		url:"",
 * 		dataArr:""
 * 		valEleId:""
 * 		txtId:""
 * }
 * 
 */
$.smartTips=function(args){
	
	
	//下拉框后缀
	var selIdSuffix="smartTips";
	var selId=args.txtId+selIdSuffix;
	
	var txt=$("#"+args.txtId);
	
	
	
	//获得将添加的下拉框位置、大小
	var width=txt.width();
	//添加的下拉框
	var sel=$("<select id='"+selId+"' style='display:none'></select>").
			css("position","absolute").css("width",width).css("left",0).css("top",0).css("z-index",1000);
	
	$("body").append(sel);
	
	//给文本框添加键盘按下事件
	txt.keyup(function(event){
		event = window.event || event  ;
		var keyCode=event.keyCode;
		//按下了esc键
		if(keyCode == 27){
			sel.css("display","none");
			return;
		}
		
//		当keyCode为下列值时，不触发事件，9：TAB键，16：Shift键，13：回车键，17：Ctrl键，18：Alt键，20：Capslock键
		var dontTriggerKey=[9,13,16,,17,18,20];
		for(var i=0;i<dontTriggerKey.length;i++){
			if(dontTriggerKey[i] == keyCode){
				return;
			}
		}
		
		var top=txt.offset().top+txt.height()+5;
		var stSelLeft=txt.offset().left;
		sel.css("width",width).css("left",stSelLeft).css("top",top);
		
		var jsonArr=findData(args);
		
		
		var obj = event.srcElement || event.target;
		
		
		sel.attr("length",0);
		var reg = new RegExp("^" + obj.value, "i")
		var j = 0;
		for (i = 0; i < jsonArr.length; i++) {
			if(reg.test(jsonArr[i].py) || reg.test(jsonArr[i].name)){
				sel.append("<option value='"+jsonArr[i].id+"'>"+jsonArr[i].name+"</option>");
				j++;
			}
		}
		
		sel.css("display","");
		sel.css("width",$(obj).width());
		sel[0].size = (j > 1) ? j : 2;
		
		sel.find("option:eq(0)").attr("selected",true);
		sel.focus();
	})	
	
	
	
	//下拉框单击事件
	sel.click(function(){
		txt.val($("#"+selId+" option:selected").text());
		if(args.valEleId){
			$("#"+args.valEleId).val($(this).val());
		}
		$(this).css("display","none");
		txt.focus();
	})
	
	sel.keyup(function(event){
		var keycode=event.keyCode || event.which;
		if(keycode == 13){
			var selectedOption=sel.find("option:selected");
			txt.val(selectedOption.text());
			$("#"+args.valEleId).val(selectedOption.val());
			$(this).css("display","none");
		}
	})
	
	//获得数据
	function findData(args){
		var json=[];
		if(args.url){
			var url=args.url;
			if(url.indexOf("?") != -1 ){
				url += "&";
			}
			url += "?py=" + txt.val()+"&name="+txt.val();
			$.ajax({
				"url":url,
				"type":"post",
				"dataType":"json",
				"async":false,
				"success":function(data){
					json=data;
				}
			});
		}else if(args.dataArr){
			json=args.dataArr;
		}
		return json;
	}
}


