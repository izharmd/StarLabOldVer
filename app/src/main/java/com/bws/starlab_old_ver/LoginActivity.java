package com.bws.starlab_old_ver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bws.starlab_old_ver.Commons.Common;
import com.bws.starlab_old_ver.ManagerViews.DashBoardManagerActivity;
import com.bws.starlab_old_ver.Utils.InternetConnection;
import com.bws.starlab_old_ver.Utils.PreferenceConnector;
import com.gitonway.lee.niftymodaldialogeffects.lib.Effectstype;
import com.gitonway.lee.niftymodaldialogeffects.lib.NiftyDialogBuilder;


import android.app.ProgressDialog;

import com.google.firebase.iid.FirebaseInstanceId;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.apache.http.Header;


public class LoginActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {

    Button btnSignIn, btnExit;
    EditText editUserName, editPassword;
    TextView textForgetPass;
    CheckBox checkbox;

    Spinner spinner;

    String[] arruserType = {"Service Engineer", "Client","Service Manager"};
    //String  userType;
    NiftyDialogBuilder animatedDialog;
    NiftyDialogBuilder animatedDialogExit;

    AsyncHttpClient client = new AsyncHttpClient();
    String asynchResult = "", asynchMessage = "";
    ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intiView();
        clickEvent();
    }

    private void clickEvent() {

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*Common.userName = editUserName.getText().toString().trim();
                Common.userPass = editPassword.getText().toString().trim();
                Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                startActivity(intent);*/
               // httpLogin();

                if (Common.userType.equals("Service Engineer")) {
                    Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                    startActivity(intent);
                }else if(Common.userType.equals("Client")){
                    Intent intent = new Intent(LoginActivity.this, DashBoardClientActivity.class);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(LoginActivity.this, DashBoardManagerActivity.class);
                    startActivity(intent);
                }




              /*  if (Common.userType.equals("Service Engineer")) {
                    Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                    startActivity(intent);
                }

               else if(editUserName.getText().length() < 0){
                    editUserName.setError("can't be empty");
                }else if(editPassword.getText().length() < 0){
                    editPassword.setError("can't be empty");
                }else {
                    Intent intent = new Intent(LoginActivity.this,DashboardActivity.class);
                    startActivity(intent);
                }

                if (Common.userType.equals("Client")) {
                    Intent intent = new Intent(LoginActivity.this, DashBoardClientActivity.class);
                    startActivity(intent);
                }

                else if(editUserName.getText().length() < 0){
                    editUserName.setError("can't be empty");
                }else if(editPassword.getText().length() < 0){
                    editPassword.setError("can't be empty");
                }else {
                    Intent intent = new Intent(LoginActivity.this,DashboardActivity.class);
                    startActivity(intent);
                }*/

            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animatedDialogExit.withTitle("StarLab")
                        .withMessage("Do you want to exit?")
                        .withDialogColor("#cc7d3d")
                        .withButton1Text("Yes")
                        .setButton1Click(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                finish();
                            }
                        })
                        .withButton2Text("No")
                        .setButton1Click(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                animatedDialogExit.dismiss();
                            }
                        })
                        .withDuration(500)
                        .withEffect(Effectstype.Fall)
                        .show();
            }
        });

        textForgetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animatedDialog
                        .withTitle("StarLab")
                        .setCustomView(R.layout.dialog_forgetpassword, LoginActivity.this)
                        .withDialogColor("#cc7d3d")
                        .withDuration(500)
                        .withEffect(Effectstype.Fall)
                        .show();
                EditText editForgetPass = (EditText) animatedDialog.findViewById(R.id.editForgetPass);
                Button btnDialog_forgetPass = (Button) animatedDialog.findViewById(R.id.btnDialog_forgetPass);
                btnDialog_forgetPass.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Toast.makeText(LoginActivity.this,"We send new password in your email.",Toast.LENGTH_SHORT).show();
                        animatedDialog.dismiss();
                    }
                });
            }
        });

        checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //code
                PreferenceConnector.writeString(LoginActivity.this, "userType", Common.userType);
                PreferenceConnector.writeString(LoginActivity.this, "userName", Common.userName);
                PreferenceConnector.writeString(LoginActivity.this, "userPass", Common.userPass);
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                Common.userType = parent.getItemAtPosition(pos).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });

    }

    //Used for getting Login Details
    public void httpLogin() {

        // for checking internet connection
        if (InternetConnection.checkConnection(LoginActivity.this)) {

            RequestParams params = new RequestParams();
            client = new AsyncHttpClient();
            client.setTimeout(30000);
            asynchResult = "";
            params.put("strUserID","863");
            params.put("strCustomerID","366");

            client.post(Common.base_URL, params, new AsyncHttpResponseHandler() {
                @Override
                public void onStart() {
                    super.onStart();
                    mDialog = ProgressDialog.show(LoginActivity.this, "Please wait...", " ", true);
                    mDialog.setIndeterminate(true);
                }

                @Override
                public void onFinish() {
                    super.onFinish();
                    mDialog.dismiss();

                    // check for success
                    if (asynchResult.isEmpty()) {

                        Toast.makeText(LoginActivity.this, "No response from server. Please try again", Toast.LENGTH_SHORT).show();

                    } else if (asynchResult.equals("Loggin success")) {

                    }
                }

                @Override
                public void onFailure(int i, Header[] headers, byte[] errorResponse, Throwable e) {
                    Log.d("HTTP==============", "Send Login Notification Failure");
                }

                @Override
                public void onSuccess(int i, Header[] headers, byte[] responseBody) {
                    asynchResult = new String(responseBody);
                    System.out.println("Login result : " + asynchResult);
                }
            });
        } else {

            Toast.makeText(LoginActivity.this, "Please Check Your Internet Connection.", Toast.LENGTH_SHORT).show();
        }
    }


    private void intiView() {

        btnSignIn = (Button) findViewById(R.id.btnSignIn);
        btnExit = (Button) findViewById(R.id.btnExit);

        editUserName = (EditText) findViewById(R.id.editUserName);
        editPassword = (EditText) findViewById(R.id.editPassword);

        textForgetPass = (TextView) findViewById(R.id.textForgetPass);

        spinner = (Spinner) findViewById(R.id.spinner);

        checkbox = (CheckBox) findViewById(R.id.checkbox);

        animatedDialog = NiftyDialogBuilder.getInstance(this);
        animatedDialogExit = NiftyDialogBuilder.getInstance(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, arruserType);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinner.setAdapter(adapter);


        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        //Toast.makeText(LoginActivity.this,refreshedToken,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
