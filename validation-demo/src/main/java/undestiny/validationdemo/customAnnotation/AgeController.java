package undestiny.validationdemo.customAnnotation;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class AgeController {

    @GetMapping("/age/{age}")
    public int age(@Age(min = 18)  @PathVariable("age")Integer age){
        return age;
    }

}
