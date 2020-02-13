package com.billbook.ui.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.billbook.R;
import com.chaos.view.PinView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.HashMap;

public class OTPActivity extends AppCompatActivity implements View.OnClickListener {

    long maxTimeInMilliseconds = 30000;
    Intent intent;
    TextView txtResendOtap,txtTimer;
    ProgressBar progressBar,progressBarOtp;
    LinearLayout llContainer;
    CountDownTimer t;

    PinView pinView;
    HashMap<String,String> params;
    SharedPreferences prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Enter OTP");

        txtResendOtap=(TextView)findViewById(R.id.activity_otp_txt_resend_otp);
        txtTimer=(TextView)findViewById(R.id.activity_otp_txt_timer);
        pinView = (PinView)findViewById(R.id.pinview);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        progressBarOtp = (ProgressBar) findViewById(R.id.progressbar_resend_otp);
        llContainer = (LinearLayout) findViewById(R.id.ll_container);

        startTimer(maxTimeInMilliseconds, 1000);
        txtResendOtap.setOnClickListener(this);

        pinView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.e("COUNT ",""+pinView.getText().toString());
                if(pinView.getText().toString().length()>5)
                   if(pinView.getText().toString().equals("123456")){
                       Intent intent = new Intent(OTPActivity.this, OrderHistoryActivity.class);
                       startActivity(intent);
                       finish();
                   }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.activity_otp_txt_resend_otp:
                progressBarOtp.setVisibility(View.VISIBLE);
                txtResendOtap.setVisibility(View.GONE);
                pinView.setText("");
                break;
        }

    }

    public void startTimer(final long finish, long tick) {

        t = new CountDownTimer(finish, tick) {

            public void onTick(long millisUntilFinished) {
                long remainedSecs = millisUntilFinished / 1000;
                txtTimer.setText("" + (remainedSecs / 60) + ":" + (remainedSecs % 60));
            }

            public void onFinish() {
                txtTimer.setText("00:00");
                txtTimer.setVisibility(View.GONE);
                txtResendOtap.setVisibility(View.VISIBLE);
                cancel();
            }
        }.start();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
