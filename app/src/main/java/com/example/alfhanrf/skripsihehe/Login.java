package com.example.alfhanrf.skripsihehe;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.alfhanrf.skripsihehe.base.BaseActivity;
import com.example.alfhanrf.skripsihehe.network.APIClient;
import com.example.alfhanrf.skripsihehe.network.APIInterface;
import com.example.alfhanrf.skripsihehe.sessionmanager.UserSession;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends BaseActivity implements View.OnClickListener {


    @BindView(R.id.btnLogin)
    Button btnLogin;
    @BindView(R.id.txtID)
    TextInputEditText txtID;
    @BindView(R.id.txtPassword)
    TextInputEditText txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mRegProgres = new ProgressDialog(this);
        txtID.setFocusable(true);
        btnLogin.setOnClickListener(this);
    }

    private Boolean fieldCheck() {
        Boolean fieldCheck = true;

        if (TextUtils.isEmpty(txtID.getText())) {
            txtID.setError("Masukan ID Anda");
            fieldCheck = false;
        }
        if (TextUtils.isEmpty(txtPassword.getText())) {
            txtPassword.setError("Masukan Password");
            fieldCheck = false;
        }

        return fieldCheck;
    }

    private void login() {
        mRegProgres.setTitle("Getting Data");
        mRegProgres.setMessage("Please Wait...");
        mRegProgres.setCanceledOnTouchOutside(false);
        mRegProgres.show();
        final String user_id = txtID.getText().toString().trim();
        String pass = txtPassword.getText().toString().trim();

        Map<String, Object> jsonParams = new ArrayMap<>();
        jsonParams.put("username", user_id);
        jsonParams.put("password", pass);

        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset-utf-8"),
                (new JSONObject(jsonParams)).toString());

        APIInterface apiInterface = APIClient.getClientAuthorize().create(APIInterface.class);
        Call<JsonObject> call = apiInterface.login(user_id, pass);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                try {
                    if (response.isSuccessful()) {
                        Log.d("masuk", "asasas");
                        JsonElement jsonToken = response.body().get("token");
                        JsonElement jsonId = response.body().get("id");
                        JsonElement jsonNama = response.body().get("nama");
                        JsonElement jsonUserId = response.body().get("user_id");
                        JsonElement jsonuserRole = response.body().get("role");

                        Log.d("id", (jsonId.getAsString()));

                        mRegProgres.dismiss();
                        UserSession userSession = new UserSession(Login.this);
                        userSession.setLoginSession(jsonId.getAsString(), jsonToken.getAsString(), jsonNama.getAsString(), jsonuserRole.getAsString(), jsonUserId.getAsString());

                        Intent i = new Intent(Login.this, MainActivity.class);
                        // Closing all the Activities
                        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        // Add new Flag to start new Activity
                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        // Staring EntityLogin Activity
                        startActivity(i);
                        finish();


                    } else {
                        mRegProgres.dismiss();
//                    Log.d("haha",response.errorBody().string() );
                        Toast.makeText(Login.this, " Gagal Login 1", Toast.LENGTH_SHORT).show();

                    }
                } catch (Exception e) {
                    mRegProgres.dismiss();
                    Toast.makeText(Login.this, "Password atau ID Salah", Toast.LENGTH_SHORT).show();
//                    e.printStackTrace();

                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                mRegProgres.dismiss();
//                Log.e("HEADER",call.request().headers().toString());
                Toast.makeText(Login.this, "Password atau ID Salah", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin: {
                if (fieldCheck()) {
                    login();
                }
            }
        }
    }
}