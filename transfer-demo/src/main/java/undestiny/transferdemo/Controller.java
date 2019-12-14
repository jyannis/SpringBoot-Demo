package undestiny.transferdemo;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class Controller {

    @Autowired
    Gson gson;

    @PostMapping("/body")
    public String getBody(@RequestBody Student student){
        return gson.toJson(student);
    }

    @PostMapping("/query")
    public String getQuery(@RequestParam("id")Integer id,
                            @RequestParam("name")String name,
                            @RequestParam("age")Integer age){
        return gson.toJson(Student.builder().id(id).name(name).age(age).build());
    }

    @PostMapping("/path/{id}/{name}/{age}")
    public String getPath(@PathVariable("id")Integer id,
                           @PathVariable("name")String name,
                           @PathVariable("age")Integer age){
        return gson.toJson(Student.builder().id(id).name(name).age(age).build());
    }

    @PostMapping("/form_data")
    public String getForm_data(Student student){
        return gson.toJson(student);
    }

}
