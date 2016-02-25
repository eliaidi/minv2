package com.repair.constant;

/**
 * 
 * @see 提示信息相关常量，主要存储各种操作后的提示信息
 * @author 周云韬
 * @date 2016-1-6
 * @version 1.0
 */
public interface MessageConstants {

	/** 错误代码：未登录 */
	Integer ERRCODE_NOT_LOGIN=-1;
	
	/** 错误代码：没有错误 */
	Integer ERRCODE_NOT_ERROR=0;
	
	/** 错误代码：出现异常 */
	Integer ERRCODE_EXCEPTION=1;
	
	
	/** 提示信息：没有登录*/
	String MSG_NOT_LOGIN="请先登录";
	
	/** 提示信息：操作成功*/
	String MSG_OPERATOR_SUCCESS="操作成功";
	
	/** 提示信息：操作失败*/
	String MSG_OPERATOR_ERROR="操作失败";
	
}
