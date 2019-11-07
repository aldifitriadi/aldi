package com.example.alfhanrf.skripsihehe;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.alfhanrf.skripsihehe.base.BaseActivity;
import com.example.alfhanrf.skripsihehe.model.bangungedung.Bangunan;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailBangun extends BaseActivity {

    @BindView(R.id.txtDetailSurveyor)
    TextView txtsurveyor;
    @BindView(R.id.txtFungsiGedung)
    TextView txtFungsiGedung;
    @BindView(R.id.txtJenisGedung)
    TextView txtJenisGedung;
    @BindView(R.id.txtJenisFungsi)
    TextView txtJenisFungsi;

    @BindView(R.id.txtNamaDepar)
    TextView txtNamaDepar;
    @BindView(R.id.txtAlmtDepar)
    TextView txtAlmtDepar;
    @BindView(R.id.txtNoIkmn)
    TextView txtNoIkmn;
    @BindView(R.id.txtNoHdno)
    TextView txtNoHdno;
    @BindView(R.id.txtTelponBgnGedung)
    TextView txtTelponBgnGedung;

    @BindView(R.id.txtImeil)
    TextView txtImeil;

    @BindView(R.id.txtNamBang)
    TextView txtNamBang;
    @BindView(R.id.txtAlamatBangunan)
    TextView txtAlamatBangunan;
    @BindView(R.id.txtFungsiBangun)
    TextView txtFungsiBangun;
    @BindView(R.id.txtSpinnerKlasifikasigedung)
    TextView txtSpinnerKlasifikasiGedung;
    @BindView(R.id.txtJumlahLantai)
    TextView txtJumlahLantai;
    @BindView(R.id.txtLuasLantai)
    TextView txtLuasLantai;
    @BindView(R.id.txtKetinggianBangun)
    TextView txtKetinggianGedung;
    @BindView(R.id.txtTglMulaiSelesai)
    TextView txtSelesaiMulai;

    @BindView(R.id.txtNamaPemilik)
    TextView txtNamaPemilik;
    @BindView(R.id.txtNomorIdentitas)
    TextView txtNoIdentitas;
    @BindView(R.id.txtNoBuktiKepemilikanTanah)
    TextView txtButkiKepemilikanTanah;
    @BindView(R.id.txtSpinnerjenispemiliktanah)
    TextView txtJenisKepemilikanGedung;
    @BindView(R.id.txtAlmtTanah)
    TextView txtAlmtTanah;
    @BindView(R.id.txtLuasTanah)
    TextView txtLuasTanah;
    @BindView(R.id.txtDataPeruntukanResmi)
    TextView txtDataPeruntukanResmi;
    @BindView(R.id.txtKDB)
    TextView txtKDB;
    @BindView(R.id.txtKLB)
    TextView txtKLB;
    @BindView(R.id.txtKDH)
    TextView txtKDH;
    @BindView(R.id.txtKTB)
    TextView txtKTB;

    @BindView(R.id.txtNamaDeparTerdahulu)
    TextView txtNamaDeparDulu;

    @BindView(R.id.txtAlmtDeparTerdahulu)
    TextView txtAlmtDeparTerdahulu;

    @BindView(R.id.txtTelponTerdahulu)
    TextView txtTelponDulu;
    @BindView(R.id.txtEmailTerdahulu)
    TextView txtEmailDulu;

    @BindView(R.id.txtNoImbTerdahulu)
    TextView txtNoImbDulu;
    @BindView(R.id.txtNoSlfTerdahulu)
    TextView txtNoSlfTerdahulu;
    MainActivity mainActivity;
    private String id_bangunan;
    private Bangunan bangunan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_bangun);
        ButterKnife.bind(this);
//        TextView txtNamaDepar = findViewById(R.id.txtNamaDepar);
//        TextView txtAlmtBangun = findViewById(R.id.txtAlmtBangun);
//        TextView txtTelponBgnGedung = findViewById(R.id.txtTelponBgnGedung);
//        TextView txtNamaBangun = findViewById(R.id.txtNamaBangun);
        mainActivity = new MainActivity();

        setTitle("Detail Bangunan");
        Bundle data = getIntent().getExtras();
        bangunan = data.getParcelable("bangunan");
        if (bangunan != null) {
            Log.d("hilih", bangunan.toString());

            id_bangunan = bangunan.getId_bangunan();


            txtsurveyor.setText(bangunan.getNama());
            txtFungsiGedung.setText(bangunan.getFungsi_bangunan());
            txtJenisGedung.setText(bangunan.getJenis_bangunan());
            txtJenisFungsi.setText(bangunan.getJenis_fungsi_bangunan());
            txtNamaDepar.setText(bangunan.getNama_departemen());
            txtAlmtDepar.setText(bangunan.getAlamat_departemen());
            txtNoIkmn.setText(bangunan.getNo_ikmn());
            txtNoHdno.setText(bangunan.getNo_hdno());
            txtTelponBgnGedung.setText(bangunan.getTelpon());
            txtImeil.setText(bangunan.getEmail());
            txtNamBang.setText(bangunan.getNama_bangunan());
            txtAlamatBangunan.setText(bangunan.getAlamat_bangunan());
            txtFungsiBangun.setText(bangunan.getFungsi_bangunan());
            txtSpinnerKlasifikasiGedung.setText(bangunan.getKlasifikasi_bangunan());
            txtJumlahLantai.setText(bangunan.getJumlah_lantai_bangunan());
            txtLuasLantai.setText(bangunan.getLuas_lantai_bangunan() + "m2");
            txtKetinggianGedung.setText(bangunan.getKetinggian_bangunan() + "m");
            txtSelesaiMulai.setText(bangunan.getDate_selesai());

            txtNamaPemilik.setText(bangunan.getNama_pemilik_tanah());
            txtNoIdentitas.setText(bangunan.getNo_ipt());
            txtButkiKepemilikanTanah.setText(bangunan.getNo_bkt());
            txtJenisKepemilikanGedung.setText(bangunan.getJenis_kepemilikan_tanah());
            txtAlmtTanah.setText(bangunan.getAlamat_tanah());
            txtLuasTanah.setText(bangunan.getLuas_tanah() + "m2");
            txtDataPeruntukanResmi.setText(bangunan.getData_peruntukan_resmi());
            txtKDB.setText(bangunan.getKdb());
            txtKLB.setText(bangunan.getKlb());
            txtKDH.setText(bangunan.getKdh());
            txtKTB.setText(bangunan.getKtb());

            txtNamaDeparDulu.setText(bangunan.getNama_departemen_dulu());
            txtAlmtDeparTerdahulu.setText(bangunan.getAlamat_departemen_dulu());
            txtTelponDulu.setText(bangunan.getTelpon_dulu());
            txtEmailDulu.setText(bangunan.getEmail_dulu());
            txtNoImbDulu.setText(bangunan.getNo_imb_terdahulu());
            txtNoSlfTerdahulu.setText(bangunan.getNo_islf_terdahulu());

//            id_bangunan = bangunan.getId_bangunan();
//            txtFungsiGedung.setText(bangunan.getFungsi_bangunan());
//            txtJenisGedung.setText(bangunan.getJenis_bangunan());
//            txtJenisFungsi.setText(bangunan.getJenis_fungsi_bangunan());
//
//            txtNamaDepar.setText(bangunan.getNama_departemen());
//            txtAlmtDepar.setText(bangunan.getAlamat_departemen());
//            txtNoIkmn.setText(bangunan.getNo_ikmn());
//            txtNoHdno.setText(bangunan.getNo_hdno());
//            txtTelponBgnGedung.setText(bangunan.getTelpon());
//            txtImeil.setText(bangunan.getEmail());
////
//            txtNamBang.setText(bangunan.getNama_bangunan());
//            Log.d("nambang", bangunan.getNama_bangunan());
////
////            txtAlamatBangunan.setText(bangunan.getAlamat_bangunan());
////            Log.d("nambang1", bangunan.getAlamat_bangunan());
////
////            txtFungsiBangun.setText(bangunan.getFungsi_bangunan());
////            txtSpinnerKlasifikasiGedung.setText(bangunan.getFungsi_bangunan());
////            //jumlah lantai
////            txtLuasLantai.setText(bangunan.getLuas_lantai_bangunan());
////            txtKetinggianGedung.setText(bangunan.getKetinggian_bangunan());
////            txtSelesaiMulai.setText(bangunan.getDate_selesai());
//
////            txtNamaPemilik.setText(bangunan.getNama_pemilik_tanah());
//            // no identitas belom
//            // jenis kepemilikan tanah
////            txtAlmtTanah.setText(bangunan.getAlamat_tanah());
//////            txtDataPeruntukanResmi.setText(bangunan.getData_peruntukan_resmi());
////            txtKDB.setText(bangunan.getKdb());
////            txtKLB.setText(bangunan.getKlb());
////            txtKDH.setText(bangunan.getKdh());
////
////            // depar dulu belom
////            // almt depar dulu
////            txtTelponDulu.setText(bangunan.getTelpon_dulu());
//////            txtEmail.setText(bangunan.getEmail_dulu());
////
////            txtNoImbDulu.setText(bangunan.getNo_imb_terdahulu());
////            txtNoSlfTerdahulu.setText(bangunan.getNo_islf_terdahulu());


        }
    }
}


//        userSession = new UserSession(DetailBangun.this);
//
//        setTitle("Detail Bangunan");
//        Bundle data = getIntent().getExtras();
//        bangunan = data.getParcelable("bangunan");
//        Log.d("testnma", userSession.getUserName());
//        if (savedInstanceState != null) {
//            bangunan = savedInstanceState.getParcelable("bangunan");
//        } else {
//            getIntentExtras();
//        }
//    }
//    private void setValuetoField(UserSession userSession){
//         txtsurveyor.setText(userSession.getUserName());
////        txtDetailAlamat.setText(perusahaan.getAlamatPerusahaan());
////        txtDetailWilayah.setText(perusahaan.getWilayah());
////        txtDetailSektor.setText(perusahaan.getSektor());
////        txtDetailPekerja.setText(perusahaan.getJmlPekerja());
////        txtDetailUMP.setText(changeValue(perusahaan.getUmpStatus()));
////        txtDetailUMSP.setText(changeValue(perusahaan.getUmspStatus()));
////        txtDetailSkala.setText(changeValue(perusahaan.getSsUpahStatus()));
////        txtDetailKeteg.setText(changeValue(perusahaan.getBpjsKtngStatus()));
////        txtDetailKes.setText(changeValue(perusahaan.getBpjsKhsStatus()));
////        txtDetailLuar.setText(changeValue(perusahaan.getJamsosHubLuarStatus()));
////        txtDetailMediator.setText(perusahaan.getName());
////        txtDetailKet.setText(perusahaan.getAddDesc());
//    }
//
//    private void getIntentExtras(){
//        userSession = getIntent().getExtras().getParcelable(ConstantsUtils.UserSession  );
//        if(userSession != null){
//            setValuetoField(userSession);
//        }
//    }
//    }
