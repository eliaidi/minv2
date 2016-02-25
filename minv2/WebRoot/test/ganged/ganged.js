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
		}

	}

	function bindEvent(firstSel, secondSel) {
		firstSel.change(function() {
			$.ajax({
				"url": args.url,
				"type": "post",
				"data": (firstSel.attr("name") != "" ? firstSel.attr("name") : firstSel.attr("id")) + "=" + firstSel.val(),
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