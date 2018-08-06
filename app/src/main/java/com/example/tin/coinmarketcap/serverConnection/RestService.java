package com.example.tin.coinmarketcap.serverConnection;

import android.content.Context;

import com.example.tin.coinmarketcap.serverConnection.responses.ListingResponse;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestService {

    private static ApiMethods INSTANCE;
    private static RestService restService;

    public static RestService getInstance(Context application) {

        /* We only want to create this once */
        if (INSTANCE == null) {

            restService = new RestService();

            Retrofit retrofit = new Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://api.coinmarketcap.com/v2/ticker/")
                    .client(provideOkHttp(application))
                    .build();

            INSTANCE = retrofit.create(ApiMethods.class);
        }

        return restService;
    }

    private static OkHttpClient provideOkHttp(Context context) {

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();

        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }

    public Observable<ListingResponse> getListings() {
        /* Here we receive the ListingResponse, (which is already parsed when it arrives here) */
        return INSTANCE.getListings();
    }
}
