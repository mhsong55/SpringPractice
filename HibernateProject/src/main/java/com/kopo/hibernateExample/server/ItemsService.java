package com.kopo.hibernateExample.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kopo.hibernateExample.dao.ItemsDAO;
import com.kopo.hibernateExample.model.Items;

@Service("itemsService")
public class ItemsService {

	@Autowired
	ItemsDAO itemsDao;
	
	@Transactional
	public List<Items> getAllItems() {
		return itemsDao.getAllItems();
	}

	@Transactional
	public Items getItems(int id) {
		return itemsDao.getItems(id);
	}

	@Transactional
	public void addItems(Items items) {
		itemsDao.addItems(items);
	}

	@Transactional
	public void updateItems(Items items) {
		itemsDao.updateItems(items);

	}

	@Transactional
	public void deleteItems(int id) {
		itemsDao.deleteItems(id);
	}
}
