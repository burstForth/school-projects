package com.fei.daoa;



import java.util.List;

import com.fei.entity.User;

public interface userDao {
	
public boolean userdao(User user);//��½

public boolean register(User us);//ע��

public boolean verification(User yu);//ע��ǰ��֤���ݿ��Ƿ��и��û�

public List<User> hu(int i);//��ѯ����id������û���id

public User hui(int i);//��ѯ�û�
}