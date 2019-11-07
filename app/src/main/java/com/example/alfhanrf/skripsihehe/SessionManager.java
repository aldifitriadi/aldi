package com.example.alfhanrf.skripsihehe;

/**
 * Created by Alfhanrf on 8/2/2018.
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


public class SessionManager {
    private SharedPreferences prefs;

    public SessionManager(Context cntx) {
        prefs = PreferenceManager.getDefaultSharedPreferences(cntx);
    }

    public void removeSession() {
        prefs.edit().remove("NamaDepar").apply();
        prefs.edit().remove("AlmtDepartemen").apply();
        prefs.edit().remove("NoIkmn").apply();
        prefs.edit().remove("NoHdno").apply();
        prefs.edit().remove("TelponBangun").apply();
        prefs.edit().remove("EmailBangun").apply();
        prefs.edit().remove("NamaBangun").apply();
        prefs.edit().remove("AlmtBangun").apply();
        prefs.edit().remove("FungsiBangun").apply();
        prefs.edit().remove("JumlahLantai").apply();
        prefs.edit().remove("LuasLantai").apply();
        prefs.edit().remove("KetinggianBangunan").apply();
        prefs.edit().remove("LuasBase").apply();
        prefs.edit().remove("code").apply();

    }

    public void setTelponBangun(String TelponBangun) {
        prefs.edit().putString("TelponBangun", TelponBangun).apply();
    }

    public void setEmailBangun(String EmailBangun) {
        prefs.edit().putString("EmailBangun", EmailBangun).apply();
    }

    public void setKetinggianBangunan(String KetinggianBangunan) {
        prefs.edit().putString("KetinggianBangunan", KetinggianBangunan).apply();
    }

    public String getNamaDepar() {
        String user = prefs.getString("NamaDepar", "");
        return user;
    }

    public void setNamaDepar(String NamaDepar) {
        prefs.edit().putString("NamaDepar", NamaDepar).apply();
    }

    public String getAlmtDepartemen() {
        String user = prefs.getString("AlmtDepartemen", "");
        return user;
    }

    public void setAlmtDepartemen(String AlmtDepartemen) {
        prefs.edit().putString("AlmtDepartemen", AlmtDepartemen).apply();
    }

    public String getNoIkmn() {
        String user = prefs.getString("NoIkmn", "");
        return user;
    }

    public void setNoIkmn(String NoIkmn) {
        prefs.edit().putString("NoIkmn", NoIkmn).apply();
    }

    public String getNoHdno() {
        String user = prefs.getString("NoHdno", "");
        return user;
    }

    public void setNoHdno(String NoHdno) {
        prefs.edit().putString("NoHdno", NoHdno).apply();
    }

    public String getTelponBgnGedung() {
        String user = prefs.getString("TelponBangun", "");
        return user;
    }

    public String getEmailBgnGedung() {
        String user = prefs.getString("EmailBangun", "");
        return user;
    }

    public String getNamaBangun() {
        String user = prefs.getString("NamaBangun", "");
        return user;
    }

    public void setNamaBangun(String NamaBangun) {
        prefs.edit().putString("NamaBangun", NamaBangun).apply();
    }

    public String getAlmtBangun() {
        String user = prefs.getString("AlmtBangun", "");
        return user;
    }

    public void setAlmtBangun(String AlmtBangun) {
        prefs.edit().putString("AlmtBangun", AlmtBangun).apply();
    }

    public String getFungsiBangun() {
        String user = prefs.getString("FungsiBangun", "");
        return user;
    }

    public void setFungsiBangun(String FungsiBangun) {
        prefs.edit().putString("FungsiBangun", FungsiBangun).apply();
    }

    public String getJumlahLantai() {
        String user = prefs.getString("JumlahLantai", "");
        return user;
    }

    public void setJumlahLantai(String JumlahLantai) {
        prefs.edit().putString("JumlahLantai", JumlahLantai).apply();
    }

    public String getLuasLantai() {
        String user = prefs.getString("LuasLantai", "");
        return user;
    }

    public void setLuasLantai(String LuasLantai) {
        prefs.edit().putString("LuasLantai", LuasLantai).apply();
    }

    public String getKetinggianBangun() {
        String user = prefs.getString("KetinggianBangunan", "");
        return user;
    }

    public String getLuasBase() {
        String user = prefs.getString("LuasBase", "");
        return user;
    }

    public void setLuasBase(String LuasBase) {
        prefs.edit().putString("LuasBase", LuasBase).apply();
    }

    public String getCode() {
        String code = prefs.getString("code", "");
        return code;
    }

    public void setCode(String code) {
        prefs.edit().putString("code", code).apply();
    }


}