package com.huajia.calculator.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.huajia.calculator.R;
import com.huajia.calculator.util.ConvertTable;

public class RateActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "RateActivity";

    private ImageButton returnImg;

    private TextView firstText;

    private TextView secondText;

    private TextView threeText;

    private static int textFlag = 1;

    private static int number = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);

        returnImg = findViewById(R.id.returnImg);
        firstText = findViewById(R.id.firstText);
        secondText = findViewById(R.id.secondText);
        threeText = findViewById(R.id.threeText);


        firstText.setOnClickListener(this);
        secondText.setOnClickListener(this);
        threeText.setOnClickListener(this);
        returnImg.setOnClickListener(this);

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

        findViewById(R.id.clean).setOnClickListener(this::functionClick);

    }

    private void functionClick(View v) {
        switch (v.getId()){
            case R.id.clean:
                firstText.setText("0");
                secondText.setText("0");
                threeText.setText("0");
                break;
        }
    }

    private void numberClick(View v) {
        if (!(v instanceof Button)){
            return;
        }
        number = Integer.parseInt(((Button) v).getText().toString());
        //输入的动态string
        StringBuilder first_value = new StringBuilder(firstText.getText().toString());
        StringBuilder second_value = new StringBuilder(secondText.getText().toString());
        StringBuilder three_value = new StringBuilder(threeText.getText().toString());
        //转换率
        double firstConvert = 0;
        double secondConvert = 0;
        double threeConvert = 0;
        switch (textFlag){
            case 1:
                if (first_value.toString().equals("0")){
                    first_value = first_value.replace(0,1,number+"");
                }else{
                    first_value.append(number);
                }
                secondConvert = ConvertTable.findRateValue("人民币","美元");
                threeConvert = ConvertTable.findRateValue("人民币","欧元");
                firstText.setText(first_value);
                secondText.setText(String.format("%.2f", (Double.parseDouble(first_value.toString()) * secondConvert)));
                threeText.setText(String.format("%.2f", (Double.parseDouble(first_value.toString()) * threeConvert)));
                break;
            case 2:
                if (second_value.toString().equals("0")){
                    second_value = second_value.replace(0,1,number+"");
                }else{
                    second_value.append(number);
                }
                firstConvert = ConvertTable.findRateValue("美元","人民币");
                threeConvert = ConvertTable.findRateValue("美元","欧元");
                secondText.setText(second_value);
                firstText.setText(String.format("%.2f", (Double.parseDouble(second_value.toString()) * firstConvert)));
                threeText.setText(String.format("%.2f", (Double.parseDouble(second_value.toString()) * threeConvert)));
                break;
            case 3:
                if (three_value.toString().equals("0")){
                    three_value = three_value.replace(0,1,number+"");
                }else{
                    three_value.append(number);
                }
                firstConvert = ConvertTable.findRateValue("欧元","人民币");
                secondConvert = ConvertTable.findRateValue("欧元","美元");
                threeText.setText(three_value);
                firstText.setText(String.format("%.2f", (Double.parseDouble(three_value.toString()) * firstConvert)));
                secondText.setText(String.format("%.2f", (Double.parseDouble(three_value.toString()) * secondConvert)));
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
                break;
            case R.id.threeText:
                textFlag = 3;
                break;
        }
        changeTextColor();
    }

    private void changeTextColor() {
        firstText.setTextColor(textFlag == 1 ? getColor(R.color.MIUI_yellow) : getColor(R.color.black));
        secondText.setTextColor(textFlag == 2 ? getColor(R.color.MIUI_yellow) : getColor(R.color.black));
        threeText.setTextColor(textFlag == 3 ? getColor(R.color.MIUI_yellow) : getColor(R.color.black));
    }
}