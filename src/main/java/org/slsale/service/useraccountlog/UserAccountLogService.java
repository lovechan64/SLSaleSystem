package org.slsale.service.useraccountlog;

import org.slsale.common.PageSupport;
import org.slsale.pojo.User;
import org.slsale.pojo.UserAccountLog;

/**
 * UserAccountLogService
 * @author bdqn_shy
 * @date 2014-4-9
 */
public interface UserAccountLogService {
	
	/**
	 * getAccountLogList
	 * @param currentpage
	 * @param start
	 * @param log
	 * @return
	 * @throws Exception
	 */
	public PageSupport getAccountLogList(Integer currentpage,String start,UserAccountLog log) throws Exception;

	/**
	 * getUserAccountLogById
	 * @param log
	 * @return
	 */
	public UserAccountLog getUserAccountLogById(UserAccountLog log) throws Exception;
	
	/**
	 * addUserAccountLog
	 * @param log
	 * @return
	 */
	public int addUserAccountLog(UserAccountLog log) throws Exception;
	
	/**
	 * modifyUserAccountLog
	 * @param log
	 * @return
	 */
	public int modifyUserAccountLog(UserAccountLog log) throws Exception;
	
	/**
	 * deleteUserAccountLog
	 * @param log
	 * @return
	 */
	public int deleteUserAccountLog(UserAccountLog log) throws Exception;
	
}
