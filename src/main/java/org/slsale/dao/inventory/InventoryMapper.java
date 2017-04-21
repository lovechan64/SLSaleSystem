package org.slsale.dao.inventory;

import java.util.List;

import org.slsale.pojo.Inventory;

/**
 * InventoryMapper
 * @author bdqn_shy
 * @date 2014-5-7
 */
public interface InventoryMapper {
	/**
	 * getInventoryList
	 * @return
	 */
	public List<Inventory> getInventoryList(Inventory inventory) throws Exception;
	
	
	/**
	 * addInventory
	 * @param inventory
	 * @return
	 */
	public int addInventory(Inventory inventory) throws Exception;
	
	/**
	 * modifyInventory
	 * @param inventory
	 * @return
	 */
	public int modifyInventory(Inventory inventory);
	
	/**
	 * deleteInventory
	 * @param inventory
	 * @return
	 */
	public int deleteInventory(Inventory inventory);
}
