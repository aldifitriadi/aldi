package com.example.alfhanrf.skripsihehe.model.bangungedung;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Alfhanrf on 8/20/2018.
 */

public class Bangunan implements Parcelable {


    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Bangunan createFromParcel(Parcel in) {
            return new Bangunan(in);
        }

        @Override
        public Bangunan[] newArray(int size) {
            return new Bangunan[size];
        }
    };
    @SerializedName("user_id")
    @Expose
    private String user_id;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("id_bangunan")
    @Expose
    private String id_bangunan;
    @SerializedName("id_reference")
    @Expose
    private int id_reference;
    @SerializedName("fungsi_bangunan")
    @Expose
    private String fungsi_bangunan;
    @SerializedName("jenis_bangunan")
    @Expose
    private String jenis_bangunan;
    @SerializedName("jenis_fungsi_bangunan")
    @Expose
    private String jenis_fungsi_bangunan;
    @SerializedName("nama_departemen")
    @Expose
    private String nama_departemen;
    @SerializedName("alamat_departemen")
    @Expose
    private String alamat_departemen;
    @SerializedName("no_ikmn")
    @Expose
    private String no_ikmn;
    @SerializedName("no_hdno")
    @Expose
    private String no_hdno;
    @SerializedName("telpon")
    @Expose
    private String telpon;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("date_input")
    @Expose
    private String date_input;
    @SerializedName("nama_bangunan")
    @Expose
    private String nama_bangunan;
    @SerializedName("alamat_bangunan")
    @Expose
    private String alamat_bangunan;
    @SerializedName("klasifikasi_bangunan")
    @Expose
    private String klasifikasi_bangunan;
    @SerializedName("jumlah_lantai_bangunan")
    @Expose
    private String jumlah_lantai_bangunan;
    @SerializedName("luas_lantai_bangunan")
    @Expose
    private String luas_lantai_bangunan;
    @SerializedName("luas_basement")
    @Expose
    private String luas_basement;
    @SerializedName("ketinggian_bangunan")
    @Expose
    private String ketinggian_bangunan;
    @SerializedName("date_selesai")
    @Expose
    private String date_selesai;
    @SerializedName("nama_pemilik_tanah")
    @Expose
    private String nama_pemilik_tanah;
    @SerializedName("no_ipt")
    @Expose
    private String no_ipt;
    @SerializedName("no_bkt")
    @Expose
    private String no_bkt;
    @SerializedName("jenis_kepemilikan_tanah")
    @Expose
    private String jenis_kepemilikan_tanah;
    @SerializedName("alamat_tanah")
    @Expose
    private String alamat_tanah;
    @SerializedName("luas_tanah")
    @Expose
    private String luas_tanah;
    @SerializedName("data_peruntukan_resmi")
    @Expose
    private String data_peruntukan_resmi;
    @SerializedName("kdb")
    @Expose
    private String kdb;
    @SerializedName("klb")
    @Expose
    private String klb;
    @SerializedName("kdh")
    @Expose
    private String kdh;
    @SerializedName("ktb")
    @Expose
    private String ktb;
    @SerializedName("nama_departemen_dulu")
    @Expose
    private String nama_departemen_dulu;
    @SerializedName("alamat_departemen_dulu")
    @Expose
    private String alamat_departemen_dulu;
    @SerializedName("no_ikmn_dulu")
    @Expose
    private String no_ikmn_dulu;
    @SerializedName("no_hdno_dulu")
    @Expose
    private String no_hdno_dulu;
    @SerializedName("telpon_dulu")
    @Expose
    private String telpon_dulu;
    @SerializedName("email_dulu")
    @Expose
    private String email_dulu;
    @SerializedName("no_imb_terdahulu")
    @Expose
    private String no_imb_terdahulu;
    @SerializedName("no_islf_terdahulu")
    @Expose
    private String no_islf_terdahulu;
    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("longitude")
    @Expose
    private String longitude;

    public Bangunan(String nama, String id_bangunan, int id_reference, String fungsi_bangunan, String jenis_bangunan,
                    String jenis_fungsi_bangunan, String nama_departemen, String alamat_departemen,
                    String no_ikmn, String no_hdno, String telpon, String email,
                    String date_input, String nama_bangunan, String alamat_bangunan,
                    String klasifikasi_bangunan, String jumlah_lantai_bangunan,
                    String luas_lantai_bangunan, String luas_basement, String ketinggian_bangunan,
                    String date_selesai, String nama_pemilik_tanah, String no_ipt,
                    String no_bkt, String jenis_kepemilikan_tanah, String alamat_tanah,
                    String luas_tanah, String data_peruntukan_resmi,
                    String kdb, String klb, String kdh, String ktb, String nama_departemen_dulu,
                    String alamat_departemen_dulu, String no_ikmn_dulu, String no_hdno_dulu,
                    String telpon_dulu, String email_dulu, String no_imb_terdahulu, String no_islf_terdahulu,
                    String latitude, String longitude) {

        this.nama = nama;
        this.id_bangunan = id_bangunan;
        this.id_reference = id_reference;
        this.fungsi_bangunan = fungsi_bangunan;
        this.jenis_bangunan = jenis_bangunan;
        this.jenis_fungsi_bangunan = jenis_fungsi_bangunan;
        this.nama_departemen = nama_departemen;
        this.alamat_departemen = alamat_departemen;
        this.no_ikmn = no_ikmn;
        this.no_hdno = no_hdno;
        this.telpon = telpon;
        this.email = email;
        this.date_input = date_input;
        this.nama_bangunan = nama_bangunan;
        this.alamat_bangunan = alamat_bangunan;
        this.fungsi_bangunan = fungsi_bangunan;
        this.klasifikasi_bangunan = klasifikasi_bangunan;
        this.jumlah_lantai_bangunan = jumlah_lantai_bangunan;
        this.luas_lantai_bangunan = luas_lantai_bangunan;
        this.luas_basement = luas_basement;
        this.ketinggian_bangunan = ketinggian_bangunan;
        this.date_selesai = date_selesai;
        this.nama_pemilik_tanah = nama_pemilik_tanah;
        this.no_ipt = no_ipt;
        this.no_bkt = no_bkt;
        this.jenis_kepemilikan_tanah = jenis_kepemilikan_tanah;
        this.alamat_tanah = alamat_tanah;
        this.luas_tanah = luas_tanah;
        this.data_peruntukan_resmi = data_peruntukan_resmi;
        this.kdb = kdb;
        this.klb = klb;
        this.kdh = kdh;
        this.ktb = ktb;
        this.nama_departemen_dulu = nama_departemen_dulu;
        this.alamat_departemen_dulu = alamat_departemen_dulu;
        this.no_ikmn_dulu = no_ikmn_dulu;
        this.no_hdno_dulu = no_hdno_dulu;
        this.telpon_dulu = telpon_dulu;
        this.email_dulu = email_dulu;
        this.no_imb_terdahulu = no_imb_terdahulu;
        this.no_islf_terdahulu = no_islf_terdahulu;

        this.date_input = date_input;
        this.latitude = latitude;
        this.longitude = longitude;

    }

    public Bangunan() {
    }

    public Bangunan(Parcel in) {
        this.nama = in.readString();
        this.id_bangunan = in.readString();
        this.id_reference = in.readInt();
        this.fungsi_bangunan = in.readString();
        this.jenis_bangunan = in.readString();
        this.jenis_fungsi_bangunan = in.readString();
        this.nama_departemen = in.readString();
        this.alamat_departemen = in.readString();
        this.no_ikmn = in.readString();
        this.no_hdno = in.readString();
        this.telpon = in.readString();
        this.email = in.readString();
        this.date_input = in.readString();
        this.nama_bangunan = in.readString();
        this.alamat_bangunan = in.readString();
        this.fungsi_bangunan = in.readString();
        this.klasifikasi_bangunan = in.readString();
        this.jumlah_lantai_bangunan = in.readString();
        this.luas_lantai_bangunan = in.readString();
        this.luas_basement = in.readString();
        this.ketinggian_bangunan = in.readString();
        this.date_selesai = in.readString();
        this.nama_pemilik_tanah = in.readString();
        this.no_ipt = in.readString();
        this.no_bkt = in.readString();
        this.jenis_kepemilikan_tanah = in.readString();
        this.alamat_tanah = in.readString();
        this.luas_tanah = in.readString();
        this.data_peruntukan_resmi = in.readString();
        this.kdb = in.readString();
        this.klb = in.readString();
        this.kdh = in.readString();
        this.ktb = in.readString();
        this.nama_departemen_dulu = in.readString();
        this.alamat_departemen_dulu = in.readString();
        this.no_ikmn_dulu = in.readString();
        this.no_hdno_dulu = in.readString();
        this.telpon_dulu = in.readString();
        this.email_dulu = in.readString();
        this.no_imb_terdahulu = in.readString();
        this.no_islf_terdahulu = in.readString();

        this.latitude = in.readString();
        this.longitude = in.readString();
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getId_bangunan() {
        return id_bangunan;
    }

    public void setId_bangunan(String id_bangunan) {
        this.id_bangunan = id_bangunan;
    }

    public int getId_reference() {
        return id_reference;
    }

    public void setId_reference(int id_reference) {
        this.id_reference = id_reference;
    }

    public String getFungsi_bangunan() {
        return fungsi_bangunan;
    }

    public void setFungsi_bangunan(String fungsi_bangunan) {
        this.fungsi_bangunan = fungsi_bangunan;
    }

    public String getJenis_bangunan() {
        return jenis_bangunan;
    }

    public void setJenis_bangunan(String jenis_bangunan) {
        this.jenis_bangunan = jenis_bangunan;
    }

    public String getJenis_fungsi_bangunan() {
        return jenis_fungsi_bangunan;
    }

    public void setJenis_fungsi_bangunan(String jenis_fungsi_bangunan) {
        this.jenis_fungsi_bangunan = jenis_fungsi_bangunan;
    }

    public String getNama_departemen() {
        return nama_departemen;
    }

    public void setNama_departemen(String nama_departemen) {
        this.nama_departemen = nama_departemen;
    }

    public String getAlamat_departemen() {
        return alamat_departemen;
    }

    public void setAlamat_departemen(String alamat_departemen) {
        this.alamat_departemen = alamat_departemen;
    }

    public String getNo_ikmn() {
        return no_ikmn;
    }

    public void setNo_ikmn(String no_ikmn) {
        this.no_ikmn = no_ikmn;
    }

    public String getNo_hdno() {
        return no_hdno;
    }

    public void setNo_hdno(String no_hdno) {
        this.no_hdno = no_hdno;
    }

    public String getTelpon() {
        return telpon;
    }

    public void setTelpon(String telpon) {
        this.telpon = telpon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate_input() {
        return date_input;
    }

    public void setDate_input(String date_input) {
        this.date_input = date_input;
    }

    public String getNama_bangunan() {
        return nama_bangunan;
    }

    public void setNama_bangunan(String nama_bangunan) {
        this.nama_bangunan = nama_bangunan;
    }

    public String getAlamat_bangunan() {
        return alamat_bangunan;
    }

    public void setAlamat_bangunan(String alamat_bangunan) {
        this.alamat_bangunan = alamat_bangunan;
    }

    public String getKlasifikasi_bangunan() {
        return klasifikasi_bangunan;
    }

    public void setKlasifikasi_bangunan(String klasifikasi_bangunan) {
        this.klasifikasi_bangunan = klasifikasi_bangunan;
    }

    public String getJumlah_lantai_bangunan() {
        return jumlah_lantai_bangunan;
    }

    public void setJumlah_lantai_bangunan(String jumlah_lantai_bangunan) {
        this.jumlah_lantai_bangunan = jumlah_lantai_bangunan;
    }

    public String getLuas_lantai_bangunan() {
        return luas_lantai_bangunan;
    }

    public void setLuas_lantai_bangunan(String luas_lantai_bangunan) {
        this.luas_lantai_bangunan = luas_lantai_bangunan;
    }

    public String getLuas_basement() {
        return luas_basement;
    }

    public void setLuas_basement(String luas_basement) {
        this.luas_basement = luas_basement;
    }

    public String getKetinggian_bangunan() {
        return ketinggian_bangunan;
    }

    public void setKetinggian_bangunan(String ketinggian_bangunan) {
        this.ketinggian_bangunan = ketinggian_bangunan;
    }

    public String getDate_selesai() {
        return date_selesai;
    }

    public void setDate_selesai(String date_selesai) {
        this.date_selesai = date_selesai;
    }

    public String getNama_pemilik_tanah() {
        return nama_pemilik_tanah;
    }

    public void setNama_pemilik_tanah(String nama_pemilik_tanah) {
        this.nama_pemilik_tanah = nama_pemilik_tanah;
    }

    public String getNo_ipt() {
        return no_ipt;
    }

    public void setNo_ipt(String no_ipt) {
        this.no_ipt = no_ipt;
    }

    public String getNo_bkt() {
        return no_bkt;
    }

    public void setNo_bkt(String no_bkt) {
        this.no_bkt = no_bkt;
    }

    public String getJenis_kepemilikan_tanah() {
        return jenis_kepemilikan_tanah;
    }

    public void setJenis_kepemilikan_tanah(String jenis_kepemilikan_tanah) {
        this.jenis_kepemilikan_tanah = jenis_kepemilikan_tanah;
    }

    public String getAlamat_tanah() {
        return alamat_tanah;
    }

    public void setAlamat_tanah(String alamat_tanah) {
        this.alamat_tanah = alamat_tanah;
    }

    public String getLuas_tanah() {
        return luas_tanah;
    }

    public void setLuas_tanah(String luas_tanah) {
        this.luas_tanah = luas_tanah;
    }

    public String getData_peruntukan_resmi() {
        return data_peruntukan_resmi;
    }

    public void setData_peruntukan_resmi(String data_peruntukan_resmi) {
        this.data_peruntukan_resmi = data_peruntukan_resmi;
    }

    public String getKdb() {
        return kdb;
    }

    public void setKdb(String kdb) {
        this.kdb = kdb;
    }

    public String getKlb() {
        return klb;
    }

    public void setKlb(String klb) {
        this.klb = klb;
    }

    public String getKdh() {
        return kdh;
    }

    public void setKdh(String kdh) {
        this.kdh = kdh;
    }

    public String getKtb() {
        return ktb;
    }

    public void setKtb(String ktb) {
        this.ktb = ktb;
    }

    public String getNama_departemen_dulu() {
        return nama_departemen_dulu;
    }

//    public String getNo_ikmn_dulu() {return no_ikmn_dulu;}
//    public void setNo_ikmn_dulu(String no_ikmn_dulu) {
//        this.no_ikmn_dulu = no_ikmn_dulu;
//    }
//
//    public String getNo_hdno_dulu() {return no_hdno_dulu;}
//    public void setNo_hdno_dulu(String no_hdno_dulu) {
//        this.no_hdno_dulu = no_hdno_dulu;
//    }

    public void setNama_departemen_dulu(String nama_departemen_dulu) {
        this.nama_departemen_dulu = nama_departemen_dulu;
    }

    public String getAlamat_departemen_dulu() {
        return alamat_departemen_dulu;
    }

    public void setAlamat_departemen_dulu(String alamat_departemen_dulu) {
        this.alamat_departemen_dulu = alamat_departemen_dulu;
    }

    public String getTelpon_dulu() {
        return telpon_dulu;
    }

    public void setTelpon_dulu(String telpon_dulu) {
        this.telpon_dulu = telpon_dulu;
    }

    public String getEmail_dulu() {
        return email_dulu;
    }

    public void setEmail_dulu(String email_dulu) {
        this.email_dulu = email_dulu;
    }

    public String getNo_imb_terdahulu() {
        return no_imb_terdahulu;
    }

    public void setNo_imb_terdahulu(String no_imb_terdahulu) {
        this.no_imb_terdahulu = no_imb_terdahulu;
    }

    public String getNo_islf_terdahulu() {
        return no_islf_terdahulu;
    }

    public void setNo_islf_terdahulu(String no_islf_terdahulu) {
        this.no_islf_terdahulu = no_islf_terdahulu;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama);
        dest.writeString(this.id_bangunan);
        dest.writeInt(this.id_reference);
        dest.writeString(this.fungsi_bangunan);
        dest.writeString(this.jenis_bangunan);
        dest.writeString(this.jenis_fungsi_bangunan);
        dest.writeString(this.nama_departemen);
        dest.writeString(this.alamat_departemen);
        dest.writeString(this.no_ikmn);
        dest.writeString(this.no_hdno);
        dest.writeString(this.telpon);
        dest.writeString(this.email);
        dest.writeString(this.date_input);
        dest.writeString(this.nama_bangunan);
        dest.writeString(this.alamat_bangunan);
        dest.writeString(this.fungsi_bangunan);
        dest.writeString(this.klasifikasi_bangunan);
        dest.writeString(this.jumlah_lantai_bangunan);
        dest.writeString(this.luas_lantai_bangunan);
        dest.writeString(this.luas_basement);
        dest.writeString(this.ketinggian_bangunan);
        dest.writeString(this.date_selesai);
        dest.writeString(this.nama_pemilik_tanah);
        dest.writeString(this.no_ipt);
        dest.writeString(this.no_bkt);
        dest.writeString(this.jenis_kepemilikan_tanah);
        dest.writeString(this.alamat_tanah);
        dest.writeString(this.luas_tanah);
        dest.writeString(this.data_peruntukan_resmi);
        dest.writeString(this.kdb);
        dest.writeString(this.klb);
        dest.writeString(this.kdh);
        dest.writeString(this.ktb);
        dest.writeString(this.nama_departemen_dulu);
        dest.writeString(this.alamat_departemen_dulu);
        dest.writeString(this.no_ikmn_dulu);
        dest.writeString(this.no_hdno_dulu);
        dest.writeString(this.telpon_dulu);
        dest.writeString(this.email_dulu);
        dest.writeString(this.no_imb_terdahulu);
        dest.writeString(this.no_islf_terdahulu);
        dest.writeString(this.latitude);
        dest.writeString(this.longitude);
    }
}
//    @SerializedName("id_bangunan")
//    @Expose
//    private String id_bangunan;
//
//    @SerializedName("fungsi_bangunan")
//    @Expose
//    private String fungsi_bangunan;
//
//    @SerializedName("jenis_bangunan")
//    @Expose
//    private String jenis_bangunan;
//
//    @SerializedName("jenis_fungsi_bangunan")
//    @Expose
//    private String jenis_fungsi_bangunan;
//
//    @SerializedName("nama_departemen")
//    @Expose
//    private String nama_departemen;
//
//    @SerializedName("alamat_departemen")
//    @Expose
//    private String alamat_departemen;
//
//    @SerializedName("no_ikmn")
//    @Expose
//    private String no_ikmn;
//
//    @SerializedName("no_hdno")
//    @Expose
//    private String no_hdno;
//
//    @SerializedName("telpon")
//    @Expose
//    private String telpon;
//
//    @SerializedName("email")
//    @Expose
//    private String email;
//
//    @SerializedName("date_input")
//    @Expose
//    private String date_input;
//
//    @SerializedName("nama_bangunan")
//    @Expose
//    private String nama_bangunan;
//
//    @SerializedName("alamat_bangunan")
//    @Expose
//    private String alamat_bangunan;
//
//    @SerializedName("klasifikasi_bangunan")
//    @Expose
//    private String klasifikasi_bangunan;
//
//    @SerializedName("luas_lantai_bangunan")
//    @Expose
//    private String luas_lantai_bangunan;
//
//    @SerializedName("ketinggian_bangunan")
//    @Expose
//    private String ketinggian_bangunan;
//
//    @SerializedName("luas_basement")
//    @Expose
//    private String luas_basement;
//
//    @SerializedName("jumlah_basement")
//    @Expose
//    private String jumlah_basement;
//
//    @SerializedName("longitude")
//    @Expose
//    private String longitude;
//
//    @SerializedName("latitude")
//    @Expose
//    private String latitude;
//
//    @SerializedName("date_selesai")
//    @Expose
//    private String date_selesai;
//
//    @SerializedName("nama_pemilik_tanah")
//    @Expose
//    private String nama_pemilik_tanah;
//
//    @SerializedName("no_ipt")
//    @Expose
//    private String no_ipt;
//
//    @SerializedName("no_bkt")
//    @Expose
//    private String no_bkt;
//
//    @SerializedName("jenis_kepemilikan_tanah")
//    @Expose
//    private String jenis_kepemilikan_tanah;
//
//    @SerializedName("alamat_tanah")
//    @Expose
//    private String alamat_tanah;
//
//    @SerializedName("luas_tanah")
//    @Expose
//    private String luas_tanah;
//
//    @SerializedName("data_peruntukan_resmi")
//    @Expose
//    private String data_peruntukan_resmi;
//
//    @SerializedName("kdb")
//    @Expose
//    private String kdb;
//
//    @SerializedName("klb")
//    @Expose
//    private String klb;
//
//    @SerializedName("kdh")
//    @Expose
//    private String kdh;
//
//    @SerializedName("ktb")
//    @Expose
//    private String ktb;
//
//    @SerializedName("nama_departemen_dulu")
//    @Expose
//    private String nama_departemen_dulu;
//
//    @SerializedName("telpon_dulu")
//    @Expose
//    private String telpon_dulu;
//
//    @SerializedName("email_dulu")
//    @Expose
//    private String email_dulu;
//
//    @SerializedName("no_imb_terdahulu")
//    @Expose
//    private String no_imb_terdahulu;
//
//    @SerializedName("no_islf_terdahulu")
//    @Expose
//    private String no_islf_terdahulu;
//
//    @SerializedName("nama")
//    private String nama;
//
//
//    public Bangunan(String id_bangunan, String fungsi_bangunan, String jenis_bangunan, String jenis_fungsi_bangunan, String nama_departemen, String alamat_departemen,
//                    String no_ikmn, String no_hdno, String telpon, String email, String date_input, String nama_bangunan,
//                    String alamat_bangunan, String klasifikasi_bangunan, String luas_lantai_bangunan, String ketinggian_bangunan,
//                    String luas_basement, String jumlah_basement, String latitude, String longitude, String date_selesai, String nama_pemilik_tanah,
//                    String alamat_tanah, String luas_tanah, String data_peruntukan_resmi, String kdb, String klb, String kdh,
//                    String ktb, String nama_departemen_dulu, String telpon_dulu, String email_dulu, String no_imb_terdahulu,
//                    String no_islf_terdahulu) {
//
//        this.id_bangunan = id_bangunan;
//        this.fungsi_bangunan = fungsi_bangunan;
//        this.jenis_bangunan = jenis_bangunan;
//        this.jenis_fungsi_bangunan = jenis_fungsi_bangunan;
//        this.nama_departemen = nama_departemen;
//        this.alamat_departemen = alamat_departemen;
//        this.no_ikmn = no_ikmn;
//        this.no_hdno = no_hdno;
//        this.telpon = telpon;
//        this.email = email;
//        this.date_input = date_input;
//        this.nama_bangunan = nama_bangunan;
//        this.alamat_bangunan = alamat_bangunan;
//        this.klasifikasi_bangunan = klasifikasi_bangunan;
//        this.luas_lantai_bangunan = luas_lantai_bangunan;
//        this.ketinggian_bangunan = ketinggian_bangunan;
//        this.luas_basement = luas_basement;
//        this.jumlah_basement = jumlah_basement;
//        this.longitude = longitude;
//        this.latitude = latitude;
//        this.date_selesai = date_selesai;
//        this.nama_pemilik_tanah = nama_pemilik_tanah;
//        this.alamat_tanah = alamat_tanah;
//        this.luas_tanah = luas_tanah;
//        this.data_peruntukan_resmi = data_peruntukan_resmi;
//        this.kdb = kdb;
//        this.klb = klb;
//        this.kdh = kdh;
//        this.ktb = ktb;
//        this.nama_departemen_dulu = nama_departemen_dulu;
//        this.telpon_dulu = telpon_dulu;
//        this.email_dulu = email_dulu;
//        this.no_imb_terdahulu = no_imb_terdahulu;
//        this.no_islf_terdahulu = no_islf_terdahulu;
//
//    }
//
//    public String getId_bangunan() {
//        return id_bangunan;
//    }
//
//    public void setId_bangunan(String id_bangunan) {
//        this.id_bangunan = id_bangunan;
//    }
//
//    public String getFungsi_bangunan() {
//        return fungsi_bangunan;
//    }
//
//    public void setFungsi_bangunan(String fungsi_bangunan) {this.fungsi_bangunan = fungsi_bangunan;
//    }
//
//    public String getJenis_bangunan() {
//        return jenis_bangunan;
//    }
//
//    public void setJenis_bangunan(String jenis_bangunan) {this.jenis_bangunan = jenis_bangunan;
//    }
//
//    public String getJenis_fungsi_bangunan() {
//        return jenis_fungsi_bangunan;
//    }
//    public void setJenis_fungsi_bangunan(String jenis_fungsi_bangunan) {this.jenis_fungsi_bangunan = jenis_fungsi_bangunan;
//    }
//
//    public String getNama_departemen() {
//        return nama_departemen;
//    }
//    public void setNama_departemen(String nama_departemen) {
//        this.nama_departemen = nama_departemen;
//    }
//
//    public String getAlamat_departemen() {
//        return alamat_departemen;
//    }
//    public void setAlamat_departemen(String alamat_departemen) {
//        this.alamat_departemen = alamat_departemen;
//    }
//
//    public String getNo_ikmn() {
//        return no_ikmn;
//    }
//
//    public void setNo_ikmn(String no_ikmn) {
//        this.no_ikmn = no_ikmn;
//    }
//
//    public String getNo_hdno() {
//        return no_hdno;
//    }
//
//    public void setNo_hdno(String no_hdno) {
//        this.no_hdno = no_hdno;
//    }
//
//    public String getTelpon() {
//        return telpon;
//    }
//
//    public void setTelpon(String telpon) {
//        this.telpon = telpon;
//    }
//
//    public String getEmail() {return email;}
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getDate_input() {
//        return date_input;
//    }
//
//    public void setDate_input(String date_input) {
//        this.email = email;
//    }
//
//    public String getNama_bangunan() {return nama_bangunan;}
//
//    public void setNama_bangunan(String nama_bangunan) {
//        this.nama_bangunan = nama_bangunan;
//    }
//
//    public String getAlamat_bangunan() {
//        return alamat_bangunan;
//    }
//
//    public void setAlamat_bangunan(String alamat_bangunan) {
//        this.alamat_bangunan = alamat_bangunan;
//    }
//
//    public String getKlasifikasi_bangunan() {
//        return klasifikasi_bangunan;
//    }
//
//    public void setKlasifikasi_bangunan(String klasifikasi_bangunan) {
//        this.klasifikasi_bangunan = klasifikasi_bangunan;
//    }
//    public String getLuas_lantai_bangunan() {
//        return luas_lantai_bangunan;
//    }
//
//    public void setLuas_lantai_bangunan(String luas_lantai_bangunan) {
//        this.luas_lantai_bangunan = luas_lantai_bangunan;
//    }
//
//    public String getKetinggian_bangunan() {
//        return ketinggian_bangunan;
//    }
//
//    public void setKetinggian_bangunan(String ketinggian_bangunan) {
//        this.ketinggian_bangunan = ketinggian_bangunan;
//    }
//
//    public String getLuas_basement() {
//        return luas_basement;
//    }
//
//    public void setLuas_basement(String luas_lantai_bangunan) {
//        this.luas_lantai_bangunan = luas_lantai_bangunan;
//    }
//
//    public String getJumlah_basement() {
//        return jumlah_basement;
//    }
//
//    public void setJumlah_basement(String jumlah_basement) {
//        this.jumlah_basement = jumlah_basement;
//    }
//
//    public String getLongitude() {
//        return longitude;
//    }
//
//    public void setLongitude(String longitude) {
//        this.longitude = longitude;
//    }
//    public String getLatitude() {
//        return latitude;
//    }
//
//    public void setLatitude(String latitude) {
//        this.latitude = latitude;
//    }
//
//    public String getDate_selesai() {
//        return date_selesai;
//    }
//
//    public void setDate_selesai(String date_selesai) {
//        this.date_selesai = date_selesai;
//    }
//
//    public String getNama_pemilik_tanah() {
//        return getNama_pemilik_tanah();
//    }
//
//    public void setNama_pemilik_tanah(String nama_pemilik_tanah) {
//        this.nama_pemilik_tanah = nama_pemilik_tanah;
//    }
//
//    public String getNo_ipt() {
//        return no_ipt;
//    }
//
//    public void setNo_ipt(String no_ipt) {
//        this.no_ipt = no_ipt;
//    }
//
//    public String getNo_bkt() {
//        return no_bkt;
//    }
//
//    public void setNo_bkt(String no_bkt) {
//        this.no_bkt = no_bkt;
//    }
//
//    public String getJenis_kepemilikan_tanah() {
//        return jenis_kepemilikan_tanah;
//    }
//
//    public void setJenis_kepemilikan_tanah(String jenis_kepemilikan_tanah) {
//        this.jenis_kepemilikan_tanah = jenis_kepemilikan_tanah;
//    }
//    public String getAlamat_tanah() {
//        return alamat_tanah;
//    }
//
//    public void setAlamat_tanah(String alamat_tanah) {
//        this.alamat_tanah = alamat_tanah;
//    }
//
//    public String getLuas_tanah() {
//        return luas_tanah;
//    }
//
//    public void setLuas_tanah(String luas_tanah) {
//        this.luas_tanah = luas_tanah;
//    }
//
//    public String getData_peruntukan_resmi() {
//        return getData_peruntukan_resmi();
//    }
//
//    public void setData_peruntukan_resmi(String data_peruntukan_resmi) {
//        this.data_peruntukan_resmi = data_peruntukan_resmi;
//    }
//    public String getKdb() {
//        return kdb;
//    }
//
//    public void setKdb(String kdb) {
//        this.kdb = kdb;
//    }
//
//
//    public String getKdh() {return kdh ;
//    }
//    public void setKdh(String Kdh) {
//        this.kdh = kdh;
//    }
////
////    public String () {return kdh;
////    }
////
////    public void setKlb(String klb) {
////        this.klb = klb;
////    }
//
//    public String getKlb() {
//        return klb;
//    }
//    public void setKlb(String klb) {
//        this.klb = klb;
//    }
//
//
//    public void setKtb(String ktb) {
//        this.ktb = ktb;
//    }
//    public String getktb() {
//        return ktb;
//    }
//
//    public String getNama_departemen_dulu() {
//        return nama_departemen_dulu;
//    }
//    public void setNama_departemen_dulu(String nama_departemen_dulu) {
//        this.nama_departemen_dulu = nama_departemen_dulu;
//    }
//
//    public String getTelpon_dulu() {
//        return telpon_dulu;
//    }
//
//    public void setTelpon_dulu(String telpon_dulu) {
//        this.telpon_dulu = telpon_dulu;
//    }
//
//    public String getEmail_dulu() {
//        return email_dulu;
//    }
//
//    public void setEmail_dulu(String email_dulu) {
//        this.email_dulu = email_dulu;
//    }
//
//    public String getNo_imb_terdahulu() {
//        return no_imb_terdahulu;
//    }
//
//    public void setNo_imb_terdahulu(String imb_terdahulu) {
//        this.no_imb_terdahulu = imb_terdahulu;
//    }
//
//
//
//    public String getNo_islf_terdahulu() {
//        return no_islf_terdahulu;
//    }
//    public void setNo_islf_terdahulu(String no_islf_terdahulu) {
//        this.no_islf_terdahulu = no_islf_terdahulu;
//    }
//
//    public void setNama(String name){
//        this.nama = nama;
//    }
//
//    public String getNama(){
//        return nama;
//    }
//
//    @Override
//    public String toString(){
//        return
//                "Bangunan{" +
//                        "id_bangunan = '" + id_bangunan+ '\'' +
//                        ",nama_departemen = '" + nama_departemen+ '\'' +
//                        ",fungsi_bangunan = '" + fungsi_bangunan+ '\'' +
//                        ",jenis_bangunan = '" + jenis_bangunan+ '\'' +
//                        ",jenis_fungsi_bangunan = '" + jenis_fungsi_bangunan+ '\'' +
//
//                        ",nama_departemen = '" + nama_departemen+ '\'' +
//                        ",alamat_departemen= '" + alamat_departemen + '\'' +
//                        ",no_ikmn = '" + no_ikmn + '\'' +
//                        ",no_hdno = '" + no_hdno + '\'' +
//                        ",telpon = '" + telpon + '\'' +
//                        ",email = '" + email + '\'' +
//                        ",date_input = '" + date_input + '\'' +
//
//                        ",nama_bangunan = '" + nama_bangunan + '\'' +
//                        ",alamat_bangunan = '" + alamat_bangunan + '\'' +
//                        ",klasifikasi_bangunan = '" + klasifikasi_bangunan + '\'' +
//                        ",luas_lantai_bangunan = '" + luas_lantai_bangunan + '\'' +
//                        ",ketinggian_bangunan = '" + ketinggian_bangunan+ '\'' +
//                        ",luas_basement = '" + luas_basement+ '\'' +
//                        ",jumlah_basement = '" + jumlah_basement + '\'' +
//
//                        ",latitude = '" + latitude + '\'' +
//                        ",longitude = '" + longitude + '\'' +
//                        ",date_selesai = '" + date_selesai + '\'' +
//                        ",nama_pemilik_tanah= '" + nama_pemilik_tanah + '\'' +
//                        ",no_ipt = '" + no_ipt + '\'' +
//                        ",no_bkt = '" + no_bkt + '\'' +
//                        ",jenis_kepemilikan_tanah = '" + jenis_kepemilikan_tanah + '\'' +
//                        ",alamat_tanah = '" + alamat_tanah + '\'' +
//                        ",luas_tanah = '" + luas_tanah + '\'' +
//                        ",data_peruntukan_resmi = '" + data_peruntukan_resmi + '\'' +
//                        ",kdb = '" + kdb + '\'' +
//                        ",klb = '" + klb + '\'' +
//                        ",kdh = '" + kdh + '\'' +
//                        ",ktb = '" + ktb + '\'' +
//                        ",nama_departemen_dulu = '" + nama_departemen_dulu + '\'' +
//                        ",alamat_departemen_dulu = '" + nama_departemen_dulu + '\'' +
//                        ",telpon_dulu = '" + telpon_dulu + '\'' +
//                        ",email_dulu = '" + email_dulu + '\'' +
//                        ",no_imb_terdahulu = '" + no_imb_terdahulu + '\'' +
//                        ",no_islf_terdahulu = '" + no_islf_terdahulu + '\'' +
//                        "}";
//    }
//
//
//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    @Override
//    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeString(this.id_bangunan);
//        dest.writeString(this.fungsi_bangunan);
//        dest.writeString(this.jenis_bangunan);
//        dest.writeString(this.jenis_fungsi_bangunan);
//        dest.writeString(this.nama_departemen);
//        dest.writeString(this.alamat_departemen);
//        dest.writeString(this.no_ikmn);
//        dest.writeString(this.no_hdno);
//        dest.writeString(this.telpon);
//        dest.writeString(this.email);
//        dest.writeString(this.date_input);
//        dest.writeString(this.email);
//        dest.writeString(this.date_input);
//        dest.writeString(this.nama_bangunan);
//        dest.writeString(this.alamat_bangunan);
//        dest.writeString(this.klasifikasi_bangunan);
//        dest.writeString(this.luas_lantai_bangunan);
//        dest.writeString(this.ketinggian_bangunan);
//        dest.writeString(this.luas_basement);
//        dest.writeString(this.longitude);
//        dest.writeString(this.latitude);
//        dest.writeString(this.date_selesai);
//        dest.writeString(this.nama_pemilik_tanah);
//        dest.writeString(this.no_ipt);
//        dest.writeString(this.no_bkt);
//        dest.writeString(this.jenis_kepemilikan_tanah);
//        dest.writeString(this.alamat_tanah);
//        dest.writeString(this.luas_tanah);
//        dest.writeString(this.data_peruntukan_resmi);
//        dest.writeString(this.kdb);
//        dest.writeString(this.klb);
//        dest.writeString(this.kdh);
//        dest.writeString(this.ktb);
//        dest.writeString(this.nama_departemen_dulu);
//        dest.writeString(this.telpon_dulu);
//        dest.writeString(this.email_dulu);
//        dest.writeString(this.no_imb_terdahulu);
//        dest.writeString(this.no_islf_terdahulu);
//        dest.writeString(this.nama);
//
//    }
//    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
//        public Bangunan createFromParcel(Parcel in) {
//            return new Bangunan(in);
//        }
//
//        public Bangunan[] newArray(int size) {
//            return new Bangunan[size];
//        }
//    };
//
//
//    public Bangunan(Parcel in) {
//        this.id_bangunan = in.readString();
//        this.fungsi_bangunan = in.readString();
//        this.jenis_bangunan = in.readString();
//        this.jenis_fungsi_bangunan = in.readString();
//        this.nama_departemen = in.readString();
//        this.alamat_departemen = in.readString();
//        this.no_ikmn = in.readString();
//        this.no_hdno = in.readString();
//        this.telpon = in.readString();
//        this.email = in.readString();
//        this.date_input = in.readString();
//        this.nama_bangunan = in.readString();
//        this.alamat_bangunan = in.readString();
//        this.klasifikasi_bangunan = in.readString();
//        this.luas_lantai_bangunan = in.readString();
//        this.ketinggian_bangunan = in.readString();
//        this.luas_basement = in.readString();
//        this.longitude = in.readString();
//        this.latitude = in.readString();
//        this.date_selesai = in.readString();
//        this.nama_pemilik_tanah = in.readString();
//        this.no_ipt = in.readString();
//        this.no_bkt = in.readString();
//        this.jenis_kepemilikan_tanah = in.readString();
//        this.alamat_tanah = in.readString();
//        this.luas_tanah = in.readString();
//        this.data_peruntukan_resmi = in.readString();
//        this.kdb = in.readString();
//        this.klb = in.readString();
//        this.kdh = in.readString();
//        this.ktb = in.readString();
//        this.nama_departemen_dulu = in.readString();
//        this.telpon_dulu = in.readString();
//        this.email_dulu = in.readString();
//        this.no_imb_terdahulu = in.readString();
//        this.no_islf_terdahulu = in.readString();
//        this.nama = in.readString();
//
//    }
//}
