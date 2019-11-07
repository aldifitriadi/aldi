package com.example.alfhanrf.skripsihehe;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alfhanrf.skripsihehe.base.BaseActivity;
import com.example.alfhanrf.skripsihehe.model.bangungedung.Bangunan;
import com.example.alfhanrf.skripsihehe.model.bangungedung.BangunanList;
import com.example.alfhanrf.skripsihehe.network.APIClient;
import com.example.alfhanrf.skripsihehe.network.APIInterface;
import com.example.alfhanrf.skripsihehe.network.RequestResponse;
import com.example.alfhanrf.skripsihehe.sessionmanager.UserSession;
import com.example.alfhanrf.skripsihehe.utils.ConstantsUtils;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener, OnMapReadyCallback {

    private final String TAG = "MainActivity";
    public GoogleMap mMap;
    @BindView(R.id.txtIdUser)
    TextView IdUser;
    @BindView(R.id.txtNamaUser)
    TextView namaUser;
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    SupportMapFragment mapFragment;
    UserSession userSession;
    LatLng mLatlng;
    List<Bangunan> bangunan;
    HashMap<Marker, Bangunan> detailMarker = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        NavigationView navigationView = findViewById(R.id.nav_view);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        userSession = new UserSession(MainActivity.this);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header = navigationView.getHeaderView(0);
        namaUser = header.findViewById(R.id.txtNamaUser);
        namaUser.setText(userSession.getUserName());
        IdUser = header.findViewById(R.id.txtIdUser);
//        IdUser.setText(userSession.getUserId());
        IdUser.setText(userSession.getUserId());


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        checkRole();


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    private void checkRole() {
        userSession = new UserSession(MainActivity.this);
        //Surveyor = 2 , User Eksternal = 3
        String id = userSession.getUserRoleStr();
        Log.d("role", id);
        if (id.equals("3")) {
            hideItemNavigation();
        }
    }

    private void hideItemNavigation() {
        NavigationView navigationView = findViewById(R.id.nav_view);
        Menu nav_Menu = navigationView.getMenu();
        nav_Menu.findItem(R.id.nav_history).setVisible(false);
        nav_Menu.findItem(R.id.nav_input_data).setVisible(false);
    }

    private void logout() {
        userSession = new UserSession(MainActivity.this);
        mRegProgres.setTitle("Logout Account");
        mRegProgres.setMessage("Please Wait...");
        mRegProgres.setCanceledOnTouchOutside(false);
        mRegProgres.show();
        APIInterface apiInterface = APIClient.getClientAuthorize().create(APIInterface.class);
        Call<RequestResponse> call = apiInterface.logout(userSession.getUserToken(), userSession.getIdUser());
        call.enqueue(new Callback<RequestResponse>() {
            @Override
            public void onResponse(Call<RequestResponse> call, Response<RequestResponse> response) {
                try {
                    if (response.isSuccessful()) {
                        mRegProgres.dismiss();
                        Intent i = new Intent(MainActivity.this, Login.class);
                        // Closing all the Activities
                        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        // Add new Flag to start new Activity
                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        // Staring Login Activity
                        startActivity(i);
                        userSession.logoutUser();
                        finish();
                    } else {
                        mRegProgres.dismiss();
                        Log.d("haha", response.errorBody().string());

                    }
                } catch (Exception e) {
//                               Toast.makeText(EntityLogin.this,response.errorBody().toString(), Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<RequestResponse> call, Throwable t) {

            }

        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setCheckedItem(R.id.posisi_bangunan);


//     if (mMap == null) {
//         mapFragment1.getMapAsync(this);
    }

    @Override
    public void onBackPressed() {
        navigationView.setCheckedItem(R.id.posisi_bangunan);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            mRegProgres.setTitle("Mengambil Data");
            mRegProgres.setMessage("Harap Tunggu ..");
            Toast.makeText(MainActivity.this, "Berhasil Ambil Data", Toast.LENGTH_SHORT).show();
            mMap.clear();
            addMarkers();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.posisi_bangunan) {

        } else if (id == R.id.nav_input_data) {
            Intent surveybangun = new Intent(MainActivity.this, Spinner_fungsi.class);
            surveybangun.putExtra(ConstantsUtils.ACTION, ConstantsUtils.ACTION_NEW);
            MainActivity.this.startActivity(surveybangun);

        } else if (id == R.id.nav_list_survey) {
            Intent listSurvey = new Intent(MainActivity.this, BangunanView.class);
            MainActivity.this.startActivity(listSurvey);


        } else if (id == R.id.nav_history) {
            Intent listSurveyor = new Intent(MainActivity.this, BangunanViewHistory.class);
            MainActivity.this.startActivity(listSurveyor);


        } else if (id == R.id.nav_logout) {
            AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
            alert.setTitle("Logout");
            alert.setMessage("Anda Yakin Akan Logout ? ");
            alert.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    logout();
                }
            }).setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();

                }
            }).create().show();
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.clear();

        setUpMap();

//        // Add a marker in Sydney and move the camera
//        final LatLng KampusD = new LatLng(-6.367328, 106.832983);
//        CameraPosition KD = new CameraPosition.Builder()
//                .target(KampusD)
//                .zoom(7)
//                .bearing(0)
//                .tilt(30)
//                .build();
//
//        final LatLng KampusE = new LatLng(-6.354283, 106.841577);
//        CameraPosition KE = new CameraPosition.Builder()
//                .target(KampusE)
//                .zoom(7)
//                .bearing(0)
//                .tilt(30)
//                .build();
//
//        mMap.addMarker(new MarkerOptions().position(KampusD).title("Gunadarma Kampus D"));
//        mMap.addMarker(new MarkerOptions().position(KampusE).title("Gunadarma Kampus E"));
//        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(KD));
//        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(KE));
//        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            // TODO: Consider calling
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 0);
//            return;
//        } else {
//            mMap.setMyLocationEnabled(true);
//            mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
//                @Override
//                public void onInfoWindowClick(Marker marker) {
//                    Intent intent = new Intent(MainActivity.this, DetailBangun.class);
//                    startActivity(intent);
//                }
//            });
////            addMarkers();
//        }
    }


    private void setUpMap() {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            // TODO: Consider calling
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 0);
            return;
        } else {
            mMap.setMyLocationEnabled(true);
            // Menggunakan LocationManager untuk menentukan posisi kamera
            LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

            // Criteria digunakan untuk mengambil Location Mode pada device pengguna
            // Yang akan digunakan untuk mengambil lokasi terakhir pengguna
            Criteria criteria = new Criteria();
            Location location = locationManager.getLastKnownLocation(locationManager.getBestProvider(criteria, false));

            // Jika lokasi terakhir pengguna tidak ada...
            if (location != null) {
                // Geser posisi kamera pada peta sesuai dengan posisi pengguna
                CameraPosition cameraPosition = new CameraPosition.Builder()
                        .target(new LatLng(location.getLatitude(), location.getLongitude()))
                        .zoom(17)
                        .build();
                mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
            }
            addMarkers();


        }
    }

    private void addMarkers() {
        APIInterface apiInterface = APIClient.getClientAuthorize().create(APIInterface.class);
        Call<BangunanList> call = apiInterface.getSemuaBangunan(userSession.getUserToken(), userSession.getIdUser());
        call.enqueue(new Callback<BangunanList>() {
            @Override
            public void onResponse(Call<BangunanList> call, Response<BangunanList> response) {
                bangunan = response.body().getSemuaBangunan();
                Log.d("getsemua", bangunan.toString());
                for (int i = 0; i < bangunan.size(); i++) {
                    mLatlng = new LatLng(Double.parseDouble(bangunan.get(i).getLatitude()),
                            Double.parseDouble(bangunan.get(i).getLongitude()));
                    Marker marker = mMap.addMarker(new MarkerOptions()
                            .position(mLatlng)
                            .title(bangunan.get(i).getNama_bangunan())
                            .snippet("Cek Data Gedung"));
                    detailMarker.put(marker, bangunan.get(i));
                }
                showToast("Mendapatkan Posisi Gedung");

            }

            @Override
            public void onFailure(Call<BangunanList> call, Throwable t) {
                showToast("Gagal Mendapatkan Lokasi");

            }

        });
        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                Intent i = new Intent(MainActivity.this, DetailBangun.class);
                i.putExtra("bangunan", detailMarker.get(marker));
                startActivity(i);
            }
        });
    }

    //    @Override
//    public void onResume() {
//        // Jika aplikasi dilanjutkan
//        super.onResume();
//        // Setup peta jika dibutuhkan
//        if (mMap == null) {
//            // Buat peta secara asynchronous
//            mapFragment.getMapAsync(this);
//        }
//    }
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 0) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                mMap.setMyLocationEnabled(true);

            }
        }
    }


}