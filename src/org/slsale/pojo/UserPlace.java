package org.slsale.pojo;

import java.util.Date;
/**
 * User
 * @author bdqn_shy
 * @date 2014-5-13
 */
public class UserPlace extends Base{
	
	private Integer placeId;//安置id
	private Date placeTime;//安置时间
	private Integer userId;//被安置用户id
	private Integer bonusUserId;//拿奖金用户id
	private double buyPV;//消费PV
	private double bonusRate;//奖金比率
	private double bonusPV;//安置奖励
	
	private String loginCode;
	
	public UserPlace() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getPlaceId() {
		return placeId;
	}

	public void setPlaceId(Integer placeId) {
		this.placeId = placeId;
	}


	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getBonusUserId() {
		return bonusUserId;
	}

	public void setBonusUserId(Integer bonusUserId) {
		this.bonusUserId = bonusUserId;
	}

	public double getBuyPV() {
		return buyPV;
	}

	public void setBuyPV(double buyPV) {
		this.buyPV = buyPV;
	}

	public double getBonusRate() {
		return bonusRate;
	}

	public void setBonusRate(double bonusRate) {
		this.bonusRate = bonusRate;
	}

	public double getBonusPV() {
		return bonusPV;
	}

	public void setBonusPV(double bonusPV) {
		this.bonusPV = bonusPV;
	}

	public Date getPlaceTime() {
		return placeTime;
	}

	public void setPlaceTime(Date placeTime) {
		this.placeTime = placeTime;
	}

	public String getLoginCode() {
		return loginCode;
	}

	public void setLoginCode(String loginCode) {
		this.loginCode = loginCode;
	}

}
