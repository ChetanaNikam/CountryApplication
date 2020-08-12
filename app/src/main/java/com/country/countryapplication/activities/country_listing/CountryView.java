package com.country.countryapplication.activities.country_listing;

public interface CountryView {
    void setError(String message);
    void showProgress();
    void hideProgress();
    void navigateToHomeScreen(Object mResponse);
}
