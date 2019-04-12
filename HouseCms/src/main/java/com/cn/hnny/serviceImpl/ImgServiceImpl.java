package com.cn.hnny.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnny.entity.Img;
import com.cn.hnny.entity.New;
import com.cn.hnny.mapper.ImgMapper;
import com.cn.hnny.service.ImgService;
import com.cn.hnny.util.RedisTemplateUtil;
@Service
public class ImgServiceImpl implements ImgService{
@Resource
private ImgMapper imgmapper;
@Resource
private RedisTemplateUtil  redisTemplateUtil;
	public List<Img> findType(String type,int status) {
		// TODO Auto-generated method stub
		List<Object> olist=redisTemplateUtil.lGet(type, 0, -1);
		List<Img> list=new  ArrayList<Img>();
		if(null!=olist &&olist.size()>0) {
			list=(List<Img>) olist.get(0);
			return list;
		}else{
		Img i=new Img();
		i.setType(type);
		i.setStatus(status);
		List<Img> ulist= imgmapper.find(i);
		redisTemplateUtil.lSet(type, ulist,1);
		return  ulist;
		}
		
	}
	public int update(Img u) {
		
		return imgmapper.update(u);
	}
	public Img findByid(String id) {
		// TODO Auto-generated method stub
		return (Img) imgmapper.find(null);
	}
public int delete(String id) {
		
		return imgmapper.delete(id);
	}
public int add(Img i) {
	// TODO Auto-generated method stub
	return imgmapper.add(i);
}
public List<Img> findType(String type) {
		// TODO Auto-generated method stub
		Img i=new Img();
		i.setType(type);
	   return imgmapper.find(i);
	}
}
