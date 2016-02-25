package com.repair.util.exception;

/**
* @ClassName: BusinessException
* @Description: 自定义异常业务处理类
* @author andy
* @version V1.0  
* @date Jul 24, 2015 10:06:49 AM
*/
public class ServiceException extends RuntimeException {
	private static final long serialVersionUID = 3152616724785436891L;  
	  
    public ServiceException(String frdMessage)  
    {  
        super(createFriendlyErrMsg(frdMessage));  
    }  
  
    public ServiceException(Throwable throwable)  
    {  
        super(throwable);  
    }  
  
    public ServiceException(Throwable throwable, String frdMessage)  
    {  
        super(throwable);  
    }  
  
    private static String createFriendlyErrMsg(String msgBody)  
    {  
        String prefixStr = "抱歉，";  
        String suffixStr = " 请稍后再试或与管理员联系！";  
  
        StringBuffer friendlyErrMsg = new StringBuffer("");  
  
        friendlyErrMsg.append(prefixStr);  
  
        friendlyErrMsg.append(msgBody);  
  
        friendlyErrMsg.append(suffixStr);  
  
        return friendlyErrMsg.toString();  
    }  
}
