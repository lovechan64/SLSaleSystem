package org.slsale.service.useraccount;

import org.slsale.pojo.User;
import org.slsale.pojo.UserAccount;

/**
 * UserAccountService
 * @author bdqn_shy
 * @date 2014-4-23
 */
public interface UserAccountService {
	
	/**
	 * getUserAccountByUserId
	 * @param tableName
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public UserAccount getUserAccountByUserId(String tableName, Integer userId,boolean isCreate) throws Exception;

	/**
	 * validateLoginCode
	 * @param loginCode
	 * @return
	 */
	public String validateLoginCode(String loginCode) throws Exception;
	
	/**
	 * validateLevelSecondPassword
	 * @param user
	 * @return
	 */
	public String validateLevelSecondPassword(User user) throws Exception;
	
	/**
	 * doInternalTransfer
	 * @param intUserId
	 * @param outUserId
	 * @param transferMoney
	 * @param note
	 * @return
	 * @throws Exception
	 */
	public String doInternalTransfer(String intLoginCode,Integer outUserId, double transferMoney,String note) throws Exception;
	
	/**
	 * doUpdateAccount 基本账户总账更新及明细插入
	 * @param accountMoney
	 * @param account
	 * @param note
	 * @param stat
	 * @throws Exception
	 */
	public void doUpdateAccount(double accountMoney,UserAccount account, String note,int stat) throws Exception;
	
}
