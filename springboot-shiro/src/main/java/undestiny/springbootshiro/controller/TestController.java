package undestiny.springbootshiro.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import undestiny.springbootshiro.dto.UserDTO;
import undestiny.springbootshiro.entity.User;

@Slf4j
@RestController
public class TestController {

    @Autowired
    private SessionDAO sessionDAO;

    @PostMapping("/1")
    @RequiresRoles("user")
    public String a1(){
        Object principal = SecurityUtils.getSubject().getPrincipal();
        UserDTO userDTO = (UserDTO) principal;
        log.info("用户" + userDTO.getUsername() + "进入a1了！");
        return "进入a1成功";
    }

    @PostMapping("/sessions")
    @RequiresRoles("admin")
    public int getSessions(){
        return sessionDAO.getActiveSessions().size();
    }


}
