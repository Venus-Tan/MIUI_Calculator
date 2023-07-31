package com.huajia.calculator.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;

import com.huajia.calculator.R;
import com.huajia.calculator.activity.RecordActivity;
import com.huajia.calculator.activity.SettingActivity;

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
                Intent intent = new Intent(getContext(), RecordActivity.class);
                getContext().startActivity(intent);
                dismiss();
            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SettingActivity.class);
                getContext().startActivity(intent);
                dismiss();
            }
        });

    }
}
