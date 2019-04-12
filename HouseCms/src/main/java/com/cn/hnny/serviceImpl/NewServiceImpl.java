package com.cn.hnny.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnny.entity.Brand;
import com.cn.hnny.entity.New;
import com.cn.hnny.mapper.NewMapper;
import com.cn.hnny.service.NewService;
import com.cn.hnny.util.RedisTemplateUtil;
@Service
public class NewServiceImpl implements NewService{
	@Resource
	private NewMapper newMapper;
	
	@Resource
	private RedisTemplateUtil redisTemplateUtil;
	
	public New findntype(String ntype) {
		// TODO Auto-generated method stub
		return (New) newMapper.find(null);
	}

	
	public List<New> findByPage(Map<String, Object> map) {
		// TODO Auto-generated method stub
		String key=map.get("currpage").toString()+map.get("rows").toString()+"list";
		List<Object> olist=redisTemplateUtil.lGet(key, 0, -1);
		List<New> list=new  ArrayList<New>();
		if(null!=olist &&olist.size()>0) {
			list=(List<New>) olist.get(0);
			System.out.println("分页联查redis");
			return list;
		}else{
		
		List<New> ulist= newMapper.findByPage(map);
		redisTemplateUtil.lSet(key, ulist,1);
		System.out.println("分页联查mysql");
		return  ulist;
		}
	}

	
	public int findByCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return newMapper.findByCount(map);
	}


	public New findid(String id) {
		// TODO Auto-generated method stub
		New n=(New) redisTemplateUtil.get(id);
		if(n!=null) {	
			return n;
		}else {
			New ne=new New();
			ne.setNid(id);
	        List<New> list=newMapper.find(ne);
	        if(null!=list && list.size()>0) {
	        	redisTemplateUtil.set(id, list.get(0), 3);
	        	return list.get(0);
	        }
		}
			return null;
	}
public int delete(String id) {
		
		return newMapper.delete(id);
	}


	public int add(New n) {
		
		return newMapper.add(n);
	}

	public int batchDelete(String[] list) {
		// TODO Auto-generated method stub
		return newMapper.batchDelete(list);
	}

	public int update(New n) {
		
		return newMapper.update(n);
	}
	
}
