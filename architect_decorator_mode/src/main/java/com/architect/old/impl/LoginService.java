package com.architect.old.impl;

import com.architect.old.ILoginService;

public class LoginService implements ILoginService {

    public String login(Long userId,String pwd){
        System.out.println(userId+" login ok");
        return "login ok";
    }

    public String register(Long userId,String pwd){
        System.out.println(userId+" register ok");
        return "register ok";
    }
}
