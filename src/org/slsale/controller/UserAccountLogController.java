package org.slsale.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.slsale.common.Constants;
import org.slsale.common.PageSupport;
import org.slsale.pojo.User;
import org.slsale.pojo.UserAccountLog;
import org.slsale.service.useraccountlog.UserAccountLogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * UserController
 * @author bdqn_shy
 * @date 2014-4-09
 */

@Controller
public class UserAccountLogController extends BaseController{
	
	private Logger logger = Logger.getLogger(UserAccountLogController.class);
	
	@Resource
	private UserAccountLogService service;
	
	/**
	 * 获取基本账户信息列表（分页）
	 * @return
	 */
	@RequestMapping("/bank/base_account/list.html")
	public ModelAndView baseAccountList(HttpSession session,Model model,
			@RequestParam(value="currentpage",required=false)Integer currentpage ,
			@RequestParam(value="start",required=false) String start){
		Map<String,Object> baseModel= (Map<String,Object>)session.getAttribute(Constants.SESSION_BASE_MODEL);
		if(baseModel == null){
			return new ModelAndView("redirect:/");
		}else{
			PageSupport page = null;
			User sessionUser =  ((User)session.getAttribute(Constants.SESSION_USER));
			UserAccountLog log = new UserAccountLog();
			log.setUserId(sessionUser.getId());
			String actionType = Constants.ACCOUNT_TYPE_BI+","+Constants.ACCOUNT_TYPE_BO+","+Constants.ACCOUNT_TYPE_T;
			log.setSearchStr1(actionType);
			try {
				page = service.getAccountLogList(currentpage,start,log);
			} catch (Exception e) {
				e.printStackTrace();
			}
			model.addAllAttributes(baseModel);
			model.addAttribute("page", page);
			model.addAttribute("start", start);

			return new ModelAndView("/bank/base_account/list");
		}
	}
	
	/**
	 * 获取重消账户信息列表（分页）
	 * @return
	 */
	@RequestMapping("/bank/repeated_account/list.html")
	public ModelAndView repeatedAccountList(HttpSession session,Model model,
			@RequestParam(value="currentpage",required=false)Integer currentpage ,
			@RequestParam(value="start",required=false) String start){
		Map<String,Object> baseModel= (Map<String,Object>)session.getAttribute(Constants.SESSION_BASE_MODEL);
		if(baseModel == null){
			return new ModelAndView("redirect:/");
		}else{
			PageSupport page = null;
			User sessionUser =  ((User)session.getAttribute(Constants.SESSION_USER));
			UserAccountLog log = new UserAccountLog();
			log.setUserId(sessionUser.getId());
			String actionType = Constants.ACCOUNT_TYPE_RI+","+Constants.ACCOUNT_TYPE_RO+","+Constants.ACCOUNT_TYPE_T;
			log.setSearchStr1(actionType);
			try {
				page = service.getAccountLogList(currentpage,start,log);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			model.addAllAttributes(baseModel);
			model.addAttribute("page", page);
			model.addAttribute("start", start);

			return new ModelAndView("/bank/repeated_account/list");
		}
	}
	
}