package com.example.tin.coinmarketcap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tin.coinmarketcap.serverConnection.responses.ListingResponse;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity implements DetailContract.DetailScreen {

    private TextView rankTv;
    private TextView nameTv;
    private TextView cSupplyTv;
    private Button button;


    private ArrayList<ListingResponse.DataModel> mCoins;
    private int positionClicked;

    private DetailPresenter detailPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detailPresenter = new DetailPresenter(this);

        setupViews();
    }

    private void setupViews() {

        rankTv = findViewById(R.id.tV_detail_rank);
        nameTv = findViewById(R.id.tV_detail_name);
        cSupplyTv = findViewById(R.id.tV_detail_cSupply);
        button = findViewById(R.id.btn_detail);

        Intent getIntent = getIntent();

        if (getIntent != null) {
            mCoins = getIntent.getParcelableArrayListExtra(MainActivity.COIN_LIST);
            positionClicked = getIntent.getIntExtra(MainActivity.POSITION_CLICKED, -1);

            rankTv.setText(String.format("%s%s", getString(R.string.rank), String.valueOf(mCoins.get(positionClicked).getCmc_rank())));
            nameTv.setText(String.format("%s%s", getString(R.string.name), mCoins.get(positionClicked).getName()));
            cSupplyTv.setText(String.format("%s%s", getString(R.string.c_supply), String.valueOf(mCoins.get(positionClicked).getCirculating_supply())));

        } else {
            Toast.makeText(this, "Error loading data, please try again.", Toast.LENGTH_SHORT).show();
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String currencyName = (String) nameTv.getText();

                detailPresenter.launchToast(currencyName);
            }
        });
    }

    @Override
    public void showToast(String currencyName) {

        Toast.makeText(this, "We're making a toast with: " + currencyName, Toast.LENGTH_SHORT).show();
    }
}
