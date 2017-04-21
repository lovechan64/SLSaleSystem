package org.slsale.dao.orderinfo;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slsale.pojo.OrderInfo;
import org.springframework.stereotype.Repository;
//@Repository("orderInfoDAO")
public class OrderInfoDAOImpl extends SqlSessionDaoSupport implements OrderInfoDAO {
	private final String shcema = "org.slsale.dao.orderinfo.";

	@Override
	public List<OrderInfo> getOrderInfoList(OrderInfo order) throws Exception {
		
		return getSqlSession().selectList("getOrderInfoList",order);
	}

	@Override
	public int count(OrderInfo order) throws Exception {

		return getSqlSession().selectOne("count",order);
	}

	@Override
	public int addOrderInfo(OrderInfo order) throws Exception {

		return getSqlSession().insert("addOrderInfo",order);
	}

	@Override
	public OrderInfo getOrderInfoById(OrderInfo order) throws Exception {
		
		return getSqlSession().selectOne("getOrderInfoById",order);
	}

	@Override
	public int modifyOrderInfo(OrderInfo order) throws Exception {
		
		return getSqlSession().update("modifyOrderInfo",order);
	}

	@Override
	public int submitOrderInfoAll(OrderInfo order) throws Exception {
		
		return getSqlSession().selectOne("submitOrderInfoAll",order);
	}

	@Override
	public int deleteOrderInfo(OrderInfo order) throws Exception {
		
		return getSqlSession().delete("deleteOrderInfo",order);
	} 


}
