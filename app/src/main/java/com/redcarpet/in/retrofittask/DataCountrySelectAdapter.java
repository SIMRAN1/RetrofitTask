package com.redcarpet.in.retrofittask;

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
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static android.R.attr.fragment;


public class DataCountrySelectAdapter extends RecyclerView.Adapter<DataCountrySelectAdapter.ViewHolder> {
    private ArrayList<Worldpopulation> user_details;
    Context context;
    MainActivity mainActivity;
    int position;


    public DataCountrySelectAdapter(Context context, ArrayList<Worldpopulation> user_details, MainActivity mainActivity) {
        this.user_details = user_details;
        this.context=context;
        this.mainActivity=mainActivity;

    }

    @Override
    public DataCountrySelectAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {


            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row, viewGroup, false);
            return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(DataCountrySelectAdapter.ViewHolder viewHolder, int i) {

        position=i;
           Picasso.with(context).load(user_details.get(i).getFlag()).resize(240, 120).into(viewHolder.flag_img);
        String flagurl = user_details.get(i).getFlag();

        viewHolder.setFlag(flagurl);
        String name = user_details.get(i).getCountry();

        viewHolder.setName(name);
        int rank = user_details.get(i).getRank();

        viewHolder.setRank(rank);
        String population = user_details.get(i).getPopulation();

        viewHolder.setPopulation(population);

    }


    @Override
    public int getItemCount() {
        return user_details.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
        Bundle args;
        CountryDetailsFragment fragment;
        private ImageView flag_img;
        String flag,name,population;
        int rank;


        ViewHolder(View view) {

            super(view);
            flag_img = (ImageView) view.findViewById(R.id.imageFlag);
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
                    .replace(R.id.fragment_container,fragment)
                    .commit();

        }


    }
}
