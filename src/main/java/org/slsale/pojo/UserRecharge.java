package org.slsale.pojo;

import java.util.Date;


public class UserRecharge extends Base{
	private int rechargeId;		//主键ID
	private Date rechargeTime;	//充值时间
	private String rechargeNum;	//充值单号
	private int userId;			//充值用户ID
	private String currency;	//充值货币
	private double rechargeMoney;//充值金额
	private String rechargeType;//充值状态
	private String note;		//摘要备注
	private double creditedMoney;//到账金额
	private Date creditedTime;	//到账时间
	private int auditUser;		//审核人
	private double pvRate;		//PV比率
	private double pv;			//兑换后PV值
	private String bankName;	//充值银行名
	private String bankAccount;	//充值账号名
	private String platform;	//充值平台
	private String param;		//充值接口参数
	
	public UserRecharge() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public String getRechargeType() {
		return rechargeType;
	}


	public void setRechargeType(String rechargeType) {
		this.rechargeType = rechargeType;
	}


	public double getRechargeMoney() {
		return rechargeMoney;
	}

	public void setRechargeMoney(double rechargeMoney) {
		this.rechargeMoney = rechargeMoney;
	}

	public int getRechargeId() {
		return rechargeId;
	}
	public void setRechargeId(int rechargeId) {
		this.rechargeId = rechargeId;
	}
	public Date getRechargeTime() {
		return rechargeTime;
	}
	public void setRechargeTime(Date rechargeTime) {
		this.rechargeTime = rechargeTime;
	}
	public String getRechargeNum() {
		return rechargeNum;
	}
	public void setRechargeNum(String rechargeNum) {
		this.rechargeNum = rechargeNum;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public double getCreditedMoney() {
		return creditedMoney;
	}
	public void setCreditedMoney(double creditedMoney) {
		this.creditedMoney = creditedMoney;
	}
	public Date getCreditedTime() {
		return creditedTime;
	}
	public void setCreditedTime(Date creditedTime) {
		this.creditedTime = creditedTime;
	}
	public int getAuditUser() {
		return auditUser;
	}
	public void setAuditUser(int auditUser) {
		this.auditUser = auditUser;
	}
	public double getPvRate() {
		return pvRate;
	}
	public void setPvRate(double pvRate) {
		this.pvRate = pvRate;
	}
	public double getPv() {
		return pv;
	}
	public void setPv(double pv) {
		this.pv = pv;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getParam() {
		return param;
	}
	public void setParam(String param) {
		this.param = param;
	}
	
}
