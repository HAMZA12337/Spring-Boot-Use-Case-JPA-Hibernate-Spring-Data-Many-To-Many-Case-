package com.users.users_role.repositories;

import com.users.users_role.entities.Role;
import com.users.users_role.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User,String> {


    User findByUserName(String userName);







}
