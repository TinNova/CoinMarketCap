package com.example.tin.coinmarketcap.serverConnection.responses;

import java.util.ArrayList;

public class ListingResponse {

    public ArrayList<Data> data;

    public ArrayList<Data> getCoins() {
        return data;
    }

    public class Data {

        int id;
        String name;
        String symbol;
        int cmc_rank;
        double circulating_supply;
        double max_supply;
//        double price;
//        double volume_24h;
//        double market_cap;

    }
}

//        "data": [
//        {
//                "id": 1,
//                "name": "Bitcoin",
//                "symbol": "BTC",
//                "slug": "bitcoin",
//                "cmc_rank": 5,
//                "num_markets": 500,
//                "circulating_supply": 16950100,
//                "total_supply": 16950100,
//                "max_supply": 21000000,
//                "last_updated": "2018-06-02T22:51:28.209Z",
//                "quote": {
//            "USD": {
//                "price": 9283.92,
//                        "volume_24h": 7155680000,
//                        "percent_change_1h": -0.152774,
//                        "percent_change_24h": 0.518894,
//                        "percent_change_7d": 0.986573,
//                        "market_cap": 158055024432
//            },
//            "BTC": {
//                "price": 1,
//                        "volume_24h": 772012,
//                        "percent_change_1h": 0,
//                        "percent_change_24h": 0,
//                        "percent_change_7d": 0,
//                        "market_cap": 17024600
//            }
//        }
//        }
//],
//        "status": {
//            "timestamp": "2018-06-02T22:51:28.209Z",
//                    "error_code": 0,
//                    "error_message": "",
//                    "elapsed": 10,
//                    "credit_count": 1
//        }