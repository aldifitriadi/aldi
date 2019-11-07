package com.example.alfhanrf.skripsihehe;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.example.alfhanrf.skripsihehe.adapter.RecycleViewAdapterBangunan;
import com.example.alfhanrf.skripsihehe.base.BaseActivity;
import com.example.alfhanrf.skripsihehe.model.bangungedung.Bangunan;
import com.example.alfhanrf.skripsihehe.model.bangungedung.BangunanList;
import com.example.alfhanrf.skripsihehe.network.APIClient;
import com.example.alfhanrf.skripsihehe.network.APIInterface;
import com.example.alfhanrf.skripsihehe.sessionmanager.UserSession;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BangunanView extends BaseActivity implements SearchView.OnQueryTextListener {


    UserSession userSession;
    @BindView(R.id.recycleview)
    RecyclerView recyclerView;
    private List<Bangunan> bangunan = new ArrayList<>();
    private RecycleViewAdapterBangunan viewAdapterBangunan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bangunan_view);

        ButterKnife.bind(this);
        viewAdapterBangunan = new RecycleViewAdapterBangunan(this, bangunan, false);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(viewAdapterBangunan);


        loadDataBangunan();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadDataBangunan();
    }

    @Override
    public void onStop() {
        super.onStop();
    }


    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {

        getMenuInflater().inflate(R.menu.menu_search, menu);
        final MenuItem item = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setQueryHint("Cari Nama Bangunan");
        searchView.setIconified(false);
        searchView.setOnQueryTextListener(BangunanView.this);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        UserSession userSession = new UserSession(BangunanView.this);
        APIInterface apiInterface = APIClient.getClientAuthorize().create(APIInterface.class);


        try {
            JSONObject dataInside = new JSONObject();
            dataInside.put("bangunan", query);
            RequestBody requestBody = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), dataInside.toString());
            Call<ResponseBody> call = apiInterface.search(userSession.getUserToken(), userSession.getIdUser(), requestBody);
            call.enqueue(new Callback<ResponseBody>() {

                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {


//                    JsonObject jsonData = new JsonObject(json.);

                    try {


                        JsonParser parser = new JsonParser();
                        JsonObject jsonData = (JsonObject) parser.parse(response.body().string());
                        JsonArray jsonArray = jsonData.get("Bangunan").getAsJsonArray();

                        Log.d("onQueryTextSubmit", "onResponse: " + jsonData.get("Bangunan"));
                        recyclerView.setVisibility(View.VISIBLE);
                        bangunan.clear();
//                    bangunan.addAll(jsonData.get("bangunan"));

                        for (int z = 0; z < jsonArray.size(); z++) {

                            JsonObject data = jsonArray.get(z).getAsJsonObject();
                            Bangunan bgn = new Bangunan();
                            bgn.setNama(data.get("user_id").getAsString());
                            bgn.setFungsi_bangunan(data.get("fungsi_bangunan").getAsString());
                            bgn.setJenis_bangunan(data.get("jenis_bangunan").getAsString());
                            bgn.setJenis_fungsi_bangunan(data.get("jenis_fungsi_bangunan").getAsString());

                            bgn.setNama_bangunan(data.get("nama_bangunan").getAsString());
                            bgn.setAlamat_bangunan(data.get("alamat_bangunan").getAsString());
                            bgn.setFungsi_bangunan(data.get("fungsi_bangunan").getAsString());
                            bgn.setKlasifikasi_bangunan(data.get("klasifikasi_bangunan").getAsString());
                            bgn.setJumlah_lantai_bangunan(data.get("jumlah_lantai_bangunan").getAsString());
                            bgn.setLuas_lantai_bangunan(data.get("luas_lantai_bangunan").getAsString());
                            bgn.setKetinggian_bangunan(data.get("ketinggian_bangunan").getAsString());
                            bgn.setDate_selesai(data.get("date_selesai").getAsString());
//                        bgn.setLuas_basement(data.get("luas_basement").getAsString());

                            bgn.setNama_departemen(data.get("nama_departemen").getAsString());
                            bgn.setAlamat_departemen(data.get("alamat_departemen").getAsString());
                            bgn.setNo_ikmn(data.get("no_ikmn").getAsString());
                            bgn.setNo_hdno(data.get("no_hdno").getAsString());
                            bgn.setTelpon_dulu(data.get("telpon").getAsString());
                            bgn.setEmail(data.get("email").getAsString());

                            bgn.setNama_pemilik_tanah(data.get("nama_pemilik_tanah").getAsString());
                            bgn.setNo_ipt(data.get("no_ipt").getAsString());
                            bgn.setNo_bkt(data.get("no_bkt").getAsString());
                            bgn.setJenis_kepemilikan_tanah(data.get("jenis_kepemilikan_tanah").getAsString());
                            bgn.setAlamat_tanah(data.get("alamat_tanah").getAsString());
                            bgn.setLuas_tanah(data.get("luas_tanah").getAsString());
                            bgn.setData_peruntukan_resmi(data.get("data_peruntukan_resmi").getAsString());
                            bgn.setKdb(data.get("kdb").getAsString());
                            bgn.setKlb(data.get("klb").getAsString());
                            bgn.setKdh(data.get("kdh").getAsString());
                            bgn.setKtb(data.get("ktb").getAsString());

                            bgn.setNama_departemen_dulu(data.get("nama_departemen_dulu").getAsString());
                            bgn.setAlamat_departemen_dulu(data.get("alamat_departemen_dulu").getAsString());
                            bgn.setTelpon_dulu(data.get("telpon_dulu").getAsString());
                            bgn.setEmail_dulu(data.get("email_dulu").getAsString());

                            bgn.setNo_imb_terdahulu(data.get("no_imb_terdahulu").getAsString());
                            bgn.setNo_islf_terdahulu(data.get("no_islf_terdahulu").getAsString());

                            bangunan.add(bgn);
                        }

                        viewAdapterBangunan = new RecycleViewAdapterBangunan(BangunanView.this, bangunan, false);
                        viewAdapterBangunan.notifyDataSetChanged();
                        recyclerView.setAdapter(viewAdapterBangunan);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {

                }


            });

        } catch (JSONException e) {

        }


        return true;
    }


    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }


    public void loadDataBangunan() {

        UserSession userSession = new UserSession(BangunanView.this);
        mRegProgres.setTitle("Mendapatkan Data");
        mRegProgres.setMessage("Tunggu Sebentar... ");
        mRegProgres.setCanceledOnTouchOutside(false);
        mRegProgres.show();

        APIInterface apiInterface = APIClient.getClientAuthorize().create(APIInterface.class);
        Call<BangunanList> call = apiInterface.getSemuaBangunan(userSession.getUserToken(), userSession.getIdUser());
        call.enqueue(new Callback<BangunanList>() {
            @Override
            public void onResponse(Call<BangunanList> call, Response<BangunanList> response) {
                mRegProgres.dismiss();
                bangunan = response.body().getSemuaBangunan();
                viewAdapterBangunan = new RecycleViewAdapterBangunan(BangunanView.this, bangunan, false);
                recyclerView.setAdapter(viewAdapterBangunan);

            }

            @Override
            public void onFailure(Call<BangunanList> call, Throwable t) {

            }
        });
    }

}

