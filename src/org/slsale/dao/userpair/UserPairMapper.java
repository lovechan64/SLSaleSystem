package org.slsale.dao.userpair;

import java.util.List;

import org.slsale.pojo.UserPair;

/**
 * UserPairMapper
 * @author bdqn_shy
 * @date 2014-4-24
 */
public interface UserPairMapper {
	
	/**
	 * getUserPairList
	 * @param pair
	 * @return
	 */
	public List<UserPair> getUserPairList(UserPair pair) throws Exception;
	
	/**
	 * count
	 * @param pair
	 * @return
	 * @throws Exception
	 */
	public int count(UserPair pair) throws Exception;
	
	/**
	 * getUserPairById
	 * @param pair
	 * @return
	 */
	public UserPair getUserPairById(UserPair pair) throws Exception;
	
	/**
	 * addUserPair
	 * @param pair
	 * @return
	 */
	public int addUserPair(UserPair pair) throws Exception;

	/**
	 * getUserPairByseletct
	 * @param pair
	 * @return
	 */
	public UserPair getUserPairByseletct(UserPair pair);
	
	/**
	 * addUserPairBySettlement
	 * @param pair
	 * @return
	 */
	public int addUserPairBySettlement(UserPair pair) throws Exception;

	/**
	 * modifyUserPair
	 * @param pair
	 * @return
	 */
	public int modifyUserPair(UserPair pair);
	
	/**
	 * deleteUserPair
	 * @param pair
	 * @return
	 */
	public int deleteUserPair(UserPair pair);

	/**
	 * createCurrentPairTable
	 * @param pair
	 */
	public void createCurrentPairTable(UserPair pair);

	/**
	 * updatePairByDLDDR
	 * @param pair
	 * @return
	 */
	public int updatePairByDLDDR(UserPair pair);
	
	/**
	 * updatePairByDLXR
	 * @param pair
	 * @return
	 */
	public int updatePairByDLXR(UserPair pair);
	
	/**
	 * updatePairByXLDDR
	 * @param pair
	 * @return
	 */
	public int updatePairByXLDDR(UserPair pair);
	
	/**
	 * updatePairByXLXR
	 * @param pair
	 * @return
	 */
	public int updatePairByXLXR(UserPair pair);

	/**
	 * updatePairBySettlement
	 * @param pair
	 * @return
	 */
	public int updatePairBySettlement(UserPair pair);
	
}
