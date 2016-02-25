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
  <body>&nbsp; 
    <!--uurframe盒子模型   上方					开始-->
      <div panelTitle="移库" roller="false" overflow="true" style="text-align:center;">
      	
		    <table class="tableStyle" transMode="true">
			   		<div>
					   		<input type="radio" name="rdCheck" id="rdCheck_1" value="${pjStoreDynamic.dictStorePosition.storePositionType }"/>配件仓库移库班组库
					   		<input type="radio" name="rdCheck" id="rdCheck_2" value="${pjStoreDynamic.dictStorePosition.storePositionType }"/>班组库移库配件仓库	
					   		<input type="radio" name="rdCheck" id="rdCheck_3" value="${pjStoreDynamic.dictStorePosition.storePositionType }"/>班祖库移库班祖库
				   	</div>
			 
			   
			   		<div style="text-align:center;" id="rdCheckDivPjPro">
			   		<form  action="" method="post" target="frmright" name="recordSpSubmitFir" id="recordSpSubmitFir">
			   			<c:forEach items="${pjStoreDynamicInfoIds }" var="pjStoreDynamicInfoId">
			   				<input type="hidden" name="pjStoreDynamicInfoId" id="pjStoreDynamicInfoId_rdCheck_1" value="${pjStoreDynamicInfoId }"/>
			   			</c:forEach>
			   			 配件名称:${pjStoreDynamic.pjStoreStaticInfo.pjName }<br/>
			   			 编号:${pjStoreDynamic.id }<br/>
			   			 配件仓库人员
			   			 <c:forEach items="${pjStoreDynamic.pjSDInfoRecords }" var="pjSDInfoRecord">
							   <c:forEach items="${pjSDInfoRecord.pjSDInfoRecordSus }" var="pjSDInfoRecordSu">
							       <input type="hidden" value="${pjSDInfoRecordSu.usersPrivs.id }" id="storeUsersId_rdCheck_1" name="storeUsersId"/>
							       ${pjSDInfoRecordSu.usersPrivs.userName }
							   </c:forEach>
						</c:forEach>
			   			 <br/>
			   			 移入仓库：
			   			 <select  name="dictStorePositionId" id="dictStorePositionId_rdCheck_1" class="default"  >
			   			 	<c:forEach items="${dictStorePositionList }" var="dictStorePosition">
			   			 		<c:if test="${dictStorePosition.storePositionType == 2}">
			   						<option value="${dictStorePosition.id }">${dictStorePosition.storePositionName }</option>
			   					</c:if>
			   				</c:forEach>
			   			</select><br/>
			   			班组人员：
			   			<select name="proteamUsersId"  id="proteamUsersId_rdCheck_1"  class="default" >
			   			 	<c:forEach items="${usersList }" var="users">
			   			 		<c:if test="${users.dictProteam !=null }">
			   						<option value="${users.id }">${users.dictProteam.proteamName}人员-${users.userName }</option>
			   					</c:if>
			   				</c:forEach>
			   			</select><br/>	
			   			<input type="submit" value="移库" id="recordSpSubmitFirBtn"><br/>
			   			</form>
			   		</div>
			   		<div style="text-align:center;" id="rdCheckDivProPj">
			   		<form action="" method="post" target="frmright" name="recordSpSubmitSec" id="recordSpSubmitSec">
			   			<c:forEach items="${pjStoreDynamicInfoIds }" var="pjStoreDynamicInfoId">
			   				<input type="hidden" name="pjStoreDynamicInfoId" id="pjStoreDynamicInfoId_rdCheck_2" value="${pjStoreDynamicInfoId }"/>
			   			</c:forEach>
			   			 配件名称:${pjStoreDynamic.pjStoreStaticInfo.pjName }<br/>
			   			 编号:${pjStoreDynamic.id }<br/>
			   			 班组库人员
			   			
			   			 <c:forEach items="${pjStoreDynamic.pjSDInfoRecords }" var="pjSDInfoRecord">
							   <c:forEach items="${pjSDInfoRecord.pjSDInfoRecordSps }" var="pjSDInfoRecordSp">
								       <input type="hidden" value="${pjSDInfoRecordSp.proteamUsers.id }" id="proteamUsersId_rdCheck_2" name="proteamUsersId"/>
								       ${pjSDInfoRecordSp.proteamUsers.userName }
							   </c:forEach>
						</c:forEach>

			   			 <br/>
			   			 移入仓库：
			   			 <select    id="dictStorePositionId_rdCheck_2" name="dictStorePositionId"  class="default" >
			   			 	<c:forEach items="${dictStorePositionList }" var="dictStorePosition">
			   			 		<c:if test="${dictStorePosition.storePositionType == 0 || dictStorePosition.storePositionType == 1}">
			   						<option value="${dictStorePosition.id }">${dictStorePosition.storePositionName }</option>
			   					</c:if>
			   				</c:forEach>
			   			</select><br/>
			   		            配件仓库人员：
			   			<select id="storeUsersId_rdCheck_2" name="storeUsersId"  class="default" >
			   			 	<c:forEach items="${usersList }" var="users">
			   					<option value="${users.id }">配件仓库人员-${users.userName }</option>
			   				</c:forEach>
			   			</select><br/>
			   			<input type="submit" value="移库" id="recordSpSubmitSecBtn" name="recordSpSubmitSecBtn"><br/>
			   		    </form>
			   		</div>
			   		<div style="text-align:center;" id="rdCheckDivProPro">
			   		<form  action="" method="post" target="frmright" name="recordSpSubmitThr" id="recordSpSubmitSecThr">
	   					<c:forEach items="${pjStoreDynamicInfoIds }" var="pjStoreDynamicInfoId">
			   				<input type="hidden" name="pjStoreDynamicInfoId" id="pjStoreDynamicInfoId_rdCheck_3" value="${pjStoreDynamicInfoId }"/>
			   			</c:forEach>
			   			 配件名称:${pjStoreDynamic.pjStoreStaticInfo.pjName }<br/>
			   			 <input type="hidden" value="${pjStoreDynamic.id }" name="pjStoreDynamicInfoId"/>
			   			 编号:${pjStoreDynamic.id }<br/>
			   			 班组库人员：
					    <c:forEach items="${pjStoreDynamic.pjSDInfoRecords }" var="pjSDInfoRecord">
							   <c:forEach items="${pjSDInfoRecord.pjSDInfoRecordSps }" var="pjSDInfoRecordSp">
								       <input type="hidden" value="${pjSDInfoRecordSp.proteamUsers.id }" name="proteamUsersBIDS"/>
								       ${pjSDInfoRecordSp.proteamUsers.userName }
							   </c:forEach>
						</c:forEach>
			   			 <br/>
			   			 移入仓库：
			   			 <select  id="dictStorePositionId_rdCheck_3"  class="default" >
			   			 	<c:forEach items="${dictStorePositionList }" var="dictStorePosition">
			   			 		<c:if test="${dictStorePosition.storePositionType == 2 }">
			   						<option value="${dictStorePosition.id }">${dictStorePosition.storePositionName }</option>
			   					</c:if>
			   				</c:forEach>
			   			</select><br/>
			   			班组人员：
			   			<select id="proteamUsersId_rdCheck_3" name="usersPrivsByProteamUsersAId.id"  class="default" >
			   			 	<c:forEach items="${usersList }" var="users">
			   			 		<c:if test="${users.dictProteam != null }">
			   						<option value="${users.id }">${users.dictProteam.proteamName}人员-${users.userName }</option>
			   					</c:if>
			   				</c:forEach>
			   			</select><br/>	
			   			<input type="submit" value="移库" id="recordSpSubmitThrBtn" name="recordSpSubmitThrBtn"><br/>
			   		</form>
			   		</div>
			</table>
     </div>
     	<!-- 自定义js -->
     	<script src="${ctx}/js/pj/moveStorePositionDialog_script.js"></script>
        <!--uurframe盒子模型下方						结束-->
  </body>
</html>
