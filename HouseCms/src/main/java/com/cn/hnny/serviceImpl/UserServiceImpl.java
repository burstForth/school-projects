package com.cn.hnny.serviceImpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnny.entity.User;
import com.cn.hnny.mapper.UserMapper;
import com.cn.hnny.service.UserService;
import com.cn.hnny.util.RedisTemplateUtil;
import com.cn.hnny.vo.UserRoleMenuVo;
@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper usermapper;
	@Resource
	private RedisTemplateUtil redistemplateutil;

	public User Login(String name, String pwd) {
		// TODO Auto-generated method stub
		User u=new User();
		u.setUname(name);
		u.setUpwd(pwd);
		u.setUstatus(1);
		List<User> list=usermapper.find(u);
		if(list!=null && list.size()>0) {
			return list.get(0);
		}	
		return null;
	}

	public List<UserRoleMenuVo> findUsersRoleMenuMap(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return usermapper.findUsersRoleMenuMap(map);
	}

	public List<User> findByPage(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return usermapper.findByPage(map);
	}

	public int findByCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return usermapper.findByCount(map);
	}

	public int delete(String id) {
		// TODO Auto-generated method stub
		return usermapper.delete(id);
	}

	public int add(User u) {
		// TODO Auto-generated method stub
		return usermapper.add(u);
	}

	public User findid(String id) {
		// TODO Auto-generated method stub
		User u=new User();
		u.setUid(id);
		List<User> list=usermapper.find(u);
		if(null!=list && list.size()>0) {
		return list.get(0);
		}else {
			return null;
		}
	}

	public List<User> findUid(String uid) {
		// TODO Auto-generated method stub
		User u=new User();
		u.setUid(uid);
		return usermapper.find(u);
	}

	public int update(User u) {
		// TODO Auto-generated method stub
		return usermapper.update(u);
	}

	public int batchDelete(String list[]) {
		// TODO Auto-generated method stub
		return usermapper.batchDelete(list);
	}

	public User findName(String name) {
		// TODO Auto-generated method stub
		User u=new User();
		u.setUname(name);
		List<User> list=usermapper.find(u);
		if(list!=null && list.size()>0) {
			return list.get(0);
		}	
		return null;
	}


}
