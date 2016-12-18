package org.slsale.pojo;

import java.util.Date;

/**
 * Base
 * @author bdqn_hl
 * @date 2014-2-21
 */
public class Base {
	private Integer id;
	private Integer starNum=0;// 分页的起始行
	private Integer pageSize=10;// 每页显示多少行
	
	private Date startTime;
	private Date endTime;
	
	private String startTimeStr;
	private String endTimeStr;
	
	private String searchStr;
	private String searchStr1;
	
	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getStarNum() {
		return starNum;
	}

	public void setStarNum(Integer starNum) {
		this.starNum = starNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSearchStr() {
		return searchStr;
	}

	public void setSearchStr(String searchStr) {
		this.searchStr = searchStr;
	}

	public String getStartTimeStr() {
		return startTimeStr;
	}

	public void setStartTimeStr(String startTimeStr) {
		this.startTimeStr = startTimeStr;
	}

	public String getEndTimeStr() {
		return endTimeStr;
	}

	public void setEndTimeStr(String endTimeStr) {
		this.endTimeStr = endTimeStr;
	}

	public String getSearchStr1() {
		return searchStr1;
	}

	public void setSearchStr1(String searchStr1) {
		this.searchStr1 = searchStr1;
	}
	
	
}
