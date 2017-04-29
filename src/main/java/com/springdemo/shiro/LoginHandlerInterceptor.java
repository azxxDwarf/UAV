package com.springdemo.shiro;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

import com.springdemo.entity.User;
import com.springdemo.util.Const;

/**��¼���������飬�൱��û��
 * @author ��ֽб��
 *
 */
public class LoginHandlerInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String path = request.getServletPath();
		System.out.println("What the path is: " + path);
		// The path is "/login.do"
		// TODO: Here to do jurisdiction...
		if (path.matches(Const.NO_INTERCEPTOR_PATH) || path.equals(""))	// �Լ��ˣ�������
			return true;
		if ("loginRedirect.do".equals(path.substring(1)))
			return true;
		Session session = SecurityUtils.getSubject().getSession();
		User user = (User) session.getAttribute("azxx");
		
		String contextPath = request.getContextPath();
		System.out.println("contextPath is: " + contextPath);
		// The contextPath is null!! ( http://localhost:8080/loginRedirect.do )
		if (user != null) {
			path = path.substring(1);
		}
		else {
			System.out.println("AZXX====User is null!");
//			System.out.println(user.toString());
			// Browser�����ض����������
		//	response.sendRedirect(contextPath + "loginRedirect.do");
		//	return false;
		}
		return true;
	}
}
