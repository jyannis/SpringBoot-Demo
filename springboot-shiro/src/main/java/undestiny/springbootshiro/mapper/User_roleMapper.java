package undestiny.springbootshiro.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import undestiny.springbootshiro.entity.User_role;

import java.util.List;

/**
 * user_role  generated at 2019-10-30 17:51:50 by: undestiny
 */

@Mapper
public interface User_roleMapper{
	@Insert("insert into user_role(id,user_id,role_id) values (#{id},#{user_id},#{role_id})")
	int insertUser_role(User_role user_role);

	@Select("select * from user_role where user_id=#{0}")
	List<User_role> getUser_roleListByUser_id(Integer user_id);
}
