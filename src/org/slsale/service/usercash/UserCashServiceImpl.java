package org.slsale.service.usercash;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slsale.common.Constants;
import org.slsale.common.DateUtil;
import org.slsale.common.PageSupport;
import org.slsale.common.SQLTools;
import org.slsale.common.Util;
import org.slsale.dao.datadictionary.DataDictionaryMapper;
import org.slsale.dao.usercash.UserCashMapper;
import org.slsale.pojo.DataDictionary;
import org.slsale.pojo.UserAccount;
import org.slsale.pojo.UserCash;
import org.slsale.service.useraccount.UserAccountService;
import org.springframework.stereotype.Service;


/**
 * UserCashServiceImpl
 * @author bdqn_shy
 * @date 2014-2-24
 */

@Service
public class UserCashServiceImpl implements UserCashService{

	@Resource
	private UserCashMapper mapper;
	@Resource
	DataDictionaryMapper ddMapper;
	@Resource
	UserAccountService accountService;
	
	@Override
	public PageSupport getUserCashList(Integer currentpage, String start,String end,
			UserCash cash) throws Exception {
		if (null != start && start.length()>0) {
			cash.setStartTimeStr(SQLTools.transfer(start));
		}
		if (null != end && end.length()>0) {
			cash.setEndTimeStr(SQLTools.transfer(end));
		}
		// pages
		PageSupport page = new PageSupport();
		if (currentpage != null)page.setPage(currentpage);
		List<UserCash> mapList = null;
		List<UserCash> cashList = null;
		try {
			page.setTotalCount(mapper.count(cash));//获取总记录数
			
			if (page.getPage() > page.getPageCount()) page.setPage(page.getPageCount());
			cash.setStarNum((page.getPage() - 1) * page.getPageSize());
			cash.setPageSize(page.getPageSize());
			
			cashList = mapper.getUserCashList(cash);//获取当前页数据
		} catch (Exception e) {
			e.printStackTrace();
		}
		page.setItems(cashList);
		
		return page;
	}
	@Override
	public UserCash getUserCashById(UserCash cash) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int addUserCash(UserCash cash) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int deleteUserCash(UserCash cash) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int doApplyCash(UserCash cash) throws Exception {
		//1、组织要保存的cash对象参数 已有参数：金额、银行名、支行名、开户人、卡号、用户id，需组织参数：
		cash.setCashTime(new Date());//提现时间
		cash.setCashNum(Util.getOrderNum(Constants.ORDER_TYPE_TX));//提现单号
		cash.setStat(Constants.CASH_STAT_O);//提现状态
		cash.setCurrency(Constants.CY_RMB);//提现货币
		
		//获取PV转换率
		DataDictionary dd = new DataDictionary();
		dd.setTypeCode(Constants.RATE);
		dd.setValueId(Constants.CY_RMB);
		dd = ddMapper.getDataDictionariesByTypeAndValueId(dd);
		Double pvRate = Double.valueOf(dd.getValueName());
		
		cash.setPvRate(pvRate);//pv转换率
		double cashMoney = cash.getCashPV() / pvRate;
		cash.setFee(Constants.CASH_FEE * cashMoney);//手续费
		cash.setCashMoney(cashMoney - cash.getFee());//提现金额
		//2、保存cash到数据库 PV_RATE
		mapper.addUserCash(cash);
		//3、更新当前用户的总账信息并插入总账明细到数据库
		
		UserAccount account = accountService.getUserAccountByUserId(null, cash.getUserId(),true);
		account.setSearchStr(DateUtil.MONTH1.format(new Date()));//拼接表名属性
		account.setBaseBalance(account.getBaseBalance()-cash.getCashPV());//基本余额
		accountService.doUpdateAccount(cash.getCashPV(),account,"提现"+cash.getCashPV()+"PV",Constants.ACCOUNT_TYPE_BO);
		
		return 0;
	}
	

}
