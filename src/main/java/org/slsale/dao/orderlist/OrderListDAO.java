package org.slsale.dao.orderlist;

import java.util.List;

import org.slsale.pojo.OrderList;

/**
 * OrderListMapper
 * @author bdqn_shy
 * @date 2014-5-5
 */
public interface OrderListDAO {
	/**
	 * getOrderlistList
	 * @return
	 */
	public List<OrderList> getOrderlistList(OrderList oList) throws Exception;
	
	/**
	 * addOrderList
	 * @param oList
	 * @return
	 */
	public int addOrderList(OrderList oList) throws Exception;
	
	/**
	 * modifyOrderList
	 * @param oList
	 * @return
	 */
	public int modifyOrderList(OrderList oList) throws Exception;
	
	/**
	 * deleteOrderList
	 * @param oList
	 * @return
	 */
	public int deleteOrderList(OrderList oList) throws Exception;
}
