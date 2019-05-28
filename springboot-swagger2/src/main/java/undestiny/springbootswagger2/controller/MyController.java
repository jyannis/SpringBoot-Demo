package undestiny.springbootswagger2.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import undestiny.springbootswagger2.entity.Student;

@Api(tags = "我的控制器")
@RestController
public class MyController {

    @ApiOperation("获取学生列表")
    @PostMapping("/GET/students")
    Student get(){
        return new Student(1,"Jack",18);
    }

}
