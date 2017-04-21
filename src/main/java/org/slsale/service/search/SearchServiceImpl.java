package org.slsale.service.search;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slsale.common.Constants;
import org.slsale.common.DateUtil;
import org.slsale.dao.user.UserMapper;
import org.slsale.dao.userbuybonus.UserBuyBonusMapper;
import org.slsale.dao.userpair.UserPairMapper;
import org.slsale.dao.userpoint.UserPointMapper;
import org.slsale.dao.userrefer.UserReferMapper;
import org.slsale.pojo.User;
import org.slsale.pojo.UserBuyBonus;
import org.slsale.pojo.UserPair;
import org.slsale.pojo.UserPoint;
import org.slsale.pojo.UserRefer;
import org.springframework.stereotype.Service;


/**
 * UserCashServiceImpl
 * @author bdqn_shy
 * @date 2014-2-24
 */

@Service
public class SearchServiceImpl implements SearchService{

	@Resource
	private UserBuyBonusMapper bonusMapper;
	@Resource
	private UserPairMapper pairMapper;
	@Resource
	private UserMapper userMapper;
	@Resource
	private UserReferMapper referMapper;
	@Resource
	private UserPointMapper pointMapper;
	@Override
	public Map<String, Object> getSearchList(User targetUser) {
		Map<String, Object> map = new HashMap<String, Object>();
		//1、获取当前登录用户推荐总人数
		User user = new User();
		user.setReferId(targetUser.getId());
		user.setIsStart(Constants.START_STATUS_Y);
		user.setActiveStatus(Constants.ACTIVE_STATUS_Y);
		List<User> userList = null;
		try {
			userList = userMapper.getUserListBySearch(user);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		if(userList!=null && userList.size()>0){
			map.put("referNum", userList.size());
		}
		double sum = 0.00;
		double referBonus_sum = 0.00;
		double placeBonus_sum = 0.00;
		double pairBonus_sum = 0.00;
		double pointBonus_sum = 0.00;
		List<Object> obj1List = new ArrayList<Object>();
		List<Object> obj2List = new ArrayList<Object>();
		for(int i =0;i<10;i++){
			//2、获取当前登录用户十日内推荐、安置及碰局奖励明细
			//日期     新推荐人數     縂碰侷數 	                                區域罔左區                                                  	區域罔右區
			//        	                                                  縂人數 	  新安置人數 	剩餘碰数  	縂人數 	新安置人數 	剩餘碰数
			Object[] obj1 = new Object[10];
			Object[] obj2 = new Object[6];
			String datestr = DateUtil.getDefaultDate(0,-(10-i));
			Date date = DateUtil.doConvertToDate(datestr);
			obj1[0]= datestr;
			obj2[0]= datestr;
			//新增推荐人数
			user.setActiveTime(date);
			try {
				userList = userMapper.getUserListBySearch(user);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(userList!=null&& userList.size()>0){
				obj1[1]= userList.size();
			}
			//统计左右分区碰局情况
			UserPair pair = new UserPair();
			String tableName = DateUtil.getDateByValue(0,-(10-i));
			pair.setSearchStr(tableName);
			pair.setBonusUserId(user.getId());
			pair.setPairTime(date);
			List<UserPair> list = null;
			try {
				list = pairMapper.getUserPairList(pair);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(null !=list && list.size()>0){
				UserPair up = list.get(0);
				obj1[2]= up.getSumPairPV()/up.getEachPV();
				obj1[3]= up.getLeftUserNum();
				obj1[5]= up.getLeftKeep();
				obj1[6]= up.getRightUserNum();
				obj1[8]= up.getRightKeep();
				obj2[3]= up.getBonusPV();
			}
			//统计左分区新增安置人数
			user.setIsStart(Constants.START_STATUS_Y);
			user.setActiveStatus(Constants.ACTIVE_STATUS_Y);
			user.setActiveTime(date);
			user.setTotalCode("'"+targetUser.getTotalCode()+"0%'");
			try {
				userList = userMapper.getUserListBySearch(user);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(null !=userList && userList.size()>0){
				obj1[4]= userList.size();
			}
			//统计右分区新增安置人数
			user.setTotalCode("'"+targetUser.getTotalCode()+"1%'");
			try {
				userList = userMapper.getUserListBySearch(user);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(null !=userList && userList.size()>0){
				obj1[7]= userList.size();
			}
			obj1List.add(obj1);
			
			//3、获取当前登录用户十日内每日各项奖励汇总
			//日期	推荐獎	安置獎	对碰獎	积分消费獎	應發合計 	 重複消費款	實發合計
			
			//推荐奖金日汇总
			UserRefer refer = new UserRefer();
			refer.setReferUserId(user.getId());
			refer.setReferTime(date);
			obj2[1] = referMapper.getSumReferBonusPV(refer);
			//安置奖金日汇总
			UserBuyBonus bonus = new UserBuyBonus();
			bonus.setBonusUserId(user.getId());
			bonus.setCalTime(date);
			obj2[2] = bonusMapper.getSumBonusPV(bonus);
			//积分消费奖金日汇总
			UserPoint point = new UserPoint();
			point.setBonusUserId(user.getId());
			point.setBuyTime(date);
			obj2[4] = pointMapper.getSumBonusPV(point);
			//实发奖金日汇总=推荐奖励+安置奖励+对碰奖励+积分消费
			double referBonus = null != obj2[1] ? Double.parseDouble(String.valueOf(obj2[1])) : 0.00;
			double placeBonus = null != obj2[2] ? Double.parseDouble(String.valueOf(obj2[2])) : 0.00;
			double pairBonus =  null != obj2[3] ? Double.parseDouble(String.valueOf(obj2[3])) : 0.00;
			double pointBonus = null != obj2[4] ? Double.parseDouble(String.valueOf(obj2[4])) : 0.00;
			double daySum = referBonus + placeBonus + pairBonus +pointBonus;
			obj2[5] = daySum != 0.00 ? daySum : null;
			
			obj2List.add(obj2);
			
			referBonus_sum += referBonus;
			placeBonus_sum += placeBonus;
			pairBonus_sum  += pairBonus;
			pointBonus_sum += pointBonus;
			sum += daySum;
		}
		map.put("obj1List",obj1List);
		map.put("obj2List",obj2List);
		map.put("heji",new Object[]{"合计",referBonus_sum,placeBonus_sum,pairBonus_sum,pointBonus_sum,sum});
		
		//4、获取当前登录用户上月重复消费月结算奖励
		UserBuyBonus bonus = new UserBuyBonus();
		bonus.setBonusUserId(user.getId());
		bonus.setBonusMonth(DateUtil.getDefaultDate(-1));
		List<UserBuyBonus> ubbList = null;
		try {
			ubbList = bonusMapper.getUserBuyBonusList(bonus);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(null !=ubbList && ubbList.size()>0){
			map.put("bonus", ubbList.get(0));
		}
		
		return map;
	}

}
