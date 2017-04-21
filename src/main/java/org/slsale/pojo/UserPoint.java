package org.slsale.pojo;

import java.util.Date;
/**
 * User
 * @author bdqn_shy
 * @date 2014-6-4
 */
public class UserPoint extends Base{
	
	private Date buyTime;//消费时间
	private Integer bonusUserId;//拿奖金用户id
	private Integer userId;//消费用户id
	private double buyPV;//消费PV
	private double bounsRate;//奖金比率
	private double bonusPV;//奖励
	
	public Date getBuyTime() {
		return buyTime;
	}
	public void setBuyTime(Date buyTime) {
		this.buyTime = buyTime;
	}
	public Integer getBonusUserId() {
		return bonusUserId;
	}
	public void setBonusUserId(Integer bonusUserId) {
		this.bonusUserId = bonusUserId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public double getBuyPV() {
		return buyPV;
	}
	public void setBuyPV(double buyPV) {
		this.buyPV = buyPV;
	}
	public double getBounsRate() {
		return bounsRate;
	}
	public void setBounsRate(double bounsRate) {
		this.bounsRate = bounsRate;
	}
	public double getBonusPV() {
		return bonusPV;
	}
	public void setBonusPV(double bonusPV) {
		this.bonusPV = bonusPV;
	}

}
