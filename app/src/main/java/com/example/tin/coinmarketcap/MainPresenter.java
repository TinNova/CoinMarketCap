package com.example.tin.coinmarketcap;

import android.util.Log;

import com.example.tin.coinmarketcap.serverConnection.RestService;
import com.example.tin.coinmarketcap.serverConnection.responses.ListingResponse;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class MainPresenter implements MainContract.MainPresenter {

    private static final String TAG = MainActivity.class.getSimpleName();

    private final MainContract.MainScreen mainScreen;

    MainPresenter(MainContract.MainScreen screen) {
        this.mainScreen = screen;
    }

    @Override
    public void getData(MainActivity context) {

        /* This is getting the Products list, should be moved to MainPresenter
           This is called on a successful or failed endpoint connection */
        RestService.getInstance(context)
                .getListings()
                .subscribeOn(Schedulers.io())
                // Above we are:
                // 1. Calling .getProducts(), this is an observable
                // 2. No Params or body is required for this endpoint, so the bracket is empty in ".getProducts():
                // 3. RestService is calling the method .getProducts from the RestService Class the data retrieved is an observable
                // 4. In the response we don't receive the Json, instead it is already parsed by Retrofit

                .observeOn(AndroidSchedulers.mainThread()) // On which thread we want to see result
                // Above we are:
                // 1. Specifying on which thread we want to see the response, here we are stating we want it on the mainThread()
                // 2. Here we can specify what to do once we have a successful response i.e launch the next activity

                .subscribe(new Observer<ListingResponse>() {
                    // Above we are:
                    // 1. .subscribe this is where we can interact with the result (error or successful)
                    // 2. Here we can specify what to do once we have a successful response i.e launch the next activity

                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(ListingResponse response) {

                        Log.d(TAG, "successful load of products " + response.getCoins());

                        mainScreen.showData(response.getCoins());
                    }

                    @Override
                    public void onError(Throwable throwable) {

                        Log.e(TAG, "error while load products " + Log.getStackTraceString(throwable));
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }
}
