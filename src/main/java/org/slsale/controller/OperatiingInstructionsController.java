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
public class OperatiingInstructionsController extends BaseController{
	
	private Logger logger = Logger.getLogger(OperatiingInstructionsController.class);
	
	@Resource
	private UserCashService service;
	@Resource
	private UserAccountService accountService;
	
	/**
	 * 获取提现明细信息列表（分页）
	 * @return
	 */
	@RequestMapping("/search/operating_instructions.html")
	public ModelAndView findUserCashList(HttpSession session,Model model){
		Map<String,Object> baseModel= (Map<String,Object>)session.getAttribute(Constants.SESSION_BASE_MODEL);
		if(baseModel == null){
			return new ModelAndView("redirect:/");
		}else{
			model.addAllAttributes(baseModel);

			return new ModelAndView("/search/operating_instructions");
		}
	}
	
	
}