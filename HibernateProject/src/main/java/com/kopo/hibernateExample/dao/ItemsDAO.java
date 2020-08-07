package com.kopo.hibernateExample.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kopo.hibernateExample.model.Items;

@Repository
public class ItemsDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public List<Items> getAllItems() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Items> itemsList = session.createQuery("from Items").list();
		return itemsList;
	}

	public Items getItems(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Items items = (Items) session.get(Items.class, new Integer(id));
		return items;
	}

	public Items addItems(Items items) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(items);
		return items;
	}

	public void updateItems(Items items) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(items);
	}

	public void deleteItems(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Items p = (Items) session.load(Items.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
	}	
}
