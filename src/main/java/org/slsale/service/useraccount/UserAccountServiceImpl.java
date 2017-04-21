package org.slsale.service.useraccount;

import java.util.Date;

import javax.annotation.Resource;

import org.slsale.common.Constants;
import org.slsale.common.DateUtil;
import org.slsale.dao.user.UserMapper;
import org.slsale.dao.useraccount.UserAccountMapper;
import org.slsale.dao.useraccountlog.UserAccountLogMapper;
import org.slsale.pojo.User;
import org.slsale.pojo.UserAccount;
import org.slsale.pojo.UserAccountLog;
import org.springframework.stereotype.Service;

/**
 * UserAccountServiceImpl
 * @author bdqn_shy
 * @date 2014-2-23
 */

@Service
public class UserAccountServiceImpl implements UserAccountService{
	@Resource
	private UserAccountMapper mapper;
	//private UserAccountDAO userAccountDao;
	@Resource
	private UserAccountLogMapper logMapper;
	//private UserAccountLogDAO logDao;
	@Resource
	private UserMapper userMapper;
	
	@Override
	public UserAccount getUserAccountByUserId(String tableName,Integer userId,boolean isCreate){
		if(!DateUtil.isNotEmpty(tableName)){
			tableName = DateUtil.MONTH1.format(new Date());
		}
		UserAccount account = new UserAccount();
		account.setSearchStr(tableName);
		account.setUserId(userId);
		try {
			account = mapper.getUserAccountByUserId(account);
			if(account==null&&isCreate){
			account = new UserAccount();
			account.setSearchStr(tableName);
			account.setUserId(userId);
			account.setBaseBalance(0);
			account.setRepeatBalance(0);
			
			mapper.addUserAccount(account);	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return account;
	}
	
	@Override
	public String validateLoginCode(String loginCode) throws Exception {
		User _user = new User();
		_user.setLoginCode(loginCode);
		_user.setIsStart(1);
		try {
			if(userMapper.loginCodeIsExit(_user) > 0)
				return "have";
			else 
				return "no";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public String validateLevelSecondPassword(User user)
			throws Exception {
		
		return null;
	}

	@Override
	public String doInternalTransfer(String intLoginCode, Integer outUserId,
			double transferMoney, String note) {
		if(DateUtil.isEmpty(note)){
			note ="内部转账";
		}
		try {
			User user = new User();
			user.setLoginCode(intLoginCode);
			user = userMapper.getUserByLoginCode(user);
			if(user!=null&&user.getId()!=null){
				String tablename = DateUtil.MONTH1.format(new Date());
				//1、进账账户更新
				UserAccount targetInAccount = getUserAccountByUserId(null,user.getId(),false);
				targetInAccount.setSearchStr(tablename);
				targetInAccount.setBaseBalance(targetInAccount.getBaseBalance()+transferMoney);//基本余额
				doUpdateAccount(transferMoney,targetInAccount,note,Constants.ACCOUNT_TYPE_BI);
				//2、出账账户更新
				UserAccount targetOutAccount = getUserAccountByUserId(null,outUserId,false);
				targetOutAccount.setSearchStr(tablename);
				targetOutAccount.setBaseBalance(targetInAccount.getBaseBalance()-transferMoney);//基本余额
				doUpdateAccount(transferMoney,targetOutAccount,note,Constants.ACCOUNT_TYPE_BO);
			}else{
				return "fail";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		
		return "success";
	}
	
	/** 
	 * doUpdateAccount 基本账户总账更新及明细插入	
	 * @param inAccountMoney
	 * @param account
	 * @param note
	 * @param stat
	 * @throws Exception
	 */
	public void doUpdateAccount(double inAccountMoney,UserAccount account, String note,int stat) throws Exception{
		//必须属性
		UserAccount targetInAccount = new UserAccount();
		targetInAccount.setAccountId(account.getAccountId());
		targetInAccount.setUserId(account.getUserId());
		targetInAccount.setSearchStr(account.getSearchStr());
		
		UserAccountLog log = new UserAccountLog();
		log.setUserId(account.getUserId());
		log.setSearchStr(account.getSearchStr());//拼接表名字段
		
		//根据帐号操作状态插入对应数据
		if(Constants.ACCOUNT_TYPE_BO==stat){
			targetInAccount.setBaseOut(inAccountMoney);//基本出账
			targetInAccount.setBaseBalance(account.getBaseBalance());//基本余额
			log.setBaseOut(inAccountMoney);
			log.setBaseBalance(account.getBaseBalance());
		}else if(Constants.ACCOUNT_TYPE_BI==stat){
			targetInAccount.setBaseIn(inAccountMoney);//基本入账
			targetInAccount.setBaseBalance(account.getBaseBalance());//基本余额
			log.setBaseIn(inAccountMoney);
			log.setBaseBalance(account.getBaseBalance());
		}else if(Constants.ACCOUNT_TYPE_RO==stat){
			targetInAccount.setRepeatOut(inAccountMoney);//重消出账
			targetInAccount.setRepeatBalance(account.getRepeatBalance());//重消余额
			log.setRepeatOut(inAccountMoney);
			log.setRepeatBalance(account.getRepeatBalance());
		}else if(Constants.ACCOUNT_TYPE_RI==stat){
			targetInAccount.setRepeatIn(inAccountMoney);//重消入账
			targetInAccount.setRepeatBalance(account.getRepeatBalance());//重消余额
			log.setRepeatIn(inAccountMoney);
			log.setRepeatBalance(account.getRepeatBalance());
		}
		
		//1、基本账户总账更新	 更新用户总账表的基本入账、基本余额、日期和总帐状态等字段数据
		targetInAccount.setAccountData(new Date());//日期
		targetInAccount.setStat(stat);//总账状态
		mapper.modifyUserAccount(targetInAccount);//执行总账更新操作
		
		//2、基本账户明细插入
		log.setActionTime(new Date());
		log.setActionDesc(note);//动作摘要
		log.setActionType(stat);//基础入账
		
		logMapper.addUserAccountLog(log);//执行总账明细插入操作
	}
	
}
