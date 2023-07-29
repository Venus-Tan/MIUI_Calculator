package com.huajia.calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.huajia.calculator.adapter.ViewPageAdapter;
import com.huajia.calculator.dialog.MenuDialog;
import com.huajia.calculator.fragement.CalculatorFragment;
import com.huajia.calculator.fragement.ConversionFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView calculatorTextView;

    private TextView conversionTextView;

    private ViewPager2 viewPager;

    private ImageButton menu;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculatorTextView = findViewById(R.id.calculate);
        conversionTextView = findViewById(R.id.conversion);
        viewPager = findViewById(R.id.viewPage);
        menu = findViewById(R.id.menu);


        //点击title切换视图
        calculatorTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0);
            }
        });

        conversionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
            }
        });


        //viewpage切换视图
        List<Fragment> list = new ArrayList<>();
        list.add(new CalculatorFragment());
        list.add(new ConversionFragment());
        ViewPageAdapter adapter = new ViewPageAdapter(getSupportFragmentManager(), getLifecycle(), list);
        viewPager.setAdapter(adapter);
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                if (position == 0){
                    calculatorTextView.setTextColor(getResources().getColor(R.color.black));
                    conversionTextView.setTextColor(getResources().getColor(R.color.title_grey));
                } else if (position == 1) {
                    calculatorTextView.setTextColor(getResources().getColor(R.color.title_grey));
                    conversionTextView.setTextColor(getResources().getColor(R.color.black));
                }
            }
        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MenuDialog dialog = new MenuDialog(MainActivity.this);
                //解决自定义dilog背景白色导致圆角失效
                dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                Window window = dialog.getWindow();
                //设置弹出位置
                window.setGravity(Gravity.TOP);

                int matchParent = ViewGroup.LayoutParams.MATCH_PARENT;//父布局的宽度

                Window dialogWindow = dialog.getWindow();
                dialogWindow.setGravity(Gravity.TOP | Gravity.RIGHT);
                WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                lp.width = matchParent;
                lp.height = matchParent;
                lp.x = matchParent;
                lp.y = 50;  //设置出现的高度，距离顶部
                window.setAttributes(lp);
                dialog.show();
            }
        });

    }
}