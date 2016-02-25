package com.repair.util.page;

/**
 * @ClassName: SystemContext
 * @Description: TODO(分页多线程局部变量)
 * @author tangqian
 * @version V1.0  
 * @date 2015-8-10 上午09:39:51
 */

public class SystemContext {
	private static ThreadLocal<Integer> offsetLocal=new ThreadLocal<Integer>();
	private static ThreadLocal<Integer> pageSizeLocal=new ThreadLocal<Integer>();
	
	public static void setOffset(Integer offset) {
		offsetLocal.set(offset);
	}
	
	public static Integer getOffset(){
		return offsetLocal.get();
	}
	
	public static void removeOffset(){
		if(offsetLocal.get()!=null)
			offsetLocal.remove();
	}
	
	public static void setPageSize(Integer pageSize){
		pageSizeLocal.set(pageSize);
	}
	
	public static Integer getPageSize(){
		return pageSizeLocal.get();
	}
	
	public static void removePageSize(){
		if(pageSizeLocal.get()!=null)
			pageSizeLocal.remove();
	}
}
