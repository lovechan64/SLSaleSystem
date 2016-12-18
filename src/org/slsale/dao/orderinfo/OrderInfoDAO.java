package org.slsale.dao.orderinfo;

import java.util.List;

import org.slsale.pojo.OrderInfo;

/**
 * OrderInfoMapper
 * @author bdqn_shy
 * @date 2014-5-5
 */
public interface OrderInfoDAO {
	/**
	 * getOrderInfoList
	 * @return
	 */
	public List<OrderInfo> getOrderInfoList(OrderInfo order) throws Exception;
	
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
}
