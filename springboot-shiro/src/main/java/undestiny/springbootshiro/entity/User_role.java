package undestiny.springbootshiro.entity;

/**
 * user_role  generated at 2019-10-30 17:41:50 by: undestiny
 */

public class User_role{
	private Integer id;
	private Integer user_id;
	private Integer role_id;

	public void setId(Integer id){
		this.id=id;
	}

	public Integer getId(){
		return id;
	}

	public void setUser_id(Integer user_id){
		this.user_id=user_id;
	}

	public Integer getUser_id(){
		return user_id;
	}

	public void setRole_id(Integer role_id){
		this.role_id=role_id;
	}

	public Integer getRole_id(){
		return role_id;
	}

}
