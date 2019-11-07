package com.example.alfhanrf.skripsihehe.model.login;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Alfhanrf on 8/15/2018.
 */

public class EntityLogin {

    @SerializedName("user_id")
    private String user_id;

    @SerializedName("password")
    private String password;


    public EntityLogin(String user_id, String password) {
        this.user_id = user_id;
        this.password = password;

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return user_id;
    }

    public void setUserId(String user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return
                "EntityLogin{" +
                        "password = '" + password + '\'' +
                        ",user_id = '" + user_id + '\'' +
                        "}";
    }
}
