package com.country.countryapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.country.countryapplication.R;
import com.country.countryapplication.model.CountryModel;

public class CountryDetail extends AppCompatActivity {
    private TextView mName,mCode,mCities,mISODivisions,mADMDevision,mGeoNameID,mIntependent;
    private CountryModel Response;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_detail);
        getIntentData();
        initView();
        setData();
    }

    private void initView() {
        mName=findViewById(R.id.tv_countryname_detail);
        mCode=findViewById(R.id.tv_code_detail);
        mCities=findViewById(R.id.tv_cities_detail);
        mISODivisions=findViewById(R.id.tv_iso_divisions_detail);
        mADMDevision=findViewById(R.id.tv_adm_divisions_details);
        mGeoNameID=findViewById(R.id.tv_geonameid_detail);
        mIntependent=findViewById(R.id.tv_independent_detail);
    }

    @SuppressLint("SetTextI18n")
    private void setData() {
        if(Response!=null) {
            mName.setText(Response.getName());
            mCode.setText(Response.getCode());
            mCities.setText(Response.getTotalCities().toString());
            mISODivisions.setText(Response.getTotalIsoDivisions().toString());
            mADMDevision.setText(Response.getTotalAdmDivisions().toString());
            mGeoNameID.setText(Response.getGeonameid().toString());
            mIntependent.setText(Response.getIndependent().toString());
        }
    }

    private void getIntentData() {
        Intent intent=getIntent();
        Response=(CountryModel) intent.getSerializableExtra("countryDetails");
    }

}