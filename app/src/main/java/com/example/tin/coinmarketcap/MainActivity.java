package com.example.tin.coinmarketcap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.tin.coinmarketcap.adapters.CoinAdapter;
import com.example.tin.coinmarketcap.serverConnection.responses.ListingResponse;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements MainContract.MainScreen {

    private static final String TAG = MainPresenter.class.getSimpleName();

    private MainPresenter mainPresenter;

    private RecyclerView mRecyclerView;
    private CoinAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainPresenter = new MainPresenter(this);

        setupViews();

        mainPresenter.getData(MainActivity.this);
    }

    @Override
    public void showData(ArrayList<ListingResponse.Data> coins) {

        Log.d(TAG, "showData: " + String.valueOf(coins));

        mAdapter = new CoinAdapter(coins, getApplicationContext());
        mRecyclerView.setAdapter(mAdapter);
    }


    private void setupViews() {

        /* Setting up the RecyclerView and Adapter*/
        mRecyclerView = findViewById(R.id.rV_main);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
    }

}
