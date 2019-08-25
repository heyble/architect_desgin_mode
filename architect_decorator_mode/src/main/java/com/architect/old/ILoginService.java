package com.architect.old;

public interface ILoginService {

    String register(Long userId,String pwd);

    String login(Long userId,String pwd);
}
