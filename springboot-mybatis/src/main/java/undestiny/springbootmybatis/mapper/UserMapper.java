package undestiny.springbootmybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import undestiny.springbootmybatis.entity.User;

import java.util.List;

@Mapper
public interface UserMapper {

    //插入一个用户
    int insertUser(User user);

    //根据用户id获取用户
    User getUserById(@Param("id")Long id);

    //根据用户id获取用户
    User getUserById2(Long id);

    //根据用户名获取用户列表
    List<User> getUserListByUsername(@Param("username")String username);

    //根据指定排序条件获取用户列表
    List<User> getUserListOrderly(@Param("order_by_sql") String order_by_sql);

    //根据用户id删除用户
    int deleteUserById(Long id);

    //根据用户id找到用户，并更新用户名
    int updateUsernameById(@Param("username")String username,@Param("id")Long id);
}
