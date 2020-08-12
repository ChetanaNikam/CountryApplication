package com.country.countryapplication.activities.country_listing;

import com.country.countryapplication.model.Country;
import com.country.countryapplication.retrofit.APIServices;
import com.country.countryapplication.retrofit.IAPIsCallbacks;

public class CountryListingInteractor implements IAPIsCallbacks {
    private onApiCall mListner;


    public void callCountryApi(final onApiCall mClick) {

        this.mListner=mClick;

        APIServices.getInstance().callCountryApi(this);
        APIServices.getInstance().setApisCallbacks(this);
    }
    @Override
    public void onSuccess(Object response, String requestTag) {
        if (response != null) {
            Country mResponse=(Country) response;
            if(mResponse.getStatus().equals("success")) {
                mListner.onSuccess(mResponse);
            }
        }
    }

    @Override
    public void OnFailure(String errorMessage) {
        mListner.onFailure(errorMessage);
    }

    public interface onApiCall {
        void onSuccess(Object response);

        void onFailure(String errorMessage);
    }

}
