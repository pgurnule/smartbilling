package com.billbook.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import com.billbook.R;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().hide();

        findViewById(R.id.cirLoginButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, OTPActivity.class);
                startActivity(intent);
                finish();
            }
        });
        findViewById(R.id.txt_register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewRegisterClicked();
            }
        });

    }

    public void viewRegisterClicked(){
        Intent intent = new Intent(LoginActivity.this,ShopRegistrationActivity.class);
        startActivity(intent);
    }

}
