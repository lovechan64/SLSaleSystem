package org.slsale.service.user;

import java.util.List;

import javax.annotation.Resource;

import org.slsale.dao.user.UserMapper;
import org.slsale.pojo.User;
import org.slsale.pojo.UserAccount;
import org.slsale.service.useraccount.UserAccountService;
import org.springframework.stereotype.Service;

/**
 * UserServiceImpl
 * @author bdqn_hl
 * @date 2014-2-21
 */

@Service
public class UserServiceImpl implements UserService{

	@Resource
	private UserMapper mapper;
	@Resource
	private UserAccountService accountService;
	
	public List<User> getUserList(User user) throws Exception{
		// TODO Auto-generated method stub
		return mapper.getUserList(user);
	}

	public User getLoginUser(User user) throws Exception{
		// TODO Auto-generated method stub
		return mapper.getLoginUser(user);
	}

	public int addUser(User user) throws Exception{
		mapper.addUser(user);
		Integer id = mapper.getLastInsertId();
		accountService.getUserAccountByUserId(null, id,true);
		return id;
	}

	public int deleteUser(User user) throws Exception{
		// TODO Auto-generated method stub
		return mapper.deleteUser(user);
	}

	public int modifyUser(User user) throws Exception{
		// TODO Auto-generated method stub
		return mapper.modifyUser(user);
	}

	public int count(User user) throws Exception {
		// TODO Auto-generated method stub
		return mapper.count(user);
	}

	public User getUserById(User user) throws Exception {
		// TODO Auto-generated method stub
		return mapper.getUserById(user);
	}

	public int delUserPic(User user) throws Exception {
		// TODO Auto-generated method stub
		return mapper.delUserPic(user);
	}

	public int loginCodeIsExit(User user) throws Exception {
		// TODO Auto-generated method stub
		return mapper.loginCodeIsExit(user);
	}

	public List<User> getUserListBySearch(User user) throws Exception {
		// TODO Auto-generated method stub
		return mapper.getUserListBySearch(user);
	}

}
