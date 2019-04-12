package com.cn.hnny.service;

import java.util.List;

import com.cn.hnny.entity.Img;

public interface ImgService {
	  List<Img> findType(String type,int status);
	  int delete(String id);
	  int update(Img i);
	  Img findByid(String id);
	  int add(Img i);
	  List<Img> findType(String type);
	}
