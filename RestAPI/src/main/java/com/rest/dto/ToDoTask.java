package com.rest.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@XmlRootElement
@Entity
public class ToDoTask{
	@Id@GeneratedValue
	private int taskId;
	private String taskPlace;
	private String taskDescription;
	
	@ManyToOne
	private User userDetails;
	

	public ToDoTask() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ToDoTask(int taskId, String taskPlace, String taskDescription) {
		super();
		this.taskId = taskId;
		this.taskPlace = taskPlace;
		this.taskDescription = taskDescription;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTaskPlace() {
		return taskPlace;
	}

	public void setTaskPlace(String taskPlace) {
		this.taskPlace = taskPlace;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public User getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(User userDetails) {
		this.userDetails = userDetails;
	}

	@Override
	public String toString() {
		return "ToDoTask [taskId=" + taskId + ", taskPlace=" + taskPlace + ", taskDescription=" + taskDescription
				+ ", userDetails=" + userDetails + "]";
	}

	
}