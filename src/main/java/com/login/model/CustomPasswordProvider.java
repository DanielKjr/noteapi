package com.login.model;

import io.quarkus.security.jpa.PasswordProvider;
import jakarta.xml.bind.DatatypeConverter;
import org.wildfly.security.password.Password;
import org.wildfly.security.password.interfaces.SimpleDigestPassword;

public class CustomPasswordProvider implements PasswordProvider {

    @Override
    public Password getPassword(String storedPassword){
        byte[] digest = DatatypeConverter.parseHexBinary(storedPassword);

        //specify that stored password is hashed with SHA256
        return SimpleDigestPassword.createRaw(SimpleDigestPassword.ALGORITHM_SIMPLE_DIGEST_SHA_256, digest);
    }


}
