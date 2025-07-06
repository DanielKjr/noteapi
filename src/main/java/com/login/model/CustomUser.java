package com.login.model;

import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.security.jpa.*;
import jakarta.persistence.*;

@UserDefinition
@Table(name="customlogin")
@Entity
public class CustomUser{

    @Id
    @GeneratedValue
    public Long id;

    @Column(name = "username")
    @Username
    public String username;

    @Column(name = "password")
    @Password
//    @Password(value = PasswordType.CUSTOM, provider = CustomPasswordProvider.class)
    public String password;

    @Roles
    public String role;

    public static CustomUser addCustom(String username, String password, String role){
        CustomUser user = new CustomUser();
        user.username = username;
        user.password = BcryptUtil.bcryptHash(password);
        user.role = role;
//        em.persist(user);

        return user;
    }
}
