package undestiny.springbootmybatispagehelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    UserService userService;

    @GetMapping("/test/{pageNum}")
    public List<User> test(@PathVariable("pageNum") Integer pageNum){
        return userService.getAll(pageNum);
    }

}
