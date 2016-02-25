 $(function() {
	            $('.bluetable').colspan(3);
	            $('.bluetable').colspan(4);
	            $('.bluetable').colspan(5);
	            $('.bluetable').colspan(6);
	            $('.bluetable').colspan(9);
	            $('.bluetable').colspan(10);
	            $('.bluetable').colspan(11);
	            $('.bluetable').colspan(12);
	            $('#scoll_div_id').floatdiv("middletop");
	        }); 
	        
	        //EXCEL导出
		    function excelExport(rjhmId){
		    	$.post("query!excelExport.do",{"rjhmId":rjhmId },function(data){
		    		var datas = data.split(',');
		    		if(datas[0] == "success"){
		    			window.location.href = "<%=basePath%>"+ datas[1];
		    		}else if(datas[0] == 'nodata') {
		    			alert("没有数据！");
		    		}else {
		    			alert("导出失败！");
		    		}
		    	})
		    }

			function SaveAsFile(){ 
				var LODOP=getLodop(document.getElementById('LODOP_OB'),document.getElementById('LODOP_EM'));   
				LODOP.PRINT_INIT(""); 
				LODOP.ADD_PRINT_TABLE(100,20,500,80,document.getElementById("scrollContent").innerHTML); 
				LODOP.SET_SAVE_MODE("Orientation",1); //Excel文件的页面设置：横向打印   1-纵向,2-横向;
				LODOP.SET_SAVE_MODE("LINESTYLE",1);//导出后的Excel是否有边框
				LODOP.SAVE_TO_FILE("${datePlan.jcType }-${datePlan.jcnum }-${datePlan.fixFreque}交车检修项目记录.xls"); 
			};	

			var LODOP; //声明为全局变量 
			function preview(){
				CreatePrintPage();
				LODOP.PREVIEW();
			}

			function setup(){
				CreatePrintPage();
				//LODOP.PRINT_SETUP();
				LODOP.PRINT_DESIGN();
			}

			function print(){
				CreatePrintPage();
				LODOP.PRINT();	
			}

			function CreatePrintPage(){
				LODOP=getLodop(document.getElementById('LODOP_OB'),document.getElementById('LODOP_EM'));  
				var strBodyStyle="<style>table,td{border:1 solid #000000;border-collapse:collapse}</style>";
				var strFormHtml=strBodyStyle+"<body>"+document.getElementById("scrollContent").innerHTML+"</body>";
				LODOP.PRINT_INITA(10,10,754,453,"打印控件操作");
				LODOP.SET_PRINT_PAGESIZE (2, 0, 0,"A4");
				LODOP.ADD_PRINT_TEXT(21,300,300,30,"${datePlan.jcType }-${datePlan.jcnum }交车检测项目记录\n");
				LODOP.SET_PRINT_STYLEA(0,"FontSize",15);
				LODOP.SET_PRINT_STYLEA(0,"ItemType",1);
				LODOP.SET_PRINT_STYLEA(0,"Horient",2);
				LODOP.SET_PRINT_STYLEA(0,"Bold",1);
				LODOP.ADD_PRINT_TEXT(40,60,350,30,"机车号:${datePlan.jcType } ${datePlan.jcnum }  修程:${datePlan.fixFreque}  检修日期:${datePlan.kcsj }");
				LODOP.SET_PRINT_STYLEA(0,"ItemType",1);
				LODOP.ADD_PRINT_HTM(63,38,684,330,strFormHtml);
				LODOP.SET_PRINT_STYLEA(0,"FontSize",15);
				LODOP.SET_PRINT_STYLEA(0,"ItemType",4);
				LODOP.SET_PRINT_STYLEA(0,"Horient",3);
				LODOP.SET_PRINT_STYLEA(0,"Vorient",3);
				LODOP.ADD_PRINT_LINE(53,23,52,725,0,1);
				LODOP.SET_PRINT_STYLEA(0,"ItemType",1);
				LODOP.SET_PRINT_STYLEA(0,"Horient",3);
				LODOP.ADD_PRINT_LINE(414,23,413,725,0,1);
				LODOP.SET_PRINT_STYLEA(0,"ItemType",1);
				LODOP.SET_PRINT_STYLEA(0,"Horient",3);
				LODOP.SET_PRINT_STYLEA(0,"Vorient",1);
				//LODOP.ADD_PRINT_TEXT(421,37,144,22,"左下脚的文本小标题");
				//LODOP.SET_PRINT_STYLEA(0,"Vorient",1);
				LODOP.ADD_PRINT_TEXT(421,542,165,22,"第#页/共&页");
				LODOP.SET_PRINT_STYLEA(0,"ItemType",2);
				LODOP.SET_PRINT_STYLEA(0,"Horient",1);
				LODOP.SET_PRINT_STYLEA(0,"Vorient",1);
			}