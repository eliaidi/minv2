名称：配置文件类源文件夹。
说明：
	文件夹：
		springConfig：存放spring和hibernate的配置文件
			文件：
				applicationContext_action_users.xml：action,users模块配置文件
				applicationContext_common.xml：数据库连接、资源文件读取、连接池配置、hibernate和jdbc模板配置
				applicationContext_dao.xml：dao层配置文件
				applicationContext_service.xml：service层配置文件
				applicationContext_tx.xml：事务配置和全局异常配置
				applicationContext_util.xml：工具类配置
				
		strutsConfig：存放struts2配置文件
			文件：
				struts_模块名.xml：struts配置文件，根据模块名命名。
	
	文件：
		ehcache.xml：二级缓存配置文件
		jdbc.properties：数据库连接信息资源文件
		log4j.dtd：日志dtd
		log4j.xml：日志配置文件
		struts.xml：struts总配置文件，包含strutsConfig文件夹中的配置文件
		
	所有该文件夹中的配置文件，无论是修改还是添加，都要写注释。
	注释模板如下：
		配置名及说明：班组，注入dao。日期：2015-08-17。作者：andy。
		
		
		
		
		
		WebRoot文件夹注释
			common:公共页面，如头，尾、标签导入页面等。
				checkLogin.jsp：检查等是否登入页面。
				common.jsp：相关组件导入页面（简，周云韬作）。 pjFix、zx、oil的模块使用，因为tablibs.jsp内组件想冲突。
				taglibs.jsp:相关组件导入页面（全）。users、pj模块使用。
				top.jsp：头页面。
			
			gdt:股道图文件夹。
			html：静态页面文件夹。
			images：图片文件夹。
			
			js：对应模块jsp页面的js文件。
			
			mainframe:UUR框架文件。
			tld：标签格式验证文件。
			
			users：用户管理模块页面。
			pj：配件管理模块页面。
			pjFix：配件检修模块页面。
			plan：计划模块页面。
			zx：中修模块页面。
			oil：油水化验模块页面。
			
			test：测试所有文件夹。
			
			login.jsp：登入页面。
			main：主页面。