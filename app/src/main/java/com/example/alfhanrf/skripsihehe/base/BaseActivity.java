package com.example.alfhanrf.skripsihehe.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import butterknife.ButterKnife;

/**
 * Created by Alfhanrf on 8/15/2018.
 */

public class BaseActivity extends AppCompatActivity {
    protected ProgressDialog mRegProgres;
    private Boolean connStatus;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checkInternet();
        mRegProgres = new ProgressDialog(this);
        mRegProgres.setTitle("Getting Data");
        mRegProgres.setMessage("Please Wait...");
        mRegProgres.setCanceledOnTouchOutside(false);
    }

    private void checkInternet() {
        ConnectivityManager ConnectionManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = ConnectionManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected() == true) {
            connStatus = true;
        } else {
            connStatus = false;
            showToast("No Internet Connection");
        }
    }

    protected void bind(int layout) {
        setContentView(layout);
        ButterKnife.bind(this);
    }

    protected void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}

