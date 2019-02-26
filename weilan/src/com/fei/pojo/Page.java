package com.fei.pojo;

import java.util.List;
import java.util.Map;

public class Page {
	private int currCount;//当前页
	private int pageSize=5;//当前页显示新闻的数量
	private int count;//总的新闻数量
	private int totalPages;//总页数
	private List list;
	
	public int getCurrCount() {
		return currCount;
	}
	public void setCurrCount(int currCount) {
		this.currCount = currCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		if(count>pageSize) {
			totalPages=(count/pageSize)+1;
			if(currCount>totalPages) {
				currCount=totalPages;
			}	
		}else {
			totalPages=1;
			currCount=totalPages;
		}
		this.count = count;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	
	public String toString() {
		return "Page [currCount=" + currCount + ", pageSize=" + pageSize + ", count=" + count + ", totalPages="
				+ totalPages + ", list=" + list + "]";
	}
}
