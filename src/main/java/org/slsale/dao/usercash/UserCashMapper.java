package org.slsale.dao.usercash;

import java.util.HashMap;
import java.util.List;

import org.slsale.pojo.UserCash;

/**
 * UserCashMapper
 * @author bdqn_shy
 * @date 2014-4-24
 */
public interface UserCashMapper {
	
	/**
	 * getUserCashList
	 * @param cash
	 * @return
	 */
	public List<UserCash> getUserCashList(UserCash cash) throws Exception;

	/**
	 * count
	 * @param cash
	 * @return
	 * @throws Exception
	 */
	public int count(UserCash cash) throws Exception;
	
	/**
	 * getUserCashById
	 * @param cash
	 * @return
	 */
	public UserCash getUserCashById(UserCash cash) throws Exception;
	
	/**
	 * addUserCash
	 * @param cash
	 * @return
	 */
	public int addUserCash(UserCash cash) throws Exception;
	
	/**
	 * modifyUserCash
	 * @param cash
	 * @return
	 */
	public int modifyUserCash(UserCash cash);
	
	/**
	 * deleteUserCash
	 * @param cash
	 * @return
	 */
	public int deleteUserCash(UserCash cash);
}
