package com.example.tin.coinmarketcap.serverConnection.responses;

import java.util.ArrayList;

public class ListingResponse {

    public ArrayList<DataModel> data;

    public ArrayList<DataModel> getCoins() {
        return data;
    }

    public class DataModel {

        int id;
        String name;
        String symbol;
        int cmc_rank;
        double circulating_supply;
        double max_supply;
//        double price;
//        double volume_24h;
//        double market_cap;


        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getSymbol() {
            return symbol;
        }

        public int getCmc_rank() {
            return cmc_rank;
        }

        public double getCirculating_supply() {
            return circulating_supply;
        }

        public double getMax_supply() {
            return max_supply;
        }
    }

}

//"data": [
//        {
//        "id": 1,
//        "name": "Bitcoin",
//        "symbol": "BTC",
//        "slug": "bitcoin",
//        "circulating_supply": 17194112,
//        "total_supply": 17194112,
//        "max_supply": 21000000,
//        "date_added": "2013-04-28T00:00:00.000Z",
//        "num_markets": 327,
//        "cmc_rank": 1,
//        "last_updated": "2018-08-06T21:04:23.000Z",
//        "quote": {
//              "USD": {
//                  "price": 6950.5614524,
//                  "volume_24h": 3785643302.4097,
//                  "percent_change_1h": -0.344539,
//                  "percent_change_24h": -1.65271,
//                  "percent_change_7d": -14.348,
//                  "market_cap": 119508732075.44827,
//                  "last_updated": "2018-08-06T21:04:23.000Z"
//                      }
//                  }
//        },
//        {
//        "id": 1027,
//        "name": "Ethereum",
//        "symbol": "ETH",
//        "slug": "ethereum",
//        "circulating_supply": 101163058.1553,
//        "total_supply": 101163058.1553,
//        "max_supply": null,
//        "date_added": "2015-08-07T00:00:00.000Z",
//        "num_markets": 345,
//        "cmc_rank": 2,
//        "last_updated": "2018-08-06T21:04:38.000Z",
//        "quote": {
//              "USD": {
//                  "price": 405.448491751,
//                  "volume_24h": 1358291181.09817,
//                  "percent_change_1h": -0.246813,
//                  "percent_change_24h": -1.28415,
//                  "percent_change_7d": -10.8583,
//                  "market_cap": 41016409349.98509,
//                  "last_updated": "2018-08-06T21:04:38.000Z"
//                      }
//                  }
//        },