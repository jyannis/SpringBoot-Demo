package undestiny.springbootshiro.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController {

    @PostMapping("/login")
    public String login(@RequestParam("username")String username,
                        @RequestParam("password")String password) {

        log.info("username-->{}, password-->{}", username, password);


        UsernamePasswordToken token = new UsernamePasswordToken();
        token.setUsername(username);
        token.setPassword(password.toCharArray());


        SecurityUtils.getSubject().login(token);

        return "success";
    }

}
