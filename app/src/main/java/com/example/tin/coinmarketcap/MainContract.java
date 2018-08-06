package com.example.tin.coinmarketcap;

import com.example.tin.coinmarketcap.serverConnection.responses.ListingResponse;

import java.util.ArrayList;

/**
 * Created by Tin on 06/08/2018.
 */

public interface MainContract {

    interface MainScreen {

        void showData(ArrayList<ListingResponse.Coin> coins);

    }

    interface MainPresenter {

        void getData(MainActivity context);

    }
}
