package com.example.tin.coinmarketcap.serverConnection;

import com.example.tin.coinmarketcap.serverConnection.responses.ListingResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiMethods {

    @GET("v1/cryptocurrency/listings/latest?CMC_PRO_API_KEY=b7c1da55-30aa-4065-a72a-bc63b0e9b91f")
    Observable<ListingResponse> getListings();
}
