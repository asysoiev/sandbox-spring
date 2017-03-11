package com.sandbox.chapter5.aop.secure;

/**
 * @author Andrii Sysoiev
 */
public class SecurityManager {

    private static ThreadLocal<UserInfo> user = new ThreadLocal<>();

    public void login(String login, String pwd) {
        user.set(new UserInfo(login, pwd));
    }

    public void logout() {
        user.set(null);
    }

    public UserInfo getUser() {
        return user.get();
    }
}
