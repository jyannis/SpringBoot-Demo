package undestiny.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReadProperty {

    @Value("${student.name}")
    private String name;

    @Value("${student.age}")
    private int age;

    @GetMapping("/GET/student")
    String getStudent(){
        return "value：  姓名：" + name + "  年龄：" + age;
    }
}
