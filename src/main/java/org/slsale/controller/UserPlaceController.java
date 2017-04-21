package org.slsale.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.slsale.common.Constants;
import org.slsale.common.DateUtil;
import org.slsale.common.PageSupport;
import org.slsale.common.SQLTools;
import org.slsale.common.Util;
import org.slsale.pojo.User;
import org.slsale.pojo.UserRefer;
import org.slsale.service.user.UserService;
import org.slsale.service.userplace.UserPlaceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
/**
 * OrderInfoController
 * @author bdqn_shy
 * @date 2014-5-5
 */
@Controller
public class UserPlaceController extends BaseController{
	private Logger logger = Logger.getLogger(UserPlaceController.class);
	
	@Resource
	private UserPlaceService service;
	@Resource
	private UserService userService;

	/**
	 * 获取列表（分页）
	 * @return
	 */
	@RequestMapping("/shopping/activate/list.html")
	public ModelAndView getUserReferList(HttpSession session,Model model,
			@RequestParam(value="start",required=false)String start ,
			@RequestParam(value="end",required=false)String end ,
			@RequestParam(value="currentpage",required=false)Integer currentpage ,
			@RequestParam(value="userName",required=false) String userName
			){
		Map<String,Object> baseModel= (Map<String,Object>)session.getAttribute(Constants.SESSION_BASE_MODEL);
		if(baseModel == null){
			return new ModelAndView("redirect:/");
		}else{
			User sessionUser =  (User)session.getAttribute(Constants.SESSION_USER);
			PageSupport page = null;
			UserRefer refer = new UserRefer();
			refer.setReferUserId(sessionUser.getId());
			if (null != start && start.length()>0) {
				refer.setStartTimeStr(SQLTools.transfer(start));
			}
			if (null != end && end.length()>0) {
				refer.setEndTimeStr(SQLTools.transfer(end));
			}
			if (null != userName && userName.length()>0) {
				refer.setUserName(SQLTools.transfer(userName));
			}
			try {
				page = service.getUserReferList(refer,currentpage);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			model.addAllAttributes(baseModel);
			model.addAttribute("page", page);
			model.addAttribute("start", start);
			model.addAttribute("end", end);
			model.addAttribute("userName", userName);

			return new ModelAndView("/shopping/activate/list");
		}
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/shopping/activate/gotoActivate.html",method=RequestMethod.GET)
	public ModelAndView gotoActivateView(HttpSession session,Model model,
			@ModelAttribute("userId") String userId,
			@ModelAttribute("password") String password,
			@ModelAttribute("rootCode") String rootCode,
			@ModelAttribute("totalCode") String totalCode,
			@ModelAttribute("searchFlag") String searchFlag
			){
		Map<String,Object> baseModel= (Map<String,Object>)session.getAttribute(Constants.SESSION_BASE_MODEL);
		if(baseModel == null){
			return new ModelAndView("redirect:/");
		}else{
			Map<String,Object> resultMap = null;
			if("goto".equals(searchFlag)){
				User sessionUser =  (User)session.getAttribute(Constants.SESSION_USER);
				totalCode =sessionUser.getTotalCode();
				if(sessionUser.getPassword2().equals(password)){
					resultMap = service.getPlaceUserList(totalCode);
				}else{
					return new ModelAndView("/shopping/activate/list");
				}
				User user = new User();
				user.setId(Integer.parseInt(userId));
				try {
					user = userService.getUserById(user);
					session.setAttribute(Constants.TARGET_PLACE_USER, user);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else{
				if(DateUtil.isEmpty(totalCode)){
					List<String> lastRootIdList = (List<String>)session.getAttribute("lastRootIdList");
					if(lastRootIdList!=null && lastRootIdList.size()>0){
						totalCode = lastRootIdList.get(lastRootIdList.size()-1);
						lastRootIdList.remove(totalCode);
					}else{
						User sessionUser =  (User)session.getAttribute(Constants.SESSION_USER);
						totalCode =sessionUser.getTotalCode();
					}
				}else{
					//3、记录当前用于查询的totalCode放入记录点击路径的集合中
					List<String> lastRootIdList = (List<String>)session.getAttribute("lastRootIdList");
					if(lastRootIdList==null||lastRootIdList.size()==0){
						lastRootIdList = new ArrayList<String>();
					}
					if(!lastRootIdList.contains(rootCode) && !totalCode.equals(rootCode)){
						lastRootIdList.add(rootCode);
						session.setAttribute("lastRootIdList", lastRootIdList);
					}
				}
				
				//1、获取以当前完整编码为顶点其下的最多15条记录
				resultMap = service.getPlaceUserList(totalCode);
			}
			
			//2、返回以当前登录用户为顶点其下的4层totalCode集合
			List<String> codeList = Util.getTotalCode(totalCode);
			
			model.addAllAttributes(baseModel);
			model.addAttribute("resultMap", resultMap);
			model.addAttribute("codeList", codeList);
			
			return new ModelAndView("/shopping/activate/gotoActivate");
		}
	}
	
	@RequestMapping("/shopping/activate/doActivate.html")
	@ResponseBody
	public Object doActivate(HttpSession session,@ModelAttribute("totalCode") String totalCode){
		Integer  result = null;
		User targetPlaceUser = (User)session.getAttribute(Constants.TARGET_PLACE_USER);
		User sessionUser =  (User)session.getAttribute(Constants.SESSION_USER);
		if(targetPlaceUser!=null){
			User targetUser = new User();
			targetUser.setId(targetPlaceUser.getId());
			targetUser.setTotalCode(totalCode);
			result = service.doActivate(targetUser,sessionUser);
			if(result==0){
				session.setAttribute(Constants.TARGET_PLACE_USER, null);
				return "successd";
			}else{
				return "faild";
			}
		}else{
			return "faild";
		}
	}
	
}
