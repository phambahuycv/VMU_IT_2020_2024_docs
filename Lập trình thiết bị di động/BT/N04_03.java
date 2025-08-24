package com.example.ki2_2022_2023;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class N04_03 extends AppCompatActivity {

    private EditText edtScreen;
    private String operation = "";
    private Double operator = 0.0;
    private ConstraintLayout layout;
    private Switch swiDarkMode;
    private void findViews() {
        edtScreen = findViewById(R.id.edtScreen);
        layout = findViewById(R.id.layCalculator);
        swiDarkMode = findViewById(R.id.swiDarkMode);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n0403);
        findViews();
    }

    public void btnCancel_Clicked(View view) {
        edtScreen.setText("0");
    }

    public void btnNumber_Clicked(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();
        String screenText = edtScreen.getText().toString();
        if (screenText.equals("0"))
            edtScreen.setText(buttonText);
        else
            edtScreen.setText(screenText + buttonText);
    }

    public void btnDot_Clicked(View view) {
        String screenText = edtScreen.getText().toString();
        if (!screenText.contains("."))
            edtScreen.setText(screenText + ".");
    }

    public void btnOperation_Clicked(View view) {
        Button button = (Button)view;
        if (operation.equals(""))
            operator = Double.parseDouble(edtScreen.getText().toString());
        else if (operation.equals("+"))
            operator = operator + Double.parseDouble(edtScreen.getText().toString());
        else if (operation.equals("-"))
            operator = operator - Double.parseDouble(edtScreen.getText().toString());
        else if (operation.equals("*"))
            operator = operator * Double.parseDouble(edtScreen.getText().toString());
        else if (operation.equals("/"))
            operator = operator / Double.parseDouble(edtScreen.getText().toString());
        operation = button.getText().toString();
        edtScreen.setText("0");
    }

    public void btnFinalResult_Clicked(View view) {
        if (operation.equals("+"))
            operator = operator + Double.parseDouble(edtScreen.getText().toString());
        else if (operation.equals("-"))
            operator = operator - Double.parseDouble(edtScreen.getText().toString());
        else if (operation.equals("*"))
            operator = operator * Double.parseDouble(edtScreen.getText().toString());
        else if (operation.equals("/"))
            operator = operator / Double.parseDouble(edtScreen.getText().toString());
        if (operator > operator.intValue())
            edtScreen.setText(Double.toString(operator));
        else
            edtScreen.setText(Integer.toString(operator.intValue()));
        operation = "";
    }

    public void swiDarkMode_Clicked(View view) {
        if (swiDarkMode.isChecked()) {
            layout.setBackgroundColor(Color.rgb(64,64,64));
            swiDarkMode.setTextColor(Color.rgb(255,255,255));
        }
        else {
            layout.setBackgroundColor(Color.rgb(255,255,255));
            swiDarkMode.setTextColor(Color.rgb(0,0,0));
        }
    }
}