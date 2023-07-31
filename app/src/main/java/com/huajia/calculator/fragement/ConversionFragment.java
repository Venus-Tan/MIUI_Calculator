package com.huajia.calculator.fragement;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.huajia.calculator.R;
import com.huajia.calculator.activity.AreaActivity;
import com.huajia.calculator.activity.BinaryActivity;
import com.huajia.calculator.activity.BmActivity;
import com.huajia.calculator.activity.CallActivity;
import com.huajia.calculator.activity.CapitalizationActivity;
import com.huajia.calculator.activity.HomeActivity;
import com.huajia.calculator.activity.LengthActivity;
import com.huajia.calculator.activity.RateActivity;
import com.huajia.calculator.activity.SpeedActivity;
import com.huajia.calculator.activity.TaxActivity;
import com.huajia.calculator.activity.TemperatureActivity;
import com.huajia.calculator.activity.TimeActivity;
import com.huajia.calculator.activity.VolumeActivity;
import com.huajia.calculator.activity.WeightActivity;

public class ConversionFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_conversion, viewGroup, false);

        view.findViewById(R.id.rate_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RateActivity.class);
                startActivity(intent);
            }
        });

        view.findViewById(R.id.length_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LengthActivity.class);
                startActivity(intent);
            }
        });

        view.findViewById(R.id.weight_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), WeightActivity.class);
                startActivity(intent);
            }
        });

        view.findViewById(R.id.volume_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), VolumeActivity.class);
                startActivity(intent);
            }
        });

        view.findViewById(R.id.tax_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TaxActivity.class);
                startActivity(intent);
            }
        });

        view.findViewById(R.id.home_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HomeActivity.class);
                startActivity(intent);
            }
        });

        view.findViewById(R.id.binary_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BinaryActivity.class);
                startActivity(intent);
            }
        });

        view.findViewById(R.id.area_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AreaActivity.class);
                startActivity(intent);
            }
        });

        view.findViewById(R.id.call_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CallActivity.class);
                startActivity(intent);
            }
        });

        view.findViewById(R.id.time_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TimeActivity.class);
                startActivity(intent);
            }
        });

        view.findViewById(R.id.temperature_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TemperatureActivity.class);
                startActivity(intent);
            }
        });

        view.findViewById(R.id.speed_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SpeedActivity.class);
                startActivity(intent);
            }
        });

        view.findViewById(R.id.capitalization_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CapitalizationActivity.class);
                startActivity(intent);
            }
        });

        view.findViewById(R.id.bm_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BmActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

}