配件动态信息 action包

1、AddOutsourcingMaintenanceAction.java             提交委外检修，添加数据
2、AddToRepairExistPjSDInfoAction.java              已经在动态配件款存在的配件（添加待修配件）
4、AddToRepairNotExistPjSDInfoAction.java           不存在动态配件款存在的配件（添加待修配件），走下车入库检修流程，先入库主仓库，再移库班组库
5、FindPjStoreDynamicInfoByPjdCodeAction.java       通过配件编码获取信息
6、QueryPjSDInfoByChooseFixPjAction.java            多条件查询动态配件
7、QueryPjStoreDynamicInfoAction.java               查询动态配件
8、SureFixPjStoreDynamicInfoAction.java             点击选择检修，改变配件检修状态
9、ToAddPjSDInfoForRepairChildIframeAciton.java     跳至addPjSDInfoForRepairChildIframe.jsp页面
10、ToChoosePjSDInfoAction.java                     跳至配件大类--添加待修配件--选择（按钮）--选中动态配件对话框
11、ToOutsourcingMaintenanceAction.java             跳转到委外检修窗口

