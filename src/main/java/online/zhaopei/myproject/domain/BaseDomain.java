package online.zhaopei.myproject.domain;

import java.io.Serializable;

public class BaseDomain implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4859374345481326332L;

	private Integer pageNum;
	
	private Integer pageSize;

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
}
