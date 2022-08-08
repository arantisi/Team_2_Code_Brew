package com.example.demo.models;

public class Accounts {

    private int accountsId;
    private String username;
    private String password;

    public Accounts() {
    }

    public Accounts(int accountsId, String username, String password) {
        this.accountsId = accountsId;
        this.username = username;
        this.password = password;
    }

    public int getAccountsId() {
        return accountsId;
    }

    public void setAccountsId(int accountsId) {
        this.accountsId = accountsId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "accountsId=" + accountsId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
