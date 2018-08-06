package com.example.tin.coinmarketcap.serverConnection.responses;

public class ListingResponse {

    int id;
    String name;
    String symbol;
    int rank;
    double circulating_supply;
    double max_supply;
    double price;
    double volume_24h;
    double market_cap;

    public ListingResponse(int id, String name, String symbol, int rank, double circulating_supply, double max_supply, double price, double volume_24h, double market_cap) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.rank = rank;
        this.circulating_supply = circulating_supply;
        this.max_supply = max_supply;
        this.price = price;
        this.volume_24h = volume_24h;
        this.market_cap = market_cap;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getRank() {
        return rank;
    }

    public double getCirculating_supply() {
        return circulating_supply;
    }

    public double getMax_supply() {
        return max_supply;
    }

    public double getPrice() {
        return price;
    }

    public double getVolume_24h() {
        return volume_24h;
    }

    public double getMarket_cap() {
        return market_cap;
    }
}