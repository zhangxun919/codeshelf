package cn.jansen.pojo;

import java.util.Date;
import java.util.List;

public class SuperUser {
	
	private Integer userId;
	private String userName;
	private String userGender;
	private Date birthdate;
	private String address;
	
	private List<Order> orders;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	@Override
	public String toString() {
		return "SuperUser [userId=" + userId + ", userName=" + userName + ", userGender=" + userGender + ", birthdate="
				+ birthdate + ", address=" + address + ", orders=" + orders + "]";
	}
	
}
