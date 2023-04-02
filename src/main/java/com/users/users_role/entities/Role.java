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
@Table(name="Roles")

public class Role {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="ROLE_NAME",unique = true, length=20)
    private String roleName;
    private String desc ;
    @ManyToMany(fetch=FetchType.EAGER)
    private List<User> users = new ArrayList<>();




}
