package com.country.countryapplication.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.country.countryapplication.R;
import com.country.countryapplication.interfaces.OnClickItem;
import com.country.countryapplication.model.CountryModel;

import java.util.ArrayList;

@SuppressWarnings("ALL")
public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<CountryModel> mResponse;
    private OnClickItem onClickLayout;

    public CountryAdapter(Context mContext, ArrayList<CountryModel> mResponse, OnClickItem onClick) {
        this.mContext = mContext;
        this.mResponse = mResponse;
        this.onClickLayout=onClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_country_list,parent,false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.mName.setText(mResponse.get(position).getName());
        holder.mCode.setText(mResponse.get(position).getCode());
        holder.mCities.setText(mResponse.get(position).getTotalCities().toString());
        holder.mISODivisions.setText(mResponse.get(position).getTotalIsoDivisions().toString());
        holder.mll_country.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickLayout.OnSingleItemClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mResponse.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout mll_country;
        private TextView mName,mCode,mCities,mISODivisions;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mll_country=itemView.findViewById(R.id.ll_countrylist);
            mName=itemView.findViewById(R.id.tv_countryname);
            mCode=itemView.findViewById(R.id.tv_code);
            mCities=itemView.findViewById(R.id.tv_cities);
            mISODivisions=itemView.findViewById(R.id.tv_iso_divisions);
        }
    }
}
