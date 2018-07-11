package cn.jansen.pojo;

import java.util.List;

public class Role {
	
	private Integer roleId;
	private String roleName;
	private List<RoleUser> users;
	
	public List<RoleUser> getUsers() {
		return users;
	}
	public void setUsers(List<RoleUser> users) {
		this.users = users;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", users=" + users + "]";
	}
	
}
