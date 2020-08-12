package com.country.countryapplication.retrofit;

public interface IAPIsCallbacks<T> {

    void onSuccess(T response, String requestTag);

    void OnFailure(String errorMessage);

}
