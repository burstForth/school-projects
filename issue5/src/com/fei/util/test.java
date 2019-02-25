package com.fei.util;



import java.util.List;

import com.fei.dao.impl.newsDaoImpl;
import com.fei.daoa.newsDao;
import com.fei.daoa.newsService;
import com.fei.entity.News;
import com.fei.entity.Page;
import com.fei.service.newsServiceImpl;

public class test {
	public static void main(String []args) {
		int currPage=9;
		int pageSize=10;
		newsDao a = new newsDaoImpl();
		Page p = new Page();
		System.out.println(a.getNewsCount());
		//System.out.println(a.getNewsa(1, 10));
		newsService e = new newsServiceImpl();
		Page f = e.huo(currPage, pageSize);
		if(currPage>f.getTotalPageCount()+1) {
			currPage = f.getTotalPageCount();
			f.setCurrPage(currPage);
			System.out.println(f.getCurrPage());	
		}
		System.out.println(f.getCurrPage());	
		System.out.println(f.getTotalPageCount());
		
		List<News> list = a.getNewsa((currPage-1)*pageSize,pageSize);
		if(list.isEmpty()) {
			List<News> lis = a.getNewsa((currPage-2)*pageSize,pageSize);
			for(News x:lis) {
				System.out.println(x);
			}
			System.out.println("十多年");
			if(lis.isEmpty()) {
				System.out.println("十多年");	
			}
		}
		
	}
}
