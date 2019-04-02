package undestiny.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping(value = "/index")
    public String doIndex(@RequestParam("param")String param) {
        return "returnString";
    }

}
