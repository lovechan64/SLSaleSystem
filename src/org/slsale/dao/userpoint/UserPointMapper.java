package org.slsale.dao.userpoint;

import java.util.List;

import org.slsale.pojo.UserPoint;

/**
 * UserPointMapper
 * @author bdqn_shy
 * @date 2014-4-24
 */
public interface UserPointMapper {
	
	/**
	 * getUserPointList
	 * @param point
	 * @return
	 */
	public List<UserPoint> getUserPointList(UserPoint point) throws Exception;
	
	/**
	 * count
	 * @param point
	 * @return
	 * @throws Exception
	 */
	public int count(UserPoint point) throws Exception;
	
	/**
	 * getUserPointById
	 * @param point
	 * @return
	 */
	public UserPoint getUserPointById(UserPoint point) throws Exception;
	
	/**
	 * getUserPointByUserId
	 * @param userId
	 * @return
	 */
	public UserPoint getUserPointByUserId(Integer userId) throws Exception;
	
	/**
	 * addUserPoint
	 * @param point
	 * @return
	 */
	public int addUserPoint(UserPoint point) throws Exception;
	
	/**
	 * modifyUserPoint
	 * @param point
	 * @return
	 */
	public int modifyUserPoint(UserPoint point);
	
	/**
	 * deleteUserPoint
	 * @param point
	 * @return
	 */
	public int deleteUserPoint(UserPoint point);

	/**
	 * getSumBonusPV
	 * @param point
	 * @return
	 */
	public Double getSumBonusPV(UserPoint point);
}
