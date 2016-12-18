package org.slsale.dao.inventory;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slsale.pojo.Inventory;
import org.springframework.stereotype.Repository;
//@Repository("inventoryDAO")
public class InventoryDAOImpl extends SqlSessionDaoSupport implements InventoryDAO {

	@Override
	public List<Inventory> getInventoryList(Inventory inventory)
			throws Exception {
		
		return getSqlSession().selectList("getInventoryList",inventory);
	}

	@Override
	public int addInventory(Inventory inventory) throws Exception {

		return getSqlSession().insert("addInventory",inventory);
	}

	@Override
	public int modifyInventory(Inventory inventory) {

		return getSqlSession().update("modifyInventory",inventory);
	}

	@Override
	public int deleteInventory(Inventory inventory) {

		return getSqlSession().delete("deleteInventory",inventory);
	} 


}
