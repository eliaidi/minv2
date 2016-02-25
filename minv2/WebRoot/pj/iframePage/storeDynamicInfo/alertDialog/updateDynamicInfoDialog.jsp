<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>

<html>
  <head>
  	<title>${cache['SYS_TITLE'][0].value}--->配件管理-配件-配件静态信息管理-新增</title>
  	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
 </head>
  
  <body>
     <div  panelTitle="配件静态信息管理-新增" roller="false" overflow="true" style="width:500px">
  		<form action="" method="post" id="updatePjStoreDynamicInfoSubmit" name="updatePjStoreDynamicInfoSubmit" >
	        <table  class="tableStyle" transMode="true" >
	           <tr>
	           		<input type="hidden" name="id" value="${id }"/>
	           		<td>收件人员：</td>
	           		<td><input type="text" name="pjSDInfoRecordSu.usersPrivs.userName" value='<c:forEach items="${pjStoreDynamic.pjSDInfoRecords }" var="pjSDInfoRecord"><c:forEach items="${pjSDInfoRecord.pjSDInfoRecordSus }" var="pjSDInfoRecordSu">${pjSDInfoRecordSu.usersPrivs.userName }[该项不能修改]</c:forEach></c:forEach>' disabled="disabled"/>
	           		<input type="hidden" name="pjSDInfoRecordSu.usersPrivs.id" value='<c:forEach items="${pjStoreDynamic.pjSDInfoRecords }" var="pjSDInfoRecord"><c:forEach items="${pjSDInfoRecord.pjSDInfoRecordSus }" var="pjSDInfoRecordSu">${pjSDInfoRecordSu.usersPrivs.id }</c:forEach></c:forEach>' readonly="readonly"/>
	           		</td>
	           </tr>
	           <tr>
	           		<td>送件人：</td>
	           		<td>
	           			<input type="text" name="pjSDInfoRecordSu.correlationUnit" value="<c:forEach items="${pjStoreDynamic.pjSDInfoRecords }" var="pjSDInfoRecord"><c:forEach items="${pjSDInfoRecord.pjSDInfoRecordSus }" var="pjSDInfoRecordSu">${pjSDInfoRecordSu.correlationUnit }</c:forEach></c:forEach>" />
	           			<input type="text" name="pjSDInfoRecordSu.correlationName" value="<c:forEach items="${pjStoreDynamic.pjSDInfoRecords }" var="pjSDInfoRecord"><c:forEach items="${pjSDInfoRecord.pjSDInfoRecordSus }" var="pjSDInfoRecordSu">${pjSDInfoRecordSu.correlationName }</c:forEach></c:forEach>" />
	           		</td>
	           </tr>
	            <tr>
	           		<td>配件名称：</td>
	           		<td>
	           		<input type="hidden" name="pjStoreStaticInfo.id" value="${pjStoreDynamic.pjStoreStaticInfo.id}"/>
	           		<input type="text" name="pjStoreStaticInfo.pjName" value="${pjStoreDynamic.pjStoreStaticInfo.pjName }" readonly = "readonly"/></td>
	           </tr>
	            <tr>
	           		<td>配件编码：</td>
	           		<td><input type="text" name="pjdCode"  value="${pjStoreDynamic.pjdCode }" readonly="readonly"/></td>
	           </tr>
	            <tr>
	           		<td>父级配件：</td>
	           		<td><input type="text" name="parentPjStoreDynamicInfo.id" value="${pjStoreDynamic.parentPjStoreDynamicInfo.id }"/></td>
	           </tr>
	            <tr>
	           		<td>专业：</td>
	           		<td>
						<c:forEach items="${pjStoreDynamic.pjStoreStaticInfo.pjStaticJcTypePjFUs  }" var="psjtp">
	           				${psjtp.jcTypePjFirstUnit.dictPjFirstUnit.firstUnitName }  
 	           			</c:forEach>
					</td>
	           </tr>
	            <tr>
	           		<td><font color="blue">适应车型：</font></td>
	           		<td>
	           			<c:forEach items="${pjStoreDynamic.pjStoreStaticInfo.pjStaticJcTypePjFUs  }" var="psjtp">
	           				${psjtp.jcTypePjFirstUnit.dictJcType.jcTypeValue }  &nbsp;&nbsp;&nbsp;
 	           			</c:forEach>
	           		</td>
	           </tr>
	            <tr>
	           		<td>入库仓库：</td>
	           		<td>
	           			<select name="dictStorePosition.id" colnum="3">
	           				<c:forEach items="${dictStorePositionList }" var="dictStorePosition">
			   					<option value="${dictStorePosition.id }">${dictStorePosition.storePositionName }</option>
			   				</c:forEach>
	           			</select>
	           		</td>
	           </tr>
	            <tr>
	           		<td>生产厂家：</td>
	           		<td><input type="text" name="pjdFactory" value='${pjStoreDynamic.pjdFactory }'/></td>
	           </tr>
	            <tr>
	           		<td>出厂日期：</td>
	           		<td><input type="text" name="pjdOutFactoryDate" value="${pjStoreDynamic.pjdOutFactoryDate }"/></td>
	           </tr>
	            <tr>
	           		<td>入库价格：</td>	
	           		<td><input type="text" name="pjdInPrice" value="${pjStoreDynamic.pjdInPrice }" />元</td>
	           </tr>
	            <tr>
	           		<td><br /></td>
	           		<td><input type="radio" name="" value="2" checked/>单位入库主仓库</td>
	           </tr>
	            <tr>
	           		<td>备&nbsp;&nbsp;&nbsp;注</td>
	           		<td>
	           			<textarea style="width:450px;height:50px;"  name="remark">${pjStoreDynamic.remark }</textarea>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	           		
	           		</td>
	           </tr>
	         
	           <tr>
	           		<td colspan="2">
	           			<input type="submit" value="修改" id="updatePjStoreDynamicInfoSubmitById">
	           		</td>
	           	
	           </tr>
	        </table>
	      </form>
	     </div>
  </body>
  <!-- 自定义js 	-->
  <script type="text/javascript" src="${ctx}/js/pj/updateDynamicInfoDialog_script.js"></script>
</html>
