package com.example.alfhanrf.skripsihehe.model.login;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {


    @SerializedName("message")
    private String message;

    @SerializedName("id_user")
    private String Id_User;

    @SerializedName("status")
    private int status;

    @SerializedName("user_role")
    private int userRole;

    @SerializedName("token")
    private String token;

    @SerializedName("nama")
    private String nama;

    public String getNama() {
        return nama;
    }

    public void setNama(String name) {
        this.nama = nama;
    }

    public String getId_User() {
        return Id_User;
    }

    public void setId_User(String Id_User) {
        this.Id_User = Id_User;
    }

    public int getUserRole() {
        return userRole;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getIDUSER() {
        return null;
    }

    public void setIDUSER(String iDUSER) {
        this.Id_User = Id_User;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return
                "LoginResponse{" +
                        "message = '" + message + '\'' +
                        ",Id_User = '" + Id_User + '\'' +
                        ",status = '" + status + '\'' +
                        ",token = '" + token + '\'' +
                        "}";
    }
}
