package com.ts.dao;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import com.rest.dto.ToDoTask;
import com.rest.dto.User;
import com.ts.db.HibernateTemplate;

public class UserDAO {
	private SessionFactory factory = null;

	public Object getUserByUserPass(String emailId,String password) {

		return HibernateTemplate.getObjectByUserPass(emailId,password);
	}
	public int register(User user) {
		System.out.println(user); 
		return HibernateTemplate.addObject(user);
	}
	public List<User> getAllUsers() {
		List<User> users = (List)HibernateTemplate.getObjectListByQuery("From User");
		System.out.println("Inside All Users ..." + users);
		return users;
	}

	public User getUser(int id) {
		return (User)HibernateTemplate.getObject(User.class,id);
	}
	public User getUserByEmail(String email) {
		return (User)HibernateTemplate.getObjectByEmail(email);
	}
	public void updateUser(User user) {
		int res = HibernateTemplate.updateObject(user);
		System.out.println("Updated " + res);
		//return res;
	}


}