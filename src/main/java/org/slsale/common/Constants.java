package org.slsale.common;


import org.springframework.context.ApplicationContext;


public class Constants {
	public static final String SESSION_USER="userSession";
	public static final String TARGET_PLACE_USER="targetPlaceUser";
	public static final String SESSION_BASE_MODEL="baseModel";
	public static ApplicationContext cxt;

	/**
	 * 默认激活状态
	 */
	public static final String ACTIVE_STATUS_Y = "1";//已激活
	public static final String ACTIVE_STATUS_N = "0";//未激活
	
	/**
	 * 默认启用状态
	 */
	public static final int START_STATUS_Y = 1;//已激活
	public static final int START_STATUS_N = 2;//未激活
	
	/**
	 * 支付状态  参考字典表ORDER_STATUS
	 */
	public static final String RECHARGE_TYPE_NO="N";//未付款
	public static final String RECHARGE_TYPE_YES="Y";//已付款待确认
	public static final String RECHARGE_TYPE_CONFIRM="C";//已确认
	public static final String ROLE_NAME_AMDIN="管理员";//已确认
	
    /**
     * 支付宝接口需提供的关键支付信息
     */
	public static final String ALIPAY_GATEWAY_OLD = "https://www.alipay.com/cooperate/gateway.do?";//支付宝提供给商户的服务接入网关URL(新)
	public static final String ALIPAY_GATEWAY_NEW = "https://mapi.alipay.com/gateway.do?";
	public static final String NOTIFY_URL = "/bank/recharge/notifyUrl.html";//客户付款后,支付宝调用的页面
	public static final String RETURN_URL = "/bank/recharge/success";//客户付款成功后,显示给客户的页面
	public static final String PARENTID = "2088601199241737";//partnerId(合作伙伴ID) 
	public static final String KEY = "q5d4myvw6frv4tnxeahmjjjminjq2y5c";//商户私钥
	public static final String AGENT = "";//
	public static final String SELLER_EMAIL = "sandbox_shang@qq.com";//你的支付宝账户email  
	public static final String SERVICE = "create_direct_pay_by_user";//服务类型：create_direct_pay_by_user=直接付款,trade_create_by_buyer 担保付款 
	
	/**
	 * 用户总账状态
	 */
	public static final int ACCOUNT_TYPE_BI=0;//基础入账
	public static final int ACCOUNT_TYPE_BO=1;//基础出账
	public static final int ACCOUNT_TYPE_RI=2;//重消入账
	public static final int ACCOUNT_TYPE_RO=3;//重消出账
	public static final int ACCOUNT_TYPE_T=4;//同时出入账
	public static final int ACCOUNT_TYPE_BRT=5;//基本、重消同时入账
	
	/**
	 * 提现状态 参考字典表CASH_IN_STATUS
	 */
	public static final int CASH_STAT_O = 0;//0申请提现
	public static final int CASH_STAT_1 = 1;//1审核通过
	public static final int CASH_STAT_2 = 2;//2转账完毕
	
	/**
	 * 套餐类型 参考字典表PACK_TYPE
	 */
	public static final String PACK_TYPE_NAME = "套餐类型";
	public static final String PACK_TYPE_BD = "BD";//1保单套餐
	public static final String PACK_TYPE_CX = "CX";//2重消套餐
	public static final String PACK_TYPE_FX = "FX";//3辅消套餐
	
	/**
	 * 默认货币类型
	 */
	public static final String CY_RMB = "RMB";
	
	/**
	 * 默认货币类型
	 */
	public static final String RATE = "PV_RATE";
	
	/**
	 * 默认手续费率
	 */
	public static final double CASH_FEE = 0.05;
	
	/**
	 * 订单类型
	 */
	public static final String ORDER_TYPE_BD = "BD";//报单购货
	public static final String ORDER_TYPE_CX = "CX";//重销购货
	public static final String ORDER_TYPE_FX = "FX";//辅消购货
	public static final String ORDER_TYPE_CZ = "CZ";//汇款充值
	public static final String ORDER_TYPE_TX = "TX";//申请提现
	
	/**
	 * 订单状态
	 */
	public static final int ORDER_STAT_XJ = 0;//新建
	public static final int ORDER_STAT_TJ = 1;//已提交
	public static final int ORDER_STAT_SH_Y = 2;//已审核
	public static final int ORDER_STAT_FH = 3;//已发货
	public static final int ORDER_STAT_SH = 4;//已收货
	public static final int ORDER_STAT_SH_N = 5;//审核未通过
	public static final int ORDER_STAT_CX = 6;//已撤销
	
	/**
	 * 默认各种奖励比率
	 */
	public static final double PLACE_BONUS_RATE = 0.005;//安置奖励比率
	public static final double REFER_BONUS_RATE = 0.015;//推荐奖励比率
	
}

