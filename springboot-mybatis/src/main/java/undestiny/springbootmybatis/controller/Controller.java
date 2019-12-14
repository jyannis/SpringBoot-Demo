package undestiny.springbootmybatis.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import undestiny.springbootmybatis.entity.User;
import undestiny.springbootmybatis.mapper.UserMapper;

import java.util.List;

@RestController
@Slf4j
public class Controller {

    @Autowired
    UserMapper userMapper;

    @GetMapping("/insertUser/{username}/{password}")
    public Long insertUser(@PathVariable("username")String username,
                           @PathVariable("password")String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        //insertUser返回插入的条数
        int count = userMapper.insertUser(user);
        log.info("count=" + count);
        log.info("id=" + user.getId());
        return user.getId();
    }

    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable("id")Long id){
        return userMapper.getUserById(id);
    }

    @GetMapping("/getUserById2/{id}")
    public User getUserById2(@PathVariable("id")Long id){
        return userMapper.getUserById2(id);
    }

    @GetMapping("/getUserByUsername/{username}")
    public List<User> getUserByUsername(@PathVariable("username")String username){
        return userMapper.getUserListByUsername(username);
    }

    @GetMapping("/getUserListOrderly/{order_by_sql}")
    public List<User> getUserListOrderly(@PathVariable("order_by_sql")String order_by_sql){
        return userMapper.getUserListOrderly(order_by_sql);
    }

    @GetMapping("/deleteUserById/{id}")
    public int deleteUserById(@PathVariable("id")Long id){
        return userMapper.deleteUserById(id);
    }

    @GetMapping("/updateUsernameById/{username}/{id}")
    public long updateUsernameById(@PathVariable("username")String username,
                                  @PathVariable("id")Long id){
        int count = userMapper.updateUsernameById(username,id);
        log.info("count=" + count);
        return id;
    }

}
