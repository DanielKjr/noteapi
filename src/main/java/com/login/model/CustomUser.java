package com.login.model;

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
    @Password(value = PasswordType.CUSTOM, provider = CustomPasswordProvider.class)
    public String password;

    @Roles
    public String role;


}
