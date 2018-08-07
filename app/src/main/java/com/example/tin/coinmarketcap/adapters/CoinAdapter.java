package com.example.tin.coinmarketcap.adapters;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tin.coinmarketcap.CoinPositionListener;
import com.example.tin.coinmarketcap.R;
import com.example.tin.coinmarketcap.serverConnection.responses.ListingResponse;

import java.util.ArrayList;

public class CoinAdapter extends RecyclerView.Adapter<CoinAdapter.ViewHolder> {

    private ArrayList<ListingResponse.DataModel> mCoins;

    private final CoinPositionListener coinPositionListener;

    public CoinAdapter(ArrayList<ListingResponse.DataModel> mCoin, Context context, CoinPositionListener listener) {
        this.mCoins = mCoin;
        Context mContext = context;
        this.coinPositionListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.bitcoin_list_item, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        ListingResponse.DataModel coin = mCoins.get(position);

        viewHolder.rankTv.setText(String.valueOf(coin.getCmc_rank()));
        viewHolder.nameTv.setText(coin.getName());
        // viewHolder.priceTv.setText(coin.getPrice()); __Cannot get price as it's a nested object

    }

    @Override
    public int getItemCount() {
        if (mCoins == null) {
            return 0;
        } else {
            return mCoins.size();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        final TextView rankTv;
        final TextView nameTv;
        final TextView priceTv;


        public ViewHolder(View itemView) {
            super(itemView);

            rankTv = itemView.findViewById(R.id.tV_rank);
            nameTv = itemView.findViewById(R.id.tV_name);
            priceTv = itemView.findViewById(R.id.tV_price);

            /* Setting up the onClickListeners */
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    /* Implementing the interface method */
                    coinPositionListener.coinItemClick(view, getAdapterPosition());
                }
            });
        }
    }
}
