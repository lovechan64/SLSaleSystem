package org.slsale.job;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.slsale.common.Constants;
import org.slsale.common.DateUtil;
import org.slsale.dao.orderinfo.OrderInfoDAO;
import org.slsale.pojo.OrderInfo;

public class OrderSettlementJob {
	@Resource
	private OrderInfoDAO orderMapper;
	
	private Logger logger = Logger.getLogger(OrderSettlementJob.class);
	
	public void doOrderSettlement() {
		logger.debug("执行OrderSettlementJob开始");
		OrderInfo order = new OrderInfo();
		order.setStat(Constants.ORDER_STAT_TJ);//0新建,1已提交,2已审核,3已发货,4已收货,5审核未通过
		order.setOrderTime(DateUtil.getDateByValue(0, -1,null));//获取昨天的日期
		try {
			//orderMapper.submitOrderInfoAll(order);
		} catch (Exception e) {
			logger.debug("执行OrderSettlementJob出现异常:");
			e.printStackTrace();
		}
		logger.debug("执行OrderSettlementJob结束");
	}
	
	/**
	 * 计算对碰奖金
	 */
	private void pairBonus(){
		
	}
	
	
}
