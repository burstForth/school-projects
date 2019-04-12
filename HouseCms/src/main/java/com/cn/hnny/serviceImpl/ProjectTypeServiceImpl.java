
package com.cn.hnny.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnny.entity.ProjectType;
import com.cn.hnny.mapper.ProjectTypeMapper;
import com.cn.hnny.service.ProjectTypeService;
import com.cn.hnny.util.RedisTemplateUtil;
@Service
public class ProjectTypeServiceImpl implements ProjectTypeService{
@Resource
private 	ProjectTypeMapper projecttypemapper;
@Resource
private RedisTemplateUtil redisTemplateUtil;
public List<ProjectType> findType() {
	
	return  projecttypemapper.find(null);
}

}
