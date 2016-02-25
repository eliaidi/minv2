var basePath;
$(function(){
	basePath=$("#basePath").val();
	title=$("#title").val();
	maker=$("#maker").val();
})
	

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
//	<c:if test = "${!empty message}" >
//		top.Dialog.close();
//		top.Dialog.alert('${message}'); 
//	</c:if>
});

function publishPlan(mainPlanId) {
	top.Dialog.confirm("计划发布后不能进行修改,确认要进行发布?", function() {
		var url=basePath+"plan/ajaxPublishJcMainPlan.action";
		$.post(url, {
			"mainPlanId": mainPlanId
		}, function(data) {
			top.Dialog.alert(data.retMsg, function() {
				window.location.reload();
			});
		});
	});
}

function delPlan(mainPlanId) {
	top.Dialog.confirm("确认要删除该时间段内所有计划?", function() {
		var url=basePath+"plan/ajaxDelJcMainPlan.action";
		$.post(url, {
			"mainPlanId": mainPlanId
		}, function(data) {
			
			if (data.retMsg == "删除成功") {
				top.Dialog.alert("计划删除成功!", function() {
					top.frmright.location.href = basePath+"plan/planCompile/edit_main_plan.jsp";
					
					window.close();
				});
			}
		});
	});
}

function delDetailPlan(mainPlanDetailId) {
	top.Dialog.confirm("确认要删除该计划?", function() {
		var url=basePath+"plan/ajaxDelJcMainPlanRecorder.action";
		$.post(url, {
			"planRecorderId": mainPlanDetailId
		}, function(data) {
			if (data.retMsg == "删除成功") {
				top.Dialog.alert("计划删除成功!", function() {
					window.location.reload();
				});
			}
		});
	});
}

//修改计划

function xiuDetailPlan(planId) {
	top.Dialog.open({
		URL: "planManage!xiuDetailPlanInput.do?planId=" + planId,
		Width: 360,
		Height: 240,
		Title: "修改计划"
	});
}

function updateThis(obj, detailId) {
	var inputName = obj.name;
	var inputVal = obj.value;
	if ($.trim(inputVal).length > 0) {
		$.post(basePath+"plan/ajaxUpdateJcMainPlanRecorder.action", {
			"planRecorderId": detailId,
			"fieldName": inputName,
			"fieldValue": inputVal
		}, function(data) {
			if (data.retMsg == "修改成功！") {
				$.messager.show(0, '计划信息修改成功!', 2000);
			}
		});
	}
}

function SaveAsFile() {
	var LODOP = getLodop(document.getElementById('LODOP_OB'), document.getElementById('LODOP_EM'));
	LODOP.PRINT_INIT("");
	LODOP.ADD_PRINT_TABLE(100, 20, 500, 80, document.getElementById("content").innerHTML);
	LODOP.SET_SAVE_MODE("Orientation", 1); //Excel文件的页面设置：横向打印   1-纵向,2-横向;
	LODOP.SET_SAVE_MODE("LINESTYLE", 1); //导出后的Excel是否有边框
	LODOP.SAVE_TO_FILE(title+".xls");
};

var LODOP; //声明为全局变量 
function preview() {
	CreatePrintPage();
	LODOP.PREVIEW();
}

function print() {
	CreatePrintPage();
	LODOP.PRINT();
}

function CreatePrintPage() {
	LODOP = getLodop(document.getElementById('LODOP_OB'), document.getElementById('LODOP_EM'));
	var strBodyStyle = "<style>table,th,td{border:1 solid #000000;border-collapse:collapse}</style>";
	var strFormHtml = strBodyStyle + "<body>" + document.getElementById("content").innerHTML + "</body>";
	LODOP.PRINT_INITA(10, 10, 754, 453, "打印控件操作");
	//LODOP.SET_PRINT_PAGESIZE (2, 0, 0,"A4");//设置页面打印方式
	LODOP.ADD_PRINT_TEXT(21, 300, 350, 30, title+"\n");
	LODOP.SET_PRINT_STYLEA(0, "FontSize", 15);
	LODOP.SET_PRINT_STYLEA(0, "ItemType", 1);
	LODOP.SET_PRINT_STYLEA(0, "Horient", 2);
	LODOP.SET_PRINT_STYLEA(0, "Bold", 1);
	var makeTime=new Date().toLocaleDateString()+" "+new Date().toLocaleTimeString();
	LODOP.ADD_PRINT_TEXT(40, 60, 350, 30, "制表日期:"+makeTime+"  制表人:"+maker);
	LODOP.SET_PRINT_STYLEA(0, "ItemType", 1);
	LODOP.ADD_PRINT_HTM(63, 38, 684, 330, strFormHtml);
	LODOP.SET_PRINT_STYLEA(0, "FontSize", 15);
	LODOP.SET_PRINT_STYLEA(0, "ItemType", 4);
	LODOP.SET_PRINT_STYLEA(0, "Horient", 3);
	LODOP.SET_PRINT_STYLEA(0, "Vorient", 3);
	LODOP.ADD_PRINT_LINE(53, 23, 52, 725, 0, 1);
	LODOP.SET_PRINT_STYLEA(0, "ItemType", 1);
	LODOP.SET_PRINT_STYLEA(0, "Horient", 3);
	LODOP.ADD_PRINT_LINE(414, 23, 413, 725, 0, 1);
	LODOP.SET_PRINT_STYLEA(0, "ItemType", 1);
	LODOP.SET_PRINT_STYLEA(0, "Horient", 3);
	LODOP.SET_PRINT_STYLEA(0, "Vorient", 1);
	LODOP.ADD_PRINT_TEXT(421, 542, 165, 22, "第#页/共&页");
	LODOP.SET_PRINT_STYLEA(0, "ItemType", 2);
	LODOP.SET_PRINT_STYLEA(0, "Horient", 1);
	LODOP.SET_PRINT_STYLEA(0, "Vorient", 1);
}