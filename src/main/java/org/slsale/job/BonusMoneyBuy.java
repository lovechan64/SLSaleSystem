package org.slsale.job;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slsale.common.ConstSale;
import org.slsale.common.Constants;
import org.slsale.common.DateUtil;
import org.slsale.dao.orderinfo.OrderInfoMapper;
import org.slsale.dao.user.UserMapper;
import org.slsale.dao.useraccount.UserAccountMapper;
import org.slsale.dao.useraccountlog.UserAccountLogMapper;
import org.slsale.dao.userbuybonus.UserBuyBonusMapper;
import org.slsale.pojo.OrderInfo;
import org.slsale.pojo.User;
import org.slsale.pojo.UserAccount;
import org.slsale.pojo.UserAccountLog;
import org.slsale.pojo.UserBuyBonus;
import org.slsale.service.useraccount.UserAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;


/**
 * 拿钱再买的重复性消费奖金
 * 直推上线3代，各领5%奖金，月结算。
 */
@Component
public class BonusMoneyBuy implements IBonus {
	@Resource
	private UserMapper userMapper;
	@Resource
	private OrderInfoMapper orderMapper;
	@Resource
	private UserBuyBonusMapper bonusMapper;
	@Resource
	private UserAccountMapper accountMapper;
	@Resource
	private UserAccountLogMapper logMapper;
	@Resource
	private UserAccountService accountService;
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
		BonusMoneyBuy bp = (BonusMoneyBuy)context.getBean("bonusMoneyBuy");
		bp.calBonus();
	}
	/* (non-Javadoc)
	 * @see com.bjtime.support.job.IBonus#calBonus()
	 */
	public String calBonus(){
		String rtn="";
		String tableName = DateUtil.MONTH1.format(new Date());
		String lastMonth = DateUtil.getDefaultDate(-1);
		User user = new User();
		user.setActiveStatus(Constants.ACTIVE_STATUS_Y);
		List<User> UserList = null;
		try {
			UserList = userMapper.getUserList(user);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		OrderInfo order = null;
		UserBuyBonus bonus = null;
		UserAccount account = null;
		UserAccount targetAccount = null;
		UserAccountLog log = null;
		Double sumPv = null;
		Double bonusPv = null;
		String note = "直推下线重复消费（拿钱再买）奖金月结算额";
		List<UserBuyBonus> bonusList =new ArrayList<UserBuyBonus>();
//		List<UserAccount> accountList =new ArrayList<UserAccount>();
		List<UserAccountLog> logList =new ArrayList<UserAccountLog>();
		for (int i = 0; i < UserList.size(); i++) {
			//1、获取每个用户下三代订单信息
			user = UserList.get(i);
			order = new OrderInfo();
			order.setTotalCode(user.getTotalCode()+"%");
			order.setDepth(user.getDepth()+3);
			order.setSearchStr(lastMonth);
			try {
				sumPv = orderMapper.calBonus(order);
			} catch (Exception e) {
				rtn = "执行orderMapper.calBonus(order)报错！";
				e.printStackTrace();
			}
			if(sumPv != null && sumPv > 0){
				//1、添加重复消费奖金月结算
				bonusPv = sumPv * ConstSale.RATE_BUY;
				bonus = new UserBuyBonus();
				bonus.setBonusMonth(lastMonth);
				bonus.setCalTime(new Date());
				bonus.setBonusUserId(user.getId());
				bonus.setBuyPV(sumPv);
				bonus.setBonusRate(ConstSale.RATE_BUY);
				bonus.setBonusPV(bonusPv);
				bonusList.add(bonus);
				try {
					targetAccount = accountService.getUserAccountByUserId(tableName,user.getId(),true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				account = new UserAccount();
				account.setAccountId(targetAccount.getAccountId());
				account.setUserId(targetAccount.getUserId());
				account.setSearchStr(tableName);
				account.setBaseIn(bonusPv*0.8);//基本入账
				account.setBaseBalance(targetAccount.getBaseBalance()+bonusPv*0.8);//80%存入基本账户
				account.setRepeatIn(bonusPv*0.2);//重消入账
				account.setRepeatBalance(targetAccount.getRepeatBalance()+bonusPv*0.2);//20%存入重消账户
				account.setAccountData(new Date());//日期
				account.setStat(Constants.ACCOUNT_TYPE_BRT);//总账状态
				//accountList.add(account);
				accountMapper.modifyUserAccount(account);
				//3、基本账户明细插入
				log = new UserAccountLog();
				log.setUserId(account.getUserId());
				log.setSearchStr(tableName);//拼接表名字段
				log.setBaseIn(bonusPv*0.8);//基本入账
				log.setBaseBalance(targetAccount.getBaseBalance()+bonusPv*0.8);//80%存入基本账户
				log.setRepeatIn(bonusPv*0.2);//重消入账
				log.setRepeatBalance(targetAccount.getRepeatBalance()+bonusPv*0.2);
				log.setActionTime(new Date());
				log.setActionDesc(note+bonusPv+"PV");//动作摘要
				log.setActionType(Constants.ACCOUNT_TYPE_BRT);
				logList.add(log);
			}
		}
		try {
			if(bonusList.size()>0){
				bonusMapper.addUserBuyBonusByBatch(bonusList);
			}
			//account = new UserAccount();
			//account.setSearchStr(tableName);
			//account.setList(accountList);
			//accountMapper.modifyUserAccountByBatch(account);//执行总账更新操作
			//执行总账明细插入操作
			if(logList.size()>0){
				log = new UserAccountLog();
				log.setSearchStr(tableName);
				log.setList(logList);
				logMapper.addUserAccountLogByBatch(log);
			}
		} catch (Exception e) {
			rtn = "批量更新月重复消费奖金报错！";
			e.printStackTrace();
		}
		
		return rtn;
	}

}
