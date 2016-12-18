package org.slsale.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.apache.log4j.Logger;
import org.slsale.common.Constants;
import org.slsale.pojo.User;
import org.slsale.service.search.SearchService;
import org.slsale.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/**
 * OrderInfoController
 * @author bdqn_shy
 * @date 2014-5-5
 */
@Controller
public class SearchController extends BaseController{
	private Logger logger = Logger.getLogger(SearchController.class);
	
	@Resource
	private UserService userService;
	@Resource
	private SearchService service;
	
	@RequestMapping("/search/recommend_search.html")
	public ModelAndView recommendSearchView(HttpSession session,Model model){
		Map<String,Object> baseModel= (Map<String,Object>)session.getAttribute(Constants.SESSION_BASE_MODEL);
		if(baseModel == null){
			return new ModelAndView("redirect:/");
		}else{
			User sessionUser =  (User)session.getAttribute(Constants.SESSION_USER);
			String jsonStr = null;
			User user = new User();
			try {
				user.setReferId(sessionUser.getId());
				user.setIsStart(Constants.START_STATUS_Y);
				user.setActiveStatus(Constants.ACTIVE_STATUS_Y);
				List<User> userList = userService.getUserListBySearch(user);
				user = new User();
				user.setUserTypeName(sessionUser.getUserTypeName());
				if(userList!=null&& userList.size()>0){
					JSONArray ja = JSONArray.fromObject(userList);
					model.addAttribute("userListJOSN", ja.toString());
					user.setReferNum(userList.size());
				}
			}catch (Exception e) {
				e.printStackTrace();
				return new ModelAndView("redirect:/401");
			}
			
			model.addAllAttributes(baseModel);
			model.addAttribute("user", user);
			
			return new ModelAndView("/search/recommend_search");
		}
	}
	
	@RequestMapping("/search/bonus_search.html")
	public ModelAndView bonusSearchView(HttpSession session,Model model){
		Map<String,Object> baseModel= (Map<String,Object>)session.getAttribute(Constants.SESSION_BASE_MODEL);
		if(baseModel == null){
			return new ModelAndView("redirect:/");
		}else{
			User sessionUser =  (User)session.getAttribute(Constants.SESSION_USER);
			Map<String,Object> map = null;
			try {
				map = service.getSearchList(sessionUser);
				Integer referNum = (Integer)map.get("referNum");
				sessionUser.setReferNum(referNum!=null?referNum:0);
			}catch (Exception e) {
				e.printStackTrace();
				return new ModelAndView("redirect:/401");
			}
			
			model.addAllAttributes(baseModel);
			model.addAttribute("sessionUser", sessionUser);
			model.addAttribute("obj1List", map.get("obj1List"));
			model.addAttribute("obj2List", map.get("obj2List"));
			model.addAttribute("heji", map.get("heji"));
			model.addAttribute("bonus", map.get("bonus"));
			
			return new ModelAndView("/search/bonus_search");
		}
	}
	
}
