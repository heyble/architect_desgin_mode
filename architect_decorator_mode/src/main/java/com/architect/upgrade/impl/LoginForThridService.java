package com.architect.upgrade.impl;

import com.architect.old.ILoginService;
import com.architect.upgrade.ILoginForThridService;

public class LoginForThridService implements ILoginForThridService {

    private ILoginService loginService;

    public LoginForThridService(ILoginService loginService) {
        this.loginService = loginService;
    }

    public String login(Long userId, String pwd){
        return loginService.login(userId, pwd);
    }

    public String register(Long userId,String pwd){
        return loginService.register(userId, pwd);
    }

    public String loginForQQ(Long openId){
        return this.login(openId, "empty");
    }

    public String loginForWeChat(Long openId){
        return this.login(openId, "empty");
    }

    public String loginForToken(String token){
        String uid = "parse token";
        String pwd = "parse token";
        return this.login(Long.parseLong(uid), pwd);
    }
}
