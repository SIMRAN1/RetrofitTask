package com.redcarpet.in.retrofittask;

/**
 * Created by simran on 5/25/2017.
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;



public class DataUserSelectAdapter extends RecyclerView.Adapter<DataUserSelectAdapter.ViewHolder> {
    private ArrayList<Worldpopulation> user_details;
    Context context;


    public DataUserSelectAdapter(Context context, ArrayList<Worldpopulation> user_details) {
        this.user_details = user_details;
        this.context=context;

    }

    @Override
    public DataUserSelectAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {


            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row, viewGroup, false);
            return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(DataUserSelectAdapter.ViewHolder viewHolder, int i) {


           Picasso.with(context).load(user_details.get(i).getFlag()).resize(240, 120).into(viewHolder.flag_img);

    }

    @Override
    public int getItemCount() {
        return user_details.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;

        private ImageView flag_img;


        ViewHolder(View view) {

            super(view);
            flag_img = (ImageView) view.findViewById(R.id.imageFlag);
           flag_img.setOnClickListener(this);

        }



        @Override
        public void onClick(View v) {

        }
    }
}
