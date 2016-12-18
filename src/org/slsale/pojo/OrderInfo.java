package org.slsale.pojo;

import java.util.Date;
import java.util.List;

/**
 * OrderInfo
 * @author bdqn_shy
 * @date 2014-5-5
 */
public class OrderInfo extends Base{
	private Integer orderId;
	private String orderNum;	//订单编号
	private String type;		//订单类型
	private Date orderTime;		//下单时间
	private Integer pickUserId;	//收货用户ID
	private Integer buyUserId;	//付款用户ID
	private Double repeatPV;	//重消PV
	private Double basePV;		//基本PV
	private Double serviceFee; 	//服务费
	private Double shipFre;		//快递费
	private Double tax;			//税费
	private String country;		//收货国家
	private String tel;
	private String mobile;
	private String email;
	private String userAddress;
	private String postCode;
	private Integer stat ;		//0新建,1已提交,2已审核,3已发货,4已收货,5审核未通过
	private String shipType;	//快递类型
	private String shipNum;		//快递单号
	private Date shipTime;		//发货时间
	private Date receiveTime;	//收货确认时间
	private String shipNote;	//送货说明

	//查询辅助字段
	private String pickUserName;
	private String buyUserName;
	private String buyUserCode;
	private Double totalPrice;
	private String totalCode;
	private Integer depth;
	private List<OrderList> olList;
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public Integer getPickUserId() {
		return pickUserId;
	}
	public void setPickUserId(Integer pickUserId) {
		this.pickUserId = pickUserId;
	}
	public Double getRepeatPV() {
		return repeatPV;
	}
	public void setRepeatPV(Double repeatPV) {
		this.repeatPV = repeatPV;
	}
	public Double getBasePV() {
		return basePV;
	}
	public void setBasePV(Double basePV) {
		this.basePV = basePV;
	}
	public Double getServiceFee() {
		return serviceFee;
	}
	public void setServiceFee(Double serviceFee) {
		this.serviceFee = serviceFee;
	}
	public Double getShipFre() {
		return shipFre;
	}
	public void setShipFre(Double shipFre) {
		this.shipFre = shipFre;
	}
	public Double getTax() {
		return tax;
	}
	public void setTax(Double tax) {
		this.tax = tax;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public Integer getStat() {
		return stat;
	}
	public void setStat(Integer stat) {
		this.stat = stat;
	}
	public String getShipType() {
		return shipType;
	}
	public void setShipType(String shipType) {
		this.shipType = shipType;
	}
	public String getShipNum() {
		return shipNum;
	}
	public void setShipNum(String shipNum) {
		this.shipNum = shipNum;
	}
	public Date getShipTime() {
		return shipTime;
	}
	public void setShipTime(Date shipTime) {
		this.shipTime = shipTime;
	}
	public Date getReceiveTime() {
		return receiveTime;
	}
	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}
	public String getShipNote() {
		return shipNote;
	}
	public void setShipNote(String shipNote) {
		this.shipNote = shipNote;
	}
	public Integer getBuyUserId() {
		return buyUserId;
	}
	public void setBuyUserId(Integer buyUserId) {
		this.buyUserId = buyUserId;
	}
	public String getPickUserName() {
		return pickUserName;
	}
	public void setPickUserName(String pickUserName) {
		this.pickUserName = pickUserName;
	}
	public String getBuyUserCode() {
		return buyUserCode;
	}
	public void setBuyUserCode(String buyUserCode) {
		this.buyUserCode = buyUserCode;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getTotalPrice() {
		if(null==totalPrice){
			totalPrice = 0.00;
			if(getRepeatPV()!=null)	totalPrice+=getRepeatPV();//重消PV
			if(getBasePV()!=null)	totalPrice+=getBasePV();//基本PV
			if(getServiceFee()!=null)totalPrice+=getServiceFee();//服务费
			if(getShipFre()!=null)	totalPrice+=getShipFre();//快递费
			if(getTax()!=null)		totalPrice+=getTax();//税费
		}
		
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public List<OrderList> getOlList() {
		return olList;
	}
	public void setOlList(List<OrderList> olList) {
		this.olList = olList;
	}
	public String getBuyUserName() {
		return buyUserName;
	}
	public void setBuyUserName(String buyUserName) {
		this.buyUserName = buyUserName;
	}
	public String getTotalCode() {
		return totalCode;
	}
	public void setTotalCode(String totalCode) {
		this.totalCode = totalCode;
	}
	public Integer getDepth() {
		return depth;
	}
	public void setDepth(Integer depth) {
		this.depth = depth;
	}
	
}
