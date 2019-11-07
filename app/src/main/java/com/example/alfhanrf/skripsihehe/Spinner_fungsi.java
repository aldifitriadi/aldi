package com.example.alfhanrf.skripsihehe;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.Settings;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.ActivityCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.alfhanrf.skripsihehe.base.BaseActivity;
import com.example.alfhanrf.skripsihehe.model.bangungedung.Bangunan;
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
import com.google.android.gms.maps.model.MarkerOptions;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.alfhanrf.skripsihehe.MapsActivity.REQUEST_LOCATION;

public class Spinner_fungsi extends BaseActivity implements AdapterView.OnItemSelectedListener, OnMapReadyCallback {

    final String KEY_SavedText = "Saved Text";
    final String KEY_SavedSel = "Saved Selection";
    @BindView(R.id.Spinnerfungsigedung)
    Spinner fungsigedung;
    @BindView(R.id.Spinnerfungsigedung1)
    Spinner Spinnerfungsigedung1;
    @BindView(R.id.Spinnerfungsigedung2)
    Spinner Spinnerfungsigedung2;
    @BindView(R.id.NamaDepar)
    TextInputEditText NamaDepar;
    @BindView(R.id.AlmtDepartemen)
    TextInputEditText AlmtDepartemen;
    @BindView(R.id.NoIkmn)
    TextInputEditText NoIkmn;
    @BindView(R.id.NoHdno)
    TextInputEditText NoHdno;
    @BindView(R.id.TelponBgnGedung)
    TextInputEditText TelponBgnGedung;
    @BindView(R.id.EmailBgnGedung)
    TextInputEditText EmailBgnGedung;
    @BindView(R.id.NamaBangun)
    TextInputEditText NamaBangun;
    @BindView(R.id.AlmtBangun)
    TextInputEditText AlmtBangun;
    //    @BindView(R.id.FungsiBangun)
//    TextInputEditText FungsiBangun;
    @BindView(R.id.Spinnerklasifikasigedung)
    Spinner Spinnerklasifikasigedung;
    @BindView(R.id.JumlahLantai)
    TextInputEditText JumlahLantai;
    @BindView(R.id.LuasLantai)
    TextInputEditText LuasLantai;
    @BindView(R.id.KetinggianBangun)
    TextInputEditText KetinggianBangun;
    @BindView(R.id.LuasBase)
    TextInputEditText LuasBase;
    @BindView(R.id.getLatitude)
    EditText getLatitude;
    @BindView(R.id.getLongitude)
    EditText getLongitude;
    @BindView(R.id.TglMulaiSelesai)
    TextInputEditText TglMulaiSelesai;
    @BindView(R.id.NamaPemilik)
    TextInputEditText NamaPemilik;
    @BindView(R.id.NomorIdentitas)
    TextInputEditText NomorIdentitas;
    @BindView(R.id.NomorBuktiKepemilikanTanah)
    TextInputEditText NomorBuktiKepemilikanTanah;
    @BindView(R.id.Spinnerjeniskepemilikantanah)
    Spinner Spinerjenispemiliktanah;
    @BindView(R.id.AlmtTanah)
    TextInputEditText AlmtTanah;
    @BindView(R.id.LuasTanah)
    TextInputEditText LuasTanah;
    @BindView(R.id.DataPeruntukanResmi)
    TextInputEditText DataPeruntukanResmi;
    @BindView(R.id.KDB)
    TextInputEditText KDB;
    @BindView(R.id.KLB)
    TextInputEditText KLB;
    @BindView(R.id.KDH)
    TextInputEditText KDH;
    @BindView(R.id.KTB)
    TextInputEditText KTB;
    @BindView(R.id.NamaDeparTerdahulu)
    TextInputEditText NamaDeparTerdahulu;
    @BindView(R.id.AlmtDeparTerdahulu)
    TextInputEditText AlmtDeparTerdahulu;
    @BindView(R.id.TelponTerdahulu)
    TextInputEditText TelponTerdahulu;
    @BindView(R.id.EmailTerdahulu)
    TextInputEditText EmailTerdahulu;
    @BindView(R.id.NoImbaTerdahulu)
    TextInputEditText NoImbterdahulu;

    //    Button inputdata = (Button) findViewById(R.id.inputData);
    @BindView(R.id.NoSlfTerdahulu)
    TextInputEditText NoSlfTerdahulu;
    @BindView(R.id.inputData)
    Button InputData;
    SessionManager sessionManager;
    SharedPreferences prefs;
    String[] fungsigedunglist;
    String[] jenisgedunglist;
    String latitude, longitude;

    LocationManager locationManager;
    int refValue;
    private GoogleMap mMap;
    private Bangunan bangunan;
//    private DatePickerDialog.OnDateSetListener mDateSetListner;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_fungsi);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ButterKnife.bind(this);

//        Bundle bundle = getIntent().getExtras();
//        ArrayList<Bangunan> bookStatus = bundle
//                .getParcelable("bangunan");

        if (getIntent().getParcelableExtra(ConstantsUtils.Bangunan) != null) {
            bangunan = getIntent().getParcelableExtra(ConstantsUtils.Bangunan);
            Log.e("ID BANGUNAN", "onCreate: " + bangunan.getId_bangunan());
            setFieldData(bangunan);

            if (getIntent().getStringExtra(ConstantsUtils.ACTION).equals(ConstantsUtils.ACTION_EDIT)) {
                InputData.setText("Update Data");
            }
        }

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        fungsigedunglist = getResources().getStringArray(R.array.fungsi_gedung);


        //intent passing data activity
        Intent intent = Spinner_fungsi.this.getIntent();
        String latitude = intent.getStringExtra("ambillatitude");
        String longitude = intent.getStringExtra("ambillongitude");
        getLatitude.setText(latitude);
        getLongitude.setText(longitude);


        fungsigedung.setOnItemSelectedListener(this);

        ArrayAdapter<String> datafungsi = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, fungsigedunglist);
        datafungsi.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fungsigedung.setAdapter(datafungsi);

        //retrieve saved preferences
        prefs = getPreferences(MODE_PRIVATE);
        String prefsString = prefs.getString(KEY_SavedText, null);
        int prefsInt = prefs.getInt(KEY_SavedSel, -1);
        if (prefsInt != -1) {
            fungsigedung.setSelection(0);
        }
//
//        ArrayAdapter<CharSequence> datafungsi = ArrayAdapter.createFromResource(this, R.array.fungsi_gedung,
//                android.R.layout.simple_list_item_1);
//
//        datafungsi.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        fungsigedung.setAdapter(datafungsi);


        final ArrayAdapter<CharSequence> datafungsibag1hunian = ArrayAdapter.createFromResource(this,
                R.array.fungsi_gedung_hunian, android.R.layout.simple_list_item_1);
        final ArrayAdapter<CharSequence> datafungsibag1usaha = ArrayAdapter.createFromResource(this,
                R.array.fungsi_gedung_usaha, android.R.layout.simple_list_item_1);
        final ArrayAdapter<CharSequence> datafungsibag1keagamaan = ArrayAdapter.createFromResource(this,
                R.array.fungsi_gedung_keagamaan, android.R.layout.simple_list_item_1);
        final ArrayAdapter<CharSequence> datafungsibag1budaya = ArrayAdapter.createFromResource(this,
                R.array.fungsi_gedung_budaya, android.R.layout.simple_list_item_1);


        final ArrayAdapter<CharSequence> datafungsibag2usahaperkantoran = ArrayAdapter.createFromResource(this,
                R.array.fungsi_gedung_usaha_perkantoran, android.R.layout.simple_list_item_1);
        final ArrayAdapter<CharSequence> datafungsibag2usahaperdagangan = ArrayAdapter.createFromResource(this,
                R.array.fungsi_gedung_usaha_perdagangan, android.R.layout.simple_list_item_1);
        final ArrayAdapter<CharSequence> datafungsibag2usahaperindustrian = ArrayAdapter.createFromResource(this,
                R.array.fungsi_gedung_usaha_perindustrian, android.R.layout.simple_list_item_1);
        final ArrayAdapter<CharSequence> datafungsibag2usahaperhotelan = ArrayAdapter.createFromResource(this,
                R.array.fungsi_gedung_usaha_perhotelan, android.R.layout.simple_list_item_1);
        final ArrayAdapter<CharSequence> datafungsibag2usahawisatarekreasi = ArrayAdapter.createFromResource(this,
                R.array.fungsi_gedung_usaha_wisatarekreasi, android.R.layout.simple_list_item_1);
        final ArrayAdapter<CharSequence> datafungsibag2usahaterminal = ArrayAdapter.createFromResource(this,
                R.array.fungsi_gedung_usaha_terminal, android.R.layout.simple_list_item_1);
        final ArrayAdapter<CharSequence> datafungsibag2usahatepatpenyimpanan = ArrayAdapter.createFromResource(this,
                R.array.fungsi_gedung_usaha_penyimpanan, android.R.layout.simple_list_item_1);
        final ArrayAdapter<CharSequence> datafungsibag2usahapenyimpanan = ArrayAdapter.createFromResource(this,
                R.array.fungsi_gedung_usaha_penyimpanan, android.R.layout.simple_list_item_1);
        final ArrayAdapter<CharSequence> datafungsibag2budayapendidikan = ArrayAdapter.createFromResource(this,
                R.array.fungsi_gedung_budaya_pendidikan, android.R.layout.simple_list_item_1);
        final ArrayAdapter<CharSequence> datafungsibag2budayakesehatan = ArrayAdapter.createFromResource(this,
                R.array.fungsi_gedung_budaya_kesehatan, android.R.layout.simple_list_item_1);
        final ArrayAdapter<CharSequence> datafungsibag2budayakebudayaan = ArrayAdapter.createFromResource(this,
                R.array.fungsi_gedung_budaya_budaya, android.R.layout.simple_list_item_1);


        datafungsibag1hunian.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        datafungsibag1usaha.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        datafungsibag1keagamaan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        datafungsibag1budaya.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        datafungsibag2usahaperkantoran.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        datafungsibag2usahaperdagangan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        datafungsibag2usahaperindustrian.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        datafungsibag2usahaperhotelan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        datafungsibag2usahawisatarekreasi.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        datafungsibag2usahaterminal.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        datafungsibag2usahapenyimpanan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        datafungsibag2budayapendidikan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        datafungsibag2budayakesehatan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        datafungsibag2budayakebudayaan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        Spinnerfungsigedung1.setEnabled(true);
        Spinnerfungsigedung2.setEnabled(false);


        fungsigedung.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Spinnerfungsigedung1.setEnabled(true);
                    Spinnerfungsigedung1.setAdapter(datafungsibag1hunian);
                    Spinnerfungsigedung2.setSelection(0);

                    new CountDownTimer(1000, 1000) {

                        @Override
                        public void onTick(long millisUntilFinished) {
                            // do something after 1s
                        }

                        @Override
                        public void onFinish() {
                            Spinnerfungsigedung2.setEnabled(false);
                        }

                    }.start();

                    refValue = 1;

                } else if (position == 1) {
                    Spinnerfungsigedung1.setEnabled(true);
                    Spinnerfungsigedung1.setAdapter(datafungsibag1keagamaan);
                    Spinnerfungsigedung2.setSelection(0);
                    Spinnerfungsigedung2.setEnabled(false);
                    Spinnerfungsigedung2.setSelection(0);

                    new CountDownTimer(1000, 1000) {

                        @Override
                        public void onTick(long millisUntilFinished) {
                            // do something after 1s
                        }

                        @Override
                        public void onFinish() {
                            Spinnerfungsigedung2.setEnabled(false);
                        }

                    }.start();

                    refValue = 2;
                } else if (position == 2) {
                    Spinnerfungsigedung1.setEnabled(true);
                    Spinnerfungsigedung1.setAdapter(datafungsibag1usaha);
                    Spinnerfungsigedung2.setEnabled(true);
                    refValue = 3;
                } else if (position == 3) {
                    Spinnerfungsigedung1.setEnabled(true);
                    Spinnerfungsigedung1.setAdapter(datafungsibag1budaya);
                    Spinnerfungsigedung2.setEnabled(true);
                    refValue = 4;
                } else {
                    Spinnerfungsigedung1.setEnabled(false);
                    Spinnerfungsigedung2.setEnabled(false);
                    Spinnerfungsigedung1.setSelection(0);
                    Spinnerfungsigedung2.setSelection(0);
                }
                SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();
                editor.putInt(KEY_SavedSel, position);
                editor.commit();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinnerfungsigedung1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String kantor = "Bangunan Perkantoran";
                String dagang = "Bangunan Perdagangan";
                String industri = "Bangunan Industri";
                String hotel = "Bangunan Perhotelan";
                String wisata = "B. Wisata dan Rekreasi";
                String terminal = "Bangunan Terminal";
                String penyimpanan = "B. Tepat Penyimpanan";
                String pendidikan = "Bangunan Pendidikan";
                String kesehatan = "B. Pelayanan Kesehatan";
                String kebudayaan = "Bangunan Kebudayaan";
                String text = Spinnerfungsigedung1.getSelectedItem().toString();
                if (text.equals(kantor)) {
                    Spinnerfungsigedung2.setEnabled(true);
                    Spinnerfungsigedung2.setAdapter(datafungsibag2usahaperkantoran);
                } else if (text.equals(dagang)) {
                    Spinnerfungsigedung2.setEnabled(true);
                    Spinnerfungsigedung2.setAdapter(datafungsibag2usahaperdagangan);
                } else if (text.equals(industri)) {
                    Spinnerfungsigedung2.setEnabled(true);
                    Spinnerfungsigedung2.setAdapter(datafungsibag2usahaperindustrian);
                } else if (text.equals(hotel)) {
                    Spinnerfungsigedung2.setEnabled(true);
                    Spinnerfungsigedung2.setAdapter(datafungsibag2usahaperhotelan);
                } else if (text.equals(wisata)) {
                    Spinnerfungsigedung2.setEnabled(true);
                    Spinnerfungsigedung2.setAdapter(datafungsibag2usahawisatarekreasi);
                } else if (text.equals(terminal)) {
                    Spinnerfungsigedung2.setEnabled(true);
                    Spinnerfungsigedung2.setAdapter(datafungsibag2usahaterminal);
                } else if (text.equals(penyimpanan)) {
                    Spinnerfungsigedung2.setEnabled(true);
                    Spinnerfungsigedung2.setAdapter(datafungsibag2usahapenyimpanan);
                } else if (text.equals(pendidikan)) {
                    Spinnerfungsigedung2.setEnabled(true);
                    Spinnerfungsigedung2.setAdapter(datafungsibag2budayapendidikan);
                } else if (text.equals(kesehatan)) {
                    Spinnerfungsigedung2.setEnabled(true);
                    Spinnerfungsigedung2.setAdapter(datafungsibag2budayakesehatan);
                } else if (text.equals(kebudayaan)) {
                    Spinnerfungsigedung2.setEnabled(true);
                    Spinnerfungsigedung2.setAdapter(datafungsibag2budayakebudayaan);
                } else {
                    Spinnerfungsigedung2.setSelection(0);
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Button gpsGetPosisi = findViewById(R.id.getPosisi);
        gpsGetPosisi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                    buildAlertMessageNoGPS();
                } else if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                    getLocation();
                    if (ActivityCompat.checkSelfPermission(Spinner_fungsi.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(Spinner_fungsi.this
                            , Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        return;
                    }
                    mMap.setMyLocationEnabled(true);
                }


            }
        });


//        DateInput.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Calendar myCalendar = Calendar.getInstance();
//                myCalendar.setTimeInMillis(System.currentTimeMillis());
//                int year = myCalendar.get(Calendar.YEAR);
//                int month = myCalendar.get(Calendar.MONTH);
//                int day = myCalendar.get(Calendar.DAY_OF_MONTH);
//
//                DatePickerDialog dialog = new DatePickerDialog(Spinner_fungsi.this,
//                        android.R.style.Theme_Holo_Light_Dialog_MinWidth, mDateSetListner,year,month,day);
//                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                dialog.show();
////                updateLabel();
//
////                new DatePickerDialog(Spinner_fungsi.this, date, myCalendar
////                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
////                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
//            }
//        });
//
//        mDateSetListner = new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//                month = month + 1;
//
//                String date = month + "-" + dayOfMonth + "-" + year;
//                TglMulaiSelesai.setText(date);
//            }
//        };


        InputData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                sessionManager.removeSession();
                if (getIntent().getStringExtra(ConstantsUtils.ACTION).equals(ConstantsUtils.ACTION_NEW)) {
                    if (fieldCheck()) {
                        final AlertDialog.Builder builder = new AlertDialog.Builder(Spinner_fungsi.this);
                        builder.setMessage("Apakah Data yang Di Input Benar ?")
                                .setCancelable(false)
                                .setPositiveButton("Ya ", new DialogInterface.OnClickListener() {
                                    public void onClick(final DialogInterface dialog, final int id) {
                                        createData(parseData());
                                        dialog.dismiss();
                                        finish();
                                    }
                                })
                                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                                    public void onClick(final DialogInterface dialog, final int id) {
                                        dialog.cancel();
                                    }
                                });
                        final AlertDialog alert = builder.create();
                        alert.show();
                    } else {
                        showToast("Ada Data Yang Belum diisi");
                    }
                } else if (getIntent().getStringExtra(ConstantsUtils.ACTION).equals(ConstantsUtils.ACTION_EDIT)) {
                    if (fieldCheck()) {
                        final AlertDialog.Builder builder = new AlertDialog.Builder(Spinner_fungsi.this);
                        builder.setMessage("Apakah Data yang Di Input Benar ?")
                                .setCancelable(false)
                                .setPositiveButton("Ya ", new DialogInterface.OnClickListener() {
                                    public void onClick(final DialogInterface dialog, final int id) {
                                        updateData(parseData());
                                        dialog.dismiss();
                                        finish();
                                    }
                                })
                                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                                    public void onClick(final DialogInterface dialog, final int id) {
                                        dialog.cancel();
                                    }
                                });
                        final AlertDialog alert = builder.create();
                        alert.show();
                    } else {
                        showToast("Ada Data Yang Belum diisi");
                    }

                }
            }
        });
    }

    //buat manggil waktu input nih.
//    private void updateLabel() {
//
//        Calendar myCalender = Calendar.getInstance();
//        String myFormat = "MM-dd-yy"; //In which you need put here
//        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.ENGLISH);
//
//        TglMulaiSelesai.setText(sdf.format(myCalender.getTime()));
//    }


    private void createData(Bangunan bangunan) {
        UserSession userSession = new UserSession(Spinner_fungsi.this);
        mRegProgres.setTitle("Sending Data");
        mRegProgres.setMessage("Please Wait...");
        mRegProgres.setCanceledOnTouchOutside(false);
        mRegProgres.show();
        APIInterface apiInterface = APIClient.getClientAuthorize().create(APIInterface.class);
        Call<RequestResponse> call = apiInterface.masukandata(userSession.getUserToken(),
                userSession.getIdUser(), bangunan);
        call.enqueue(new Callback<RequestResponse>() {
            @Override
            public void onResponse(Call<RequestResponse> call, Response<RequestResponse> response) {
                if (response.isSuccessful()) {
                    mRegProgres.dismiss();
                    showToast("Data Berhasil Di Inputkan");
                }
            }

            @Override
            public void onFailure(Call<RequestResponse> call, Throwable t) {
//                mRegProgres.dismiss();
//                showToast("Data Berhasil Di Inputkan " + t.toString());
                showToast("Data Berhasil Di Inputkan ");
            }
        });
    }

    private void updateData(Bangunan bangunan) {
//        UserSession userSession = new UserSession(Spinner_fungsi.this);
        UserSession session = new UserSession(this);
        Log.e("SpinnerFungsi", "updateData: " + bangunan.getId_bangunan());
        mRegProgres.setTitle("Sending Data");
        mRegProgres.setMessage("Please Wait...");
        mRegProgres.setCanceledOnTouchOutside(false);
        mRegProgres.show();
        APIInterface apiInterface = APIClient.getClientAuthorize().create(APIInterface.class);
        Call<RequestResponse> call = apiInterface.updateBangunan(session.getUserToken(),
                String.valueOf(session.getUserID()),
                bangunan.getId_bangunan(),
                bangunan);
        call.enqueue(new Callback<RequestResponse>() {
            @Override
            public void onResponse(Call<RequestResponse> call, Response<RequestResponse> response) {
                if (response.isSuccessful()) {

                    // mRegProgres.dismiss();
                    showToast("Data Berhasil Di Update");
                }
            }

            @Override
            public void onFailure(Call<RequestResponse> call, Throwable t) {
                showToast("Data gagal Dikirim : " + t.toString());
            }
        });
    }

    private void buildAlertMessageNoGPS() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Harap Menayalakan GPS")
                .setCancelable(false)
                .setPositiveButton("Nyalakan GPS ", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
                        startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                    }
                })
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
                        dialog.cancel();
                    }
                });
        final AlertDialog alert = builder.create();
        alert.show();
    }

    private void getLocation() {
        if (ActivityCompat.checkSelfPermission(Spinner_fungsi.this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(Spinner_fungsi.this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
            ActivityCompat.requestPermissions(Spinner_fungsi.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
        } else {
            Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            LatLng target = new LatLng(location.getLatitude(), location.getLongitude());

            if (location != null) {
                double latti = location.getLatitude();
                double longi = location.getLongitude();
                latitude = String.valueOf(latti);
                longitude = String.valueOf(longi);

                getLatitude.setText(latitude);
                getLongitude.setText(longitude);
                CameraPosition.Builder builder = new CameraPosition.Builder();
                builder.zoom(18);
                builder.target(target);

                this.mMap.animateCamera(CameraUpdateFactory.newCameraPosition(builder.build()));
                mMap.addMarker(new MarkerOptions().position(new LatLng(location.getLatitude(),
                        location.getLongitude())).title("Posisi Anda"));
            } else
                Toast.makeText(this, "Tidak Mendapatkan Posisi", Toast.LENGTH_SHORT).show();
        }

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        setUpMap();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mRegProgres != null) {
            mRegProgres.dismiss();
            mRegProgres = null;
        }
    }

    private void setUpMap() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission
                (this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        // Enable MyLocation Layer of Google Map
        mMap.setMyLocationEnabled(true);

    }

    private void validateSpinner(String compareValue, int array, Spinner spinner) {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, array, android.R.layout.simple_spinner_item);
        if (compareValue != null) {
            int spinnerPosition = adapter.getPosition(compareValue);
            spinner.setSelection(spinnerPosition);
        }
    }

    private Bangunan parseData() {

        Bangunan bangunan = new Bangunan();
        UserSession userSession = new UserSession(this);
        if (bangunan != null && getIntent().getStringExtra(ConstantsUtils.ACTION).equals(ConstantsUtils.ACTION_EDIT)) {
            bangunan.setId_bangunan(this.bangunan.getId_bangunan());
        }
        bangunan.setUser_id(userSession.getUserId());
        bangunan.setNama_departemen(NamaDepar.getText().toString().trim());
        bangunan.setJenis_bangunan(Spinnerfungsigedung1.getSelectedItem().toString());
        bangunan.setJenis_fungsi_bangunan(Spinnerfungsigedung2.getSelectedItem().toString().trim());
        bangunan.setId_reference(refValue);
        bangunan.setAlamat_departemen(AlmtDepartemen.getText().toString().trim());
        bangunan.setNo_ikmn(NoIkmn.getText().toString().trim());
        bangunan.setNo_hdno(NoHdno.getText().toString().trim());
        bangunan.setTelpon(TelponBgnGedung.getText().toString().trim());
        bangunan.setEmail(EmailBgnGedung.getText().toString().trim());

        bangunan.setNama_bangunan(NamaBangun.getText().toString().trim());
        bangunan.setAlamat_bangunan(AlmtBangun.getText().toString().trim());

        bangunan.setKlasifikasi_bangunan(Spinnerklasifikasigedung.getSelectedItem().toString().trim());
        bangunan.setJumlah_lantai_bangunan(JumlahLantai.getText().toString().trim());
        bangunan.setLuas_lantai_bangunan(LuasLantai.getText().toString().trim());
        bangunan.setKetinggian_bangunan(KetinggianBangun.getText().toString().trim());
        bangunan.setLuas_basement(LuasBase.getText().toString().trim());
        bangunan.setLatitude(getLatitude.getText().toString().trim());
        bangunan.setLongitude(getLongitude.getText().toString().trim());
        bangunan.setDate_selesai(TglMulaiSelesai.getText().toString().trim());

        bangunan.setNama_pemilik_tanah(NamaPemilik.getText().toString().trim());
        bangunan.setNo_ipt(NomorIdentitas.getText().toString().trim());
        bangunan.setNo_bkt(NomorBuktiKepemilikanTanah.getText().toString().trim());
        bangunan.setJenis_kepemilikan_tanah(Spinerjenispemiliktanah.getSelectedItem().toString().trim());
        bangunan.setAlamat_tanah(AlmtTanah.getText().toString().trim());
        bangunan.setLuas_tanah(LuasTanah.getText().toString().trim());
        bangunan.setData_peruntukan_resmi(DataPeruntukanResmi.getText().toString().trim());
        bangunan.setKdb(KDB.getText().toString().trim());
        bangunan.setKlb(KLB.getText().toString().trim());
        bangunan.setKdh(KDH.getText().toString().trim());
        bangunan.setKtb(KTB.getText().toString().trim());

        bangunan.setNama_departemen_dulu(NamaDeparTerdahulu.getText().toString().trim());
        bangunan.setAlamat_departemen_dulu(AlmtDeparTerdahulu.getText().toString().trim());
        bangunan.setTelpon_dulu(TelponTerdahulu.getText().toString().trim());
        bangunan.setEmail_dulu(EmailTerdahulu.getText().toString().trim());

        bangunan.setNo_imb_terdahulu(NoImbterdahulu.getText().toString().trim());
        bangunan.setNo_islf_terdahulu(NoSlfTerdahulu.getText().toString().trim());


        bangunan.setFungsi_bangunan(fungsigedung.getSelectedItem().toString().trim());

        return bangunan;
    }

    private void setFieldData(Bangunan bangunan) {

        Log.d("Alfhan", bangunan.getNama_bangunan());

//        validateSpinner(bangunan.getFungsi_bangunan(), R.array.fungsi_gedung, fungsigedung);
//
//        validateSpinner(bangunan.getJenis_bangunan(), R.array.fungsi_gedung_hunian, Spinnerfungsigedung1);
//        validateSpinner(bangunan.getJenis_bangunan(), R.array.fungsi_gedung_keagamaan, Spinnerfungsigedung1);
//        validateSpinner(bangunan.getJenis_bangunan(), R.array.fungsi_gedung_usaha, Spinnerfungsigedung1);
//        validateSpinner(bangunan.getJenis_bangunan(), R.array.fungsi_gedung_budaya, Spinnerfungsigedung1);
//
//        validateSpinner(bangunan.getJenis_bangunan(), R.array.fungsi_gedung_usaha_perkantoran, Spinnerfungsigedung2);
//        validateSpinner(bangunan.getJenis_bangunan(), R.array.fungsi_gedung_usaha_perdagangan, Spinnerfungsigedung2);
//        validateSpinner(bangunan.getJenis_bangunan(), R.array.fungsi_gedung_usaha_perindustrian, Spinnerfungsigedung2);
//        validateSpinner(bangunan.getJenis_bangunan(), R.array.fungsi_gedung_usaha_perhotelan, Spinnerfungsigedung2);
//        validateSpinner(bangunan.getJenis_bangunan(), R.array.fungsi_gedung_usaha_wisatarekreasi, Spinnerfungsigedung2);
//        validateSpinner(bangunan.getJenis_bangunan(), R.array.fungsi_gedung_usaha_terminal, Spinnerfungsigedung2);
//        validateSpinner(bangunan.getJenis_bangunan(), R.array.fungsi_gedung_usaha_penyimpanan, Spinnerfungsigedung2);

//        NamaDepar.setText(bangunan.getNama_departemen());
//        AlmtDepartemen.setText(bangunan.getAlamat_departemen());
//        NoIkmn.setText(bangunan.getNo_ikmn());
//        NoHdno.setText(bangunan.getNo_hdno());

        NamaDepar.setText(bangunan.getNama_departemen());
        AlmtDepartemen.setText(bangunan.getAlamat_departemen());
        NoIkmn.setText(bangunan.getNo_ikmn());
        NoHdno.setText(bangunan.getNo_hdno());
        TelponBgnGedung.setText(bangunan.getTelpon());
        EmailBgnGedung.setText(bangunan.getEmail());


        NamaBangun.setText(bangunan.getNama_bangunan());
        AlmtBangun.setText(bangunan.getAlamat_bangunan());
//        FungsiBangun.setText(bangunan.getFungsi_bangunan());
        validateSpinner(bangunan.getKlasifikasi_bangunan(), R.array.klasifikasi_bangunan, Spinnerklasifikasigedung);
        JumlahLantai.setText(bangunan.getJumlah_lantai_bangunan());
        LuasLantai.setText(bangunan.getLuas_lantai_bangunan());
        LuasBase.setText(bangunan.getLuas_basement());
        KetinggianBangun.setText(bangunan.getKetinggian_bangunan());
        getLatitude.setText(bangunan.getLatitude());
        getLongitude.setText(bangunan.getLongitude());
        TglMulaiSelesai.setText(bangunan.getDate_selesai());


        NamaPemilik.setText(bangunan.getNama_pemilik_tanah());
        NomorIdentitas.setText(bangunan.getNo_ipt());
        NomorBuktiKepemilikanTanah.setText(bangunan.getNo_bkt());
        validateSpinner(bangunan.getJenis_kepemilikan_tanah(), R.array.jenis_kepimilikan_tanah, Spinerjenispemiliktanah);
        AlmtTanah.setText(bangunan.getAlamat_tanah());
        LuasTanah.setText(bangunan.getLuas_tanah());
        DataPeruntukanResmi.setText(bangunan.getData_peruntukan_resmi());
        KDB.setText(bangunan.getKdb());
        KLB.setText(bangunan.getKlb());
        KDH.setText(bangunan.getKdh());
        KTB.setText(bangunan.getKtb());

        NamaDeparTerdahulu.setText(bangunan.getNama_departemen_dulu());
        AlmtDeparTerdahulu.setText(bangunan.getAlamat_departemen_dulu());
        TelponTerdahulu.setText(bangunan.getTelpon_dulu());
        EmailTerdahulu.setText(bangunan.getEmail_dulu());

        NoImbterdahulu.setText(bangunan.getNo_imb_terdahulu());
        NoSlfTerdahulu.setText(bangunan.getNo_islf_terdahulu());


    }

    private Boolean fieldCheck() {
        Boolean fieldCheck = true;

        if (TextUtils.isEmpty(NamaBangun.getText())) {
            NamaBangun.setError("Masukan Nama Bangun");
            fieldCheck = false;
        }
        if (TextUtils.isEmpty(AlmtBangun.getText())) {
            AlmtBangun.setError("Masukan Alamat Bangunan");
            fieldCheck = false;
        }
        if (TextUtils.isEmpty(NamaDepar.getText())) {
            NamaDepar.setError("Masukan Nama Departemen");
            fieldCheck = false;
        }
        return fieldCheck;
    }


//                DialogInterface.OnClickListener dialogClickListener = (dialog, which) -> {
//                    switch (which){
//                        case DialogInterface.BUTTON_POSITIVE:
//                            createData(parseData());
//                            dialog.dismiss();
//                            finish();
//                            break;
//
//                        case DialogInterface.BUTTON_NEGATIVE:
//                            dialog.dismiss();
//                            break;
//                    }
}
//                AlertDialog.Builder builder = new AlertDialog.Builder(this);
//                builder.setMessage("Apakah Data yang akan diinputkan sudah benar ?")
//                        .setPositiveButton("Yes", dialogClickListener)
//                        .setNegativeButton("No", dialogClickListener).show();
//
//            } else {
//                showToast("Ada Data Yang Belum diisi");
//            }
//    }
//}
