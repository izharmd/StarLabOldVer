package com.bws.starlab;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bws.starlab.Commons.Common;
import com.bws.starlab.Utils.PreferenceConnector;

public class SplashActivity extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final String userType = PreferenceConnector.readString(this, Common.userType, "");
        String userName = PreferenceConnector.readString(this, Common.userName, "");
        String userPass = PreferenceConnector.readString(this, Common.userPass, "");

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {

                Intent mainIntent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(mainIntent);
                finish();

               /* if(userType == null) {
                    Intent mainIntent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(mainIntent);
                    finish();
                }else if(userType.equals("Service Engineer")){
                    Intent intent = new Intent(SplashActivity.this,DashboardActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Intent intent = new Intent(SplashActivity.this,DashBoardClientActivity.class);
                    startActivity(intent);
                    finish();
                }*/
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
