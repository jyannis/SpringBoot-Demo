package undestiny.springbootshiro.service.shiro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import undestiny.springbootshiro.entity.Permission;
import undestiny.springbootshiro.entity.Role;
import undestiny.springbootshiro.entity.Role_permission;
import undestiny.springbootshiro.entity.User_role;
import undestiny.springbootshiro.mapper.PermissionMapper;
import undestiny.springbootshiro.mapper.RoleMapper;
import undestiny.springbootshiro.mapper.Role_permissionMapper;
import undestiny.springbootshiro.mapper.User_roleMapper;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Component
@Validated
public class AuthorityQuerier {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private User_roleMapper user_roleMapper;

    @Autowired
    private Role_permissionMapper role_permissionMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    public List<Role> getRoleListByUser_id(@NotNull Integer user_id) {
        List<User_role> user_roleList = user_roleMapper.getUser_roleListByUser_id(user_id);

        List<Role> roleList = new ArrayList<>();
        for(User_role user_role:user_roleList){
            int role_id = user_role.getRole_id();
            Role role = roleMapper.getRoleById(role_id);
            if(role != null){
                roleList.add(role);
            }
        }
        return roleList;
    }

    public List<String> getRoleNameListByUser_id(@NotNull Integer user_id){
        List<Role> roleList = getRoleListByUser_id(user_id);
        List<String> roleNameList = new ArrayList<>();
        for(Role role:roleList){
                String roleName = role.getName();
                roleNameList.add(roleName);
        }
        return roleNameList;
    }

    public List<Permission> getPermissionListByUser_id(@NotNull Integer user_id){
        List<Role> roleList = getRoleListByUser_id(user_id);
        List<Permission> permissionList = new ArrayList<>();
        for(Role role:roleList){
            List<Role_permission> role_permissionList = role_permissionMapper.getRole_permissionListByRole_id(role.getId());
            for(Role_permission role_permission:role_permissionList){
                int permission_id = role_permission.getPermission_id();
                Permission permission = permissionMapper.getPermissionById(permission_id);
                if(permission != null){
                    permissionList.add(permission);
                }
            }
        }
        return permissionList;
    }


    public List<String> getPermissionNameListByUser_id(@NotNull Integer user_id){
        List<Permission> permissionList = getPermissionListByUser_id(user_id);
        List<String> permissionNameList = new ArrayList<>();
        for(Permission permission:permissionList){
            String permissionName = permission.getName();
            permissionNameList.add(permissionName);
        }
        return permissionNameList;
    }

}
