package undestiny.springbootmybatisannotation.mapper;

import org.apache.ibatis.annotations.*;
import undestiny.springbootmybatisannotation.entity.User;

import java.util.List;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO user(id,username,password) VALUES (#{id},#{username},#{password});")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertUser(User user);

    @ResultType(User.class)
    @Select("SELECT * FROM user WHERE id=#{id};")
    User getUserById(@Param("id") Long id);

    @ResultType(User.class)
    @Select("SELECT * FROM user WHERE id=#{id};")
    User getUserById2(Long id);

    //用@Results来替换原xml配置的<resultMap />
    @Results(
            id = "userList",value = {
            @Result(property="username", column="username"),
            @Result(property="password", column="password")
    }
    )
    @Select("SELECT * FROM user WHERE username=#{username};")
    List<User> getUserListByUsername(@Param("username") String username);

    //如果已经定义过@Results，可以直接用@ResultMap来调取
    @ResultMap("userList")
    @Select("SELECT * FROM user ORDER BY ${order_by_sql};")
    List<User> getUserListOrderly(@Param("order_by_sql") String order_by_sql);

    @Delete("DELETE FROM user WHERE id=#{id};")
    int deleteUserById(Long id);

    @Update("UPDATE user SET username=#{username} where id=#{id};")
    int updateUsernameById(@Param("username") String username, @Param("id") Long id);
}
