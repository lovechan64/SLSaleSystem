package org.slsale.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.slsale.common.Constants;
import org.slsale.common.PageSupport;
import org.slsale.pojo.User;
import org.slsale.pojo.UserAccount;
import org.slsale.pojo.UserAccountLog;
import org.slsale.pojo.UserCash;
import org.slsale.service.useraccount.UserAccountService;
import org.slsale.service.usercash.UserCashService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * UserCashController
 * @author bdqn_shy
 * @date 2014-4-24
 */

@Controller
public class UserCashController extends BaseController{
	
	private Logger logger = Logger.getLogger(UserCashController.class);
	
	@Resource
	private UserCashService service;
	@Resource
	private UserAccountService accountService;
	
	/**
	 * 获取提现明细信息列表（分页）
	 * @return
	 */
	@RequestMapping("/bank/apply_cash/list.html")
	public ModelAndView findUserCashList(HttpSession session,Model model,
			@RequestParam(value="currentpage",required=false)Integer currentpage ,
			@RequestParam(value="start",required=false)String start ,
			@RequestParam(value="end",required=false) String end){
		Map<String,Object> baseModel= (Map<String,Object>)session.getAttribute(Constants.SESSION_BASE_MODEL);
		if(baseModel == null){
			return new ModelAndView("redirect:/");
		}else{
			PageSupport page = null;
			User sessionUser =  ((User)session.getAttribute(Constants.SESSION_USER));
			UserCash cash = new UserCash();
			cash.setUserId(sessionUser.getId());
			try {
				page = service.getUserCashList(currentpage,start,end,cash);
			} catch (Exception e) {
				e.printStackTrace();
			}
			model.addAllAttributes(baseModel);
			model.addAttribute("page", page);
			model.addAttribute("start", start);
			model.addAttribute("end", end);

			return new ModelAndView("/bank/apply_cash/list");
		}
	}
	
	/**
	 * 去申请提现页面
	 * @return
	 */
	@RequestMapping("/bank/apply_cash/apply.html")
	public ModelAndView gotoApplyView(HttpSession session,Model model){
		Map<String,Object> baseModel= (Map<String,Object>)session.getAttribute(Constants.SESSION_BASE_MODEL);
		if(baseModel == null){
			return new ModelAndView("redirect:/");
		}else{
			User sessionUser =  ((User)session.getAttribute(Constants.SESSION_USER));
			UserAccount account = null;
			try {
				account = accountService.getUserAccountByUserId(null, sessionUser.getId(),true);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			model.addAllAttributes(baseModel);
			model.addAttribute("account", account);
			return new ModelAndView("/bank/apply_cash/apply");
		}
	}
	
	/**
	 * 执行申请提现操作
	 * @return
	 */
	@RequestMapping("/bank/apply_cash/doApply.html")
	public ModelAndView doApplyCash(HttpSession session,
			@ModelAttribute("cash") UserCash cash){
		Map<String,Object> baseModel= (Map<String,Object>)session.getAttribute(Constants.SESSION_BASE_MODEL);
		if(baseModel == null){
			return new ModelAndView("redirect:/");
		}else{
			User sessionUser =  ((User)session.getAttribute(Constants.SESSION_USER));
			cash.setUserId(sessionUser.getId());
			try {
				service.doApplyCash(cash);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return new ModelAndView("redirect:/bank/apply_cash/list.html");
		}
	}
	
}