package com.login.model;


import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "logins")
//@UserDefinition
public class User extends PanacheEntity {

//    @Username
    public String username;

//    @Password
    public String password;

    @ManyToMany(cascade = CascadeType.ALL)
//    @Roles
    public List<Role> roles;

    public static void add(String username, String password, List<Role> roles){
        User user = new User();
        user.username = username;
        user.password = BcryptUtil.bcryptHash(password);
        user.roles = roles;
        user.persist();

    }

}
