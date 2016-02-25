
$(function() {
    
	//调节窗体大小
	$('.flexiStyle').flexigrid({
		height : 330,
		width : 1100,
		resizable : false,
		showToggleBtn : false
	});

	// 查询数据之后数据保存在文本框中，复选框选中

	// 静态名称
	var bool = $("#pjName").val() != "";
	$("#staticName").attr("checked", bool ? true : false);
	$("#staticNameDiv").css("display", bool ? 'inline' : 'none');

	// 大部件(专业)
	var bool = $("#firstUnitName").val() != "";
	$("#unitName").attr("checked", bool ? true : false);
	$("#unitNameDiv").css("display", bool ? 'inline' : 'none');

	// 班组
	var bool = $("#proteamName").val() != "";
	$("#pjProteam").attr("checked", bool ? true : false);
	$("#pjProteamDiv").css("display", bool ? 'inline' : 'none');


	// 组装状态
	var bool = $("#pjAssemblyTypeId").val() != "";
	$("#statu").attr("checked", bool ? true : false);
	$("#statuDiv").css("display", bool ? 'inline' : 'none');

	// 点击复选框触发的事件
	$("#staticName").click(function() {
		$("#staticNameDiv").css("display", this.checked ? 'inline' : 'none');
	});
	$("#pjProteam").click(function() {
		$("#pjProteamDiv").css("display", this.checked ? 'inline' : 'none');
	});
	$("#statu").click(function() {
		$("#statuDiv").css("display", this.checked ? 'inline' : 'none');
	});
	$("#unitName").click(function() {
		$("#unitNameDiv").css("display", this.checked ? 'inline' : 'none');
	});

	// 批量删除，刷新到当前页面
	$("#batchDel").click(function() {
		var pars = "";
		var flag;
		var checkPjStoreStaticIn = $("input:checkbox[name=pjSSInfonCkb]:checked");
		$.each(checkPjStoreStaticIn, function(i) {
			flag = true;
			pars += "staticInfoId=" + $(this).val() + "&";
		});

		if (flag) {
			top.Dialog.confirm("确定删除吗？",function() {
				window.location.href = "deletePjStoreStaticInfo.action?"+
					pars+ "returnUrl="+ window.location.href;
			});
		} else {
			top.Dialog.alert("请至少选择一个用户");
		}
	});

	// 新添数据
	$("#add").click(function() {
			var flag;
			var checkPjStoreStaticIn = $("input:checkbox[name=pjSSInfonCkb]:checked");
			if (flag) {
				window.location.href = "findAddPjStoreStaticInfo.action?id="+ checkPjStoreStaticIn;
			}
	});

	$("#vagueSelect").click(function() {
		// alert($("#pjName").val());
		var url = "findPagePjStoreStaticInfo.action?";
		// 静态名称
		var bool = $("#staticName").attr("checked") && $("#pjName").val() != null;
		if (bool) {
			url += "pjName=" + $("#pjName").val() + "&";
		}
		// 配件班组
		var bool = $("#pjProteam").attr("checked") && $("#proteamName").val() != null;
		if (bool) {
			url += "proteamId=" + $("#proteamName").val() + "&";
		}
		// 组装状态
		var bool = $("#statu").attr("checked")
				&& $("#pjAssemblyTypeId").val() != null;
		if (bool) {
			url += "pjAssemblyType=" + $("#pjAssemblyTypeId").val()+ "&";
		}
		// 专业名称
		var bool = $("#unitName").attr("checked")
				&& $("#firstUnitName").val() != null;
		if (bool) {
			url += "firstUnitName=" + $("#firstUnitName").val() + "&";
		}
		// 未启用复选框
		var bool = $("#isOpen").attr("checked");
		if (bool) {
			url += "pjActivate=" + $("#isOpen").val() + "&";
		}
		// 最小库存复选框
		if ($("#minStore").attr("checked")) {
			url += "minStore=true";
		}
		window.location.href = url;
	});

	// 单选按钮选择事件
	$("#isOpen").click(function() {

		if (this.checked) {
			$("#pjActivate").val("0");
		} else {
			$("#pjActivate").val("1");
		}

	});

	var count = 0;
	// 选项状态
	$("span[id='all']").click(function() {
		var ckbs = $("#checkboxTable input[type=checkbox]");

		$.each(ckbs, function(index, obj) {
			var bool = count == 0;
			$(obj).attr("checked", bool);
		});
		count += 1;
		count %= 2;
	});
	
	//配件名称文本框联想输入
	$.smartTips({
		"url":"findPjSSInfoListByNameOrPy.action",
		"txtId":"pjName",
		"valEleId":"pjStoreStaticInfoId"
	});
	
	//专业
	$.smartTips({
		"url":"findDictPjFirstUnitListByNameOrPy.action",
		"txtId":"firstUnitName"
	});

});
// 普通删除，刷新到当前页面
function deleteStaticInfo(staticInfoId) {

	top.Dialog.confirm("确定删除吗？", function() {
		window.location = "deletePjStoreStaticInfo.action?staticInfoId="
				+ staticInfoId + "&returnUrl=" + window.location.href;
	});
};


