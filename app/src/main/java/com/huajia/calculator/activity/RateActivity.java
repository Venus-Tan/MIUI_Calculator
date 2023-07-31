package com.huajia.calculator.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.huajia.calculator.R;

public class RateActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton returnImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);

        returnImg = findViewById(R.id.returnImg);

        returnImg.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.returnImg:
                finish();
                break;
        }
    }
}