分页组件使用说明：
第一步：导入 pager-taglib.jar包，taglib.tld 标签库
在web.xml配置如下：
<taglib>
	<taglib-uri>page-taglib</taglib-uri>
	<taglib-location>/WEB-INF/tld/taglib.tld</taglib-location>
</taglib>
第二步：编写分页相关java类，PageModel.java,SystemContext.java,PageDao.java,PageFilter.java
在web.xml配置如下：
<!-- 分页过滤器 -->
<filter>
	<filter-name>pageFilter</filter-name>
	<filter-class>com.repair.util.page.PageFilter</filter-class>
</filter>
<filter-mapping>
	<filter-name>pageFilter</filter-name>
	<url-pattern>/*</url-pattern>
	<dispatcher>FORWARD</dispatcher>
	<dispatcher>INCLUDE</dispatcher>
	<dispatcher>REQUEST</dispatcher>
</filter-mapping>
第三步：后台使用参照TestPageDaoImpl.java
第四步：前台使用参照test/testPage.jsp
注意引入：<%@ taglib prefix="pg" uri="page-taglib" %>