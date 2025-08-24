package com.example.ki2_2022_2023;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class N08_03 extends AppCompatActivity {
    private Double result = 0.0;
    private String operator = "";
    private EditText edtManHinh;
    private Switch swiCheDoToi;
    private ConstraintLayout layMayTinh;
    private void findViews() {
        edtManHinh = findViewById(R.id.edtManHinh);
        swiCheDoToi = findViewById(R.id.swiCheDoToi);
        layMayTinh = findViewById(R.id.layMayTinh);
    }
    private void addEvents() {
        edtManHinh.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String screenText = s.toString();
                if (screenText.equals("Infinity")) {
                    edtManHinh.setTextColor(Color.rgb(255,0,0));
                }
                else if (swiCheDoToi.isChecked()) {
                    edtManHinh.setTextColor(Color.rgb(255,255,255));
                }
                else {
                    edtManHinh.setTextColor(Color.rgb(0,0,0));
                }
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n0803);
        findViews();
        addEvents();
    }

    public void btnHuy_Clicked(View view) {
        edtManHinh.setText("0");
        result = 0.0;
        operator = "";
    }

    public void btnSo_Clicked(View view) {
        Button button = (Button) view;
        String number = button.getText().toString();
        String screenText = edtManHinh.getText().toString();
        if (screenText.equals("0"))
            edtManHinh.setText(number);
        else
            edtManHinh.setText(screenText + number);
    }

    public void btnCham_Clicked(View view) {
        String screenText = edtManHinh.getText().toString();
        if (!screenText.contains("."))
            edtManHinh.setText(screenText + ".");
    }

    public void btnPhepToan_Clicked(View view) {
        Button button = (Button) view;
        String screenText = edtManHinh.getText().toString();
        if (operator.equals(""))
            result = Double.parseDouble(screenText);
        else if (operator.equals("+"))
            result += Double.parseDouble(screenText);
        else if (operator.equals("-"))
            result -= Double.parseDouble(screenText);
        else if (operator.equals("*"))
            result *= Double.parseDouble(screenText);
        else
            result /= Double.parseDouble(screenText);
        edtManHinh.setText("0");
        operator = button.getText().toString();
    }

    public void btnKetQua_Clicked(View view) {
        String screenText = edtManHinh.getText().toString();
        if (operator.equals(""))
            result = Double.parseDouble(screenText);
        else if (operator.equals("+"))
            result += Double.parseDouble(screenText);
        else if (operator.equals("-"))
            result -= Double.parseDouble(screenText);
        else if (operator.equals("*"))
            result *= Double.parseDouble(screenText);
        else
            result /= Double.parseDouble(screenText);
        operator = "";
        if (result > result.intValue())
            edtManHinh.setText(Double.toString(result));
        else
            edtManHinh.setText(Integer.toString(result.intValue()));
    }

    public void swiCheDoToi_Clicked(View view) {
        if (swiCheDoToi.isChecked()) {
            layMayTinh.setBackgroundColor(Color.rgb(128,128,128));
            edtManHinh.setBackgroundColor(Color.rgb(160,160,160));
            if (!edtManHinh.getText().toString().equals("Infinity"))
                edtManHinh.setTextColor(Color.rgb(255,255,255));
        }
        else {
            layMayTinh.setBackgroundColor(Color.rgb(255,255,255));
            edtManHinh.setBackgroundColor(Color.rgb(223,223,223));
            if (!edtManHinh.getText().toString().equals("Infinity"))
                edtManHinh.setTextColor(Color.rgb(0,0,0));
        }

    }
}