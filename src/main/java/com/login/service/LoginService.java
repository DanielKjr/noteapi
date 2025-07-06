package com.login.service;

import com.login.model.CustomUser;
import com.login.model.Role;
import com.login.model.User;
import io.quarkus.elytron.security.common.BcryptUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class LoginService {

    @Inject
    EntityManager em;

    public CustomUser createCustomUser(String username, String password){
        return addCustom(username, password, "admin");
    }

    @Transactional
    public CustomUser addCustom(String username, String password, String role){
        CustomUser user = new CustomUser();
        user.username = username;
        user.password = BcryptUtil.bcryptHash(password);
        user.role = role;
        em.persist(user);

        return user;
    }
    public User createUser(String username, String password) {
        return add(username, password, new ArrayList<Role>());
    }


    @Transactional
    public static User add(String username, String password, List<Role> roles){
        User user = new User();
        user.username = username;
        user.password = BcryptUtil.bcryptHash(password);
        user.roles = roles;
        user.persist();
        return user;
    }
}
