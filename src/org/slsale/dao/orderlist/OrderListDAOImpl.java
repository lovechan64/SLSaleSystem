package org.slsale.dao.orderlist;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slsale.pojo.OrderList;
import org.springframework.stereotype.Repository;
//@Repository("orderListDAO")
public class OrderListDAOImpl extends SqlSessionDaoSupport implements OrderListDAO {
	private final String shcema = "org.slsale.dao.orderlist.";

	@Override
	public List<OrderList> getOrderlistList(OrderList oList) throws Exception {
		
		return getSqlSession().selectList("getOrderlistList",oList);
	}

	@Override
	public int addOrderList(OrderList oList) throws Exception {
		
		return getSqlSession().insert("addOrderList",oList);
	}

	@Override
	public int modifyOrderList(OrderList oList) throws Exception {
		
		return getSqlSession().update("modifyOrderList",oList);
	}

	@Override
	public int deleteOrderList(OrderList oList) throws Exception {
		
		return getSqlSession().delete("deleteOrderList",oList);
	} 


}
