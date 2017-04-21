package org.slsale.pojo;


/**
 * OrderList
 * @author bdqn_shy
 * @date 2014-5-7
 */
public class OrderList extends Base{
	private Integer listId;
	private String orderNum;	//订单编号
	private Integer stat;		//状态
	private String goodsType;	//商品类型 G为商品P为套餐
	private Integer goodsId;	//商品或套餐ID
	private String goodsSN;		//商品或套餐编号
	private String goodsName;	//商品或套餐名称
	private String goodsFormat;	//规格
	private Integer goodsNum;	//商品或套餐数量
	private Double eachPrice; 	//单价
	private Double sumPrice;	//总价
	private Double discount;	//折扣
	private Double realPrice;	//实际价格
	private String currency;	//货币种类
	private Double realPV;		//实际PV
	private Double pvRate;		//PV折算率
	
	public Integer getListId() {
		return listId;
	}
	public void setListId(Integer listId) {
		this.listId = listId;
	}
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsSN() {
		return goodsSN;
	}
	public void setGoodsSN(String goodsSN) {
		this.goodsSN = goodsSN;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsFormat() {
		return goodsFormat;
	}
	public void setGoodsFormat(String goodsFormat) {
		this.goodsFormat = goodsFormat;
	}
	public Integer getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(Integer goodsNum) {
		this.goodsNum = goodsNum;
	}
	public Double getEachPrice() {
		return eachPrice;
	}
	public void setEachPrice(Double eachPrice) {
		this.eachPrice = eachPrice;
	}
	public Double getSumPrice() {
		return sumPrice;
	}
	public void setSumPrice(Double sumPrice) {
		this.sumPrice = sumPrice;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public Double getRealPrice() {
		return realPrice;
	}
	public void setRealPrice(Double realPrice) {
		this.realPrice = realPrice;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Double getRealPV() {
		return realPV;
	}
	public void setRealPV(Double realPV) {
		this.realPV = realPV;
	}
	public Double getPvRate() {
		return pvRate;
	}
	public void setPvRate(Double pvRate) {
		this.pvRate = pvRate;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public String getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}
	public Integer getStat() {
		return stat;
	}
	public void setStat(Integer stat) {
		this.stat = stat;
	}
	
}
