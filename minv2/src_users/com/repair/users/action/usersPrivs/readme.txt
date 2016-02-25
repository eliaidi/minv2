名称：用户管理模块-用户action层
时间：2015-8-5 8：57
内容：
	1、DelUserByIdAction.java：通过Id删除Users[用户]
	2、FindAllUserAction.java：查找所有Users[用户]
	3、FindUserByDictAreaIdAction.java：通过地区（机务段）id查找Users[用户]
	4、FindUserByDictDepartIdAction.java：通过部门id查找Users[用户]
	5、FindUserByIdAction.java：通过id查找Users[用户]
	6、FindUserByNameAction.java：通过姓名查找Users[用户]
	7、UpdateUserPassByIdAction.java：通过id修改用户密码
	
	8、action中方法的修改：
	   （1）
	    com.repair.constant.Constants.java  中设置页面跳转参数常量。
	    	DEPART_USERS_MANAGE_CHILD_IFRAME="departUsersManageChildIframe";
	    	PROTEAM_USERS_MANAGE_CHILD_IFRAME="proteamUsersManageChildIframe";
	        ....
	    
	    
	   （2）用户action中的execute分为executeDepart(部门的执行方法)、executeProteam(班组的执行方法)、executeDepartProteam(部门和班组的执行方法)的action执行方法，以后以此类推。
	   （3）如果action中的某个方法，Depart和Proteam都能使用，那么在action中提取这个方法，为公共方法，然后用executeDepart和executeProteam，调用该公共方法。
	        比如：addUsers这个功能，Depart和Proteam都能使用，那就编码格式如下：
	        	
	        	//公共方法
	        	public String addUsers(){
	        		//获取页面数据
	        		//调用service层方法
	        	}
	        	
	        	public void executeDepart(){
	        		addUsers(); //调用公共的方法
	        		return DEPART_USERS_MANAGE_CHILD_IFRAME; //调用页面跳转参数常量
	        	}
	        	
	        	public void executeProteam(){
	        		addUsers();//调用公共的方法
	        		return PROTEAM_USERS_MANAGE_CHILD_IFRAME; //调用页面跳转参数常量
	        	}
	     (4)页面用action名！executeDepart|executeProteam来调用该方法。
	   
	   
	