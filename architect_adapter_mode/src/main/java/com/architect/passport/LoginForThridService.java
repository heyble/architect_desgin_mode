package com.architect.passport;

public class LoginForThridService extends LoginService {

    public String loginForQQ(Long openId){
        return super.login(openId, "empty");
    }

    public String loginForWeChat(Long openId){
        return super.login(openId, "empty");
    }

    public String loginForToken(String token){
        String uid = "parse token";
        String pwd = "parse token";
        return super.login(Long.parseLong(uid), pwd);
    }
}
