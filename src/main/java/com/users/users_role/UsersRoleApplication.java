package com.users.users_role;

import com.users.users_role.Service.RoleService;
import com.users.users_role.Service.UserService;
import com.users.users_role.entities.Role;
import com.users.users_role.entities.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class UsersRoleApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsersRoleApplication.class, args);
    }

    @Bean
    CommandLineRunner start(UserService userService) {

        return args -> {

            User user1= new User();
            User user2= new User();

            ////////////////////
            user1.setUserName("hamza");
            user1.setPassword("123455");
            userService.addNewUser(user1);
            //////////////////////////////
            user1.setUserName("admin");
            user1.setPassword("123455");
            userService.addNewUser(user1);

            ////////////////////////////

            Stream.of("STUDENT","USER","ADMIN").forEach( r-> {
                Role role1 = new Role();
                role1.setRoleName(r);
                role1.setDesc("blbllblblblbl");
                userService.addNewRole(role1);

            });

//////////////////////////////

            userService.addRoletoUser("hamza","STUDENT");
            userService.addRoletoUser("admin","ADMIN");





        };
    }
}






