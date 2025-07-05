package com.login.controller;

import com.dto.LoginDto;
import com.login.model.CustomUser;
import com.login.model.User;
import com.login.service.LoginService;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/login")
public class LoginController {
    @Inject
    LoginService loginService;

    @POST
    @Path("/createNew")
    public User createNew(LoginDto loginDto){
       return loginService.createUser(loginDto.username , loginDto.password);
    }

    @POST
    @Path("/createNewCustom")
    public CustomUser createNewCustom(LoginDto loginDto){
        return loginService.createCustomUser(loginDto.username , loginDto.password);
    }
}
