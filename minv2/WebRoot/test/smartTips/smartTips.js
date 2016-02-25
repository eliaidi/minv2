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
	var width=parseInt(txt.css("width").substring(0,txt.css("width").indexOf("px")));
	var top=parseInt(txt.attr("offsetTop"))+parseInt(txt.css("height").substring(0,txt.css("height").indexOf("px")));
	var stSelLeft=parseInt(txt.attr("offsetLeft"));
	
	//添加的下拉框
	var sel=$("<select id='"+selId+"' class='default' style='display:none'></select>").
			css("position","absolute").css("width",width).css("left",stSelLeft).css("top",top);
	
	$("body").append(sel);
	
	//给文本框添加键盘按下事件
	$("#"+args.txtId).keyup(function(event){
		var jsonArr=findData(args);
		
		var sel=$("#"+selId);
		obj = event.srcElement || event.target;
		sel.attr("length",0);
		var reg = new RegExp("^" + obj.value, "i")
		var j = 0;
		for (i = 0; i < jsonArr.length; i++) {
			if(reg.test(jsonArr[i].py) || reg.test(jsonArr[i].name)){
				$("#"+selId).append("<option value='"+jsonArr[i].id+"'>"+jsonArr[i].name+"</option>");
				j++;
			}
		}
		
		sel.css("display","");
		sel.css("width",$(this).css("width"));
		sel[0].size = (j > 1) ? j : 2;
		
		sel.find("option:eq(0)").attr("selected",true);
		sel.focus();
	})	
	
	//下拉框单击事件
	$("#"+selId).click(function(){
		txt.val($("#"+selId+" option:selected").text());
		if(args.valEleId){
			$("#"+args.valEleId).val($("#"+selId+" option:selected").val());
		}
		$(this).css("display","none");
		txt.focus();
	})
	
	$("#"+selId).keyup(function(event){
		var keycode=event.keyCode || event.which;
		if(keycode == 13){
			$("#"+args.txtId).val($("#"+selId+" option:selected").text());
			$("#"+args.valEleId).val($("#"+selId+" option:selected").val());
			$(this).css("display","none");
		}
	})
	
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


