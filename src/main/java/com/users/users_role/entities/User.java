package com.users.users_role.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Users")

public class User {

    @Id
    private String userId ;
    @Column(name="USER_NAME",unique = true, length=20)
    private String userName;
    private String password ;
    @ManyToMany(mappedBy="users",fetch=FetchType.EAGER)
    private List<Role> roles = new ArrayList<>();
//    @JoinTable(name="Users_Roles",) // la table jointure car manytomany relation








}
