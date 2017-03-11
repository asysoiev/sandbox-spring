package com.sandbox.chapter5.aop.secure;

/**
 * @author Andrii Sysoiev
 */
public class UserInfo {

    private final String login;
    private final String pwd;

    public UserInfo(String login, String pwd) {
        this.login = login;
        this.pwd = pwd;
    }

    public String getLogin() {
        return login;
    }

    public String getPwd() {
        return pwd;
    }
}
