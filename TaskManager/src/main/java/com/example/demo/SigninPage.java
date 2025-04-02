package com.example.demo;

public class SigninPage {

    private String login_email;
    private String login_password;

    public String getLoginEmail() {
        return login_email;
    }

    public void setLogin_email(String login_email) { // Corrected setter
        this.login_email = login_email;
    }

    public String getLoginPassword() { // Corrected getter name
        return login_password;
    }

    public void setLoginPassword(String login_password) { // Corrected setter
        this.login_password = login_password;
    }

    @Override
    public String toString() {
        return "SigninPage[ email =" + login_email + ", password = " + login_password + "]";
    }
}