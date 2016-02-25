<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=UTF-8"%>
<!--引用公共插件文件，每个jsp文件都引用该文件 --> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>

<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/struts-dojo-tags" prefix="sx"%>

<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>

<!-- 得到根路径 -->
<c:set value="<%=request.getContextPath()%>" var="ctx"></c:set>
<!-- 得到全路径 uur框架图标不显示，需要用到全路径，才能显示图片-->
<c:set value="<%=basePath%>" var="urlctx"></c:set>





<!--框架必需start-->
<script type="text/javascript" src="${urlctx}mainframe/js/jquery-1.4.js"></script>
<script type="text/javascript" src="${urlctx}mainframe/js/framework.js"></script>
<link href="${urlctx}mainframe/css/import_basic.css" rel="stylesheet" type="text/css"/>

<!-- uurframe页面框架                                                                                        开始-->
<!-- 所有的css都从mainframe目录开始找 -->
<link  rel="stylesheet" type="text/css"  id="skin" prePath="${urlctx}mainframe/"/>

<script type="text/javascript" src="${urlctx}mainframe/js/bsFormat.js"></script>
<!--框架必需end-->

<!-- uurframe表单验证码框架							开始 -->
<script src="${urlctx}mainframe/js/form/validationEngine-cn.js" type="text/javascript"></script>
<script src="${urlctx}mainframe/js/form/validationEngine.js" type="text/javascript"></script>
<!-- uurframe表单验证码框架							结束-->

<script type="text/javascript" src="${urlctx}mainframe/js/attention/floatPanel.js"></script>
<script type="text/javascript" src="${urlctx}mainframe/js/attention/messager.js"></script>
<%--
<!--修正IE6支持透明png图片start-->
<script type="text/javascript" src="${ctx}/mainframe/js/method/pngFix/supersleight.js"></script>
 --%>
 
 <%--
 <!--  滚动条                                                                                        开始-->
<script type="text/javascript" src="../js/mainframe/scroll/jquery.mousewheel.js"></script>
<script type="text/javascript" src="../js/mainframe/scroll/jScrollPane.js"></script>
  <!-- 滚动条                                                                                        结束-->
 --%>
 
<!--引入弹出窗组件 不使用mainframe/js/attention/zDialg整合组件（图标不能显示），使用js/zDialog_split独立组件（uur独立组件）， start-->
<script type="text/javascript" src="${urlctx}js/zDialog_split/zDrag.js"></script>
<script type="text/javascript" src="${urlctx}js/zDialog_split/zDialog.js"></script>
<!--引入弹出窗组件end-->

<!-- uurframe页面框架                                                                                        结束-->
<!-- dynatree树形菜单 				开始-->



 <!--多功能表格start-->
<link rel="stylesheet" type="text/css" href="${urlctx }mainframe/js/table/flexigrid/css/flexigrid/flexigrid.css">
<script type="text/javascript" src="${urlctx }mainframe/js/table/flexigrid/flexigrid.js"></script>
<!--多功能表格end-->


<!-- ztree树形菜单                                                   开始-->
<link rel="stylesheet" href="${urlctx}js/ztree/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="${urlctx}js/ztree/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="${urlctx}js/ztree/jquery.ztree.excheck-3.5.js"></script>
 <!-- ztree树形菜单                                                 结束-->
 
 <!-- 多选下拉框 -->
 <script type="text/javascript" src="${urlctx}mainframe/js/form/multiselect.js"></script>
 
<!-- 多级树形表格 --> 
<script type="text/javascript" src="${urlctx}mainframe/js/table/treeTable.js"></script>
 
<!-- 自定义样式和js文件 -->
<link rel="stylesheet" type="text/css" href="${urlctx}js/style.css" />
<script type="text/javascript" src="${urlctx}js/script.js" charset="UTF-8"></script>






<html>
<body>
	
	<div class="box2" panelTitle="功能面板" roller="false">
		<table>
			<tr>
				<td>院系:<input type="checkbox"/><input type="checkbox"/></td>
				<td><select id="dd">
					<option value="0">请选择</option>
					<option value="1">院系1</option>
					<option value="2">院系2</option>
					<option value="3">院系3</option>
				</select></td>
				<td>时间：</td>
				<td><input type="text" class="date"/></td>
				<td>关键词：</td>
				<td><input type="text" /></td>
				<td><button><span class="icon_find">查询</span></button></td>
			</tr>
			
		</table>
	</div>
<div id="scrollContent" class="border_gray">
	<table class="tableStyle">
		<tr>
			<th width="10%">姓名</th>
			<th width="10%">性别</th>
			<th width="5%">年龄</th>
			<th width="20%">工作</th>
			<th width="15%">联系方式</th>
			<th width="20%">住址</th>
			<th width="10%">婚姻状况</th>
			<th width="10%">操作</th>
		</tr>
		<tr>
			<td><input type="checkbox"/></td>
			<td>男</td>
			<td>25</td>
			<td>
				<span class="float_left">软件设计师</span>
				<span class="img_light" title="这里展示的提示信息，放置用于解释说明的文字。这里展示的提示信息，放置用于解释说明的文字。这里展示的提示信息，放置用于解释说明的文字。"></span>
			</td>
			<td>15012546548</td>
			<td>
				<span class="text_slice" style="width:200px;" title="这是一段很长的文字，当容器放不下则会出现省略号。这是一段很长的文字，当容器放不下则会出现省略号。这是一段很长的文字，当容器放不下则会出现省略号。">这是一段很长的文字，当容器放不下则会出现省略号。这是一段很长的文字，当容器放不下则会出现省略号。这是一段很长的文字，当容器放不下则会出现省略号。</span>
			</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>
				<span class="float_left">软件设计师</span>
				<span class="img_light" title="这里展示的提示信息，放置用于解释说明的文字。这里展示的提示信息，放置用于解释说明的文字。这里展示的提示信息，放置用于解释说明的文字。"></span>
			</td>
			<td>15012546548</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>
				<span class="float_left">软件设计师</span>
				<span class="img_light" title="这里展示的提示信息，放置用于解释说明的文字。这里展示的提示信息，放置用于解释说明的文字。这里展示的提示信息，放置用于解释说明的文字。"></span>
			</td>
			<td>15012546548</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>软件设计师</td>
			<td>15012546548</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>软件设计师</td>
			<td>15012546548</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>软件设计师</td>
			<td>15012546548</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>软件设计师</td>
			<td>15012546548</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>软件设计师</td>
			<td>15012546548</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>软件设计师</td>
			<td>15012546548</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>软件设计师</td>
			<td>15012546548</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>软件设计师</td>
			<td>15012546548</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>软件设计师</td>
			<td>15012546548</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>软件设计师</td>
			<td>15012546548</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>软件设计师</td>
			<td>15012546548</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>软件设计师</td>
			<td>15012546548</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>软件设计师</td>
			<td>15012546548</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>软件设计师</td>
			<td>15012546548</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>软件设计师</td>
			<td>15012546548</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>软件设计师</td>
			<td>15012546548</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>软件设计师</td>
			<td>15012546548</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>软件设计师</td>
			<td>15012546548</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>软件设计师</td>
			<td>15012546548</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>软件设计师</td>
			<td>15012546548</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>软件设计师</td>
			<td>15012546548</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>软件设计师</td>
			<td>15012546548</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>软件设计师</td>
			<td>15012546548</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>软件设计师</td>
			<td>15012546548</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>软件设计师</td>
			<td>15012546548</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>软件设计师</td>
			<td>15012546548</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
		<tr>
			<td>张小三</td>
			<td>男</td>
			<td>25</td>
			<td>软件设计师</td>
			<td>15012546548</td>
			<td>天津市和平区</td>
			<td>已婚</td>
			<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
		</tr>
	</table>
</div>


<div style="height:35px;">
	<div class="float_left padding5">
		<input type="button" value="本页代码"  
		onclick='top.Dialog.open({URL:"lesson/chapter4-5-code.html",Width:"100",Height:"100",Title:"本页代码"});'/>
	</div>
	<div class="float_right padding5 paging">
		<div class="float_left padding_top4">
		<span class="paging_disabled"><a href="javascript:;">上一页</a></span>
		<span class="paging_current"><a href="javascript:;">1</a></span>
		<span><a href="javascript:;">2</a></span>
		<span><a href="javascript:;">3</a></span>
		<span><a href="javascript:;">4</a></span>
		<span><a href="javascript:;">5</a></span>
		<span>...</span>
		<span><a href="javascript:;">20</a></span>
		<span><a href="javascript:;">下一页</a></span> 每页
		</div>
		<div class="float_left"><select autoWidth="true"><option>50</option><option>100</option><option>150</option></select></div>
		<div class="float_left padding_top4">条记录</div>
		<div class="clear"></div>
	</div>
	<div class="clear"></div>
</div>
						
</body>


  </body>
</html>

