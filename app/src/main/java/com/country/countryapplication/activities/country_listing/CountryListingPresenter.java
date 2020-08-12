package com.country.countryapplication.activities.country_listing;

import android.content.Context;

import com.country.countryapplication.R;
import com.country.countryapplication.Utils;

public class CountryListingPresenter  implements CountryListingInteractor.onApiCall {

    private CountryView mView;
    private CountryListingInteractor mInteractor;


    public CountryListingPresenter(CountryView view, CountryListingInteractor mInteractor) {
        this.mView = view;
        this.mInteractor = mInteractor;
    }


    public void callCountryApi(Context mContext) {
        if (mView != null) {
            if (Utils.isConnected(mContext)) {
                mInteractor.callCountryApi(this);
            } else {
                mView.setError(mContext.getResources().getString(R.string.internet_connection_check));

            }
        }
    }

    @Override
    public void onSuccess(Object response) {
        mView.navigateToHomeScreen(response);
    }

    @Override
    public void onFailure(String errorMessage) {
        mView.setError(errorMessage);
    }
}
