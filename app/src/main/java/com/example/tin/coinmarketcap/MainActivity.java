package com.example.tin.coinmarketcap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.tin.coinmarketcap.adapters.CoinAdapter;
import com.example.tin.coinmarketcap.serverConnection.responses.ListingResponse;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements MainContract.MainScreen, CoinPositionListener {

    public static String COIN_LIST = "coinList";
    public static final String POSITION_CLICKED = "positionClicked";


    private static final String TAG = MainActivity.class.getSimpleName();

    private MainPresenter mainPresenter;

    private RecyclerView mRecyclerView;
    private CoinAdapter mAdapter;
    private ArrayList<ListingResponse.DataModel> mCoins;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainPresenter = new MainPresenter(this);

        setupViews();

        mainPresenter.getData(MainActivity.this);
    }

    @Override
    public void showData(ArrayList<ListingResponse.DataModel> coins) {

        Log.d(TAG, "showData: " + String.valueOf(coins));

        mCoins = coins;

        mAdapter = new CoinAdapter(mCoins, getApplicationContext(),this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void coinItemClick(View v, int position) {

        Log.d(TAG, "Item Position: " + position);

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(POSITION_CLICKED, position);
        intent.putParcelableArrayListExtra(COIN_LIST, mCoins);
        startActivity(intent);
    }

    private void setupViews() {

        /* Setting up the RecyclerView and Adapter*/
        mRecyclerView = findViewById(R.id.rV_main);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
    }
}
