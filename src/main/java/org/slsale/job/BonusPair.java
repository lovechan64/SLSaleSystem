package org.slsale.job;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slsale.common.ConstSale;
import org.slsale.common.Constants;
import org.slsale.common.DateUtil;
import org.slsale.dao.user.UserMapper;
import org.slsale.dao.useraccount.UserAccountMapper;
import org.slsale.dao.useraccountlog.UserAccountLogMapper;
import org.slsale.dao.userpair.UserPairMapper;
import org.slsale.pojo.User;
import org.slsale.pojo.UserAccount;
import org.slsale.pojo.UserAccountLog;
import org.slsale.pojo.UserPair;
import org.slsale.service.useraccount.UserAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
@Component
public class BonusPair implements IBonus {
	@Resource
	private UserMapper userMapper;
	@Resource
	private UserAccountMapper accountMapper;
	@Resource
	private UserAccountService accountService;
	@Resource
	private UserAccountLogMapper logMapper;
	@Resource
	private UserPairMapper pairMapper;
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
		BonusPair bp = (BonusPair)context.getBean("bonusPair");
		bp.calBonus();
	}
	
	public String calBonus(){
		String result = "";
		String yesterday = DateUtil.getDefaultDate(0, -1);
		String tableName = DateUtil.MONTH1.format(new Date());
		User auUser = new User();
		auUser.setActiveStatus(Constants.ACTIVE_STATUS_Y);
		List<User> userList = null;
		try {
			userList = userMapper.getUserList(auUser);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		UserPair pair = null;
		List<UserPair> pairList = new ArrayList<UserPair>();
		// 遍历userList  插入到user_pair_XXX表
		for(User user : userList){
			pair = new UserPair();
			pair.setSearchStr(tableName);
			pair.setBonusUserId(user.getId());
			pair.setTotalCode(user.getTotalCode());
			pair.setEachPV(ConstSale.EACH_PV);
			pair.setBonusRate(ConstSale.RATE_PAIR);
			pair.setActiveTime(yesterday);
			pair.setPvTimes(0);
			pair.setLeftYesterday(0);
			pair.setRightYesterday(0);
			pair = pairMapper.getUserPairByseletct(pair);
			pairList.add(pair);
		}
		try {
			pair = new UserPair();
			pair.setSearchStr(tableName);
			pair.setList(pairList);
			pairMapper.addUserPairBySettlement(pair);
		} catch (Exception e) {
			result = "调用addUserPairBySettlement(pairList)结算对碰奖励异常！";
			e.printStackTrace();
		}
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------
		//计算并更新 对碰奖
		pair.setYesterday(yesterday);
		//1、大于100碰的
		//left >= right
		pairMapper.updatePairByDLDDR(pair);
		//left < right
		pairMapper.updatePairByDLXR(pair);
		//2、小于100碰的
		//left >= right
		pairMapper.updatePairByXLDDR(pair);
		//left < right
		pairMapper.updatePairByXLXR(pair);
		//计算
		pairMapper.updatePairBySettlement(pair);
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------
		//更新 账户表记录
		UserAccount account = null;
		UserAccount targetAccount = null;
		UserAccountLog log = null;
		List<UserPair> listPair = null;
		try {
			listPair = pairMapper.getUserPairList(pair);
			if(listPair!=null && listPair.size()>0 ){
				//List<UserAccount> accountList = new ArrayList<UserAccount>();
				List<UserAccountLog> logList = new ArrayList<UserAccountLog>();
				String note = "对碰奖";
				for(UserPair up :listPair){
					//2、基本账户总账更新	 
					targetAccount = accountService.getUserAccountByUserId(tableName,up.getBonusUserId(),true);
					account = new UserAccount();
					account.setAccountId(targetAccount.getAccountId());
					account.setUserId(targetAccount.getUserId());
					account.setSearchStr(tableName);
					account.setBaseIn(up.getBonusPV());//基本入账
					account.setBaseBalance(targetAccount.getBaseBalance()+up.getBonusPV());//存入基本账户
					account.setAccountData(new Date());//日期
					account.setStat(Constants.ACCOUNT_TYPE_BI);//总账状态
					//accountList.add(account);
					accountMapper.modifyUserAccount(account);
					//3、基本账户明细插入
					log = new UserAccountLog();
					log.setUserId(account.getUserId());
					log.setSearchStr(tableName);//拼接表名字段
					log.setBaseIn(up.getBonusPV());//基本入账
					log.setBaseBalance(targetAccount.getBaseBalance()+up.getBonusPV());//存入基本账户
					log.setActionDesc(note+up.getBonusPV()+"PV");//动作摘要
					log.setActionType(Constants.ACCOUNT_TYPE_BI);
					logList.add(log);
				}
				//account = new UserAccount();
				//account.setList(accountList);
				//accountMapper.modifyUserAccountByBatch(accountList);
				log = new UserAccountLog();
				log.setSearchStr(tableName);
				log.setList(logList);
				logMapper.addUserAccountLogByBatch(log);
			}
		} catch (Exception e) {
			result = "最终结算对碰奖励异常！";
			e.printStackTrace();
		}
		
		return result;
	}
}
