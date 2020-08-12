package com.country.countryapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.country.countryapplication.R;
import com.country.countryapplication.activities.country_listing.CountryListing;

public class Login extends AppCompatActivity implements View.OnClickListener{
    private TextView mLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        initListener();
    }

    private void initView() {
        mLogin=findViewById(R.id.tvLogin);
    }

    private void initListener() {
        mLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.tvLogin:
                Intent intent=new Intent(Login.this, CountryListing.class);
                startActivity(intent);
                break;
        }

    }
}