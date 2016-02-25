/**
 * 
* @Description: 下拉框二级联动 工具类
* @author 周云韬
* @version V1.0  
* @date 2015-9-21 下午2:28:44
 */

/**
 * 下拉框联动，当一级下拉框选中被改变时，将自动发送http请求，获得二级菜单数据
 * 假如URL参数值为http://www.baidu.com，发送http请求时，将会自动为url附加参数。即当前选中下拉框值为1时，
 * 请求url为http://www.baidu.com?firstSelName的值=一级下拉框选中的值
 * 接收json格式参数
 * 选项如下：
 * firstSelId：一级下拉框ID
 * secondSelId：二级下拉框ID
 * firstSelName：一级下拉框name：当需要为多个下拉框进行联动时，采用name传值
 * secondSelName：二级下拉框name：当需要为多个下拉框进行联动时，采用name传值
 * url：通过一级下拉框选中的值查询的URL
 */
$.ganged = function(args) {
	var firstSelId = args.firstSelId;
	var secondSelId = args.secondSelId;

	if (firstSelId && secondSelId) {
		var firstSel = $("#" + firstSelId);
		var secondSel = $("#" + secondSelId);
		if ($.isEmptyObject(firstSel) || $.isEmptyObject(secondSel)) {
			return;
		}
		bindEvent(firstSel, secondSel);
		firstSel.trigger("change");
	} else {
		var firstSelName = args.firstSelName;
		var secondSelName = args.secondSelName;

		var firstSels = $("select[name='" + firstSelName + "']");
		var secondSels = $("select[name='" + secondSelName + "']");

		if ($.isEmptyObject(firstSels) || $.isEmptyObject(secondSels)) {
			return;
		}

		if (firstSels.length != secondSels.length) {
			return;
		}

		for (var i = 0; i < firstSels.length; i++) {
			bindEvent($(firstSels[i]), $(secondSels[i]));
			$(firstSels[i]).trigger("change");
		}

	}

	function bindEvent(firstSel, secondSel) {
		
		firstSel.change(function() {
			$.ajax({
				"url": args.url,
				"type": "post",
				"data":(firstSel.attr("name") != "" ? firstSel.attr("name") : firstSel.attr("id")) + "=" + firstSel.val(),
				"async": true,
				"dataType": "json",
				"success": function(data) {
					secondSel.attr("length", 0);
					if (!$.isEmptyObject(data)) {

						for (var i = 0; i < data.length; i++) {
							secondSel.append("<option value='" + data[i].value + "'>" + data[i].showValue + "</option>");
						}
					}
				},
				"error": function() {
					alert("数据加载失败！");
				}
			});
		});
	};

}