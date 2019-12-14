package undestiny.springbootshiro.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import undestiny.springbootshiro.entity.Permission;

/**
 * permission  generated at 2019-10-30 17:51:50 by: undestiny
 */

@Mapper
public interface PermissionMapper{
	@Insert("insert into permission(id,name) values (#{id},#{name})")
	int insertPermission(Permission permission);

	@Select("select * from permission where id=#{0}")
	Permission getPermissionById(Integer id);
}
