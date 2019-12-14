package undestiny.springbootshiro.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import undestiny.springbootshiro.entity.Role_permission;

import java.util.List;

/**
 * role_permission  generated at 2019-10-30 17:51:50 by: undestiny
 */

@Mapper
public interface Role_permissionMapper{
	@Insert("insert into role_permission(id,role_id,permission_id) values (#{id},#{role_id},#{permission_id})")
	int insertRole_permission(Role_permission role_permission);

	@Select("select * from role_permission where role_id=#{0}")
	List<Role_permission> getRole_permissionListByRole_id(Integer role_id);
}
