package com.unitedinternet.jam.konten.service.login;

/**
 * Created by agrunow on 14.11.16.
 */
public class LoginService {
    public boolean isLoginValid(String username, String passwort) {

        if (username.equalsIgnoreCase("kekse")
                && passwort.equalsIgnoreCase("kekse"))
            return true;
        else
            return false;
    }
}
