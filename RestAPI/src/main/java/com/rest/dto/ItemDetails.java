package com.rest.dto;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@Entity
public class ItemDetails {
	
	@Id@GeneratedValue
	private int itemId;
	private String itemName;
	private String itemDescription;
	private String itemImage;
	private String itemType;
	 
	
	
	@ManyToOne
	private User userDetails;
	
	public int getItemId() {
		return itemId;
	}



	public void setItemId(int itemId) {
		this.itemId = itemId;
	}



	public String getItemName() {
		return itemName;
	}



	public void setItemName(String itemName) {
		this.itemName = itemName;
	}



	public String getItemDescription() {
		return itemDescription;
	}



	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}



	public String getItemImage() {
		return itemImage;
	}



	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}

	public String getItemType() {
		return itemType;
	}



	public void setItemType(String itemType) {
		this.itemType = itemType;
	}


	public User getUserDetails() {
		return userDetails;
	}



	public void setUserDetails(User userDetails) {
		this.userDetails = userDetails;
	}



	@Override
	public String toString() {
		return "ItemDetails [itemId=" + itemId + ", itemName=" + itemName + ", itemDescription=" + itemDescription
				+ ", itemImage=" + itemImage + ", itemType=" + itemType + ", userDetails=" + userDetails + "]";
	}
	

}
