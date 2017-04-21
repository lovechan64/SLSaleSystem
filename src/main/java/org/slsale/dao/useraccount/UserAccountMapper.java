package org.slsale.dao.useraccount;

import java.util.List;

import org.slsale.common.dao.BaseMapper;
import org.slsale.pojo.UserAccount;

/**
 * UserAccountMapper
 * @author bdqn_shy
 * @date 2014-4-22
 */
public interface UserAccountMapper extends BaseMapper {
	
	/**
	 * getUserAccountList
	 * @param account
	 * @return
	 */
	public List<UserAccount> getUserAccountList(UserAccount account) throws Exception;

	/**
	 * count
	 * @param account
	 * @return
	 * @throws Exception
	 */
	public int count(UserAccount account) throws Exception;
	
	/**
	 * getUserAccountById
	 * @param account
	 * @return
	 */
	public UserAccount getUserAccountById(UserAccount account) throws Exception;
	
	
	/**
	 * getUserAccountByUserId
	 * @param account
	 * @return
	 * @throws Exception
	 */
	public UserAccount getUserAccountByUserId(UserAccount account) throws Exception;
	
	/**
	 * addUserAccount
	 * @param account
	 * @return
	 */
	public int addUserAccount(UserAccount account) throws Exception;

	/**
	 * addUserAccountByBatch
	 * @param account
	 * @return
	 */
	public int addUserAccountByBatch(UserAccount account) throws Exception;
	
	/**
	 * modifyUserAccount
	 * @param account
	 * @return
	 */
	public int modifyUserAccount(UserAccount account);
	
	/**
	 * modifyUserAccountBatch
	 * @param account
	 * @return
	 */
	public int modifyUserAccountByBatch(List<UserAccount> list);
	
	/**
	 * deleteUserAccount
	 * @param account
	 * @return
	 */
	public int deleteUserAccount(UserAccount account);
	
	/**
	 * createCurrentTable
	 * @param account
	 */
	public void createCurrentAccountTable(UserAccount account);
	
	/**
	 * insertAccountTableData
	 * @param account
	 */
	public void insertAccountTableData(UserAccount account);
	
	
}
