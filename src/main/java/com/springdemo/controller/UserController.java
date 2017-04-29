package com.springdemo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.springdemo.entity.User;
import com.springdemo.service.LoginService;
import com.springdemo.util.AppUtil;
import com.springdemo.util.PageData;

/**�û������࣬ͨ��/user���·��ӳ��
 * @author ��ֽб��
 *
 */
@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController {
	
	@Resource(name = "loginService")
	private LoginService loginService;
	
	@RequestMapping(value = "/goAddUser.do")
	public ModelAndView goAddUser() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/user_edit");
		return mv;
	}
	
	/**����DB����
	 * @param id
	 * @param username
	 * @param password
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/updateConfirm.do")
	public ModelAndView update(String id, String username, String password, String name) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("loginSuc");
		// Execute update here!
		User user = new User();
		user.setId(Integer.parseInt(id));
		user.setUsername(username);
		user.setPassword(password);
		user.setName(name);
		loginService.update(user);
		return mv;
	}
	
	/**
	 * ����ע���֪Spring������Ҫ�����صĶ�����Ϊ��Դ���͸��ͻ��ˣ�
	 * ������ת��ΪClient�ɽ��ܵı�����ʽ��ajax��ܹ�������		!important ��δ���Ҫ����
	 * @return map
	 */
	@RequestMapping(value = "/hasU.do")
	@ResponseBody
	public Object hasU() {
		Map<String,String> map = new HashMap<String,String>();
		String errInfo = "success";
		PageData pd = this.getPageData();
		if (loginService.findByUsername(pd) != null) {
			System.out.println("pd is not null, username exists");
			errInfo = "error";
		} else {
			System.out.println("pd is null!!!");
		}
		
		map.put("result", errInfo);
		return AppUtil.returnObject(pd, map);
	}
	
}
