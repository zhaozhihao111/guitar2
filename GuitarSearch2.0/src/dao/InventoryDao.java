package dao;

import java.util.List;

import bean.Guitar;
import model.InventoryModel;

public interface InventoryDao {
	
	public List<Guitar> search(String serialNumber)throws Exception;
}
