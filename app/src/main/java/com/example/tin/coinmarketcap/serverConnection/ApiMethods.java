package com.example.tin.coinmarketcap.serverConnection;

import com.example.tin.coinmarketcap.serverConnection.responses.ListingResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiMethods {

    @GET("/?sort=rank")
    Observable<ListingResponse> getListings();
}
