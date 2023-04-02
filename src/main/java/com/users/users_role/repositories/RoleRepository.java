package com.users.users_role.repositories;

import com.users.users_role.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {


    Role findByRoleName(String name);
}
