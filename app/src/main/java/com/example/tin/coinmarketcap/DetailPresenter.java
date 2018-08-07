package com.example.tin.coinmarketcap;


public class DetailPresenter implements DetailContract.DetailPresenter {

    private final DetailContract.DetailScreen detailScreen;

    DetailPresenter(DetailContract.DetailScreen screen) {
        this.detailScreen = screen;
    }
}
