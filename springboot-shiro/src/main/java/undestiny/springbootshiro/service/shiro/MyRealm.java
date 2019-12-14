package undestiny.springbootshiro.service.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import undestiny.springbootshiro.dto.UserDTO;
import undestiny.springbootshiro.entity.User;
import undestiny.springbootshiro.entity.User_role;
import undestiny.springbootshiro.mapper.UserMapper;

import java.util.List;

@Component
public class MyRealm extends AuthorizingRealm {

    @Autowired
    UserMapper userMapper;

    @Autowired
    AuthorityQuerier authorityQuerier;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        Object principal = principals.getPrimaryPrincipal();
        UserDTO userDTO = (UserDTO) principal;

        int id = userDTO.getId();

        //获取用户的角色、权限信息
        List<String> roleNameList = authorityQuerier.getRoleNameListByUser_id(id);
        List<String> permissionNameList = authorityQuerier.getPermissionNameListByUser_id(id);

        //注入角色与权限
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        info.addRoles(roleNameList);
        info.addStringPermissions(permissionNameList);


        return info;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        //数据库匹配，认证
        String username = token.getUsername();
        String password = new String(token.getPassword());

        User user = userMapper.getUserByUsername(username);
        if(user == null || !(user.getPassword()+"").equals(password))throw new AuthenticationException();

        // 处理登录信息
        UserDTO userDTO = new UserDTO(user);

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userDTO, token.getCredentials(), getName());
        return info;
    }
}
