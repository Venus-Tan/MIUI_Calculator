package com.huajia.calculator.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.huajia.calculator.R;
import com.huajia.calculator.util.ConvertTable;

public class LengthActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView firstText;

    private TextView secondText;

    private static int textFlag = 1;

    private static int number = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);

        findViewById(R.id.returnImg).setOnClickListener(this);

        firstText = findViewById(R.id.firstText);
        secondText = findViewById(R.id.secondText);

        findViewById(R.id.one).setOnClickListener(this::numberClick);
        findViewById(R.id.two).setOnClickListener(this::numberClick);
        findViewById(R.id.three).setOnClickListener(this::numberClick);
        findViewById(R.id.four).setOnClickListener(this::numberClick);
        findViewById(R.id.five).setOnClickListener(this::numberClick);
        findViewById(R.id.six).setOnClickListener(this::numberClick);
        findViewById(R.id.seven).setOnClickListener(this::numberClick);
        findViewById(R.id.eight).setOnClickListener(this::numberClick);
        findViewById(R.id.nine).setOnClickListener(this::numberClick);
        findViewById(R.id.zero).setOnClickListener(this::numberClick);
        findViewById(R.id.double_zero).setOnClickListener(this::numberClick);

    }

    private void numberClick(View v) {
        if (!(v instanceof Button)){
            return;
        }
        number = Integer.parseInt(((Button) v).getText().toString());
        //输入的动态string
        StringBuilder first_value = new StringBuilder(firstText.getText().toString());
        StringBuilder second_value = new StringBuilder(secondText.getText().toString());
        //转换率
        double firstConvert = 0;
        double secondConvert = 0;
        switch (textFlag) {
            case 1:
                if (first_value.toString().equals("0")) {
                    first_value = first_value.replace(0, 1, number + "");
                } else {
                    first_value.append(number);
                }
                secondConvert = ConvertTable.findRateValue("米", "厘米");
                firstText.setText(first_value);
                secondText.setText(String.format("%.2f", (Double.parseDouble(first_value.toString()) * secondConvert)));
                break;
            case 2:
                if (second_value.toString().equals("0")) {
                    second_value = second_value.replace(0, 1, number + "");
                } else {
                    second_value.append(number);
                }
                firstConvert = ConvertTable.findRateValue("厘米", "米");
                secondText.setText(second_value);
                firstText.setText(String.format("%.2f", (Double.parseDouble(second_value.toString()) * firstConvert)));
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.returnImg:
                finish();
                break;
            case R.id.firstText:
                textFlag = 1;
                break;
            case R.id.secondText:
                textFlag = 2;
        }
        changeTextColor();
    }

    private void changeTextColor() {
        firstText.setTextColor(textFlag == 1 ? getColor(R.color.MIUI_yellow) : getColor(R.color.black));
        secondText.setTextColor(textFlag == 2 ? getColor(R.color.MIUI_yellow) : getColor(R.color.black));
    }
}