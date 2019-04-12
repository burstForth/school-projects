package com.cn.hnny.mapper;

import java.util.List;

import com.cn.hnny.entity.Project;

public interface ProjectMapper extends BaseMapper<Project> {
	List<Project> findProject(Project t);
}
