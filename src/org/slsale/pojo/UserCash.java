package org.slsale.pojo;

import java.util.Date;
/**
 * User
 * @author bdqn_shy
 * @date 2014-4-24
 */
public class UserCash extends Base{
	
	private Date cashTime;//提现时间
	private String cashNum;//提现单号
	private int stat;//提现状态
	private Integer userId;//提现用户id
	private double cashPV;//提现pv
	private String currency;//提现货币
	private double pvRate;//pv转换率
	private double cashMoney;//提现金额
	private double fee;//手续费
	private double tax;//税费
	private double otherFee;//其他税费
	private String bankName;//开户行
	private String bankBrance;//支行名称
	private String bankAccount;//银行卡号
	private String accountName;//开户人姓名
	private double creditedMoney;//到账金额
	private Date creditedTime;//到账时间
	private int operator;//操作人
	private String note;//备注

	private User user;
	
	public UserCash() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Date getCashTime() {
		return cashTime;
	}

	public void setCashTime(Date cashTime) {
		this.cashTime = cashTime;
	}

	public String getCashNum() {
		return cashNum;
	}

	public void setCashNum(String cashNum) {
		this.cashNum = cashNum;
	}

	public int getStat() {
		return stat;
	}

	public void setStat(int stat) {
		this.stat = stat;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public double getCashPV() {
		return cashPV;
	}

	public void setCashPV(double cashPV) {
		this.cashPV = cashPV;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getPvRate() {
		return pvRate;
	}

	public void setPvRate(double pvRate) {
		this.pvRate = pvRate;
	}

	public double getCashMoney() {
		return cashMoney;
	}

	public void setCashMoney(double cashMoney) {
		this.cashMoney = cashMoney;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public double getOtherFee() {
		return otherFee;
	}

	public void setOtherFee(double otherFee) {
		this.otherFee = otherFee;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankBrance() {
		return bankBrance;
	}

	public void setBankBrance(String bankBrance) {
		this.bankBrance = bankBrance;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
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

	public int getOperator() {
		return operator;
	}

	public void setOperator(int operator) {
		this.operator = operator;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
