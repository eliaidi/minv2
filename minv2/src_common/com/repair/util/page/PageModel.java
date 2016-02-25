package com.repair.util.page;

import java.util.List;

/**
 * @ClassName: PageModel
 * @Description: TODO(分页实体类)
 * @author tangqian
 * @version V1.0  
 * @date 2015-8-10 上午09:33:38
 */
public class PageModel<T> {
	/**
	 * 查询出来的记录总数
	 */
	private int count;
	/**
	 * 每页显示的数据
	 */
	private List<T> datas;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<T> getDatas() {
		return datas;
	}
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	
}

