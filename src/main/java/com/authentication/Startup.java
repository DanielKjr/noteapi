package com.authentication;

import com.login.model.CustomUser;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Singleton
public class Startup {

    @Inject
    EntityManager em;

    @Transactional
    public void loadUsers(@Observes StartupEvent startupEvent) {

       CustomUser admin = CustomUser.addCustom("admin", "admin","admin");
       em.persist(admin);
        CustomUser user = CustomUser.addCustom("user", "user","user");
        em.persist(user);
    }
}
