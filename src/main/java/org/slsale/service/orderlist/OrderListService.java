package org.slsale.service.orderlist;

import java.util.List;

import org.slsale.common.PageSupport;
import org.slsale.pojo.OrderList;

/**
 * OrderListService
 * @author bdqn_shy
 * @date 2014-5-5
 */
public interface OrderListService {
	
	/**
	 * getOrderListList
	 * @return
	 */
	public PageSupport getOrderListList(OrderList orderList,Integer pageIndex) throws Exception;
	
	/**
	 * getOrderListList
	 * @return
	 */
	public List<OrderList> getOrderListList(OrderList orderList);
	
	/**
	 * count
	 * @param orderList
	 * @return
	 * @throws Exception
	 */
	public int count(OrderList orderList) throws Exception;

	/**
	 * getOrderListById
	 * @param orderList
	 * @return
	 */
	public OrderList getOrderListById(OrderList orderList) throws Exception;
	
	/**
	 * addOrderList
	 * @param orderList
	 * @return
	 */
	public int addOrderList(OrderList orderList) throws Exception;
	
	/**
	 * modifyOrderList
	 * @param orderList
	 * @return
	 */
	public int modifyOrderList(OrderList orderList) throws Exception;
	
	/**
	 * deleteOrderList
	 * @param orderList
	 * @return
	 */
	public String deleteOrderList(OrderList orderList);
}
