package undestiny.springbootswagger2.controller.a;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import undestiny.springbootswagger2.model.User;

@Api(tags = "控制器A")
@RestController
public class ControllerA {

    @PostMapping("/user")
    @ApiOperation("增加一个普通用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username",value = "账户名",required = true),
            @ApiImplicitParam(name = "password",value = "账户密码",required = true)
    })
    public User post(@RequestParam("username")String username,
                     @RequestParam("password")String password){
        return User.builder()
                .username(username)
                .password(password)
                .build();
    }

    @PutMapping("/user")
    @ApiOperation("修改一个普通用户的信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "age",value = "年龄",required = true,defaultValue = "18"),
            @ApiImplicitParam(name = "name",value = "姓名",required = true)
    })
    public User put(@RequestParam(value = "age",defaultValue = "18")Integer age,
                    @RequestParam("name")String name){
        return User.builder()
                .username("myUsername")
                .password("myPassword")
                .age(age)
                .name(name)
                .build();
    }

}
