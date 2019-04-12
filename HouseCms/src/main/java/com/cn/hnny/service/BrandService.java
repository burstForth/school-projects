package com.cn.hnny.service;

import java.util.List;
import java.util.Map;

import com.cn.hnny.entity.Brand;

public interface BrandService {
   List<Brand> findByPage(Map<String, Object> map);
   int findByCount(Map<String, Object> map);
   Brand findid(String id);
   

   int delete(String id);
   int add(Brand u);
   int update(Brand u);
   int batchDelete(String list[]);
}
