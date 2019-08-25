package com.architect.upgrade;

import com.architect.old.ILoginService;

public interface ILoginForThridService extends ILoginService {

    String loginForQQ(Long openId);

    String loginForWeChat(Long openId);

    String loginForToken(String token);
}
