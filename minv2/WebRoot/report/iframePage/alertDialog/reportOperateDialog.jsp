<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/common.jsp" %>
<html >

	<head>
		<title>报活 添加或修改</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
		<script type="text/javascript">
			//为了解决jQuery兼容问题
         	var jQuery_2_1_4 = $.noConflict(true);
       	</script>
		<script type="text/javascript" src="${urlctx}js/report/alertDialog/reportOperateDialog_script.js"></script>

	</head>

	<body>
		<input type="hidden" id="basePath" value="${urlctx }" />
		<div class="box1" whiteBg="true">
			<!-- frmright  jcmain leadmain-->
			<form action="${urlctx }report/saveJtReport.action" id="reportForm" onsubmit="return submitValidate();">
				<input type="hidden" name="id"  value="${jtReport.id}"/>
				<input type="hidden" id="planDateId" name="planDate.id" value="${param.planDateId }" />
				<table width="100%">
					<tr>
						<td width="50%" valign="top">
							<table>
								<tr>
									<td height="12px;"></td>
									<td></td>
								</tr>
								<tr>
									<td width="30%">
										<div style="text-align: right; margin-right: 20px;">报活类型：</div>
									</td>
									<td>
										
										<input type="radio" name="reportType" value="0" ${jtReport.reportType==0 ? 'checked' : ''}  onclick="zeroReport(this)"  />JT28报活
										<input type="radio" name="reportType" value="1" ${jtReport.reportType==1 ? 'checked' : '' } onclick="zeroReport(this)" />复检报活
										<input type="radio" name="reportType" value="2" ${jtReport.reportType==2 ? 'checked' : '' } onclick="zeroReport(this)" />过程报活
										<input type="radio" name="reportType" value="6" ${jtReport.reportType==6 ? 'checked' : '' }/>零公里报活
										<br/>
									</td>
								</tr>
								<tr>
									<td>
										<div style="text-align: right; margin-right: 20px;">班组：</div>
									</td>
									<td>
										<select id="proteamId" name="proteam.id" class="default" style="width: 209px;">
											<option value="">请选择班组名称</option>
										</select>&nbsp;&nbsp;&nbsp;
										<input type="checkbox" name="jcz" id="jczCheck" onclick="jczSelect();" />交车组
									</td>
								</tr>

								<tr>
									<td>
										<div style="text-align: right; margin-right: 20px;">故障所处：</div>
									</td>
									<td>
										<select id="firstUnit" class="default" style="width: 209px;">
											<option value="">请选择专业</option>
										</select>
										<br/>
										<select id="secondUnit" class="default" name="reportPart" style="margin-top: 5px;width: 209px;">
											<option value="">请选择部位</option>
										</select>
										<br/>
										<select id="thirdUnit" class="default" style="margin-top: 5px;width: 209px;">
											<option value="">请选择处所</option>
										</select>
									</td>
								</tr>
								<tr>
									<td>
										<div style="text-align: right; margin-right: 20px;">故障说明：</div>
									</td>
									<td>
										<textarea id="faultContent" name="reportCondition">${jtReport.reportCondition}</textarea>
									</td>
								</tr>
								<tr>
									<td>
										<div style="text-align: right; margin-right: 20px;">照片：</div>
									</td>
									<td valign="top">
										<input  name="reportImg" type="file" multiple />
									</td>
								</tr>
								<tr>
									<td>
										<div style="text-align: right; margin-right: 20px;">提票签字：</div>
									</td>
									<td>
										<input type="text" value="${loginUser.userName }" readonly="readonly" />
									</td>
								</tr>
							</table>
						</td>
						<td align="left" valign="top">
							<div style="overflow: auto;height: 435px;">
								<table width="100%" id="faultContentTable" border="1px" cellpadding="0" cellspacing="0">
									<tr bgcolor="lightblue">
										<th width="10px"></th>
										<th>故障内容</th>
									</tr>
								</table>
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center" height="30px">
							<input type="submit" id="subEnter" value="提 交 " />
							<input type="button" onclick="return getMyReport()" value="查看报活信息" />
						</td>
					</tr>
				</table>
			</form>
		</div>

	</body>

</html>