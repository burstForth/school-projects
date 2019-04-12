package com.cn.hnny.shiro;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import com.cn.hnny.entity.User;
import com.cn.hnny.service.UserService;
import com.cn.hnny.vo.UserRoleMenuVo;

public class UsersRealm extends AuthorizingRealm {

	@Resource
	private UserService userService;
	 @Override
	    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
	        // 从 token 中获取用户身份信息

	    	String username = (String) token.getPrincipal();
	    	String password = new String((char[])token.getCredentials());
	    	User u=null;
			try {
				u = userService.Login(username, DigestUtils.md5Hex(password));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        if(null!=u){
	        	 Subject subject = SecurityUtils.getSubject();
	        	 subject.getSession().setAttribute("user", u);
       }else{
	          throw new UnknownAccountException();
	        }
	        //返回认证信息由父类 AuthenticatingRealm 进行认证
	        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, password, getName());
	        return info;

	        
	    }
	    
	    /**
	     * 授权
	     */
	   @Override
	    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
	        // 获取身份信息
	        String username = (String) principals.getPrimaryPrincipal();
	        // 根据身份信息从数据库中查询权限数据
	        Map<String, Object> map=new HashMap<String, Object>();
	        //falg=3 查询button
	        map.put("falg", "3");
           map.put("uname", username);
	        // 将权限信息封闭为AuthorizationInfo
	        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
	        try {
	        	List<UserRoleMenuVo> list=userService.findUsersRoleMenuMap(map);
	        	if(null!=list){
	        		for (UserRoleMenuVo u: list) {
	        			simpleAuthorizationInfo.addStringPermission(u.getCode());
					}
	        	}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return simpleAuthorizationInfo;
	    }
	    public static void main(String[] args) {
			System.out.println(DigestUtils.md5Hex("123123"));
		}

}