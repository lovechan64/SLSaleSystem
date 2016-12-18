package org.slsale.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.slsale.common.Constants;
import org.slsale.common.DateUtil;
import org.slsale.pojo.User;
import org.slsale.pojo.UserAccount;
import org.slsale.service.useraccount.UserAccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * UserController
 * @author bdqn_shy
 * @date 2014-4-23
 */

@Controller
public class UserAccountController extends BaseController{
	
	private Logger logger = Logger.getLogger(UserAccountController.class);
	
	@Resource
	private UserAccountService service;

	/**
	 * 去内部转账页面
	 * @return
	 */
	@RequestMapping("bank/transfer_accounts/transfer.html")
	public ModelAndView gotoTransferPageView(HttpSession session,Model model,
			@RequestParam(value="note",required=false) String note){
		Map<String,Object> baseModel= (Map<String,Object>)session.getAttribute(Constants.SESSION_BASE_MODEL);
		if(baseModel == null){
			return new ModelAndView("redirect:/");
		}else{
			User sessionUser =  ((User)session.getAttribute(Constants.SESSION_USER));
			UserAccount account = null;
			try {
				 account = service.getUserAccountByUserId(null, sessionUser.getId(),true);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			model.addAllAttributes(baseModel);
			model.addAttribute("account", account);
			
			return new ModelAndView("bank/transfer_accounts/transfer");
		}
	}
	
	/**
	 * 验证登录名是否存在
	 * @return
	 */
	@RequestMapping("bank/validateLoginName.html")
	@ResponseBody
	public Object validateLoginCode(@RequestParam String targetUser){
		String result = null;
		try {
			result = service.validateLoginCode(targetUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	/**
	 * 验证二级密码
	 * @return
	 */
	@RequestMapping("bank/validateLevelSencondPassword.html")
	@ResponseBody
	public Object validateLevelSencondPassword(HttpSession session,
			@RequestParam(value="password",required=false) String password){
		User sessionUser =  ((User)session.getAttribute(Constants.SESSION_USER));
		String pass2 = sessionUser.getPassword2();
		if(pass2!=null&&pass2.equals(password)){
			return "true";
		}
		
		return "false";
	}
	
	/**
	 * 执行内部转账操作
	 * @return
	 */
	@RequestMapping("/bank/doInternalTransfer.html")
	public ModelAndView doInternalTransfer(HttpSession session,
			@ModelAttribute("targetUser")String targetUser ,
			@ModelAttribute("transferMoney")String transferMoney ,
			@ModelAttribute("note") String note,
			Model model){
		@SuppressWarnings("unchecked")
		Map<String,Object> baseModel= (Map<String,Object>)session.getAttribute(Constants.SESSION_BASE_MODEL);
		if(baseModel == null){
			return new ModelAndView("redirect:/");
		}else{
				
			User sessionUser =  ((User)session.getAttribute(Constants.SESSION_USER));
			try {
				if(DateUtil.isNotEmpty(targetUser)&&DateUtil.isNotEmpty(transferMoney)){
					service.doInternalTransfer(targetUser,sessionUser.getId(),Double.parseDouble(transferMoney),note);
				}else{
					return new ModelAndView("redirect:/bank/transfer_accounts/transfer.html");
				}
			} catch (Exception e) {
				e.printStackTrace();
				return new ModelAndView("redirect:/bank/transfer_accounts/transfer.html");
			}
			
			return new ModelAndView("redirect:/bank/base_account/list.html");
		}
	}
}