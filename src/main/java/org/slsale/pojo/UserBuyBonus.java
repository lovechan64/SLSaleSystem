package org.slsale.pojo;

import java.util.Date;
/**
 * User
 * @author bdqn_shy
 * @date 2014-5-13
 */
public class UserBuyBonus extends Base{
	
	private String bonusMonth;//结算月份
	private Date calTime;//结算时间
	private Integer bonusUserId;//拿奖金用户id
	private double buyPV;//消费PV
	private double bonusRate;//奖金比率
	private double bonusPV;//奖励
	
	public String getBonusMonth() {
		return bonusMonth;
	}
	public void setBonusMonth(String bonusMonth) {
		this.bonusMonth = bonusMonth;
	}
	public Date getCalTime() {
		return calTime;
	}
	public void setCalTime(Date calTime) {
		this.calTime = calTime;
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
	public double getBonusPV() {
		return bonusPV;
	}
	public void setBonusPV(double bonusPV) {
		this.bonusPV = bonusPV;
	}
	public double getBonusRate() {
		return bonusRate;
	}
	public void setBonusRate(double bonusRate) {
		this.bonusRate = bonusRate;
	}
	
}
