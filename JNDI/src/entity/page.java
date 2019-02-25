package entity;

import java.util.List;

public class page {
	private int pid;
	private String content;
	private int currentPage;//当前页
	private int pageSize;//显示条数
	private int totalContent;//总新闻数
	private int totalPages;//总页数
	private List<page> allnews;
	
	public List<page> getAllnews() {
		return allnews;
	}
	public void setAllnews(List<page> allnews) {
		this.allnews = allnews;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getCurrentPage() {
		
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalContent() {
		return totalContent;
	}
	public void setTotalContent(int totalContent) {
		this.totalContent = totalContent;
		if(totalContent>pageSize) {
			totalPages=(totalContent/pageSize)+1;
			if(currentPage>totalPages) {
				currentPage=totalPages;
			}
		}else {
			totalPages=1;
		}
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	
	
}
