package org.slsale.common.dao;

import org.slsale.pojo.Base;


/**
 * UserAccountMapper
 * @author bdqn_shy
 * @date 2014-4-22
 */
public interface BaseMapper {
	
	/**
	 * executeSQL
	 * @param base
	 * @return
	 * @throws Exception
	 */
	public int executeSQL(Base base) throws Exception;

}
