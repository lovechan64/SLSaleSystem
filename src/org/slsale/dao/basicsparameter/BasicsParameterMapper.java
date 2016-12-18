package org.slsale.dao.basicsparameter;

import java.util.List;

import org.slsale.pojo.BasicsParameter;

/**
 * BasicsParameterMapper
 * @author bdqn_shy
 * @date 2014-5-7
 */
public interface BasicsParameterMapper {
	/**
	 * getBasicsParameterList
	 * @return
	 */
	public List<BasicsParameter> getBasicsParameterList(BasicsParameter param) throws Exception;
	
	
	/**
	 * addBasicsParameter
	 * @param param
	 * @return
	 */
	public int addBasicsParameter(BasicsParameter param) throws Exception;
	
	/**
	 * modifyBasicsParameter
	 * @param param
	 * @return
	 */
	public int modifyBasicsParameter(BasicsParameter param);
	
	/**
	 * deleteBasicsParameter
	 * @param param
	 * @return
	 */
	public int deleteBasicsParameter(BasicsParameter param);
}
