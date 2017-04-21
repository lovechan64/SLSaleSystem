package org.slsale.service.orderlist;

import java.util.List;

import org.slsale.common.PageSupport;
import org.slsale.pojo.OrderList;
import org.springframework.stereotype.Service;
/**
 * OrderListServiceImpl
 * @author bdqn_shy
 * @date 2014-5-5
 */
@Service
public class OrderListServiceImpl implements OrderListService{

	@Override
	public PageSupport getOrderListList(OrderList orderList, Integer pageIndex)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderList> getOrderListList(OrderList orderList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count(OrderList orderList) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public OrderList getOrderListById(OrderList orderList) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addOrderList(OrderList orderList) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyOrderList(OrderList orderList) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String deleteOrderList(OrderList orderList) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
