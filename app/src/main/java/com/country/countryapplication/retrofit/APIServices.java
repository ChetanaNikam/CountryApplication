package com.country.countryapplication.retrofit;


import com.country.countryapplication.model.Country;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@SuppressWarnings({"FieldCanBeLocal", "rawtypes"})
public class APIServices {

    private static APIServices ourInstance;
    private IAppIPS iAppIPS;
    private IAPIsCallbacks apisCallbacks;

    public APIServices() {
        this.iAppIPS = RetrofitClient.getRetrofit().create(IAppIPS.class);
    }

    public synchronized static APIServices getInstance() {
        if (ourInstance == null) {
            ourInstance = new APIServices();
        }
        return ourInstance;
    }

    public void setApisCallbacks(IAPIsCallbacks apisCallbacks) {
        this.apisCallbacks = apisCallbacks;
    }

    public void callCountryApi(final IAPIsCallbacks apisCallbacks) {
        Call<Country> call=iAppIPS.callCountryApi();

        call.enqueue(new Callback<Country>() {
            @SuppressWarnings({"NullableProblems", "unchecked"})
            @Override
            public void onResponse(Call<Country> call, Response<Country> response) {
                if(response.code()==200)
                {
                    apisCallbacks.onSuccess(response.body(),APIConstants.CMD_COUNTRY);
                }
                else if(response.code() == 401){
                    apisCallbacks.OnFailure("Unauthorised");
                }
                else{
                    try {
                        assert response.errorBody() != null;
                        JSONObject jObjError = new JSONObject(response.errorBody().string());
                        String message = "";
                        if (jObjError.has("Message"))
                            message = jObjError.getString("Message");
                        apisCallbacks.OnFailure(message);
                    } catch (Exception e) {
                        e.printStackTrace();
                        apisCallbacks.OnFailure(null);
                    }
                }

            }

            @SuppressWarnings("NullableProblems")
            @Override
            public void onFailure(Call<Country> call, Throwable t) {
                apisCallbacks.OnFailure("We regret for the inconvenience. Please try after some time");
            }
        });
    }
}
