package com.example.tin.coinmarketcap;

import com.example.tin.coinmarketcap.serverConnection.responses.ListingResponse;

import java.util.ArrayList;


public interface MainContract {

    interface MainScreen {

        void showData(ArrayList<ListingResponse.Data> coins);

    }

    interface MainPresenter {

        void getData(MainActivity context);

    }
}
