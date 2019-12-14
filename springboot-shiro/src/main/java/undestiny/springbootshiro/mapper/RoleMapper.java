package undestiny.springbootshiro.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import undestiny.springbootshiro.entity.Role;

/**
 * role  generated at 2019-10-30 17:51:50 by: undestiny
 */

@Mapper
public interface RoleMapper{
	@Insert("insert into role(id,name) values (#{id},#{name})")
	int insertRole(Role role);

	@Select("select * from role where id=#{0}")
	Role getRoleById(Integer id);
}
