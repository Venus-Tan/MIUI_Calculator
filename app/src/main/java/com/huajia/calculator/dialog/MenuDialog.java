package com.huajia.calculator.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;

import com.huajia.calculator.R;

/**
 * @author: huajia
 * @date: 2023/7/29 10:46
 */

public class MenuDialog extends Dialog {

    private Button record;

    private Button setting;

    public MenuDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_dialog);

        record = findViewById(R.id.record);
        setting = findViewById(R.id.setting);

        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("点击了历史记录");
            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("设置");
            }
        });

    }
}
