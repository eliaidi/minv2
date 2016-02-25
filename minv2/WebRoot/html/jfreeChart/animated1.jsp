<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<title>甘特图</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		
		
		<link href="../../../../mainframe/css/import_basic.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="../../../../mainframe/js/jquery-1.4.js"></script>
		<script type="text/javascript" src="../../../../mainframe/js/bsFormat.js"></script>
		<script type="text/javascript" src="../../../../mainframe/js/framework.js"></script>
		
		<link rel="stylesheet" id="skin" prePath="../../../../mainframe/" />
		<script type="text/javascript" src="../../../../js/My97DatePicker/WdatePicker.js"></script>
		
		 <script type="application/javascript" src="../../html/jfreeChart/awesomechart.js"> </script>
		<link href="../../html/jfreeChart/demoAnimated.css" type="text/css" rel="stylesheet" />
       
    </head>
    <body>
     
        
        <div class="charts_container">
            <div class="chart_container">
                <canvas id="chartCanvas1" width="400" height="400">
                	甘特图
                </canvas>
                </div>
            </div>
            
           
        <script type="application/javascript">
        
        	
        	var data;
            var chart1 = new AwesomeChart('chartCanvas1');
            chart1.title = "二号甘特图";
            for ( var i = 0; i < data.length; i++) {
            	chart1.data = [51.62,31.3,10.06,100,70.96,48.78,20.36];
                chart1.labels = [data[i].jcType];
                chart1.colors = ['#006CFF', '#FF6600', '#34A038', '#945D59', '#93BBF4', '#F493B8','cc33ff'];
			}
            chart1.randomColors = true;
            chart1.animate = true;
            chart1.animationFrames = 30;
            chart1.draw();
          
        </script>
        
    </body>
</html>

