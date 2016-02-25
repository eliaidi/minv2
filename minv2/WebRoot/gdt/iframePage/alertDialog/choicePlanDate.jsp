<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>

<html>

	<head>
		<title>选择待修机车页面</title>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		<script type="text/javascript" src="${urlctx}/gdt/hengyang_gdt/js/jccurriculum_script.js"></script>
		<script type="text/javascript" src="${ctx}/gdt/generalJs/choicePlanDate_script.js"></script>
	</head>
	<body>
		<fieldset>
			<legend>待修机车</legend>
			<table class="tableStyle" id="radioTable">
				<thead>
					<tr>
						<th width="2%"></th>
						<th>车型</th>
						<th>车号</th>
						<th>修程修次</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${!empty recList}">
						<c:forEach items="${recList}" var="entry">
							<tr>
								<td>
									<input type="radio" name="jiche" value="${entry.dictJcType.jcTypeValue}-${entry.jcNumber}"/>
								</td>
								<td>
									${entry.dictJcType.jcTypeValue}
								</td>
								<td>
									${entry.jcNumber}
								</td>
								<td>
								</td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</fieldset>
		<input type="hidden" id="jcTypeValue" />
		<input type="hidden" id="jcNumber" />
	</body>

</html>