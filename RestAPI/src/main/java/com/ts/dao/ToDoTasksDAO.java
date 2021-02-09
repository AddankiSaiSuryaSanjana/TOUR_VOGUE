package com.ts.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import com.rest.dto.ToDoTask;
import com.rest.dto.User;
import com.ts.db.HibernateTemplate;

public class ToDoTasksDAO {

	private SessionFactory factory = null;

	public int add(ToDoTask task) {
		System.out.println(task); 
		return HibernateTemplate.addObject(task);
	}

	public List<ToDoTask> getAllTasks() {
		List<ToDoTask> tasks=(List)HibernateTemplate.getObjectListByQuery("From ToDoTasks");
		System.out.println("Inside All Tasks ..."+ tasks);
		return tasks;
	}
	public List<ToDoTask> getAllTasks(int id) {
		List<ToDoTask> tasks=(List)HibernateTemplate.getObjectListByQuery("from ToDoTask where userDetails_userId =" + id);
		System.out.println("Inside All Tasks ..."+ tasks);
		return tasks;
	}

	public ToDoTask getTask(int id) {
		return (ToDoTask)HibernateTemplate.getObject(User.class,id);
	}
	public void deleteTask(int id) {
		int res = HibernateTemplate.deleteObject(ToDoTask.class, id);
		System.out.println("Deleted " + res);
		//return res;
	}
	public void updateTask(ToDoTask task) {
		int res = HibernateTemplate.updateObject(task);
		System.out.println("Updated " + res);
		//return res;
	}

}