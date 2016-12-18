package org.slsale.dao.userplace;

import java.util.HashMap;
import java.util.List;

import org.slsale.pojo.UserPlace;

/**
 * UserPlaceMapper
 * @author bdqn_shy
 * @date 2014-4-24
 */
public interface UserPlaceMapper {
	
	/**
	 * getUserPlaceList
	 * @param place
	 * @return
	 */
	public List<UserPlace> getUserPlaceList(UserPlace place) throws Exception;
	
	/**
	 * count
	 * @param place
	 * @return
	 * @throws Exception
	 */
	public int count(UserPlace place) throws Exception;
	
	/**
	 * getUserPlaceById
	 * @param place
	 * @return
	 */
	public UserPlace getUserPlaceById(UserPlace place) throws Exception;
	
	/**
	 * getUserPlaceByUserId
	 * @param userId
	 * @return
	 */
	public UserPlace getUserPlaceByUserId(Integer userId) throws Exception;
	
	/**
	 * addUserPlace
	 * @param place
	 * @return
	 */
	public int addUserPlace(UserPlace place) throws Exception;
	
	/**
	 * modifyUserPlace
	 * @param place
	 * @return
	 */
	public int modifyUserPlace(UserPlace place);
	
	/**
	 * deleteUserPlace
	 * @param place
	 * @return
	 */
	public int deleteUserPlace(UserPlace place);
}
