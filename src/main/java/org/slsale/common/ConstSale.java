package org.slsale.common;

public class ConstSale {

	/**
	 * 推荐奖10%
	 */
	public final static double RATE_REFER=0.1; //推荐奖10%
	
	/**
	 * 安置奖1%
	 */
	public final static double RATE_PLACE=0.01; //安置奖1%
	
	/**
	 * 对碰奖10%
	 */
	public final static double RATE_PAIR=0.1; //对碰奖10%
	
	/**
	 * 对碰奖10%
	 */
	public final static int EACH_PV=1000; //每碰PV数
	
	/**
	 * 现金重复消费奖金5%
	 */
	public final static double RATE_BUY=0.05; //现金重复消费奖金5%
	
	/**
	 * 积分消费第一层2%
	 */
	public final static double RATE_POINT_1=0.02; //积分消费第一层2%
	
	/**
	 * 积分消费第2-15层3%
	 */
	public final static double RATE_POINT_N=0.03; //积分消费第2-15层3%
	
	/**
	 * 个人拿钱再买消费折扣0.8
	 */
	public final static double DISCOUNT_PERSON=0.8;

	/**
	 * 美容院拿钱再买消费折扣0.4
	 */
	public final static double DISCOUNT_COMPANY=0.4;
	
	/**
	 * 提现手续费5%
	 */
	public final static double FEE_CASH=0.05;//提现手续费
	
	
	/**
	 * 获取订单类型
	 * @param type
	 * @return
	 */
	public static String getOrderType(int type){
		String orderType="";
		switch (type){
		case 0:
			orderType = "报单购货";break;
		case 1:
			orderType = "重消购货";break;
		case 2:
			orderType = "辅消购货";break;
		default:
			orderType = "未知";
		}
		return orderType;
	}
	
	/**
	 * 获取订单状态
	 * @return
	 */
	public static String getOrderStat(int stat){
		String orderStat="";
		switch (stat){
		case 0:
			orderStat = "新建";break;
		case 1:
			orderStat = "已提交";break;
		case 2:
			orderStat = "已审核";break;
		case 3:
			orderStat = "已发货";break;
		case 4:
			orderStat = "已收货";break;
		case 5:
			orderStat = "审核未通过";break;
		default:
			orderStat = "未知";
		}
		return orderStat;
	}
}
