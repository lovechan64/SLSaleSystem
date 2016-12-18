package org.slsale.service.orderinfo;

import java.util.List;
import java.util.Map;

import org.slsale.common.PageSupport;
import org.slsale.pojo.OrderInfo;
import org.slsale.pojo.OrderList;
import org.slsale.pojo.User;

/**
 * OrderInfoService
 * @author bdqn_shy
 * @date 2014-5-5
 */
public interface OrderInfoService {
	
	/**
	 * getOrderInfoList
	 * @return
	 */
	public PageSupport getOrderInfoList(OrderInfo order,Integer pageIndex) throws Exception;
	
	/**
	 * getOrderInfoList
	 * @return
	 */
	public List<OrderInfo> getOrderInfoList(OrderInfo order);
	
	/**
	 * getOrderListByOrder
	 * @return
	 */
	public List<OrderList> getOrderListByOrder(OrderInfo order) throws Exception;
	
	/**
	 * getOrderListByPackIds
	 * @return
	 */
	public List<OrderList> getOrderListByPackIds(String packIds,String buyNums) throws Exception;

	/**
	 * getUserListByUserId
	 * @return
	 */
	public List<User> getUserListByUserId(Integer userId) throws Exception;
	
	/**
	 * getGoToDeclarativeData
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> getGoToDeclarativeData(Integer targetUserId,Integer loginUserId) throws Exception;
	
	/**
	 * count
	 * @param order
	 * @return
	 * @throws Exception
	 */
	public int count(OrderInfo order) throws Exception;
	
	/**
	 * addOrderInfo
	 * @param order
	 * @return
	 */
	public int doDeclarative(OrderInfo order,Integer packId);
	
	/**
	 * addOrderInfo
	 * @param order
	 * @return
	 */
	public int addOrderInfo(OrderInfo order) throws Exception;
	
	/**
	 * doAdd
	 * @param order
	 * @param checkedIds
	 * @param buyNums
	 * @return
	 */
	public void doAdd(OrderInfo order,String checkedIds,String buyNums) throws Exception;
	
	
	/**
	 * getOrderInfoById
	 * @param order
	 * @return
	 */
	public OrderInfo getOrderInfoById(OrderInfo order) throws Exception;
	
	/**
	 * modifyOrderInfo
	 * @param order
	 * @return
	 */
	public int modifyOrderInfo(OrderInfo order) throws Exception;
	
	/**
	 * deleteOrderInfo
	 * @param order
	 * @return
	 */
	public String deleteOrderInfo(OrderInfo order);
	
	/**
	 * doSettlement
	 * @param order
	 * @param ids
	 * @param buyNums
	 * @return
	 */
	public String doSettlement(OrderInfo order,String ids,String buyNums);
}
