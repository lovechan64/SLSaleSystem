package org.slsale.service.search;

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
public interface SearchService {
	
	/**
	 * getSearchList
	 * @param user
	 * @return
	 * @
	 */
	public Map<String,Object> getSearchList(User user) ;
}
