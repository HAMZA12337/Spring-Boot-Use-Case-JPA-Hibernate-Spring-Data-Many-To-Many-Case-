package com.users.users_role.Service;

import com.users.users_role.entities.Role;
import com.users.users_role.entities.User;

public interface UserService {


    User addNewUser(User user);
    Role addNewRole(Role role);
    User searchUserByUserName(String userName);
    Role searchRolebyName(String name);

    void addRoletoUser(String userName,String UserName);

}
