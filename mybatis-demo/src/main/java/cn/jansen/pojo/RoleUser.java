package cn.jansen.pojo;

import java.util.Date;
import java.util.List;

public class RoleUser {

	private Integer userId;
	private String userName;
	private String userGender;
	private Date birthdate;
	private String address;
	
	private List<Role> roles;
	
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
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
	
	@Override
	public String toString() {
		return "RoleUser [userId=" + userId + ", userName=" + userName + ", userGender=" + userGender + ", birthdate="
				+ birthdate + ", address=" + address + ", roles=" + roles + "]";
	}
	
}
