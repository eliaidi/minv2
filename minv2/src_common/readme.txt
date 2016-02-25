名称：普通类源文件夹。
说明：
	工具类包(com.repair.util，其中ServletContextUtil.java类为全局信息存储空间操作类，作用类似于Application)、
	实体类包(com.repair.entity)、
	异常类包(com.repair.util.exception，其中ExceptionAdvisor.java和ServiceException.java为全局异常类，如果需要定义自己的异常，需在该包下新建自定义包，方可自定异常)、
	过滤器包(com.repair.util.filter)、
	拦截器包(com.repair.util.interceptor)

	存放文件夹。该文件夹中的包为全局的，任何模块都可使用。
	
	
	智能提示包（com.repair.util.smartTips，其中SmartTips.java类为智能提示bean类，在访问时，转换为json格式，smartTips组件需要使用这种json格式）
	
	实体类相关工具包（com.repair.pojoUtil）