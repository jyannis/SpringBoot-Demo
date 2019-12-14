package undestiny.springbootshiro.entity;

/**
 * role_permission  generated at 2019-10-30 17:41:50 by: undestiny
 */

public class Role_permission{
	private Integer id;
	private Integer role_id;
	private Integer permission_id;

	public void setId(Integer id){
		this.id=id;
	}

	public Integer getId(){
		return id;
	}

	public void setRole_id(Integer role_id){
		this.role_id=role_id;
	}

	public Integer getRole_id(){
		return role_id;
	}

	public void setPermission_id(Integer permission_id){
		this.permission_id=permission_id;
	}

	public Integer getPermission_id(){
		return permission_id;
	}

}
