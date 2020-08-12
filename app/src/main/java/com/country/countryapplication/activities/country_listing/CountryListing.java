package com.country.countryapplication.activities.country_listing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.country.countryapplication.adapter.CountryAdapter;
import com.country.countryapplication.activities.CountryDetail;
import com.country.countryapplication.interfaces.OnClickItem;
import com.country.countryapplication.model.Country;
import com.country.countryapplication.model.CountryModel;
import com.country.countryapplication.R;

import java.util.ArrayList;

@SuppressWarnings("FieldCanBeLocal")
public class CountryListing extends AppCompatActivity implements CountryView {
    private ArrayList<CountryModel> mResponse;
    private CountryListingPresenter mPresenter;
    private Context mContext;
    private RecyclerView mRv_Country;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_listing);
        mContext=this;
        mPresenter=new CountryListingPresenter(this,new CountryListingInteractor());
        initView();


        mPresenter.callCountryApi(mContext);

    }

    private void initView() {
        mRv_Country=findViewById(R.id.rv_country_listing);
        mRv_Country.setLayoutManager(new LinearLayoutManager(mContext));
    }

    @Override
    public void setError(String message) {
        Toast.makeText(mContext,message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void navigateToHomeScreen(Object mData) {
        Country Response=(Country) mData;
        mResponse=Response.getCountries();
        CountryAdapter countryAdapter =new CountryAdapter(mContext, mResponse, new OnClickItem() {
            @Override
            public void OnSingleItemClick(int position) {
                Intent intent=new Intent(CountryListing.this, CountryDetail.class);
                intent.putExtra("countryDetails", mResponse.get(position));
                startActivity(intent);
            }
        });
        mRv_Country.setAdapter(countryAdapter);

    }
}