package org.slsale.service.userrecharge;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slsale.common.Constants;
import org.slsale.common.DateUtil;
import org.slsale.common.PageSupport;
import org.slsale.common.pay.AlipayNotify;
import org.slsale.dao.datadictionary.DataDictionaryMapper;
import org.slsale.dao.leavemessage.LeaveMessageMapper;
import org.slsale.dao.useraccount.UserAccountMapper;
import org.slsale.dao.useraccountlog.UserAccountLogMapper;
import org.slsale.dao.userrecharge.UserRechargeMapper;
import org.slsale.pojo.DataDictionary;
import org.slsale.pojo.LeaveMessage;
import org.slsale.pojo.UserAccount;
import org.slsale.pojo.UserAccountLog;
import org.slsale.pojo.UserRecharge;
import org.springframework.stereotype.Service;

/**
 * UserRechargeServiceImpl
 * 
 * @author bdqn_hl
 * @date 2014-2-21
 */

@Service
public class UserRechargeServiceImpl implements UserRechargeService {

	@Resource
	private UserRechargeMapper mapper;
	@Resource
	private UserAccountMapper accountMapper;
	@Resource
	private UserAccountLogMapper logMapper;
	@Resource
	private LeaveMessageMapper lmMapper;
	@Resource
	private DataDictionaryMapper ddMapper;
	
	public PageSupport getUserRechargeList(UserRecharge recharge,
			PageSupport page) throws Exception {
		List<UserRecharge> userList = null;
		try {
			page.setTotalCount(mapper.count(recharge));
			if (page.getPage() > page.getPageCount())
				page.setPage(page.getPageCount());
			recharge.setStarNum((page.getPage() - 1) * page.getPageSize());
			recharge.setPageSize(page.getPageSize());
			userList = mapper.getUserRechargeList(recharge);
		} catch (Exception e) {
			e.printStackTrace();
		}
		page.setItems(userList);

		return page;
	}

	public int addUserRecharge(UserRecharge recharge) throws Exception {
		recharge.setRechargeType(Constants.RECHARGE_TYPE_NO);//默认充值状态为：未支付
		recharge.setCurrency(Constants.CY_RMB);//充值货币
		//获取PV转换率
		DataDictionary dd = new DataDictionary();
		dd.setTypeCode(Constants.RATE);
		dd.setValueId(Constants.CY_RMB);
		dd = ddMapper.getDataDictionariesByTypeAndValueId(dd);
		Double pvRate = Double.valueOf(dd.getValueName());
		recharge.setPvRate(pvRate);//PV比率
		
		mapper.addUserRecharge(recharge);//保存到数据库
		
		return mapper.getAddRechargeId();
	}

	public int deleteUserRecharge(UserRecharge recharge) throws Exception {
		// TODO Auto-generated method stub
		return mapper.deleteUserRecharge(recharge);
	}

	public int modifyUserRecharge(UserRecharge recharge) throws Exception {
		// TODO Auto-generated method stub
		return mapper.modifyUserRecharge(recharge);
	}

	public UserRecharge getUserRechargeById(String id) throws Exception {
		// TODO Auto-generated method stub
		return mapper.getUserRechargeById(id);
	}

	@Override
	public int count(UserRecharge recharge) throws Exception {
		// TODO Auto-generated method stub
		return mapper.count(recharge);
	}

	@Override
	public int addLeaveMessage(LeaveMessage message, String id)
			throws Exception {
		UserRecharge recharge = getUserRechargeById(id);

		String messageCode = "WDZTX" + id;
		String messageTitle = "用户" + message.getCreatedBy() + "未到账提醒";
		String messageContent = "充值单号：" + recharge.getRechargeNum() + " 日期："
				+ DateUtil.getDateTime(recharge.getRechargeTime()) + " 金额："
				+ recharge.getCreditedMoney() + " 汇款未到账，速查！";
		message.setMessageCode(messageCode);
		message.setMessageTitle(messageTitle);
		message.setMessageContent(messageContent);
		message.setState(0);
		message.setCreateTime(new Date());

		return lmMapper.addLeaveMessage(message);
	}

	/**
	 * 根据订单生成支付宝接口URL.
	 * 
	 * @param httpRequest
	 * @param order
	 *            订单实例
	 * @return
	 * @throws Exception
	 */
	@Override
	public String makeOrderAlipayUrl(String charset, String contextPath,
			String id) throws Exception {
		UserRecharge recharge = mapper.getUserRechargeById(id);
		if (null != recharge) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("_input_charset", charset);// 采用相同的编码方式
			map.put("body", "您在SL会员商城上的订单");// 填写在跳到支付宝页面上显示的付款内容信息
			map.put("notify_url", "http://" + contextPath
					+ Constants.NOTIFY_URL);// 客户付款后,支付宝调用的页面
			map.put("out_trade_no", recharge.getRechargeNum());// 外部交易号,最好具有唯一性,在获取支付宝发来的付款信息时使用.
			map.put("partner", Constants.PARENTID);// partnerId(合作伙伴ID)
			map.put("payment_type", "1");// 支付类型 1=商品购买,2=服务购买,...
			map.put("price", recharge.getRechargeMoney());// 订单金额信息
			map.put("quantity", "1");// 订单商品数量,一般都是写1,它是按照整个订单包来计算
			map.put("return_url", "http://" + contextPath
					+ Constants.RETURN_URL);// 客户付款成功后,显示给客户的页面
			map.put("seller_email", Constants.SELLER_EMAIL);// 你的支付宝账户email
			map.put("service", Constants.SERVICE);// create_direct_pay_by_user=直接付款,trade_create_by_buyer
													// 担保付款
			map.put("subject", "SL会员商城的订单");// 填写在跳到支付宝页面上显示的付款标题信息
			// alipay.micropay.order.confirmpayurl.get https通道API 免费
			// https://openapi.alipaydev.com/gateway.do 沙箱接口访问url

			return makeUrl(map, Constants.KEY, charset,
					Constants.ALIPAY_GATEWAY_NEW);// securityCode(安全码)
		}

		return null;

	}

	/**
	 * 根据传入的参数生成alipay的支付URL
	 * 
	 * @param map
	 *            参数值
	 * @param securityCode
	 *            安全码
	 * @param charset
	 *            编码
	 * @param payGateway
	 *            支付宝gateway
	 * @return
	 */
	private String makeUrl(HashMap map, String securityCode, String charset,
			String payGateway) throws Exception {
		List keys = new ArrayList(map.keySet());
		Collections.sort(keys);// 支付宝要求参数必须按字母排序
		StringBuffer content = new StringBuffer();
		for (int i = 0; i < keys.size(); i++) {
			content.append(String.valueOf(keys.get(i)));
			content.append("=");
			content.append(String.valueOf(map.get(String.valueOf(keys.get(i)))));
			if (i != keys.size() - 1) {
				content.append("&");
			}
		}
		if (securityCode != null) {
			content.append(securityCode);
		}
		String sign = md5(content.toString(), charset);
		content.delete(0, content.length());
		content.append(payGateway);
		for (int i = 0; i < keys.size(); i++) {
			content.append(keys.get(i));
			content.append("=");
			content.append(URLEncoder.encode(
					String.valueOf(map.get(keys.get(i))), charset));
			content.append("&");
		}
		content.append("sign=");
		content.append(sign);
		content.append("&sign_type=MD5");
		keys.clear();
		keys = null;

		return content.toString();
	}

	/**
	 * 生成md5编码字符串.
	 * 
	 * @param str
	 *            源字符串
	 * @param charset
	 *            编码方式
	 * @return
	 * 
	 */
	private String md5(String str, String charset) {
		if (str == null)
			return null;
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };

		MessageDigest md5MessageDigest = null;
		byte[] md5Bytes = null;
		char md5Chars[] = null;
		byte[] strBytes = null;
		try {
			strBytes = str.getBytes(charset);
			md5MessageDigest = MessageDigest.getInstance("MD5");
			md5MessageDigest.update(strBytes);
			md5Bytes = md5MessageDigest.digest();
			int j = md5Bytes.length;
			md5Chars = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte md5Byte = md5Bytes[i];
				md5Chars[k++] = hexDigits[md5Byte >>> 4 & 0xf];
				md5Chars[k++] = hexDigits[md5Byte & 0xf];
			}
			return new String(md5Chars);
		} catch (NoSuchAlgorithmException e) {
			// Log.output(e.toString(), Log.STD_ERR);
			return null;
		} catch (UnsupportedEncodingException e) {
			// Log.output(e.toString(), Log.STD_ERR);
			return null;
		} finally {
			md5MessageDigest = null;
			strBytes = null;
			md5Bytes = null;
		}
	}

	/**
	 * 
	 */
	public String updateByPayResult(HttpServletRequest request)
			throws Exception {
		String result = "fail";
		// 获取支付宝POST过来反馈信息
		Map<String, String> params = new HashMap<String, String>();
		Map requestParams = request.getParameterMap();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			StringBuilder builder = new StringBuilder("");
			for (int i = 0; i < values.length; i++) {
				builder.append((i == values.length - 1) ? values[i]	: values[i] + ",") ;
			}
			// 乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
			// valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
			params.put(name, builder.toString());
		}

		if (AlipayNotify.verify(params)) {// 验证成功
			String orderId = request.getParameter("out_trade_no");// 获取待处理的订单号
			if (orderId == null || "".equals(orderId)) {
				orderId = "-1";
				return result;
			}

			UserRecharge ur = new UserRecharge();
			ur.setRechargeNum(orderId);
			UserRecharge recharge = null;
			List<UserRecharge> rechargeList = mapper.getUserRechargeList(ur); // 获取充值目标
			if (null != rechargeList && rechargeList.size() > 0) {
				recharge = rechargeList.get(0);
			}
			// 判断是否在商户网站中已经做过了这次通知返回的处理。如果没有做过处理，那么执行业务程序
			if (null != recharge
					&& recharge.getRechargeType().equals(
							Constants.RECHARGE_TYPE_NO)) {
				// 1、更新当前充值记录
				recharge.setRechargeType(Constants.RECHARGE_TYPE_YES);// 充值记录状态
				recharge.setCreditedMoney(Double.parseDouble(params.get("creditedMoney")));// 到账金额
				recharge.setCreditedTime(new Date());// 到账时间
				
				double rechargePV = recharge.getCreditedMoney() * recharge.getPvRate();
				recharge.setPv(rechargePV);// 兑换后PV值
				
				//未处理参数
				String bankName;	//充值银行名
				String bankAccount;	//充值账号名
				String platform; // 充值平台
				String param; // 充值接口参数

				// 2、更新用户总账表的基本入账、基本余额、日期和总帐状态等字段数据
				UserAccount account = new UserAccount();
				account.setUserId(recharge.getUserId());
				List<UserAccount> accountList = accountMapper
						.getUserAccountList(account);// 获取目标用户的总账记录
				if (null != accountList && accountList.size() > 0) {
					account = accountList.get(0);
				}
				account.setAccountData(new Date());// 日期
				account.setStat(Constants.ACCOUNT_TYPE_BI);//总账状态
				account.setBaseIn(rechargePV);//基本入账
				account.setBaseBalance(account.getBaseBalance()+rechargePV);//基本余额

				accountMapper.modifyUserAccount(account);// 执行保存操作

				// 3、向用户总账明细表中插入进账数据
				UserAccountLog log = new UserAccountLog();
				log.setUserId(recharge.getUserId());
				List<UserAccountLog> logList = logMapper
						.getUserAccountLogList(log);

				if (null != logList && logList.size() > 0) {
					log = logList.get(0);
				}

				log.setActionTime(new Date());
				log.setActionDesc("汇款充值");// 动作摘要
				log.setActionType(Constants.ACCOUNT_TYPE_BI);// 基础入账
				log.setBaseIn(rechargePV);
				log.setBaseBalance(account.getBaseBalance() + rechargePV);
				logMapper.addUserAccountLog(log);

				result = "success";
			}
		}

		return result;
	}

	/*
	 * public String updateByPayResult(HttpServletRequest httpRequest) { String
	 * result = "fail"; //定义变量和进行必要的初始化工作 Enumeration parameterNames = null;
	 * String parameterName = null; String parameterValue = null; int count = 0;
	 * Vector[] params = null; Vector vParameterName = new Vector(); Vector
	 * vParameterValue = new Vector();
	 * 
	 * String orderId = httpRequest.getParameter("out_trade_no");//订单号
	 * if(orderId==null||"".equals(orderId)){ orderId="-1"; return result; }
	 * UserRecharge ur = new UserRecharge(); ur.setRechargeNum(orderId);
	 * UserRecharge recharge = null; try { List<UserRecharge> rechargeList =
	 * mapper.getUserRechargeList(ur);
	 * if(null!=rechargeList&&rechargeList.size()>0){
	 * recharge=rechargeList.get(0); } } catch (Exception e1) { // TODO
	 * Auto-generated catch block e1.printStackTrace(); return result; } try {
	 * if(null!=recharge){ parameterNames = httpRequest.getParameterNames();
	 * boolean isPrint = false; while (parameterNames.hasMoreElements())
	 * {//循环收取支付宝发来的所有参数信息 parameterName = (String)
	 * parameterNames.nextElement(); parameterValue =
	 * httpRequest.getParameter(parameterName); if(parameterValue==null)
	 * parameterValue=""; vParameterName.add(parameterName);
	 * vParameterValue.add(parameterValue); count++; }
	 * 
	 * //这里添加对收到信息的处理: //1、更新当前充值记录 String rechargeType;//充值记录状态 String
	 * currency; //充值货币 double creditedMoney=0;//到账金额 Date creditedTime; //到账时间
	 * int auditUser; //审核人 double pvRate; //PV比率 int pv; //兑换后PV值 String
	 * bankName; //充值银行名 String bankAccount;//充值账号名 String platform; //充值平台
	 * String param; //充值接口参数
	 * 
	 * //2、更新用户总账表的基本入账、基本余额、日期和总帐状态等字段数据 UserAccount account = new
	 * UserAccount(); account.setUserId(recharge.getUserId()); List<UserAccount>
	 * accountList = accountMapper.getUserAccountList(account);
	 * if(null!=accountList&&accountList.size()>0){ account=accountList.get(0);
	 * } account.setAccountData(new Date());//日期 //account.setStat(stat);//总账状态
	 * //account.setBaseIn(baseIn);//基本入账
	 * //account.setBaseBalance(baseBalance);//基本余额
	 * 
	 * accountMapper.modifyUserAccount(account);//执行保存操作
	 * 
	 * //3、向用户总账明细表中插入进账数据 UserAccountLog log = new UserAccountLog();
	 * log.setUserId(recharge.getUserId()); List<UserAccountLog> logList =
	 * logMapper.getUserAccountLogList(log);
	 * 
	 * if(null!=logList&&logList.size()>0){ log=logList.get(0); }
	 * 
	 * log.setActionTime(new Date()); log.setActionDesc("汇款充值");//动作摘要
	 * log.setActionType(Constants.ACCOUNT_TYPE_BI);//基础入账
	 * log.setBaseIn(creditedMoney);
	 * log.setBaseBalance(account.getBaseBalance()+creditedMoney);
	 * logMapper.addUserAccountLog(log);
	 * 
	 * result="success";
	 * 
	 * return result; }else{ return result; } } catch (Exception e) { return
	 * e.toString(); } finally { // } }
	 */
}
