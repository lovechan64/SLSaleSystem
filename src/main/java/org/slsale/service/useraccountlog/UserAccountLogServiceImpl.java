package org.slsale.service.useraccountlog;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slsale.common.DateUtil;
import org.slsale.common.PageSupport;
import org.slsale.common.SQLTools;
import org.slsale.dao.useraccountlog.UserAccountLogMapper;
import org.slsale.pojo.UserAccountLog;
import org.springframework.stereotype.Service;

/**
 * UserAccountLogServiceImpl
 * @author bdqn_shy
 * @date 2014-2-21
 */

@Service
public class UserAccountLogServiceImpl implements UserAccountLogService{

	@Resource
	private UserAccountLogMapper mapper;

	public int addUserAccountLog(UserAccountLog log) throws Exception{
		// TODO Auto-generated method stub
		return mapper.addUserAccountLog(log);
	}

	public int deleteUserAccountLog(UserAccountLog log) throws Exception{
		// TODO Auto-generated method stub
		return mapper.deleteUserAccountLog(log);
	}

	public int modifyUserAccountLog(UserAccountLog log) throws Exception{
		// TODO Auto-generated method stub
		return mapper.modifyUserAccountLog(log);
	}


	public UserAccountLog getUserAccountLogById(UserAccountLog log) throws Exception {
		// TODO Auto-generated method stub
		return mapper.getUserAccountLogById(log);
	}

	public int count(UserAccountLog log) throws Exception {
		// TODO Auto-generated method stub
		return mapper.count(log);
	}

	@Override
	public PageSupport getAccountLogList(Integer currentpage, String start,UserAccountLog log)
			throws Exception {
		if(null==log){
			log = new UserAccountLog();
		}
		if (null != start && start.length()>0) {
			log.setStartTimeStr(SQLTools.transfer(start));
		}else{
			log.setStartTimeStr(DateUtil.MONTH2.format(new Date()));
		}
		// pages
		PageSupport page = new PageSupport();
		if (currentpage != null)page.setPage(currentpage);
		List<UserAccountLog> userList = null;
		try {
			log.setSearchStr(DateUtil.getCurrentYearMonth(log.getStartTimeStr()));
			page.setTotalCount(mapper.count(log));//获取总记录数
			
			if (page.getPage() > page.getPageCount()) page.setPage(page.getPageCount());
			log.setStarNum((page.getPage() - 1) * page.getPageSize());
			log.setPageSize(page.getPageSize());
			
			userList = mapper.getUserAccountLogList(log);//获取当前页数据
		} catch (Exception e) {
			e.printStackTrace();
		}
		page.setItems(userList);
		
		return page;
	}

}
