package org.slsale.job;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
public class DayBonusJob {
	private List<IBonus> listBonus;
	private Logger logger = Logger.getLogger(DayBonusJob.class);
	
	public DayBonusJob() {
	}
	
	/**
	 * 构造方法，需要Spring注入所有日结算定时计算奖金的实例
	 * @param listBonus
	 */
	@Autowired
	public DayBonusJob(List<IBonus> listBonus){
		this.listBonus = listBonus;
	}
	
	/**
	 * 逐个计算奖金
	 * @return
	 */
	public void startCalculate(){
		logger.debug("开始执行BonusSettlementJob，结算前一天的奖金。。。。。。。");
		for (int i = 0; i < listBonus.size(); i++) {
			String str=listBonus.get(i).calBonus();
			logger.debug(str);
		}
		logger.debug("执行CreateCurrentTableJob结束。。。。。。。");
	}
}
