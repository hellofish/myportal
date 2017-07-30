package com.wawa.common.utils;

import com.wawa.common.exception.PortalException;

public class Pagination {
	public static final int PAGE_SMALL_SIZE = 2;
	public static final int PAGE_DEFAULT_SIZE = 5;
	public static final int PAGE_LARGE_SIZE = 20;
	
	private int page;
	
	private int pageSize;
	
	public Pagination() throws PortalException {
		this(1);
	}
	
	public Pagination(int page) throws PortalException {
		this(page, PAGE_DEFAULT_SIZE);
	}
	public Pagination(int page,int pageSize) throws PortalException {
		if(page<1){
			throw new PortalException("页码必须大于1");
		}
		this.page = page;
		this.pageSize = pageSize;
	}
	
	public int getFirstResult(){
		return (page-1)*pageSize;
	}
	
	public int getMaxResult(){
		return this.pageSize;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	

}
