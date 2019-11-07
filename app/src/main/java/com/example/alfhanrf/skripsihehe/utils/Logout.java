package com.example.alfhanrf.skripsihehe.utils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.widget.Toast;

import com.example.alfhanrf.skripsihehe.Login;
import com.example.alfhanrf.skripsihehe.network.APIClient;
import com.example.alfhanrf.skripsihehe.network.APIInterface;
import com.example.alfhanrf.skripsihehe.network.RequestResponse;
import com.example.alfhanrf.skripsihehe.sessionmanager.UserSession;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Alfhanrf on 8/20/2018.
 */

public class Logout {


    public static void clearSession(final Activity activity) {

        final UserSession userSession;
        final RequestResponse n = new RequestResponse();
        final String message = n.getMessage();


        ProgressDialog mRegProgres = new ProgressDialog(activity);
        mRegProgres.setTitle("Logout Account");
        mRegProgres.setMessage("Please Wait...");
        mRegProgres.setCanceledOnTouchOutside(false);
        mRegProgres.show();
        userSession = new UserSession(activity);
        APIInterface apiInterface = APIClient.getClientAuthorize().create(APIInterface.class);
        Call<RequestResponse> call = apiInterface.logout(userSession.getIdUser(), userSession.getUserToken());
        call.enqueue(new Callback<RequestResponse>() {
            @Override
            public void onResponse(Call<RequestResponse> call, Response<RequestResponse> response) {
                try {
                    if (response.isSuccessful()) {
                        Intent i = new Intent(activity, Login.class);
                        // Closing all the Activities
                        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        // Add new Flag to start new Activity
                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        // Staring Login Activity
                        activity.startActivity(i);
                        userSession.logoutUser();
                        activity.finish();
                    } else
//                    Log.d("haha",response.errorBody().string() );
                        Toast.makeText(activity, " Gagal Login 1", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {

                }
            }

            @Override
            public void onFailure(Call<RequestResponse> call, Throwable t) {
                Toast.makeText(activity, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}