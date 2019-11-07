package com.example.alfhanrf.skripsihehe.model.bangungedung;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Alfhanrf on 8/20/2018.
 */

public class BangunanList {
    @SerializedName("code")
    private int code;

    @SerializedName("Message")
    private String message;

    @SerializedName("Bangunan")
    private List<Bangunan> bangunan = null;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setBangunan(List<Bangunan> bangunan) {
        this.bangunan = bangunan;
    }

    public List<Bangunan> getSemuaBangunan() {
        return bangunan;
    }

    @Override
    public String toString() {
        return
                "BangunanResponse{" +
                        "code = '" + code + '\'' +
                        ",message = '" + message + '\'' +
                        ",bangunan = '" + bangunan + '\'' +
                        "}";
    }
}


