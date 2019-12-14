package undestiny.springbootshiro.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import undestiny.springbootshiro.entity.User;

/**
 * user  generated at 2019-10-30 17:51:50 by: undestiny
 */

@Mapper
public interface UserMapper{
	@Insert("insert into user(id,username,password,description) values (#{id},#{username},#{password},#{description})")
	int insertUser(User user);

	@Select("select * from user where id=#{0}")
	User getUserById(int id);

	@Select("select * from user where username=#{0}")
	User getUserByUsername(String username);
}
