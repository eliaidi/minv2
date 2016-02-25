<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>


<html>
	
  <head>
  	<title>机务检修信息管理系统-配件管理-->配件-->新件入库右边Iframe</title>
  	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  
   
   
   <script>
   	$(function(){
		//弹窗中将下面的width和height设为一个合适的数值让窗口不出现滚动条
		$('.flexiStyle').flexigrid({
			height:290,
			width:870,
			resizable: false,
			showToggleBtn: false
		});	
	})
   </script>
 </head>
  
  <body>
    <!-- 用户管理 功能操作和数据显示区域    动态配件管理 ************ -->
  	<div class="box2" panelTitle="动态配件管理" panelHeight="520">
		<table width="100%">
			<!-- *********	操作功能区  start  ********** -->
			<tr>
				<td width="100%" >
					<div panelTitle="" roller="true" overflow="auto">
						<table >
							<tr>
								<td>
									静态配件名称:<input type="text" value="必填,PY或名称联想输入" />
								</td>
								<td>
									&nbsp; 出厂日期:<input type="text"/>
								</td>
								<td>
									 &nbsp;收件人员：<input type="text" color="red" value="张飞" style="width:130px"/>
								</td>
							</tr>
							<tr>
								<td align="right">
									&nbsp;入库仓库:
									<select>
										<option>0、长沙平库</option>
									</select>
								</td>
								<td>
									&nbsp; <span>入库价格:</span><input type="text" value="非必填项"/>
								</td>
								<td>
									&nbsp;<input type="checkbox" id="mainPosition"/><label for="mainPosition">主仓库与单位</label> 
								</td>
							</tr>
							<tr>
								<td colspan="2" align="right" ">
								&nbsp;生产厂家: 
									<input type="text" style="width:320px" value="非必填项"/>
								</td>
								<td>
									&nbsp;送件人员:<input type="text" value="单位/班组" style="width: 60px"/>&nbsp;<input style="width: 60px" type="text" value="姓名"/>
								</td>
							</tr>
							<tr>
								<td colspan="3">
									&nbsp;&nbsp;&nbsp;备  注: <input type="text" style="width:528px" value="非必填项"/>
								</td>
							</tr>
							<tr>
								<td colspan="3">
									配件名称：<font color="blue">继电器</font>&nbsp;&nbsp;&nbsp;
									配件编码：<input type="text" style="width:335px" value="通过外部设备扫描输入，或手工输入，不能为空"/>
									<button><span class="icon_add">添加</span></button>
								</td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
			<!-- *********	操作功能区  end  ********** -->
			
			<!-- ************************************************************************************************* -->
			
			<!-- *********	数据显示区  start  ********** -->
			<tr>
				<td>
					
					<table class="flexiStyle"  striped="true" useCheckBox="true">
							<thead>
								<tr>
									<th align="center" width="50"><span class="img_checkAllOff"></span></th>
									<th width="70">序号</th>
									<th width="150">配件编码</th>
									<th width="160">状态</th>
									<th width="150">入库日期</th>
									<th width="145">操作</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td ><input type="checkbox" name="userCkb"/></td>
									<td >2</td>
									<td >（动）00002</td>
									<td  >
										(动)新件合格
									</td>
									<td>（动）2015-6-1</td>
									
									<td>
										<button><span class="icon_edit" onclick='top.Dialog.open({URL:"iframePage/storeDynamicInfo/alertDialog/editDynamicInfoDialog.html",Title:"编辑动态配件",Height:450});'>修改</span></button>
										<button><span class="icon_delete">删除</span></button>
									</td>
								</tr>
								<tr>
									<td ><input type="checkbox" name="userCkb"/></td>
									<td >1</td>
									<td >（动）00001</td>
									<td>
										(动)新件合格
									</td>
									<td >（动）2015-6-1</td>
									
									<td >
										<button><span class="icon_edit" onclick="">修改</span></button>
										<button><span class="icon_delete">删除</span></button>
									</td>
								</tr>
								<tr>
									<td><input type="checkbox" name="userCkb"/></td>
									<td >1</td>
									<td >（动）00001</td>
									<td >
										(动)新件合格
									</td>
									<td >（动）2015-6-1</td>
									
									<td >
										<button><span class="icon_edit">修改</span></button>
										<button><span class="icon_delete">删除</span></button>
									</td>
								</tr>
								<tr>
									<td ><input type="checkbox" name="userCkb"/></td>
									<td >1</td>
									<td >（动）00001</td>
									<td>
										(动)新件合格
									</td>
									<td >（动）2015-6-1</td>
									
									<td >
										<button><span class="icon_edit">修改</span></button>
										<button><span class="icon_delete">删除</span></button>
									</td>
								</tr>
								<tr>
									<td><input type="checkbox" name="userCkb"/></td>
									<td >1</td>
									<td >（动）00001</td>
									<td >
										(动)新件合格
									</td>
									<td >（动）2015-6-1</td>
									
									<td >
										<button><span class="icon_edit">修改</span></button>
										<button><span class="icon_delete">删除</span></button>
									</td>
								</tr>
								<tr>
									<td ><input type="checkbox" name="userCkb"/></td>
									<td >1</td>
									<td >（动）00001</td>
									<td>
										(动)新件合格
									</td>
									<td >（动）2015-6-1</td>
									
									<td >
										<button><span class="icon_edit">修改</span></button>
										<button><span class="icon_delete">删除</span></button>
									</td>
								</tr>
								<tr>
									<td><input type="checkbox" name="userCkb"/></td>
									<td >1</td>
									<td >（动）00001</td>
									<td >
										(动)新件合格
									</td>
									<td >（动）2015-6-1</td>
									
									<td >
										<button><span class="icon_edit">修改</span></button>
										<button><span class="icon_delete">删除</span></button>
									</td>
								</tr>
								<tr>
									<td ><input type="checkbox" name="userCkb"/></td>
									<td >1</td>
									<td >（动）00001</td>
									<td>
										(动)新件合格
									</td>
									<td >（动）2015-6-1</td>
									
									<td >
										<button><span class="icon_edit">修改</span></button>
										<button><span class="icon_delete">删除</span></button>
									</td>
								</tr>
								<tr>
									<td><input type="checkbox" name="userCkb"/></td>
									<td >1</td>
									<td >（动）00001</td>
									<td >
										(动)新件合格
									</td>
									<td >（动）2015-6-1</td>
									
									<td >
										<button><span class="icon_edit">修改</span></button>
										<button><span class="icon_delete">删除</span></button>
									</td>
								</tr>
								<tr>
									<td ><input type="checkbox" name="userCkb"/></td>
									<td >1</td>
									<td >（动）00001</td>
									<td>
										(动)新件合格
									</td>
									<td >（动）2015-6-1</td>
									
									<td >
										<button><span class="icon_edit">修改</span></button>
										<button><span class="icon_delete">删除</span></button>
									</td>
								</tr>
								<tr>
									<td><input type="checkbox" name="userCkb"/></td>
									<td >1</td>
									<td >（动）00001</td>
									<td >
										(动)新件合格
									</td>
									<td >（动）2015-6-1</td>
									
									<td >
										<button><span class="icon_edit">修改</span></button>
										<button><span class="icon_delete">删除</span></button>
									</td>
								</tr>
								<tr>
									<td ><input type="checkbox" name="userCkb"/></td>
									<td >1</td>
									<td >（动）00001</td>
									<td>
										(动)新件合格
									</td>
									<td >（动）2015-6-1</td>
									
									<td >
										<button><span class="icon_edit">修改</span></button>
										<button><span class="icon_delete">删除</span></button>
									</td>
								</tr>
								<tr>
									<td><input type="checkbox" name="userCkb"/></td>
									<td >1</td>
									<td >（动）00001</td>
									<td >
										(动)新件合格
									</td>
									<td >（动）2015-6-1</td>
									
									<td >
										<button><span class="icon_edit">修改</span></button>
										<button><span class="icon_delete">删除</span></button>
									</td>
								</tr>
								<tr>
									<td ><input type="checkbox" name="userCkb"/></td>
									<td >1</td>
									<td >（动）00001</td>
									<td>
										(动)新件合格
									</td>
									<td >（动）2015-6-1</td>
									
									<td >
										<button><span class="icon_edit">修改</span></button>
										<button><span class="icon_delete">删除</span></button>
									</td>
								</tr>
								<tr>
									<td><input type="checkbox" name="userCkb"/></td>
									<td >1</td>
									<td >（动）00001</td>
									<td >
										(动)新件合格
									</td>
									<td >（动）2015-6-1</td>
									
									<td >
										<button><span class="icon_edit">修改</span></button>
										<button><span class="icon_delete">删除</span></button>
									</td>
								</tr>
							</tbody>
						</table>
					
				</td>
			</tr>
			<!-- *********	数据显示区  end  ********** -->
		</table>
	</div>
	<!-- 用户管理 功能操作和数据显示区域    end  ************* -->
	
	

	<!-- *********	分页信息显示区  start  ********** -->
	<div style="height:35px; width: 100%;">
		<div class="float_left padding5">
			
		</div>
		<div class="float_right padding5 paging">
			<div class="float_left padding_top4">
				<span class="paging_disabled"><a href="javascript:;">上一页</a></span>
				<span class="paging_current"><a href="javascript:;">1</a></span>
				<span><a href="javascript:;">2</a></span>
				<span><a href="javascript:;">3</a></span>
				<span>...</span>
				<span><a href="javascript:;">20</a></span>
				<span><a href="javascript:;">下一页</a></span>&nbsp;每页
			</div>
			<div class="float_left">
			    <select autoWidth="true">
					<option>10</option>
				    <option>20</option>
				    <option>50</option>
				    <option>100</option>
			    </select></div>
			<div class="float_left padding_top4">条记录</div>
			<div class="clear"></div>
		</div>
		<div class="clear"></div>
	</div>
	<!-- *********	分页信息显示区  start  ********** -->
  </body>
</html>
