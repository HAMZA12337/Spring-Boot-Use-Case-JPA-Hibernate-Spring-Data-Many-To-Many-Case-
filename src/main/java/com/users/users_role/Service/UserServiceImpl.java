package com.users.users_role.Service;

import com.users.users_role.entities.Role;
import com.users.users_role.entities.User;
import com.users.users_role.repositories.RoleRepository;
import com.users.users_role.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
@Transactional
public class UserServiceImpl implements UserService {


    // instead of autowired we can use injection by constructor
    private UserRepository userRepository ;
    private RoleRepository roleRepository;



    // we can do this or use annotation @AllArgsConstructor
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User addNewUser(User user) {

        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public Role addNewRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User searchUserByUserName(String userName) {

        return userRepository.findByUserName(userName) ;
    }
     @Override
    public Role searchRolebyName(String name) {
        return roleRepository.findByRoleName(name) ;
    }

    @Override
    public void addRoletoUser(String userName, String roleName) {

        User user=searchUserByUserName(userName);
        Role role=searchRolebyName(roleName);
        if(user.getRoles() != null ) {

            // bidirectionnel
            user.getRoles().add(role);
            role.getUsers().add(user);
        // we don't nned to this userRep.save(user) because we aleardy add transactionnel annotation

        }

  }
}
