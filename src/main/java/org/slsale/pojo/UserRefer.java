package org.slsale.pojo;

import java.util.Date;

public class UserRefer extends Base{
	private Integer id;
	private Date referTime;
	private Integer userId;		//被推荐人ID
	private String userName;	//被推荐人姓名
	private Integer referUserId;//推荐人ID
	private String referUserName;//推荐人姓名
	private Double buyPV;		//消费PV
	private Double bonusRate;	//奖金比率
	private Double bonusPV;		//推荐奖励PV
	
	//查询用属性
	private String loginCode;	//登录名
	private Date createTime;	//注册日期
	private String activeStatus;//激活状态
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getReferTime() {
		return referTime;
	}
	public void setReferTime(Date referTime) {
		this.referTime = referTime;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getReferUserId() {
		return referUserId;
	}
	public void setReferUserId(Integer referUserId) {
		this.referUserId = referUserId;
	}
	public Double getBuyPV() {
		return buyPV;
	}
	public void setBuyPV(Double buyPV) {
		this.buyPV = buyPV;
	}
	public Double getBonusRate() {
		return bonusRate;
	}
	public void setBonusRate(Double bonusRate) {
		this.bonusRate = bonusRate;
	}
	public Double getBonusPV() {
		return bonusPV;
	}
	public void setBonusPV(Double bonusPV) {
		this.bonusPV = bonusPV;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLoginCode() {
		return loginCode;
	}
	public void setLoginCode(String loginCode) {
		this.loginCode = loginCode;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getReferUserName() {
		return referUserName;
	}
	public void setReferUserName(String referUserName) {
		this.referUserName = referUserName;
	}
	public String getActiveStatus() {
		return activeStatus;
	}
	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}
	
}
