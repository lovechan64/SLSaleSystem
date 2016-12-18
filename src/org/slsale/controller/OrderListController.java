package org.slsale.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.slsale.service.orderlist.OrderListService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * OrderListController
 * @author bdqn_shy
 * @date 2014-5-5
 */
@Controller
public class OrderListController extends BaseController{
	private Logger logger = Logger.getLogger(OrderListController.class);
	
	@Resource
	private OrderListService service;

	@ResponseBody
	public Object saveOrderList(HttpSession session,
			@RequestParam(value="checkedIds",required=false)String checkedIds,
			@RequestParam(value="buyNums",required=false)String buyNums
		){
		
		return null;
	}

}
