package com.yarncostingindia.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.yarncostingindia.R;
import com.yarncostingindia.Utils.AndyConstants;

import org.w3c.dom.Text;

public class AboutusActivity extends AppCompatActivity {

    private TextView tvversion, tvpayment, tvinternet;
    private Button btnactive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);

        tvversion = (TextView) findViewById(R.id.tvversion);
        tvpayment = (TextView) findViewById(R.id.payment);
        tvinternet = (TextView) findViewById(R.id.tvinternet);
        btnactive = (Button) findViewById(R.id.final_activate);

        if(AndyConstants.currentTime <= AndyConstants.expireTime){

            tvversion.setText("Full Version");
            tvversion.setTextColor(getResources().getColor(R.color.colorPrimary));
            tvpayment.setVisibility(View.GONE);
            tvinternet.setVisibility(View.GONE);
            btnactive.setVisibility(View.GONE);

        }
    }
}
