package org.slsale.service.userplace;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slsale.common.Constants;
import org.slsale.common.PageSupport;
import org.slsale.common.Util;
import org.slsale.dao.orderinfo.OrderInfoMapper;
import org.slsale.dao.user.UserMapper;
import org.slsale.dao.userplace.UserPlaceMapper;
import org.slsale.dao.userrefer.UserReferMapper;
import org.slsale.pojo.OrderInfo;
import org.slsale.pojo.User;
import org.slsale.pojo.UserPlace;
import org.slsale.pojo.UserRefer;
import org.springframework.stereotype.Service;


/**
 * UserCashServiceImpl
 * @author bdqn_shy
 * @date 2014-2-24
 */

@Service
public class UserPlaceServiceImpl implements UserPlaceService{

	@Resource
	private UserPlaceMapper mapper;
	@Resource
	private UserReferMapper referMapper;
	@Resource
	private UserMapper userMapper;
	@Resource
	private OrderInfoMapper orderMapper;
	@Override
	public Map<String,Object> getPlaceUserList(String totalCode) {
		//1、如果lastRootId不为空，将用户点击痕迹记录到session
		//2、如果标识存在，将返回上一次点击的位置
		//3、获取页面显示所需的以当前用户为顶点其下的最多15条已安置的用户信息
		
		//根据用户id获取以当前登录用户为顶点其之下的4层(包含当前用户)安置信息集合
		User searchUser = new User();
		searchUser.setTotalCode(totalCode+"%");
		searchUser.setPageSize(15);
		List<User> list = null;
		try {
			list = userMapper.getUserList(searchUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Map<String,Object> map = new HashMap<String,Object>();
		if(list!=null){
			for(User u :list){
				map.put(u.getTotalCode(), u);
			}
		}
		
		return map;
	}
	
	@Override
	public UserPlace getUserPlaceById(Integer id) {
		UserPlace place = new UserPlace();
		place.setId(id);
		try {
			place = mapper.getUserPlaceById(place);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return place;
	}
	@Override
	public int addUserPlace(UserPlace place) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int deleteUserPlace(UserPlace place) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public PageSupport getUserReferList(UserRefer refer, Integer pageIndex) {
		List<UserRefer> list = null;
		if(null==refer){
			refer = new UserRefer();
		}
		// pages
		PageSupport page = new PageSupport();
		if (pageIndex != null)page.setPage(pageIndex);
		try {
			refer.setSearchStr("0");//用户激活状态为待激活的
			page.setTotalCount(referMapper.count(refer));//获取总记录数
			
			if (page.getPage() > page.getPageCount()) page.setPage(page.getPageCount());
			refer.setStarNum((page.getPage() - 1) * page.getPageSize());
			refer.setPageSize(page.getPageSize());
			
			list = referMapper.getUserReferList(refer);//获取当前页数据
		} catch (Exception e) {
			e.printStackTrace();
		}
		page.setItems(list);
		
		return page;
	}
	@Override
	public int doActivate(User targetUser,User sessionUser) {
		try {
			//1、更新上级用户IsLeaf字段
			String parentCode = targetUser.getTotalCode().substring(0,targetUser.getTotalCode().length()-1);
			User parentUser = new User();
			parentUser.setTotalCode(parentCode);
			parentUser.setActiveStatus("1");
			parentUser = userMapper.getUserByLoginCode(parentUser);
			if(parentUser!=null){
				if(parentUser.getIsLeaf()!=null && !parentUser.getIsLeaf().equals("N")){
					User tu= new User();
					tu.setId(parentUser.getId());
					tu.setIsLeaf("N");
					userMapper.modifyUser(tu);//更新IsLeaf字段
				}
				targetUser.setParentId(parentUser.getId());//上线用户
			}
			//2、更新当前用户安置信息
			String code = targetUser.getTotalCode().substring(targetUser.getTotalCode().length()-1);
			targetUser.setCode(code);
			targetUser.setTotalCode(targetUser.getTotalCode());
			targetUser.setIsLeaf("Y");
			targetUser.setDepth(targetUser.getTotalCode().length());//安置层数
			targetUser.setActiveStatus("1");//激活状态 0待激活1已激活
			targetUser.setActiveTime(new Date());//激活时间
			userMapper.modifyUser(targetUser);
			
			//3、计算安置用户产生的安置奖金并添加安置记录到数据库
			//获取消费PV
			OrderInfo order= new OrderInfo();
			order.setPickUserId(targetUser.getId());
			order.setBuyUserId(sessionUser.getId());
			order.setType(Constants.ORDER_TYPE_BD);
			List<OrderInfo> orderList = orderMapper.getOrderInfoList(order);
			if(orderList!=null && orderList.size()>=0){
				order = orderList.get(0);
				User user = new User();
				user.setActiveStatus("1");
				//根据当前用户的code获取所有上级totalcode
				String codeList = Util.getParentTotalCodeList(targetUser.getTotalCode());
				user.setTotalCode(codeList);
				//根据规则，获取所有能获得安置奖励的user集合
				List<User> bonusUserList = userMapper.getUserListBySearch(user);
				if(bonusUserList!=null && bonusUserList.size()>0){
					for(User u :bonusUserList){
						UserPlace place = new UserPlace();
						place.setPlaceTime(new Date());
						place.setUserId(targetUser.getId());//被安置用户id
						place.setBonusUserId(u.getId());//拿奖金用户id
						place.setBuyPV(order.getBasePV());//消费PV
						place.setBonusRate(Constants.PLACE_BONUS_RATE);//奖金比率
						place.setBonusPV(place.getBuyPV() * Constants.PLACE_BONUS_RATE);//安置奖励
						mapper.addUserPlace(place);
					}
				}
				
			}
			
			//4、每日0时10分定时结算前一日的安置奖励金额，将奖励PV按9：1的比例分别放到获取奖励用户的基本账户和重销账户中（此步骤写在定时任务中）
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		return 0;
	}

}
