package undestiny.springbootswagger2.controller.b;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import undestiny.springbootswagger2.model.User;

@Api(tags = "控制器B")
@RestController
public class ControllerB {

    @GetMapping("/user")
    @ApiOperation("获取用户信息")
    public User get(){
        return User.builder()
                .username("myUsername")
                .password("myPassword")
                .name("myName")
                .age(10)
                .build();
    }

}
