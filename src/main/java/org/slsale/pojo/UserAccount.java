package org.slsale.pojo;

import java.util.Date;
import java.util.List;


public class UserAccount extends Base {
	private int accountId;		//主键ID
	private int userId;			//用户主键ID
	private Date accountData;	//日期
	private Integer stat;			//总账状态
	private double baseIn;		//基本入账
	private double baseOut;		//基本出账
	private double baseBalance;	//基本余额
	private double repeatIn;	//重消入账
	private double repeatOut;	//重消出账
	private double repeatBalance;//重消余额
	private double freePV;			//未分红重消PV
	private double alreadyPV;		//已分红未领货重消PV
	private double buyPV;			//已领货重消PV

	//辅助字段
	private List<UserAccount> list;
	
	public UserAccount() {
		super();
		// TODO Auto-generated constructor stub
	}


	public UserAccount(int accountId, int userId, Date accountData, int stat,
			double baseIn, double baseOut, double baseBalance, double repeatIn,
			double repeatOut, double repeatBalance, int freePV, int alreadyPV,
			int buyPV) {
		super();
		this.accountId = accountId;
		this.userId = userId;
		this.accountData = accountData;
		this.stat = stat;
		this.baseIn = baseIn;
		this.baseOut = baseOut;
		this.baseBalance = baseBalance;
		this.repeatIn = repeatIn;
		this.repeatOut = repeatOut;
		this.repeatBalance = repeatBalance;
		this.freePV = freePV;
		this.alreadyPV = alreadyPV;
		this.buyPV = buyPV;
	}


	public int getAccountId() {
		return accountId;
	}


	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}


	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getAccountData() {
		return accountData;
	}
	public void setAccountData(Date accountData) {
		this.accountData = accountData;
	}
	public Integer getStat() {
		return stat;
	}
	public void setStat(Integer stat) {
		this.stat = stat;
	}
	public double getBaseIn() {
		return baseIn;
	}
	public void setBaseIn(double baseIn) {
		this.baseIn = baseIn;
	}
	public double getBaseOut() {
		return baseOut;
	}
	public void setBaseOut(double baseOut) {
		this.baseOut = baseOut;
	}
	public double getBaseBalance() {
		return baseBalance;
	}
	public void setBaseBalance(double baseBalance) {
		this.baseBalance = baseBalance;
	}
	public double getRepeatIn() {
		return repeatIn;
	}
	public void setRepeatIn(double repeatIn) {
		this.repeatIn = repeatIn;
	}
	public double getRepeatOut() {
		return repeatOut;
	}
	public void setRepeatOut(double repeatOut) {
		this.repeatOut = repeatOut;
	}
	public double getRepeatBalance() {
		return repeatBalance;
	}
	public void setRepeatBalance(double repeatBalance) {
		this.repeatBalance = repeatBalance;
	}
	public double getFreePV() {
		return freePV;
	}
	public void setFreePV(double freePV) {
		this.freePV = freePV;
	}
	public double getAlreadyPV() {
		return alreadyPV;
	}
	public void setAlreadyPV(double alreadyPV) {
		this.alreadyPV = alreadyPV;
	}
	public double getBuyPV() {
		return buyPV;
	}
	public void setBuyPV(double buyPV) {
		this.buyPV = buyPV;
	}

	public List<UserAccount> getList() {
		return list;
	}

	public void setList(List<UserAccount> list) {
		this.list = list;
	}
	
	
	
	
}
