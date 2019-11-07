package com.example.alfhanrf.skripsihehe;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.alfhanrf.skripsihehe.base.BaseActivity;
import com.example.alfhanrf.skripsihehe.network.APIClient;
import com.example.alfhanrf.skripsihehe.network.APIInterface;
import com.example.alfhanrf.skripsihehe.network.RequestResponse;
import com.example.alfhanrf.skripsihehe.sessionmanager.UserSession;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Splashscreen extends BaseActivity {

    UserSession userSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        userSession = new UserSession(Splashscreen.this);

        Thread timerThread = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if (userSession.isUserLoggedIn()) {
                        APIInterface apiInterface = APIClient.getClientAuthorize().create(APIInterface.class);
                        Call<RequestResponse> call = apiInterface.checkLogin(userSession.getUserToken(), String.valueOf(userSession.getIdUser()));
                        Log.d("checklogin", (userSession.getIdUser()));
                        Log.d("checklogin1", (userSession.getUserToken()));
                        call.enqueue(new Callback<RequestResponse>() {
                            @Override
                            public void onResponse(Call<RequestResponse> call, Response<RequestResponse> response) {
                                try {
                                    if (response.isSuccessful()) {
                                        Intent intent = new Intent(Splashscreen.this, MainActivity.class);
                                        startActivity(intent);
                                    } else {
                                        sessionExpired();
                                        Intent intent = new Intent(Splashscreen.this, Login.class);
                                        startActivity(intent);
                                    }
                                } catch (Exception e) {
                                    Toast.makeText(Splashscreen.this, "Password atau ID Salah", Toast.LENGTH_SHORT).show();
                                }

                            }

                            @Override
                            public void onFailure(Call<RequestResponse> call, Throwable t) {
                                showToast(t.toString());
                            }
                        });
                    } else {
                        Intent intent = new Intent(Splashscreen.this, Login.class);
                        startActivity(intent);
                    }
                }
            }
        };
        timerThread.start();
    }

    //                    if (userSession.isUserLoggedIn()){
//                        APIInterface apiInterface = APIClient.getClientAuthorize().create(APIInterface.class);
//                        Call<ResponseBody> call = apiInterface.checkLogin(userSession.getIdUser(),userSession.getUserToken());
//                        Log.d("checklogin", (userSession.getIdUser()));
//                        Log.d("checklogin1", (userSession.getUserToken()));
//                        call.enqueue(new Callback<ResponseBody>() {
//                            @Override
//                            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                                if(response.isSuccessful()){
//                                        Intent intent = new Intent(Splashscreen.this,MainActivity.class);
//                                        startActivity(intent);
//                                }else{
//                                    sessionExpired();
//                                }
//                            }else{
//                                sessionExpired();
//                            }
//                        }
//
//                            @Override
//                            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                                showToast(t.toString());
//                            }
//                        });
//                    }else{
//                        Intent intent = new Intent(Splashscreen.this,Login.class);
//                        startActivity(intent);
//                    }
//                }
//            }
//        };
//        timerThread.start();
//    }
    private void sessionExpired() {

        showToast("Session Expired");

    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }
}
