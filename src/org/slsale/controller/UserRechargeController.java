package org.slsale.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.slsale.common.Constants;
import org.slsale.common.DateUtil;
import org.slsale.common.PageSupport;
import org.slsale.common.Util;
import org.slsale.pojo.LeaveMessage;
import org.slsale.pojo.User;
import org.slsale.pojo.UserRecharge;
import org.slsale.service.userrecharge.UserRechargeService;
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
 * @date 2014-4-09
 */

@Controller
public class UserRechargeController extends BaseController{
	
	private Logger rechargeger = Logger.getLogger(UserRechargeController.class);
	
	@Resource
	private UserRechargeService service;
	
	/**
	 * 获取汇款账信息列表
	 * @return
	 */
	@RequestMapping("/bank/base_account/rechargeBill.html")
	public ModelAndView getRechargeList(HttpSession session,Model model,
			@RequestParam(value="currentpage",required=false)Integer currentpage){
		Map<String,Object> baseModel= (Map<String,Object>)session.getAttribute(Constants.SESSION_BASE_MODEL);
		if(baseModel == null){
			return new ModelAndView("redirect:/");
		}else{
			User sessionUser =  ((User)session.getAttribute(Constants.SESSION_USER));
			UserRecharge recharge = new UserRecharge();
			recharge.setUserId(sessionUser.getId());
			// pages
			PageSupport page = new PageSupport();
			if (currentpage != null)
				page.setPage(currentpage);
			try {
				page = service.getUserRechargeList(recharge,page);
			} catch (Exception e) {
				e.printStackTrace();
			}
			model.addAllAttributes(baseModel);
			model.addAttribute("page", page);
			
			return new ModelAndView("/bank/recharge/list");
		}
	}

	/**
	 * 添加未到账汇款单提醒通知
	 * @return
	 */
	@RequestMapping("/bank/base_account/addMessage.html")
	@ResponseBody
	public Object addMessage(HttpSession session,
			@RequestParam String id){
		Map<String,Object> baseModel= (Map<String,Object>)session.getAttribute(Constants.SESSION_BASE_MODEL);
		String result = null;
		if(baseModel == null){
			return new ModelAndView("redirect:/");
		}else{
			try {
				User sessionUser =  ((User)session.getAttribute(Constants.SESSION_USER));
				LeaveMessage message = new LeaveMessage();
				message.setCreatedBy(sessionUser.getLoginCode());
				if(DateUtil.isNotEmpty(id)){
					result = String.valueOf(service.addLeaveMessage(message,id));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return result;
		}
	}

	/**
	 * 去汇款充值页面
	 * @return
	 */
	@RequestMapping("/bank/recharge/gotoRecharge.html")
	public ModelAndView gotoRechargeView(HttpSession session,Model model){
		Map<String,Object> baseModel= (Map<String,Object>)session.getAttribute(Constants.SESSION_BASE_MODEL);
		if(baseModel == null){
			return new ModelAndView("redirect:/");
		}else{
			UserRecharge recharge = new UserRecharge();
			recharge.setRechargeNum(Util.getOrderNum(Constants.ORDER_TYPE_CZ));//获取汇款单据编号
			model.addAllAttributes(baseModel);
			model.addAttribute("recharge", recharge);
			if(rechargeger.isDebugEnabled()){
				rechargeger.debug("跳转至支付页面-‘/bank/recharge/recharge.thml’");
			}
			return new ModelAndView("/bank/recharge/recharge");
		}
	}
	
	/**
	 * 保存汇款充值操作记录
	 * @return
	 */
	@RequestMapping("/bank/doRecharge.html")
	public ModelAndView doRecharge(HttpSession session,
			@ModelAttribute("recharge") UserRecharge recharge,
			Model model){
		Map<String,Object> baseModel= (Map<String,Object>)session.getAttribute(Constants.SESSION_BASE_MODEL);
		if(baseModel == null){
			return new ModelAndView("redirect:/");
		}else{
			User sessionUser =  ((User)session.getAttribute(Constants.SESSION_USER));
			recharge.setUserId(sessionUser.getId());
			try {
				
				int id = service.addUserRecharge(recharge);
				recharge.setRechargeId(id);
				if(rechargeger.isDebugEnabled()){
					rechargeger.debug("保存充值汇款记录到数据库！！rechargeId="+id);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//alipay.micropay.order.confirmpayurl.get  https通道API 免费
			model.addAllAttributes(baseModel);
			model.addAttribute("recharge", recharge);
			
			return new ModelAndView("/bank/recharge/pay");
		}
	}
	
	/**
	 * 调用支付宝接口进行汇款充值操作
	 * @return
	 */
	@RequestMapping("/bank/recharge/doPay.html")
	public ModelAndView doPay(HttpSession session,HttpServletRequest request,
			@ModelAttribute("rechargeId") String rechargeId){
		Map<String,Object> baseModel= (Map<String,Object>)session.getAttribute(Constants.SESSION_BASE_MODEL);
		if(baseModel == null){
			return new ModelAndView("redirect:/");
		}else{
			String url=null;
			try {
				if(rechargeger.isDebugEnabled()){
					rechargeger.debug("调用支付接口进行充值汇款！！rechargeId="+rechargeId);
				}
				url = service.makeOrderAlipayUrl(request.getCharacterEncoding(),request.getContextPath(),rechargeId);
				if(rechargeger.isDebugEnabled()){
					rechargeger.debug("调用支付接口的URL路径："+url);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//return new ModelAndView(url);
			return new ModelAndView("redirect:/"+url);
		}
	}
	  
    /**
	 * 接收支付宝付款通知
	 * @return
	 */
	@RequestMapping("/bank/recharge/notifyUrl.html")
	@ResponseBody
	public Object notify(HttpServletRequest request){
		String result = null;
		try {
			result = service.updateByPayResult(request);
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}   
        return result;
	}
}