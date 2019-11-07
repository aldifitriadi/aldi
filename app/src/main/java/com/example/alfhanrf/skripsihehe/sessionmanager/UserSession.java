package com.example.alfhanrf.skripsihehe.sessionmanager;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Alfhanrf on 8/15/2018.
 */

public class UserSession {
    private static final String PREFER_NAME = "SurveyBangunGedung";
    private static final String IS_USER_LOGIN = "LoginStatus";
    private static final String KEY_ID_USER = "id_user";
    private static final String KEY_USER_ROLE = "user_role";
    private static final String KEY_USER_ID = "user_id";
    private static final String KEY_USER_TOKEN = "token";
    private static final String KEY_USER_NAME = "nama";
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private Context mContext;

    public UserSession(Context mContext) {
        this.mContext = mContext;
        preferences = mContext.getSharedPreferences(PREFER_NAME, 0);
        editor = preferences.edit();
    }


//    public void setLoginSession(int id_user,int userRole, String token, String user_id,String nama) {
//        editor.putBoolean(IS_USER_LOGIN, true);
//        editor.putString(KEY_USER_ID, user_id);
////        editor.putInt(KEY_ID_USER, id_user);
//        editor.putInt(KEY_USER_ROLE, userRole);
//        editor.putString(KEY_USER_TOKEN, token);
//        editor.putString(KEY_USER_NAME, nama);
//        editor.commit();
//    }

    public void setLoginSession(String id, String token, String nama, String userRole, String user_id) {
        editor.putBoolean(IS_USER_LOGIN, true);

        editor.putString(KEY_USER_ID, user_id);
        editor.putString(KEY_ID_USER, id);
        editor.putString(KEY_USER_TOKEN, token);
        editor.putString(KEY_USER_NAME, nama);
        editor.putString(KEY_USER_ROLE, userRole);

        editor.commit();
    }

    public void logoutUser() {
        editor.clear();
        editor.commit();
    }


    public String getUserID() {
        return preferences.getString(KEY_ID_USER, null);
    }

    public int getUserRole() {
        return preferences.getInt(KEY_USER_ROLE, 0);
    }

    public String getUserToken() {
        return preferences.getString(KEY_USER_TOKEN, null);
    }

    public String getUserId() {
        return preferences.getString(KEY_USER_ID, null);
    }

    public String getIdUser() {
        return preferences.getString(KEY_ID_USER, "null");
    }

    public String getUserName() {
        return preferences.getString(KEY_USER_NAME, null);
    }

    public String getUserRoleStr() {
        return preferences.getString(KEY_USER_ROLE, null);
    }

    // Check for login
    public boolean isUserLoggedIn() {
        return preferences.getBoolean(IS_USER_LOGIN, false);
    }
}
