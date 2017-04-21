package org.slsale.dao.userbuybonus;

import java.util.List;

import org.slsale.pojo.UserBuyBonus;
import org.slsale.pojo.UserRefer;

/**
 * UserBuyBonusMapper
 * @author bdqn_shy
 * @date 2014-4-24
 */
public interface UserBuyBonusMapper {
	
	/**
	 * getUserBuyBonusList
	 * @param bonus
	 * @return
	 */
	public List<UserBuyBonus> getUserBuyBonusList(UserBuyBonus bonus) throws Exception;
	
	/**
	 * count
	 * @param bonus
	 * @return
	 * @throws Exception
	 */
	public int count(UserBuyBonus bonus) throws Exception;
	
	/**
	 * getUserBuyBonusById
	 * @param bonus
	 * @return
	 */
	public UserBuyBonus getUserBuyBonusById(UserBuyBonus bonus) throws Exception;
	
	/**
	 * getUserBuyBonusByUserId
	 * @param userId
	 * @return
	 */
	public UserBuyBonus getUserBuyBonusByUserId(Integer userId) throws Exception;
	
	/**
	 * addUserBuyBonus
	 * @param bonus
	 * @return
	 */
	public int addUserBuyBonus(UserBuyBonus bonus) throws Exception;
	
	/**
	 * addUserBuyBonusByBatch
	 * @param bonus
	 * @return
	 */
	public int addUserBuyBonusByBatch(List<UserBuyBonus> list) throws Exception;
	
	/**
	 * modifyUserBuyBonus
	 * @param bonus
	 * @return
	 */
	public int modifyUserBuyBonus(UserBuyBonus bonus);
	
	/**
	 * deleteUserBuyBonus
	 * @param bonus
	 * @return
	 */
	public int deleteUserBuyBonus(UserBuyBonus bonus);

	/**
	 * getSumBonusPV
	 * @param bonus
	 * @return
	 */
	public Double getSumBonusPV(UserBuyBonus bonus);
}
