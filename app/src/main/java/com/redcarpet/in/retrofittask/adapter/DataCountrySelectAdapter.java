package com.redcarpet.in.retrofittask.adapter;

/**
 * Created by simran on 5/25/2017.
 */

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.redcarpet.in.retrofittask.fragment.CountryDetailsFragment;
import com.redcarpet.in.retrofittask.activity.MainActivity;
import com.redcarpet.in.retrofittask.R;
import com.redcarpet.in.retrofittask.utils.Worldpopulation;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class DataCountrySelectAdapter extends RecyclerView.Adapter<DataCountrySelectAdapter.ViewHolder> {
    private ArrayList<Worldpopulation> countrydetails;
    Context context;
    MainActivity mainActivity;
    int position;


    public DataCountrySelectAdapter(Context context, ArrayList<Worldpopulation> countrydetails, MainActivity mainActivity) {
        this.countrydetails = countrydetails;
        this.context=context;
        this.mainActivity=mainActivity;

    }

    @Override
    public DataCountrySelectAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {


            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_country, viewGroup, false);
            return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(final DataCountrySelectAdapter.ViewHolder viewHolder, int i) {

        position=i;
           Picasso.with(context).load(countrydetails.get(i).getFlag()).resize(240, 120).into(viewHolder.flag_img, new Callback() {
               @Override
               public void onSuccess() {
                   viewHolder.pb.setVisibility(View.GONE);
               }

               @Override
               public void onError() {

               }
           });
        String flagurl = countrydetails.get(i).getFlag();

        viewHolder.setFlag(flagurl);
        String name = countrydetails.get(i).getCountry();

        viewHolder.setName(name);
        int rank = countrydetails.get(i).getRank();

        viewHolder.setRank(rank);
        String population = countrydetails.get(i).getPopulation();

        viewHolder.setPopulation(population);

    }


    @Override
    public int getItemCount() {
        return countrydetails.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
        Bundle args;
        ProgressBar pb;
        CountryDetailsFragment fragment;
        private ImageView flag_img;
        String flag,name,population;
        int rank;


        ViewHolder(View view) {

            super(view);
            flag_img = (ImageView) view.findViewById(R.id.imageFlag);
            pb=(ProgressBar)view.findViewById(R.id.progressbar);
           flag_img.setOnClickListener(this);

        }
        public void setFlag(String flag) {
            this.flag = flag;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setRank(int rank) {
            this.rank=rank;
        }

        public void setPopulation(String population) {
            this.population = population;
        }

        @Override
        public void onClick(View v) {
            fragmentManager = mainActivity.getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();

            args = new Bundle();
            args.putString("flag",flag);
            args.putString("countryname",name);
            args.putString("rank",Integer.toString(rank));
            args.putString("population",population);
            fragment = new CountryDetailsFragment();
            fragment.setArguments(args);
            fragmentTransaction
                    .setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right)
                    .replace(R.id.fragment_container,fragment).addToBackStack(null)
                    .commit();

        }


    }
}
