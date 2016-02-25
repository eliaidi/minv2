var basePath=$("#basePath").val();

//合并表格的单元格
function cellMege(table, col) {
	var lines = $('#' + table + ' tr').size();
	if (lines <= 2) return;
	var v, l = 0,
		current = '',
		index = 1;
	for (var i = 1; i < lines; i++) {
		var tr = $('#' + table + ' tr').eq(i);
		v = tr.find('td[name="' + col + '"]').html();
		//alert(tr.find('td[name="secondname"]').size());
		l++;
		//alert(v);
		if (v != current || i == (lines - 1)) { //如果两个值不相同或者是最后一行
			if (i == (lines - 1)) l++;
			if (l > 1) { //草果两行，合并
				var td = $('#' + table + ' tr').eq(index).find('td[name="' + col + '"]');
				td.attr('rowspan', l);
				for (var j = 1; j < l; j++) {
					var td = $('#' + table + ' tr').eq(index + j).find('td[name="' + col + '"]').remove();
				}
			}
			l = 0; //从新计数
			current = v;
			index = i;
		}
	}
}

$(function() {
	cellMege('datatabel', 'planTime');
	cellMege('datatabel', 'planWeek');
});

function getCashReason(obj, id) {
	var reason = obj.value;
	if ($.trim(reason).length > 0) {
		var url=basePath+"plan/ajaxUpdateNoCashReason.action";
		$.post(url, {
			"planRecorderId": id,
			"noCashReason": reason
		}, function(data) {
			if (data.retMsg == "修改成功") {
				$.messager.show(0, '未兑现原因保存成功', 2000);
			}
		});
	}
}