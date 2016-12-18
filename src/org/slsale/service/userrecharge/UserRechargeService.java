package org.slsale.service.userrecharge;

import javax.servlet.http.HttpServletRequest;

import org.slsale.common.PageSupport;
import org.slsale.pojo.LeaveMessage;
import org.slsale.pojo.UserRecharge;

/**
 * UserRechargeService
 * @author bdqn_shy
 * @date 2014-4-9
 */
public interface UserRechargeService {
	/**
	 * getUserRechargeList
	 * @param recharge
	 * @return
	 */
	public PageSupport getUserRechargeList(UserRecharge recharge,PageSupport page) throws Exception;

	/**
	 * addLeaveMessage
	 * @param message
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int addLeaveMessage(LeaveMessage message,String id) throws Exception;
	
	
	String makeOrderAlipayUrl(String charset,String contextPath,String id) throws Exception;
	
	/**
	 * count
	 * @param recharge
	 * @return
	 * @throws Exception
	 */
	public int count(UserRecharge recharge) throws Exception;
	
	/**
	 * getUserRechargeById
	 * @param id
	 * @return
	 */
	public UserRecharge getUserRechargeById(String id) throws Exception;
	
	/**
	 * addUserRecharge
	 * @param recharge
	 * @return
	 */
	public int addUserRecharge(UserRecharge recharge) throws Exception;
	
	/**
	 * modifyUserRecharge
	 * @param recharge
	 * @return
	 */
	public int modifyUserRecharge(UserRecharge recharge) throws Exception;
	
	/**
	 * deleteUserRecharge
	 * @param recharge
	 * @return
	 */
	public int deleteUserRecharge(UserRecharge recharge) throws Exception;

	/**
	 * deleteUserRecharge
	 * @param recharge
	 * @return
	 */
	public String updateByPayResult(HttpServletRequest httpRequest) throws Exception;
	
}
