package com.repair.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import com.opensymphony.xwork2.conversion.impl.DefaultTypeConverter;

public class UtilDateConverter extends DefaultTypeConverter {
	@Override
	public Object convertValue(Map<String, Object> context, Object value,Class toType) {
		String[] formatStringArr={"yyyy-MM-dd HH:mm:ss.SSS","yyyy-MM-dd HH:mm:ss","yyyy-MM-dd HH:mm","yyyy-MM-dd"};
		
		SimpleDateFormat format = new SimpleDateFormat(formatStringArr[0]);
		
		
		if (toType == Date.class)// 把字符串转换为util.Date
		{
			Date date = null;
			String[] arr={};

			if (value != null ) {
				String str=null;
				if(value.getClass() == arr.getClass()){
					String[] strs = (String[]) value;
					str=strs[0];
				}else{
					str=(String) value;
				}
				
				for (int i = 0; i < formatStringArr.length; i++) {
					try {
						format = new SimpleDateFormat(formatStringArr[i]);
						date = format.parse(str);
						break;
					}
					catch (ParseException e) {
						if(i == formatStringArr.length-1){
							e.printStackTrace();
						}
					}catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		
			return date;
		} else if(toType == String.class){
			// 把Date转换为字符串
			Date d = (Date) value;
			String dateStr = null;
			for (int i = 0; i < formatStringArr.length; i++) {
				try {
					format = new SimpleDateFormat(formatStringArr[i]);
					dateStr = format.format(d);
					break;
				}
				catch (Exception e) {
					if(i == formatStringArr.length-1){
						e.printStackTrace();
					}
				}
			}
			
			
			return dateStr;
		}else{
			return value;
		}
	}

}
