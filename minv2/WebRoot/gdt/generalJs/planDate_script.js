$(function() {
	var basePath = $("#basePath").val();

	$("#subform").submit(function() {
		
	});

	$("#jcFixFreque").click(function() {
		var diag = new top.Dialog();
		diag.Title = "选择修程修次";
		diag.Width = 360;
		diag.Height = 320;
		diag.URL = basePath + "zx/toChoiceFixMileage.action";
		diag.OKEvent = function() {
			//获得弹出窗口window对象
			var doucmentWin = diag.innerFrame.contentWindow;
			//通过window对象调用弹出窗口的getFixFrequeRadioLine方法
			doucmentWin.getFixFrequeRadioLine();
			//获得弹出窗口中 ID为fixFreque的元素的值
			var fixfreque = doucmentWin.document.getElementById("fixFreque").value;
			var fixfrequeId = doucmentWin.document.getElementById("fixFrequeId").value;
			var extraFixFrequeId = doucmentWin.document.getElementById("extraFixFrequeId").value;
			var extraFixFreque = doucmentWin.document.getElementById("extraFixFreque").value;

			if (fixfreque != "") {
				$("#fixMileageValue").val(fixfreque);
				$("#fixMileageId").val(fixfrequeId);

				$("#extraFixMileageId").val(extraFixFrequeId);
				$("#extraFixMileage").val(extraFixFreque);

				diag.close();
			}
		}
		diag.show();

	})

	$("#jccurriculum").click(function() {
		var diag = new top.Dialog();
		diag.Title = "请选择车型";
		diag.Width = 360;
		diag.Height = 320;
		diag.URL = basePath + "zx/toChoiceJcInfo.action";
		diag.OKEvent = function() {
			var doucmentWin = diag.innerFrame.contentWindow;
			doucmentWin.getRadioLine();

			var jcTypeValue = doucmentWin.document
				.getElementById("jcTypeValue").value;
			var jcNumber = doucmentWin.document
				.getElementById("jcNumber").value;

			if (jcTypeValue != "") {
				$("#jcTypeValue").val(jcTypeValue);
				$("#jcNumber").val(jcNumber);
				diag.close();
			}
		};
		diag.show();

	});

	$("#jcweekplan").click(function() {
		var diag = new top.Dialog();
		diag.Title = "机车信息窗口";
		diag.Width = 360;
		diag.Height = 320;
		diag.URL = basePath + "zx/toChoiceBZJcMPRecorder.action";
		diag.OKEvent = function() {
			var doucmentWin = diag.innerFrame.contentWindow;
			var msg = doucmentWin.getRadioLine();

			var arr = msg.split('-');
			$("#jcTypeValue").val(arr[0]);
			$("#jcNumber").val(arr[1]);
			$("#fixMileageValue").val(arr[2]);
			$("#remark").val(arr[3]);
			$("#fixMileageId").val(arr[4]);

			if (msg != "") {
				diag.close();
			}
		};
		diag.show();

	});
});