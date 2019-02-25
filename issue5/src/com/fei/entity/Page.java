package com.fei.entity;

import java.util.ArrayList;
import java.util.List;

public class Page {
	private int currPage;//��ǰҳ
	private int pageSize = 10;//��ǰҳ�������ɶ�������
	private int totalCount;//�ܼ�¼��
	private int totalPageCount=1;//��ҳ��
	private List<News> newsList;//ÿҳ���ż���
	
	public int getCurrPage() {
		//�жϵ�ǰҳ�Ƿ������ҳ��--����һ�����ڷ�ҳ����ҳ�����
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
	//����ÿҳ��ʾ�����ݸ���
	public void setPageSize(int pageSize) {
		//�ж�ҳ����ÿҳ����ʾ���������Ϊ0���ֵ10��Ҫ��Ȼ������pageSize
		this.pageSize = pageSize==0?10:pageSize;
	}
	//
	public int getTotalCount() {
		return totalCount;
	}
	//�����ܼ�¼���������ۺϼ�¼��������ҳ��
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		//������ҳ��
		if(totalCount>0) {
		//��С��һʱ��������Ԫ������ж������ʾ�������ǲ��ǵ����㣬���ڽ�����һҳ��ʾ���һ�����ݺ�����ÿҳ��ʾ10�����ݵĳ�ͻ
			totalPageCount = this.totalCount % this.pageSize==0?
					this.totalCount/this.pageSize//���ܳ����������
					:(this.totalCount/this.pageSize)+1;//������ʱ���� 101 10/11
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
