package com.country.countryapplication.retrofit;

import com.country.countryapplication.model.Country;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IAppIPS {

    @GET(APIConstants.CMD_COUNTRY)
    Call<Country> callCountryApi();
}
