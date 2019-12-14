package undestiny.validationdemo;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class BodyController {
	
    @GetMapping(value = "/body")
	//实体参数前加上@Valid使constraints生效
    public void body(@Valid @RequestBody MyBean bean) {
	}

}