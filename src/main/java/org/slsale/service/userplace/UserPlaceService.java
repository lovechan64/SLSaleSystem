package org.slsale.service.userplace;

import java.util.Map;

import org.slsale.common.PageSupport;
import org.slsale.pojo.User;
import org.slsale.pojo.UserPlace;
import org.slsale.pojo.UserRefer;

/**
 * UserPlaceService
 * @author bdqn_shy
 * @date 2014-4-24
 */
public interface UserPlaceService {
	
	/**
	 * getPlaceUserList
	 * @param id
	 * @return
	 * @
	 */
	public Map<String,Object> getPlaceUserList(String totalCode) ;

	/**
	 * getUserReferList
	 * @param refer
	 * @param id
	 * @return
	 */
	public PageSupport getUserReferList(UserRefer refer, Integer currentpage) ;
	
	/**
	 * getUserPlaceById
	 * @param id
	 * @return
	 */
	public UserPlace getUserPlaceById(Integer id) ;
	
	/**
	 * doApplyCash
	 * @param place
	 * @return
	 * @
	 */
	public int doActivate(User targetUser,User sessionUser) ;
	
	/**
	 * addUserPlace
	 * @param place
	 * @return
	 */
	public int addUserPlace(UserPlace place) ;
	
	/**
	 * deleteUserPlace
	 * @param place
	 * @return
	 */
	public int deleteUserPlace(UserPlace place) ;
}
