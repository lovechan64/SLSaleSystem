package org.slsale.pojo;

import java.util.Date;
import java.util.List;
/**
 * User
 * @author bdqn_shy
 * @date 2014-5-13
 */
public class UserPair extends Base{
	
	private Date pairTime;		//对碰时间
	private Integer bonusUserId;//拿奖金用户id
	private Integer leftUserNum;//左用户总数
	private Integer rightUserNum;//右用户总数
	private Integer leftKeep;	//左保留总数
	private Integer rightKeep;	//右保留总数
	private double eachPV;		//每碰PV数
	private double sumPairPV;	//总碰PV数
	private double bonusRate;	//奖金比率
	private double bonusPV;		//奖励PV
	private Integer pvTimes;		//最低结算数
	private Integer leftYesterday;//左边昨日剩余碰数
	private Integer rightYesterday;//右边昨日剩余碰数
	
	//查询辅助字段
	private String totalCode;
	private String activeTime;
	private String yesterday;
	private List<UserPair> list;
	
	public Integer getBonusUserId() {
		return bonusUserId;
	}
	public void setBonusUserId(Integer bonusUserId) {
		this.bonusUserId = bonusUserId;
	}
	public Integer getLeftUserNum() {
		return leftUserNum;
	}
	public void setLeftUserNum(Integer leftUserNum) {
		this.leftUserNum = leftUserNum;
	}
	public Integer getRightUserNum() {
		return rightUserNum;
	}
	public void setRightUserNum(Integer rightUserNum) {
		this.rightUserNum = rightUserNum;
	}
	public Integer getLeftKeep() {
		return leftKeep;
	}
	public void setLeftKeep(Integer leftKeep) {
		this.leftKeep = leftKeep;
	}
	public Integer getRightKeep() {
		return rightKeep;
	}
	public void setRightKeep(Integer rightKeep) {
		this.rightKeep = rightKeep;
	}
	public double getEachPV() {
		return eachPV;
	}
	public void setEachPV(double eachPV) {
		this.eachPV = eachPV;
	}
	public double getSumPairPV() {
		return sumPairPV;
	}
	public void setSumPairPV(double sumPairPV) {
		this.sumPairPV = sumPairPV;
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
	public String getTotalCode() {
		return totalCode;
	}
	public void setTotalCode(String totalCode) {
		this.totalCode = totalCode;
	}
	public double getPvTimes() {
		return pvTimes;
	}
	public void setPvTimes(Integer pvTimes) {
		this.pvTimes = pvTimes;
	}
	public double getLeftYesterday() {
		return leftYesterday;
	}
	public void setLeftYesterday(Integer leftYesterday) {
		this.leftYesterday = leftYesterday;
	}
	public double getRightYesterday() {
		return rightYesterday;
	}
	public void setRightYesterday(Integer rightYesterday) {
		this.rightYesterday = rightYesterday;
	}
	public String getYesterday() {
		return yesterday;
	}
	public void setYesterday(String yesterday) {
		this.yesterday = yesterday;
	}
	public Date getPairTime() {
		return pairTime;
	}
	public void setPairTime(Date pairTime) {
		this.pairTime = pairTime;
	}
	public String getActiveTime() {
		return activeTime;
	}
	public void setActiveTime(String activeTime) {
		this.activeTime = activeTime;
	}
	public List<UserPair> getList() {
		return list;
	}
	public void setList(List<UserPair> list) {
		this.list = list;
	}

}
