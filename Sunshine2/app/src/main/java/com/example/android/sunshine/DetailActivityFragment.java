package com.example.android.sunshine;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailActivityFragment extends Fragment {

    public DetailActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        // Get the intent from the fragment's activity
        Intent intent = getActivity().getIntent();

        // Ensure intent exists and has extra text
        if (intent != null && intent.hasExtra(Intent.EXTRA_TEXT)) {
            String forecast = intent.getStringExtra(Intent.EXTRA_TEXT);
            TextView tvDetailForecast = (TextView)view.findViewById(R.id.tvDetailForecast);
            tvDetailForecast.setText(forecast);
        }

        return view;
    }
}
