package com.fei.entity;

import java.util.ArrayList;
import java.util.List;

public class Page {
	private int currPage;//当前页
	private int pageSize = 10;//当前页可以容纳多少数据
	private int totalCount;//总记录数
	private int totalPageCount=1;//总页数
	private List<News> newsList;//每页新闻集合
	
	public int getCurrPage() {
		//判断当前页是否大于总页数--另外一种是在分页控制页面控制
		if(currPage>totalPageCount) {
			currPage=totalPageCount;
		}
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	//设置每页显示的数据个数
	public void setPageSize(int pageSize) {
		//判断页面中每页的显示的数据如果为0则给值10，要不然参数新pageSize
		this.pageSize = pageSize==0?10:pageSize;
	}
	//
	public int getTotalCount() {
		return totalCount;
	}
	//计算总记录数，根据综合记录数计算总页数
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		//计算总页数
		if(totalCount>0) {
		//不小于一时，则用三元运算符判断最后显示的数据是不是等于零，用于解决最后一页显示最后一条数据和我们每页显示10条数据的冲突
			totalPageCount = this.totalCount % this.pageSize==0?
					this.totalCount/this.pageSize//当能除尽的情况下
					:(this.totalCount/this.pageSize)+1;//除不尽时，当 101 10/11
		}else {
			totalPageCount=0;
		}
	}
	public int getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	public List<News> getNewsList() {
		return newsList;
	}
	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}	
}
