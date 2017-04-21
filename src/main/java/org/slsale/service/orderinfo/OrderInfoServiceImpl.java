package org.slsale.service.orderinfo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slsale.common.Constants;
import org.slsale.common.DateUtil;
import org.slsale.common.PageSupport;
import org.slsale.common.Util;
import org.slsale.dao.basicsparameter.BasicsParameterMapper;
import org.slsale.dao.datadictionary.DataDictionaryMapper;
import org.slsale.dao.goodsinfo.GoodsInfoMapper;
import org.slsale.dao.goodspack.GoodsPackMapper;
import org.slsale.dao.goodspackaffiliated.GoodsPackAffiliatedMapper;
import org.slsale.dao.inventory.InventoryMapper;
import org.slsale.dao.orderinfo.OrderInfoMapper;
import org.slsale.dao.orderlist.OrderListMapper;
import org.slsale.dao.user.UserMapper;
import org.slsale.dao.userrefer.UserReferMapper;
import org.slsale.pojo.BasicsParameter;
import org.slsale.pojo.DataDictionary;
import org.slsale.pojo.GoodsPack;
import org.slsale.pojo.GoodsPackAffiliated;
import org.slsale.pojo.Inventory;
import org.slsale.pojo.OrderInfo;
import org.slsale.pojo.OrderList;
import org.slsale.pojo.User;
import org.slsale.pojo.UserAccount;
import org.slsale.pojo.UserRefer;
import org.slsale.service.useraccount.UserAccountService;
import org.springframework.stereotype.Service;
/**
 * OrderInfoServiceImpl
 * @author bdqn_shy
 * @date 2014-5-5
 */
@Service
public class OrderInfoServiceImpl implements OrderInfoService{
	@Resource
	private OrderInfoMapper mapper;
	//private OrderInfoDAO orderInfoDao;
	@Resource
	private GoodsPackMapper packMapper;
	@Resource
	private InventoryMapper inventoryMapper;
	//private InventoryDAO inventoryDao;
	@Resource
	private GoodsPackAffiliatedMapper affiMapper;
	@Resource
	private GoodsInfoMapper goodsMapper;
	@Resource
	private UserMapper userMapper;
	@Resource
	private UserAccountService accountService;
	@Resource
	private DataDictionaryMapper ddMapper;
	@Resource
	private OrderListMapper oListMapper;
	//private OrderListDAO oListDao;
	@Resource
	private BasicsParameterMapper paramMapper;
	@Resource
	private UserReferMapper referMapper;
	//private UserReferDAO referDao;

	@Override
	public int count(OrderInfo order) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addOrderInfo(OrderInfo order) throws Exception {
		
		return 0;
	}

	@Override
	public OrderInfo getOrderInfoById(OrderInfo order) throws Exception {
		return mapper.getOrderInfoById(order);
	}

	@Override
	public int modifyOrderInfo(OrderInfo order) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String deleteOrderInfo(OrderInfo order){
		String result = "success";
		try {
			mapper.deleteOrderInfo(order);
			OrderList oList = new OrderList();
			oList.setOrderNum(order.getOrderNum());
			oListMapper.deleteOrderList(oList);
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return result;
	}

	@Override
	public List<User> getUserListByUserId(Integer userId) throws Exception {
		List<User> userList = null;
		if(userId!=null){
			User user = new User();
			user.setReferId(userId);
			user.setUserType("1");
			user.setActiveStatus("IS NULL");
			userList = mapper.getUserList(user);
		}
		return userList;
	}
	
	@Override
	public Map<String, Object> getGoToDeclarativeData(Integer targetUserId,Integer loginUserId)
			throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		if(null!=targetUserId){
			//获取要报单的目标用户信息
			User user = new User();
			user.setId(targetUserId);
			user = userMapper.getUserById(user);
			map.put("targetUser", user);
			//获取所有报单购物产品套餐
			
			GoodsPack pack = new GoodsPack();
			pack.setTypeName("报单购货");
			DataDictionary dataDictionary = new DataDictionary();
			dataDictionary.setTypeName(Constants.PACK_TYPE_NAME);
			dataDictionary.setValueId(Constants.PACK_TYPE_BD);
			dataDictionary = ddMapper.getDataDictionariesByTypeAndValueId(dataDictionary);
			pack.setTypeId(Integer.parseInt(dataDictionary.getValueName()));
			List<GoodsPack> list = packMapper.getGoodsPackList(pack);
			map.put("packList", list);
			UserAccount account = null;
			//获取当前用户的账户余额
			account = accountService.getUserAccountByUserId(null, loginUserId,true);
			map.put("account", account);
		}
		
		return map;
	}

	@Override
	public int doDeclarative(OrderInfo order, Integer packId) {
		GoodsPack pack = new GoodsPack();
		pack.setId(packId);
		try {
			pack = packMapper.getGoodsPackById(pack);
			UserAccount account = accountService.getUserAccountByUserId(null, order.getBuyUserId(),true);//获取当前用户的账户余额
			//1、验证当前用户账户余额是否不小于选择的报单套餐
			if(account!=null &&account.getBaseBalance() >= pack.getTotalPrice()){
				//获取报单用户信息
				User user = new User();
				user.setId(order.getPickUserId());
				user = userMapper.getUserById(user);
				//获取推荐人信息
				User buyUser = new User();
				buyUser.setId(order.getBuyUserId());
				buyUser = userMapper.getUserById(buyUser);
				
				//2、更新报单用户推荐人信息
				user.setReferId(buyUser.getId());
				user.setReferCode(buyUser.getLoginCode());
				user.setActiveStatus("0");//0待激活,1已激活
				userMapper.modifyUser(user);
				
				//3、将订单保存到orderInfo表中
				order.setType(Constants.ORDER_TYPE_BD);
				order.setCountry(user.getCountry());
				order.setEmail(user.getEmail());
				order.setOrderTime(new Date());
				order.setMobile(user.getMobile());
				order.setStat(1);//0新建,1已提交,2已审核,3已发货,4已收货,5审核未通过
				order.setBasePV(pack.getTotalPrice());
				mapper.addOrderInfo(order);
				
				//4、将订单信息保存到orderList表中
				OrderList oList = new OrderList();
				oList.setOrderNum(order.getOrderNum());
				oList.setGoodsId(packId);
				oList.setGoodsSN(pack.getGoodsPackCode());
				oList.setGoodsName(pack.getGoodsPackName());
				oList.setGoodsNum(pack.getNum());
				oList.setSumPrice(pack.getTotalPrice());
				oList.setCurrency(Constants.CY_RMB);
				//获取PV转换率
				DataDictionary dd = new DataDictionary();
				dd.setTypeCode(Constants.RATE);
				dd.setValueId(Constants.CY_RMB);
				dd = ddMapper.getDataDictionariesByTypeAndValueId(dd);
				Double pvRate = Double.valueOf(dd.getValueName());
				oList.setPvRate(pvRate);
				oListMapper.addOrderList(oList);
				//5、减余额
				reducedInventory(pack);
				//6、付款
				account.setSearchStr(DateUtil.MONTH1.format(new Date()));
				account.setBaseBalance(account.getBaseBalance()-order.getTotalPrice());
				double buyPV = Constants.ORDER_TYPE_CX.equals(order.getType()) ? order.getRepeatPV():order.getBasePV();
				accountService.doUpdateAccount(buyPV, account, "报单购货", Constants.ACCOUNT_TYPE_BO);
				
				//7、将目标报单用户添加到推荐记录表
				UserRefer refer = new UserRefer();
				refer.setReferTime(new Date());
				refer.setUserId(user.getId());
				refer.setUserName(user.getUserName());
				refer.setReferUserId(buyUser.getId());
				refer.setReferUserName(buyUser.getUserName());
				refer.setBuyPV(order.getBasePV());//消费PV
				//获取推荐奖金比率
				BasicsParameter param = new BasicsParameter();
				param.setCode("referRate");
				List<BasicsParameter> paramList = paramMapper.getBasicsParameterList(param);
				if(null!=paramList){
					param = paramList.get(0);
				}
				refer.setBonusRate(Double.parseDouble(param.getValue()));//奖金比率
				refer.setBonusPV(order.getBasePV() * refer.getBonusRate());//推荐奖励PV
				referMapper.addUserRefer(refer);
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public PageSupport getOrderInfoList(OrderInfo order, Integer pageIndex)
			throws Exception {
		if(null==order){
			order = new OrderInfo();
		}
		// pages
		PageSupport page = new PageSupport();
		if (pageIndex != null)page.setPage(pageIndex);
		List<OrderInfo> list = null;
		try {
			page.setTotalCount(mapper.count(order));//获取总记录数
			
			if (page.getPage() > page.getPageCount()) page.setPage(page.getPageCount());
			order.setStarNum((page.getPage() - 1) * page.getPageSize());
			order.setPageSize(page.getPageSize());
			
			list = mapper.getOrderInfoList(order);//获取当前页数据
		} catch (Exception e) {
			e.printStackTrace();
		}
		page.setItems(list);
		
		return page;
	}
	
	@Override
	public List<OrderInfo> getOrderInfoList(OrderInfo order) {
		List<OrderInfo> list = null; 
		try{
			list = mapper.getOrderInfoList(order);//获取当前页数据
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public void doAdd(OrderInfo order, String checkedIds, String buyNums)
			throws Exception {
		order.setStat(Constants.ORDER_STAT_XJ);
		order.setOrderTime(new Date());
		mapper.addOrderInfo(order);//完成订单初始化
		String[] ids;
		String[] nums;
		if(checkedIds.indexOf(",")!=-1){
			ids = checkedIds.split(",");
			nums = buyNums.split(",");
		}else{
			ids = new String []{checkedIds};
			nums = new String []{buyNums};
		}
		GoodsPack pack =null;
		OrderList oList =null;
		//获取PV转换率
		DataDictionary dd = new DataDictionary();
		dd.setTypeCode(Constants.RATE);
		dd.setValueId(Constants.CY_RMB);
		dd = ddMapper.getDataDictionariesByTypeAndValueId(dd);
		for(int i=0;i<ids.length;i++){//循环完成订单集合初始化
			pack = new GoodsPack();
			pack.setId(Integer.parseInt(ids[i]));
			pack = packMapper.getGoodsPackById(pack);
			
			oList = new OrderList();
			oList.setOrderNum(order.getOrderNum());
			oList.setGoodsId(Integer.parseInt(ids[i]));
			oList.setGoodsSN(pack.getGoodsPackCode());
			oList.setGoodsName(pack.getGoodsPackName());
			oList.setGoodsNum(Integer.parseInt(nums[i]));
			oList.setSumPrice(pack.getTotalPrice());
			oList.setCurrency(Constants.CY_RMB);
			oList.setGoodsType(order.getType());
			oList.setEachPrice(pack.getTotalPrice());
			oList.setRealPrice(pack.getTotalPrice());
			oList.setRealPV(pack.getTotalPrice());
			Double pvRate = Double.valueOf(dd.getValueName());
			oList.setPvRate(pvRate);
			oListMapper.addOrderList(oList);
		}

	}

	@Override
	public List<OrderList> getOrderListByOrder(OrderInfo order)
			throws Exception {
		OrderList ol = new OrderList();
		ol.setOrderNum(order.getOrderNum());
		return oListMapper.getOrderlistList(ol);
	}

	@Override
	public String doSettlement(OrderInfo order, String checkedIds, String buyNums) {
		String result = "success";
		try {
			//1、初始化订单
			if(DateUtil.isNotEmpty(checkedIds) && DateUtil.isNotEmpty(buyNums)){
				doAdd(order,checkedIds,buyNums);
			}
			//2、更新订单
			OrderInfo oddOrder = null;
			List<OrderInfo> list = mapper.getOrderInfoBySearch(order);
			if(list!=null && list.size()>0){
				oddOrder = list.get(0);
			}
			User user = new User();
			user.setId(oddOrder.getBuyUserId());
			user = userMapper.getUserById(user);
			order.setOrderId(oddOrder.getOrderId());
			order.setOrderTime(new Date());
			order.setCountry(user.getCountry());
			order.setMobile(user.getMobile());
			order.setEmail(user.getEmail());
			order.setUserAddress(user.getUserAddress());
			order.setPostCode(user.getPostCode());
			order.setShipType(user.getExpressType());
			order.setStat(Constants.ORDER_STAT_TJ);
			order.setOrderTime(new Date());
			
			UserAccount account = accountService.getUserAccountByUserId(null, user.getId(),true);//获取当前用户的账户余额
			account.setSearchStr(DateUtil.MONTH1.format(new Date()));
			double buyPV = 0.0;	//消费总PV
			String note = "";	//记账备注
			int type = -1;
			if(Constants.ORDER_TYPE_CX.equals(oddOrder.getType())){
				order.setRepeatPV(order.getBasePV());
				order.setBasePV(0.0);
				account.setRepeatBalance(account.getRepeatBalance()-order.getTotalPrice());
				buyPV = order.getRepeatPV();
				note ="重消购货";
				type = Constants.ACCOUNT_TYPE_RO;
			}else{
				account.setBaseBalance(account.getBaseBalance()-order.getTotalPrice());
				buyPV = order.getBasePV();
				note ="辅消购货";
				type = Constants.ACCOUNT_TYPE_BO;
			}
			mapper.modifyOrderInfo(order);
			//2、账户支付
			accountService.doUpdateAccount(buyPV, account, note,type);
			//3、减库存
			OrderList oList = new OrderList();
			oList.setOrderNum(order.getOrderNum());
			List<OrderList> olList = oListMapper.getOrderlistList(oList);
			for(OrderList ol : olList){
				GoodsPack pack = new GoodsPack();
				pack.setId(ol.getGoodsId());
				pack = packMapper.getGoodsPackById(pack);
				pack.setNum(pack.getNum()-ol.getGoodsNum());
				reducedInventory(pack);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		
		return result;
	}

	/**
	 * 产品减库存
	 * @param pack
	 * @throws Exception
	 */
	private void reducedInventory(GoodsPack pack) throws Exception{
		//套餐减库存
		Inventory inventory = new Inventory();
		inventory.setGoodsId(pack.getId());
		inventory.setType("pack");
		inventory.setOperator("-");//运算方式
		inventory.setNum(pack.getNum());
		inventoryMapper.modifyInventory(inventory);
		//获取套餐中的产品集合
		GoodsPackAffiliated gpa = new GoodsPackAffiliated();
		gpa.setGoodsPackId(pack.getId());
		List<GoodsPackAffiliated> gpaList = affiMapper.getGoodsPackAffiliatedListById(gpa);
		if(null!=gpaList){
			//迭代所有套餐中的产品，分别减库存
			for(GoodsPackAffiliated a:gpaList){
				//获取对应的库存对象
				inventory = new Inventory();
				inventory.setGoodsId(a.getGoodsInfoId());
				inventory.setType("goods");
				inventory.setOperator("-");//运算方式
				inventory.setNum(a.getGoodsNum() * pack.getNum());//套餐中每个产品的数量 x 套餐数
				inventoryMapper.modifyInventory(inventory);
			}
		}
		GoodsPack targetPack = new GoodsPack();
		targetPack.setId(pack.getId());
		targetPack.setNum(pack.getNum());
		packMapper.modifyGoodsPack(targetPack);
	}

	@Override
	public List<OrderList> getOrderListByPackIds(String packIds,String buyNums)
			throws Exception {
		String[] nums;
		if(buyNums.indexOf(",")!=-1){
			nums = buyNums.split(",");
		}else{
			nums = new String []{buyNums};
		}
		GoodsPack pack = null;
		OrderList ol = null;
		List<OrderList> list = new ArrayList<OrderList>();
		try {
			pack = new GoodsPack();
			pack.setSearchStr(packIds);
			List<GoodsPack> packList = packMapper.getGoodsPackListByIds(pack);
			for(int i=0;i<packList.size();i++){
				pack =packList.get(i);
				ol = new OrderList();
				ol.setGoodsNum(Integer.parseInt(nums[i]));
				ol.setGoodsSN(pack.getGoodsPackCode());
				ol.setGoodsName(pack.getGoodsPackName());
				ol.setSumPrice(pack.getTotalPrice());
				list.add(ol);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		return list;
	}
	
}
