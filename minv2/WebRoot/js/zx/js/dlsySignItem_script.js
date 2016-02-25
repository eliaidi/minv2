$(function() {
	var option = {
		width : 150,
		items : [ {
			text : "合格",
			icon : "<%=basePath%>images/icons/ico4.gif",
			alias : "合格",
			width : 180,
			action : menuAction
		}, {
			text : "不合格",
			icon : "<%=basePath%>images/icons/ico4.gif",
			alias : "不合格",
			width : 180,
			action : menuAction
		} ],
		onShow : applyrule,
		onContextMenu : BeforeContextMenu
	};
	function menuAction(object) {
		var obj = $(object).val();
		$(object).val(obj + this.data.alias);
		$(object).focus();
	}
	function BeforeContextMenu() {
		return this.id != "target3";
	}

	function applyrule(menu) {
		menu.applyrule({
			name : "all",
			disable : true,
			items : []
		});
	}
	$("input[type='text']").contextmenu(option);
});
