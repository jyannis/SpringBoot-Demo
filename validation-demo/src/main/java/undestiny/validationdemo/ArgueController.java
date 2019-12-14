package undestiny.validationdemo;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@RestController
@Validated
//类上加@Validated使constraints生效
public class ArgueController {

    @GetMapping("/argue/{password}")
    public String argue(@NotNull @Size(min = 4,max = 20) @PathVariable("password")String password){
        return password;
    }

}
