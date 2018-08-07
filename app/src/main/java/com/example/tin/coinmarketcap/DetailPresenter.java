package com.example.tin.coinmarketcap;


public class DetailPresenter implements DetailContract.DetailPresenter {

    private final DetailContract.DetailScreen detailScreen;

    DetailPresenter(DetailContract.DetailScreen screen) {
        this.detailScreen = screen;
    }

    @Override
    public void launchToast(String currencyName) {

        detailScreen.showToast(currencyName);
    }
}
