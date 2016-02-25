function getRadioLine(){
				var msg;
				msg=$("#radioTable input[type=radio]").filter("[checked=true]").val();
				if (typeof(msg) == 'undefined') {
					top.Dialog.alert("请选择需要扣的机车！");
				} else {
					var typeAndNum =msg.split('-');
					$("#jcTypeValue").val(typeAndNum[0]);
					$("#jcNumber").val(typeAndNum[1]);
				}
			}