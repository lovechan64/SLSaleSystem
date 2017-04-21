package org.slsale.controller;

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
import org.slsale.pojo.DataDictionary;
import org.slsale.pojo.GoodsPack;
import org.slsale.pojo.OrderInfo;
import org.slsale.pojo.OrderList;
import org.slsale.pojo.User;
import org.slsale.pojo.UserAccount;
import org.slsale.service.dataDictionary.DataDictionaryService;
import org.slsale.service.goodspack.GoodsPackService;
import org.slsale.service.orderinfo.OrderInfoService;
import org.slsale.service.user.UserService;
import org.slsale.service.useraccount.UserAccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.jdbc.StringUtils;
/**
 * OrderInfoController
 * @author bdqn_shy
 * @date 2014-5-5
 */
@Controller
public class OrderInfoController extends BaseController{
	private Logger logger = Logger.getLogger(OrderInfoController.class);
	
	@Resource
	private OrderInfoService service;
	@Resource
	private UserService userService;
	@Resource
	private GoodsPackService goodsPackService;
	@Resource
	private DataDictionaryService dataDictionaryService;
	@Resource
	private UserAccountService accountService;
	
	@RequestMapping("/shopping/declarative/prompt.html")
	public ModelAndView gotoIndexView(HttpSession session,Model model){
		Map<String,Object> baseModel= (Map<String,Object>)session.getAttribute(Constants.SESSION_BASE_MODEL);
		if(baseModel == null){
			return new ModelAndView("redirect:/");
		}else{
			User sessionUser =  (User)session.getAttribute(Constants.SESSION_USER);
			List<User> userList = null;
			try {
				userList = service.getUserListByUserId(sessionUser.getId());
			}catch (Exception e) {
				e.printStackTrace();
				return new ModelAndView("redirect:/401");
			}
			
			model.addAllAttributes(baseModel);
			model.addAttribute("userList", userList);
			
			return new ModelAndView("/shopping/declarative/prompt");
		}
	}
	
	
	
	@RequestMapping("/shopping/declarative/gotoDeclarative.html")
	public ModelAndView gotoDeclarativeView(HttpSession session,Model model, 
			@RequestParam(value="targetUserId",required=false)Integer targetUserId){
		Map<String,Object> baseModel= (Map<String,Object>)session.getAttribute(Constants.SESSION_BASE_MODEL);
		if(baseModel == null){
			return new ModelAndView("redirect:/");
		}else{
			User sessionUser =  (User)session.getAttribute(Constants.SESSION_USER);
			try {
				Map<String,Object> map = service.getGoToDeclarativeData(targetUserId,sessionUser.getId());
				if(null!=map){
					model.addAttribute("targetUser", map.get("targetUser"));
					model.addAttribute("packList", map.get("packList"));
					model.addAttribute("account", map.get("account"));
				}
			}catch (Exception e) {
				e.printStackTrace();
				return new ModelAndView("redirect:/401");
			}
			
			model.addAllAttributes(baseModel);
			return new ModelAndView("/shopping/declarative/gotoDeclarative");
		}
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/shopping/declarative/doDeclarative.html")
	@ResponseBody
	public Object doDeclarative(HttpSession session, 
			@RequestParam(value="targetUserId",required=false)Integer targetUserId,
			@RequestParam(value="packId",required=false)Integer packId,
			@RequestParam(value="expressType",required=false)String expressType,
			@RequestParam(value="userAddress",required=false)String userAddress,
			@RequestParam(value="postCode",required=false)String postCode
			){
		Map<String,Object> baseModel= (Map<String,Object>)session.getAttribute(Constants.SESSION_BASE_MODEL);
		if(baseModel == null){
			return new ModelAndView("redirect:/");
		}else{
			User sessionUser =  (User)session.getAttribute(Constants.SESSION_USER);
			try {
				OrderInfo order = new OrderInfo();
				order.setPickUserId(targetUserId);
				order.setOrderNum(Util.getOrderNum(Constants.ORDER_TYPE_BD));
				order.setUserAddress(userAddress);
				order.setPostCode(postCode);
				order.setShipType(expressType);
				order.setBuyUserId(sessionUser.getId());
				//boolean ta = AopUtils.isAopProxy(service);
				int resultNum = service.doDeclarative(order,packId);
				if(resultNum==1){
					return "success";
				}else{
					return "fail";
				}
			}catch (Exception e) {
				e.printStackTrace();
				return new ModelAndView("redirect:/401");
			}

		}
	}
	

	/**
	 * 获取列表（分页）
	 * @return
	 */
	@RequestMapping("/shopping/management/list.html")
	public ModelAndView orderInfoList(HttpSession session,Model model,
			@RequestParam(value="currentpage",required=false)Integer currentpage ,
			@RequestParam(value="orderNum",required=false) String orderNum, 
			@RequestParam(value="orderType",required=false) String orderType
			){
		Map<String,Object> baseModel= (Map<String,Object>)session.getAttribute(Constants.SESSION_BASE_MODEL);
		if(baseModel == null){
			return new ModelAndView("redirect:/");
		}else{
			User sessionUser =  (User)session.getAttribute(Constants.SESSION_USER);
			PageSupport page = null;
			OrderInfo order = new OrderInfo();
			order.setBuyUserId(sessionUser.getId());
			if (null != orderNum && orderNum.length()>0) {
				order.setOrderNum(SQLTools.transfer(orderNum));
			}
			
			if (DateUtil.isNotEmpty(orderType)) {
				order.setType(SQLTools.transfer(orderType));
			}
			//1已提交,2已审核,3已发货,4已收货
			String actionType = Constants.ACCOUNT_TYPE_BO+","+Constants.ACCOUNT_TYPE_RI+","+Constants.ACCOUNT_TYPE_RO+","+Constants.ACCOUNT_TYPE_T;
			order.setSearchStr1(actionType);
			try {
				page = service.getOrderInfoList(order,currentpage);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			model.addAllAttributes(baseModel);
			model.addAttribute("page", page);
			model.addAttribute("orderNum", orderNum);
			model.addAttribute("orderType", orderType);

			return new ModelAndView("/shopping/management/list");
		}
	}
	
	@RequestMapping("/shopping/management/doRemove.html")
	@ResponseBody
	public Object doRemove(HttpSession session,Model model, 
			@RequestParam(value="orderId",required=false)Integer orderId,
			@RequestParam(value="orderNum",required=false)String orderNum
			){
		OrderInfo order = new OrderInfo();
		order.setOrderId(orderId);
		order.setOrderNum(orderNum);
		String result = service.deleteOrderInfo(order);
		
		return result;
	}

	/**
	 * 获取重消套餐列表（分页）
	 * @return
	 */
	@RequestMapping("/shopping/repeated/list.html")
	public ModelAndView goodsPackListByRepeated(HttpSession session,Model model,
			@RequestParam(value="currentpage",required=false)Integer currentpage ,
			@RequestParam(value="code",required=false) String code, 
			@RequestParam(value="packName",required=false) String packName
			){
		Map<String,Object> baseModel= (Map<String,Object>)session.getAttribute(Constants.SESSION_BASE_MODEL);
		if(baseModel == null){
			return new ModelAndView("redirect:/");
		}else{
			DataDictionary dataDictionary = new DataDictionary();
			dataDictionary.setTypeName(Constants.PACK_TYPE_NAME);
			dataDictionary.setValueId(Constants.PACK_TYPE_CX);
			dataDictionary = dataDictionaryService.getDataDictionariesByTypeAndValueId(dataDictionary);
			GoodsPack goodsPack = new GoodsPack();
			goodsPack.setState(1);//状态为上架
			goodsPack.setTypeId(Integer.parseInt(dataDictionary.getValueName()));
			if(null != packName)
				goodsPack.setGoodsPackName("%"+SQLTools.transfer(packName)+"%");
			if(!StringUtils.isNullOrEmpty(code))
				goodsPack.setGoodsPackCode(SQLTools.transfer(code));
			//pages 
			PageSupport page = new PageSupport();
			
			try{
				page.setTotalCount(goodsPackService.count(goodsPack));
			}catch (Exception e1) {
				e1.printStackTrace();
			}
			if(page.getTotalCount() > 0){
				if(currentpage != null)
					page.setPage(currentpage);
				if(page.getPage() <= 0)
					page.setPage(1);
				if(page.getPage() > page.getPageCount())
					page.setPage(page.getPageCount());
				goodsPack.setStarNum((page.getPage() - 1) * page.getPageSize());
				goodsPack.setPageSize(page.getPageSize());
				List<GoodsPack> goodsPackList = null;
				try {
					goodsPackList = goodsPackService.getGoodsPackList(goodsPack);
				}catch (Exception e) {
					e.printStackTrace();
				}
				page.setItems(goodsPackList);
			}else{
				page.setItems(null);
			}
			model.addAllAttributes(baseModel);
			model.addAttribute("page", page);
			model.addAttribute("packName", packName);
			model.addAttribute("code", code);
			return new ModelAndView("/shopping/repeated/list");
		}
	}
	
	/**
	 * 获取辅消套餐列表（分页）
	 * @return
	 */
	@RequestMapping("/shopping/fx/list.html")
	public ModelAndView goodsPackListByFX(HttpSession session,Model model,
			@RequestParam(value="currentpage",required=false)Integer currentpage ,
			@RequestParam(value="code",required=false) String code, 
			@RequestParam(value="packName",required=false) String packName
			){
		Map<String,Object> baseModel= (Map<String,Object>)session.getAttribute(Constants.SESSION_BASE_MODEL);
		if(baseModel == null){
			return new ModelAndView("redirect:/");
		}else{
			DataDictionary dataDictionary = new DataDictionary();
			dataDictionary.setTypeName(Constants.PACK_TYPE_NAME);
			dataDictionary.setValueId(Constants.PACK_TYPE_FX);
			dataDictionary = dataDictionaryService.getDataDictionariesByTypeAndValueId(dataDictionary);
			GoodsPack goodsPack = new GoodsPack();
			goodsPack.setState(1);//状态为上架
			goodsPack.setTypeId(Integer.parseInt(dataDictionary.getValueName()));
			if(null != packName)
				goodsPack.setGoodsPackName("%"+SQLTools.transfer(packName)+"%");
			if(!StringUtils.isNullOrEmpty(code))
				goodsPack.setGoodsPackCode(SQLTools.transfer(code));
			//pages 
			PageSupport page = new PageSupport();
			
			try{
				page.setTotalCount(goodsPackService.count(goodsPack));
			}catch (Exception e1) {
				e1.printStackTrace();
			}
			if(page.getTotalCount() > 0){
				if(currentpage != null)
					page.setPage(currentpage);
				if(page.getPage() <= 0)
					page.setPage(1);
				if(page.getPage() > page.getPageCount())
					page.setPage(page.getPageCount());
				goodsPack.setStarNum((page.getPage() - 1) * page.getPageSize());
				goodsPack.setPageSize(page.getPageSize());
				List<GoodsPack> goodsPackList = null;
				try {
					goodsPackList = goodsPackService.getGoodsPackList(goodsPack);
				}catch (Exception e) {
					e.printStackTrace();
				}
				page.setItems(goodsPackList);
			}else{
				page.setItems(null);
			}
			model.addAllAttributes(baseModel);
			model.addAttribute("page", page);
			model.addAttribute("packName", packName);
			model.addAttribute("code", code);
			return new ModelAndView("/shopping/fx/list");
		}
	}

	@RequestMapping("/shopping/management/settlement.html")
	public ModelAndView gotoSettlementView(HttpSession session,Model model, 
			@RequestParam(value="type",required=false)String type,
			@RequestParam(value="flag",required=false)String flag,
			@RequestParam(value="checkedIds",required=false)String checkedIds,
			@RequestParam(value="buyNums",required=false)String buyNums
			){
		Map<String,Object> baseModel= (Map<String,Object>)session.getAttribute(Constants.SESSION_BASE_MODEL);
		if(baseModel == null){
			return new ModelAndView("redirect:/");
		}else{
			User sessionUser =  (User)session.getAttribute(Constants.SESSION_USER);
			OrderInfo order =  new OrderInfo();
			List<OrderList> list = null;
			try {
				UserAccount account = accountService.getUserAccountByUserId(null, sessionUser.getId(),true);
				if(!"chart".equals(flag)){
					String orderType = "repeated".equals(type) ?  Constants.ORDER_TYPE_CX :Constants.ORDER_TYPE_FX;
					order.setOrderNum(Util.getOrderNum(orderType));
					order.setType(orderType);
					list =  service.getOrderListByPackIds(checkedIds,buyNums);
					session.setAttribute("checkedIds", checkedIds);
					session.setAttribute("buyNums", buyNums);
				}else{
					order.setOrderId(Integer.parseInt(checkedIds));
					order = service.getOrderInfoById(order);
					list = order.getOlList();
					if(DateUtil.isNotEmpty(buyNums) && list!=null){
						String[] str = buyNums.split(",");
						for(int i =0;i<list.size();i++){
							OrderList ol = list.get(i);
							ol.setGoodsNum(Integer.parseInt(str[i]));
						}
					}
				}
				model.addAttribute("sessionUser",sessionUser);
				model.addAttribute("account",account);
				model.addAttribute("order",order);
				model.addAttribute("orderList",list);
			}catch (Exception e) {
				e.printStackTrace();
				return new ModelAndView("redirect:/401");
			}
			
			model.addAllAttributes(baseModel);
			return new ModelAndView("/shopping/management/settlement");
		}
	}
	
	@RequestMapping("/shopping/management/shoppingCart.html")
	public ModelAndView gotoShoppingCartView(HttpSession session,Model model){
		Map<String,Object> baseModel= (Map<String,Object>)session.getAttribute(Constants.SESSION_BASE_MODEL);
		if(baseModel == null){
			return new ModelAndView("redirect:/");
		}else{
			User sessionUser =  (User)session.getAttribute(Constants.SESSION_USER);
			List<OrderInfo> list = null;
			try {
				OrderInfo order = new OrderInfo();
				order.setBuyUserId(sessionUser.getId());
				order.setStat(Constants.ORDER_STAT_XJ);
				list = service.getOrderInfoList(order);
			}catch (Exception e) {
				e.printStackTrace();
				return new ModelAndView("redirect:/401");
			}
			
			model.addAllAttributes(baseModel);
			model.addAttribute("list",list);
			
			return new ModelAndView("/shopping/management/shoppingCart");
		}
	}

	@RequestMapping("/shopping/repeated/doSettlement.html")
	@ResponseBody
	public Object doSettlement(HttpSession session,
			@RequestParam(value="orderNum",required=false)String orderNum,
			@RequestParam(value="sum",required=false)Double sum,
			@RequestParam(value="type",required=false)String type
			){
		String result = null;
		User sessionUser =  (User)session.getAttribute(Constants.SESSION_USER);
		OrderInfo order = new OrderInfo();
		order.setOrderNum(orderNum);
		order.setBasePV(sum);
		order.setPickUserId(sessionUser.getId());
		order.setBuyUserId(sessionUser.getId());
		order.setType(type);
		String checkedIds = (String)session.getAttribute("checkedIds");
		String buyNums = (String)session.getAttribute("buyNums");
		result = service.doSettlement(order,checkedIds,buyNums);
		if("success".equals(result)){
			session.setAttribute("checkedIds", null);
			session.setAttribute("buyNums",null);
		}
		
		return result;
	}
	
	@RequestMapping("/shopping/repeated/saveOrderInfo.html")
	@ResponseBody
	public Object saveOrderInfo(HttpSession session,
			@RequestParam(value="checkedIds",required=false)String checkedIds,
			@RequestParam(value="type",required=false)String type,
			@RequestParam(value="buyNums",required=false)String buyNums
		){
		User sessionUser =  (User)session.getAttribute(Constants.SESSION_USER);
		String result = null;
		OrderInfo order = new OrderInfo();
		String orderType = "repeated".equals(type) ?  Constants.ORDER_TYPE_CX :Constants.ORDER_TYPE_FX;
		order.setType(orderType);
		order.setPickUserId(sessionUser.getId());
		order.setBuyUserId(sessionUser.getId());
		order.setOrderNum(Util.getOrderNum(orderType));
		try {
			if(DateUtil.isNotEmpty(checkedIds)&&DateUtil.isNotEmpty(buyNums)){
				service.doAdd(order,checkedIds,buyNums);
				result = "success";
			}else{
				result = "fail";
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = "fail";
		}
		
		return result;
	}
	
}
