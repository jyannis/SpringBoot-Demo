package undestiny.springbootshiro.entity;

/**
 * user  generated at 2019-10-30 17:41:50 by: undestiny
 */

public class User{
	private Integer id;
	private String username;
	private String password;
	private String description;

	public void setId(Integer id){
		this.id=id;
	}

	public Integer getId(){
		return id;
	}

	public void setUsername(String username){
		this.username=username;
	}

	public String getUsername(){
		return username;
	}

	public void setPassword(String password){
		this.password=password;
	}

	public String getPassword(){
		return password;
	}

	public void setDescription(String description){
		this.description=description;
	}

	public String getDescription(){
		return description;
	}

}
