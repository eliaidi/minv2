<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="${basePath}">
    
    <title>${cache['SYS_TITLE'][0].value}-用户管理</title>
    
  
    
    
    <!-- 截取文字   开始 -->
	<script type="text/javascript" src="${ctx}/js/flexigrid/text-overflow.js"></script>
	
	
	
  </head>
  
  <body>
	    <!-- *********	操作功能区  											开始 -->
	  	<div class="box2" showStatus="false" roller="false">
			<table>
				<tr>
					<td>角色:</td>
					<td>
						<select id="dd" colNum="3">
							<option value="0">请选择</option>
							<option value="1">院系1</option>
							<option value="2">院系2</option>
							<option value="3">院系3</option>
						</select>
					</td>
					<td>姓名：</td>
					<td>
						<input type="text" watermark="输入姓名"/>
					</td>
					<td>工号：</td>
					<td><input type="text" watermark="输入工号"/></td>
					<td><button><span class="icon_find">查询</span></button></td>
				</tr>
				<tr>
					<td colspan="7">
						<button onclick='top.Dialog.open({URL:"editUsers.jsp",Title:"新增用户",ShowCloseButton:true});'><span class="icon_add" />新建</span></button>
						
						<button onclick='top.Dialog.open({URL:"editUsers.jsp",Title:"修改用户",ShowCloseButton:true});'><span class="icon_edit">编辑</span></button>
						<button><span class="icon_mark">转移</span></button>
					</td>
				</tr>
			</table>
		</div>
		<!-- *********	操作功能区 											 结束 ********** -->
		
		<!-- *********	数据显示区 											 开始  ********** -->
		<div id="scrollContent" class="border_gray">
			<table class="tableStyle" id="tableCss">
				<tr>
					<th align="center" width="5%"><span class="img_checkAllOff"></span></th>
					<th width="10%">用户ID</th>
					<th width="5%">用户工号</th>
					<th width="20%">用户名称</th>
					<th width="15%">登录账号</th>
					<th width="10%">操作</th>
				</tr>
				<tr>
					<td><input type="checkbox" name="userCkb"/></td>
					<td>男</td>
					<td>25</td>
					<td>
						软件设计师
					</td>
					<td>15012546548</td>
					
					<td>
						<span class="img_view hand" title="查看" onclick='top.Dialog.open({URL:"findUsers.jsp",Title:"查看用户详情",ShowCloseButton:true,Height:310});'></span>
						<span class="img_edit hand" title="修改"></span>
						<span class="img_delete hand" title="删除"></span>
					</td>
				</tr>
				<tr>
					<td><input type="checkbox" name="userCkb"/></td>
					<td>男</td>
					<td>25</td>
					<td>
						软件设计师
					</td>
					<td>15012546548</td>
					
					<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
				</tr>
				<tr>
					<td><input type="checkbox" name="userCkb"/></td>
					<td>男</td>
					<td>25</td>
					<td>
						软件设计师
						</td>
					<td>15012546548</td>
					
					<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
				</tr>
				<tr>
					<td><input type="checkbox" name="userCkb"/></td>
					<td>男</td>
					<td>25</td>
					<td>软件设计师</td>
					<td>15012546548</td>
					
					<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
				</tr>
				<tr>
					<td><input type="checkbox" name="userCkb"/></td>
					<td>男</td>
					<td>25</td>
					<td>软件设计师</td>
					<td>15012546548</td>
					
					<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
				</tr>
				<tr>
					<td><input type="checkbox" name="userCkb"/></td>
					<td>男</td>
					<td>25</td>
					<td>软件设计师</td>
					<td>15012546548</td>
					
					<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
				</tr>
				<tr>
					<td><input type="checkbox" name="userCkb"/></td>
					<td>男</td>
					<td>25</td>
					<td>软件设计师</td>
					<td>15012546548</td>
					
					<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
				</tr>
				<tr>
					<td><input type="checkbox" name="userCkb"/></td>
					<td>男</td>
					<td>25</td>
					<td>软件设计师</td>
					<td>15012546548</td>
					
					<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
				</tr>
				<tr>
					<td><input type="checkbox" name="userCkb"/></td>
					<td>男</td>
					<td>25</td>
					<td>软件设计师</td>
					<td>15012546548</td>
					
					<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
				</tr>
				<tr>
					<td><input type="checkbox" name="userCkb"/></td>
					<td>男</td>
					<td>25</td>
					<td>软件设计师</td>
					<td>15012546548</td>
					
					<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
				</tr>
				<tr>
					<td><input type="checkbox" name="userCkb"/></td>
					<td>男</td>
					<td>25</td>
					<td>软件设计师</td>
					<td>15012546548</td>
					
					<td><span class="img_view hand" title="查看"></span><span class="img_edit hand" title="修改"></span><span class="img_delete hand" title="删除"></span></td>
				</tr>
				
			</table>
		</div>
		<!-- *********	数据显示区 											结束  ********** -->
	
		<!-- *********	分页信息显示区 									            开始  ********** -->
		<div style="height:35px;">
			<div class="float_left padding5">
				
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
				<span><a href="javascript:;">下一页</a></span>&nbsp;每页
				</div>
				<div class="float_left"><select autoWidth="true"><option>50</option><option>100</option><option>150</option></select></div>
				<div class="float_left padding_top4">条记录</div>
				<div class="clear"></div>
			</div>
			<div class="clear"></div>
		</div>
		<!-- *********	分页信息显示区 									          结束  ********** -->
  </body>
</html>
