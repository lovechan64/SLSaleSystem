package org.slsale.dao.userrecharge;

import java.util.List;

import org.slsale.pojo.UserRecharge;

/**
 * UserRechargeMapper
 * @author bdqn_shy
 * @date 2014-4-9
 */
public interface UserRechargeMapper {
	
	/**
	 * getUserRechargeList
	 * @param recharge
	 * @return
	 */
	public List<UserRecharge> getUserRechargeList(UserRecharge recharge) throws Exception;

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
	 * getAddGoodsPackId
	 * @return
	 */
	public int getAddRechargeId() throws Exception;
	
	/**
	 * modifyUserRecharge
	 * @param recharge
	 * @return
	 */
	public int modifyUserRecharge(UserRecharge recharge);
	
	
	/**
	 * deleteUserRecharge
	 * @param recharge
	 * @return
	 */
	public int deleteUserRecharge(UserRecharge recharge);
}
