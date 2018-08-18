package com.bws.starlab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AssetsDetailsActivity extends AppCompatActivity {

    TextView textAssetsName1, textAssetsName2, textResorce, textOther, textTime;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assets_details);

        initView();
        clickEvent();
    }

    private void clickEvent() {

        findViewById(R.id.textBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initView() {

        textAssetsName1 = (TextView) findViewById(R.id.textAssetsName1);
        textAssetsName2 = (TextView) findViewById(R.id.textAssetsName2);
        textResorce = (TextView) findViewById(R.id.textResorce);
        textOther = (TextView) findViewById(R.id.textOther);
        textTime = (TextView) findViewById(R.id.textTime);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        TextView textJob_header = (TextView) findViewById(R.id.textJob_header);
        textJob_header.setText("Job Details");


    }
}
