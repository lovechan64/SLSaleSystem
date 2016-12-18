package org.slsale.service.usercash;

import org.slsale.common.PageSupport;
import org.slsale.pojo.UserCash;

/**
 * UserCashService
 * @author bdqn_shy
 * @date 2014-4-24
 */
public interface UserCashService {

	/**
	 * getUserCashList
	 * @param currentpage
	 * @param start
	 * @param end
	 * @param cash
	 * @return
	 * @throws Exception
	 */
	public PageSupport getUserCashList(Integer currentpage, String start, String end, UserCash cash) throws Exception;

	/**
	 * getUserCashById
	 * @param cash
	 * @return
	 */
	public UserCash getUserCashById(UserCash cash) throws Exception;
	
	/**
	 * doApplyCash
	 * @param cash
	 * @return
	 * @throws Exception
	 */
	public int doApplyCash(UserCash cash) throws Exception;
	
	/**
	 * addUserCash
	 * @param cash
	 * @return
	 */
	public int addUserCash(UserCash cash) throws Exception;
	
	/**
	 * deleteUserCash
	 * @param cash
	 * @return
	 */
	public int deleteUserCash(UserCash cash) throws Exception;
}
