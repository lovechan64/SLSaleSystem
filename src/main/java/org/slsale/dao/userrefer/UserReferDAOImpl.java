package org.slsale.dao.userrefer;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slsale.pojo.UserAccountLog;
import org.slsale.pojo.UserRefer;
import org.springframework.stereotype.Repository;
//@Repository("userReferDAO")
public class UserReferDAOImpl extends SqlSessionDaoSupport implements UserReferDAO {

	@Override
	public List<UserRefer> getUserReferList(UserRefer refer) throws Exception {
		
		return getSqlSession().selectList("getUserReferList",refer);
	}

	@Override
	public int addUserRefer(UserRefer refer) throws Exception {

		return getSqlSession().insert("addUserRefer",refer);
	}

	@Override
	public int modifyUserRefer(UserRefer refer) {

		return getSqlSession().update("modifyUserRefer",refer);
	}

	@Override
	public int deleteUserRefer(UserRefer refer) {

		return getSqlSession().delete("deleteUserRefer",refer);
	} 



}
