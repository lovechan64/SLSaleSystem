package org.slsale.dao.orderinfo;

import java.util.List;

import org.slsale.pojo.OrderInfo;
import org.slsale.pojo.User;

/**
 * OrderInfoMapper
 * @author bdqn_shy
 * @date 2014-5-5
 */
public interface OrderInfoMapper {
	/**
	 * getOrderInfoList
	 * @return
	 */
	public List<OrderInfo> getOrderInfoList(OrderInfo order) throws Exception;
	
	/**
	 * getOrderInfoList
	 * @return
	 */
	public List<OrderInfo> getOrderInfoBySearch(OrderInfo order) throws Exception;
	
	/**
	 * getUserList
	 * @return
	 */
	public List<User> getUserList(User user) throws Exception;
	
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
	public int addOrderInfo(OrderInfo order) throws Exception;
	
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
	 * submitOrderInfoAll
	 * @param order
	 * @return
	 */
	public int submitOrderInfoAll(OrderInfo order) throws Exception;
	
	/**
	 * deleteOrderInfo
	 * @param order
	 * @return
	 */
	public int deleteOrderInfo(OrderInfo order) throws Exception;
	
	/**
	 * getLastInsertId
	 * @return
	 */
	public int getLastInsertId() throws Exception;
	
	/**
	 * calBonus
	 * @return
	 */
	public Double calBonus(OrderInfo order) throws Exception;
}
