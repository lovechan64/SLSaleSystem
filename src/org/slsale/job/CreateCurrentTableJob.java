package org.slsale.job;

import java.util.Date;


import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.slsale.common.DateUtil;
import org.slsale.dao.useraccount.UserAccountMapper;
import org.slsale.dao.useraccountlog.UserAccountLogMapper;
import org.slsale.dao.userpair.UserPairMapper;
import org.slsale.pojo.UserAccount;
import org.slsale.pojo.UserAccountLog;
import org.slsale.pojo.UserPair;
import org.springframework.stereotype.Component;
@Component
public class CreateCurrentTableJob {
	@Resource
	private UserAccountMapper mapper;
	@Resource
	private UserAccountLogMapper logMapper;
	@Resource
	private UserPairMapper pairMapper;
	
	private Logger logger = Logger.getLogger(CreateCurrentTableJob.class);
	
	public static void main(String[] args) {
		new CreateCurrentTableJob().createTable();
	}
	public void createTable() {
		logger.debug("开始执行CreateCurrentTableJob，创建本月Account表、AccountLog表和UserPair表。。。。。。。");
		String currentDate =DateUtil.MONTH1.format(new Date());
		UserAccount account = new UserAccount();
		account.setSearchStr(currentDate);
		createAccountTable(account);
		
		UserAccountLog log = new UserAccountLog();
		log.setSearchStr(currentDate);
		createAccountLogTable(log);

		UserPair pair = new UserPair();
		pair.setSearchStr(currentDate);
		createPairTable(pair);
		logger.debug("执行CreateCurrentTableJob结束。。。。。。。");
	}
	
	/**
	 * 创建本月Account表
	 * @param account
	 */
	private void createAccountTable(UserAccount account) {
		Integer count = null;
		try {
			mapper.createCurrentAccountTable(account);
			count = mapper.count(account);
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug("创建当前用户总账表错误！");
			return;
		}
		if(count>=0){//如果本月的userAccount表创建成功，则从上个月的userAccount表中导入数据
			String lastMonth = DateUtil.getDateStrByValue(-1,0);
			try{
				//查询上个月的userAccount表是否存在
				account.setSearchStr(lastMonth);
				count = mapper.count(account);
			}catch(Exception e){
				logger.debug("获取 user_account_"+account.getSearchStr()+"表失败，,不再进行数据导入!");
				return;
			}
			if(count>=0){
				logger.debug("开始从 user_account_"+account.getSearchStr()+"表向本月表中导入数据。。。。。。。。。。");
				account.setSearchStr(DateUtil.getDateStrByValue(0,0));
				account.setSearchStr1(lastMonth);
				mapper.insertAccountTableData(account);
				logger.debug("导入本月数据成功！");
			}
		}else{
			logger.debug("查询Account表时出现异常,不再进行数据导入!");
		}
	}
	
	/**
	 * 创建本月AccountLog表
	 * @param log
	 */
	private void createAccountLogTable(UserAccountLog log) {
		Integer count = null;
		try {
			logMapper.createCurrentAccountLogTable(log);
			count = logMapper.count(log);
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug("创建当月UserAccountLog表错误");
			return;
		}
		if(count>=0){
			logger.debug("user_account_log_"+log.getSearchStr()+"表已存在！");
		}else{
			logger.debug("创建本月UserAccountLog表未成功！");
		}
	}
	
	/**
	 * 创建本月UserPair表
	 * @param pair
	 */
	private void createPairTable(UserPair pair) {
		Integer count = null;
		try {
			pairMapper.createCurrentPairTable(pair);
			count = pairMapper.count(pair);
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug("创建当月UserPair表错误");
			return;
		}
		if(count>=0){
			logger.debug("user_pair_"+pair.getSearchStr()+"表已存在！");
		}else{
			logger.debug("创建本月UserPair表未成功！");
		}
	}
	
}
