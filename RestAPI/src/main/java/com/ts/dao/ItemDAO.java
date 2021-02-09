package com.ts.dao;
import java.util.List;

import org.hibernate.SessionFactory;

import com.rest.dto.ItemDetails;
import com.ts.db.HibernateTemplate;

public class ItemDAO {
private SessionFactory factory = null;
	
	public List<ItemDetails> getAllItemDetails() {
		List<ItemDetails> itemDetails=(List)HibernateTemplate.getObjectListByQuery("From ItemDetails");
		return itemDetails;	
	}
	
	
	public int additem(ItemDetails item) {
		System.out.println(item); 
		return HibernateTemplate.addObject(item);
	}
	
}
