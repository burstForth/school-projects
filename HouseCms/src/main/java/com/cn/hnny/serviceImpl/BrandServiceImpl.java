package com.cn.hnny.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnny.entity.Brand;
import com.cn.hnny.mapper.BrandMapper;
import com.cn.hnny.service.BrandService;
import com.cn.hnny.util.RedisTemplateUtil;

@Service
public class BrandServiceImpl  implements BrandService {
	@Resource
	private BrandMapper  brandmapper ;
	@Resource
	private RedisTemplateUtil redistemplateutil;
	public List<Brand> findByPage(Map<String, Object> map) {
		// TODO Auto-generated method stub
		String key=map.get("currpage").toString()+map.get("rows").toString()+"blist";
		List<Object> olist=redistemplateutil.lGet(key, 0, -1);
		List<Brand> list=new  ArrayList<Brand>();
		if(null!=olist &&olist.size()>0) {
			list=(List<Brand>) olist.get(0);
			return list;
		}else{
		
		List<Brand> ulist= brandmapper.findByPage(map);
		redistemplateutil.lSet(key, ulist,3);
		return  ulist;
		}
	}

	public int findByCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return brandmapper.findByCount(map);
	}

	public Brand findid(String id) {
		Brand b=(Brand) redistemplateutil.get(id);
		if(b!=null) {
			return b;
		}else {
			Brand brand=new Brand();
			brand.setBid(id);
	        List<Brand> list=brandmapper.find(brand);
	        if(null!=list && list.size()>0) {
	        	redistemplateutil.set(id, list.get(0), 3);
	        	return list.get(0);
	        }
		}
			return null;
	}

	public int delete(String id) {
		// TODO Auto-generated method stub
		return brandmapper.delete(id);
	}

	public int add(Brand u) {
		// TODO Auto-generated method stub
		return brandmapper.add(u);
	}

	public int update(Brand u) {
		// TODO Auto-generated method stub
		return brandmapper.update(u);
	}

	public int batchDelete(String[] list) {
		// TODO Auto-generated method stub
		return brandmapper.batchDelete(list);
	}
	

}
