package com.repair.util.splitPage;

import com.repair.constant.Constants;

/**
 * 
* @ClassName: SearchDto
* @Description: TODO 分页搜索时需要使用的dto
* @author 周云韬
* @version V1.0  
* @date 2015-9-1 下午3:34:33
 */
public class SearchDto {
	/**  每页显示数据大小  */
	private int pageSize;
	
	/**  当前页数   */
	private int pageNo;

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		if(pageSize <= 0){
			this.pageSize=Constants.SPLIT_PAGE_DEFALT_SIZE;
		}else{
			this.pageSize = pageSize;
		}
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		if(pageNo <=0 ){
			this.pageNo = 1;
		}else{
			this.pageNo = pageNo;
		}
	}
}
