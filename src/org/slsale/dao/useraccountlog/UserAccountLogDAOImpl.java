package org.slsale.dao.useraccountlog;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slsale.pojo.UserAccountLog;
import org.springframework.stereotype.Repository;
//@Repository("userAccountLogDAO")
public class UserAccountLogDAOImpl extends SqlSessionDaoSupport implements UserAccountLogDAO {
	private final String shcema = "org.slsale.dao.useraccountlog."; 

	@Override
	public List<UserAccountLog> getUserAccountLogList(UserAccountLog log)
			throws Exception {
		
		return getSqlSession().selectList("getUserAccountLogList",log);
	}

	@Override
	public int count(UserAccountLog log) throws Exception {
		return getSqlSession().selectOne("count",log);
	}

	@Override
	public UserAccountLog getUserAccountLogById(UserAccountLog log)
			throws Exception {
		return getSqlSession().selectOne("getUserAccountLogById",log);
	}

	@Override
	public UserAccountLog getUserAccountLogByUserId(UserAccountLog log)
			throws Exception {
		return getSqlSession().selectOne("getUserAccountLogByUserId",log);
	}

	@Override
	public int addUserAccountLog(UserAccountLog log) throws Exception {
		return getSqlSession().insert("addUserAccountLog",log);
	}

	@Override
	public int modifyUserAccountLog(UserAccountLog log) {
		return getSqlSession().update("modifyUserAccountLog",log);
	}

	@Override
	public int deleteUserAccountLog(UserAccountLog log) {
		return getSqlSession().delete("deleteUserAccountLog",log);
	}

	@Override
	public void createCurrentAccountLogTable(UserAccountLog log) {
		getSqlSession().selectOne("createCurrentAccountLogTable",log);
	}

}
