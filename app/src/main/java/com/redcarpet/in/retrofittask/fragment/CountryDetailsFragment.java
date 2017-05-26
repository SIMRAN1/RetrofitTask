package com.redcarpet.in.retrofittask.fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.redcarpet.in.retrofittask.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

/**
 * Created by simran on 5/25/2017.
 */

public class CountryDetailsFragment extends Fragment {
    String FlagUrl, Country, Rank,Population;
    ImageView CountryFlag;
    TextView CountryName,CountryRank,CountryPopulation;
    ProgressBar pb;

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.country_details_fragment, container, false);
        pb=(ProgressBar)view.findViewById(R.id.progressbar);

        Bundle bundle = getArguments();
        if(bundle!=null) {
            FlagUrl = bundle.getString("flag");
            Country = bundle.getString("countryname");
            Rank = bundle.getString("rank");
            Population = bundle.getString("population");
        }
        Typeface type = Typeface.createFromAsset(getActivity().getAssets(), "fonts/CarnevaleeFreakshow.ttf");
        CountryName=(TextView)view.findViewById(R.id.country_value);
        CountryRank=(TextView)view.findViewById(R.id.rank_value);
        CountryPopulation=(TextView)view.findViewById(R.id.population_value);
        CountryFlag=(ImageView)view.findViewById(R.id.imageFlag);
        Picasso.with(getActivity()).load(FlagUrl).resize(240, 120).into(CountryFlag, new Callback() {
            @Override
            public void onSuccess() {
                pb.setVisibility(View.GONE);
            }

            @Override
            public void onError() {

            }
        });
        CountryName.setText(Country);
        CountryRank.setText(Rank);
        CountryPopulation.setText(Population);
        CountryName.setTypeface(type);
        CountryRank.setTypeface(type);
        CountryPopulation.setTypeface(type);
        return view;
    }
}
