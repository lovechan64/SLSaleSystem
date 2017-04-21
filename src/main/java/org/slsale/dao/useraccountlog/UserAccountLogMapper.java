package org.slsale.dao.useraccountlog;

import java.util.List;

import org.slsale.pojo.UserAccountLog;

/**
 * UserAccountLogMapper
 * @author bdqn_shy
 * @date 2014-4-9
 */
public interface UserAccountLogMapper {
	
	/**
	 * getUserAccountLogList
	 * @param log
	 * @return
	 */
	public List<UserAccountLog> getUserAccountLogList(UserAccountLog log) throws Exception;

	/**
	 * count
	 * @param log
	 * @return
	 * @throws Exception
	 */
	public int count(UserAccountLog log) throws Exception;
	
	/**
	 * getUserAccountLogById
	 * @param log
	 * @return
	 */
	public UserAccountLog getUserAccountLogById(UserAccountLog log) throws Exception;
	
	/**
	 * getUserAccountLogByUserId
	 * @param log
	 * @return
	 * @throws Exception
	 */
	public UserAccountLog getUserAccountLogByUserId(UserAccountLog log) throws Exception;
	
	/**
	 * addUserAccountLog
	 * @param log
	 * @return
	 */
	public int addUserAccountLog(UserAccountLog log) throws Exception;
	
	/**
	 * addUserAccountLogByBatch
	 * @param log
	 * @return
	 */
	public int addUserAccountLogByBatch(UserAccountLog log) throws Exception;
	
	/**
	 * modifyUserAccountLog
	 * @param log
	 * @return
	 */
	public int modifyUserAccountLog(UserAccountLog log);
	
	
	/**
	 * deleteUserAccountLog
	 * @param log
	 * @return
	 */
	public int deleteUserAccountLog(UserAccountLog log);

	/**
	 * createCurrentAccountLogTable
	 * @param log
	 */
	public void createCurrentAccountLogTable(UserAccountLog log);
}
