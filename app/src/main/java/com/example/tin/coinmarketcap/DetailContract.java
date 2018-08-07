package com.example.tin.coinmarketcap;

public class DetailContract {

    interface DetailScreen {

        void showToast(String currencyName);
    }

    interface DetailPresenter {

        void launchToast(String currencyName);
    }
}
