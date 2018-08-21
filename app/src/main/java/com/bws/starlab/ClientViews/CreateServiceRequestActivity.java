package com.bws.starlab.ClientViews;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.bws.starlab.R;

public class CreateServiceRequestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_service_request);

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

        findViewById(R.id.btnCancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


    private void initView() {
        TextView textJob_header = (TextView) findViewById(R.id.textJob_header);
        textJob_header.setText("Create new service request");
    }
}
