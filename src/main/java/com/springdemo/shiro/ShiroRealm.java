package com.springdemo.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class ShiroRealm extends AuthorizingRealm {

	/* ����֤��Ϣ����¼��Ϣ���û���֤��Ϣ(non-Javadoc)
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		System.out.println("====================================func1 AuthenticationInfo invoked...");
		String username = (String) token.getPrincipal();				// Get username
		String password = new String((String) token.getCredentials());	// Get password
		if (username != null && password != null) {
			return new SimpleAuthenticationInfo(username, password, getName());
		} else 
			return null;
	}
	
	/* ����׼����Ȩ��Ϣ�� ��ѯ�ص�����(non-Javadoc)
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
		System.out.println("====================================func2 AuthorizationInfo invoked...");
		return null;
	}

}
