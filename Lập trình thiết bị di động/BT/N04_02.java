package com.example.ki2_2022_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class N04_02 extends AppCompatActivity {
    //Khai bao ra cac view tuong tac
    private EditText edt1;
    private EditText edt2;
    private EditText edt3;
    private Button btnAdd;
    private Button btnSub;
    private Button btnMul;
    private Button btnDiv;
    //Anh xa cac bien lap trinh voi cac view tren giao dien
    private void findViews() {
        edt1 = findViewById(R.id.edtSo1);
        edt2 = findViewById(R.id.edt2);
        edt3 = findViewById(R.id.edt3);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
    }
    //Ham sua loi cho form
    private void correctForm() {
        if (edt1.getText().toString().equals(""))
            edt1.setText("0");
        if (edt2.getText().toString().equals(""))
            edt2.setText("0");
        edt1.setText(Integer.toString(Integer.parseInt(edt1.getText().toString())));
        edt2.setText(Integer.toString(Integer.parseInt(edt2.getText().toString())));
    }
    //Tao su kien
    private void addEvents() {
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correctForm();
                String strEdt1 = edt1.getText().toString();
                String strEdt2 = edt2.getText().toString();
                Integer result = Integer.parseInt(strEdt1) - Integer.parseInt(strEdt2);
                edt3.setText(result.toString());
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correctForm();
                String strEdt1 = edt1.getText().toString();
                String strEdt2 = edt2.getText().toString();
                Integer result = Integer.parseInt(strEdt1) * Integer.parseInt(strEdt2);
                edt3.setText(result.toString());
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correctForm();
                String strEdt1 = edt1.getText().toString();
                String strEdt2 = edt2.getText().toString();
                if (Integer.parseInt(strEdt2) == 0)
                    edt3.setText("NaN");
                else {
                    Integer result = Integer.parseInt(strEdt1) / Integer.parseInt(strEdt2);
                    edt3.setText(result.toString());
                }
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n0402);
        findViews();
        addEvents();
    }
    public void btnAdd_Clicked(View view) {
        correctForm();
        String strEdt1 = edt1.getText().toString();
        String strEdt2 = edt2.getText().toString();
        Integer result = Integer.parseInt(strEdt1) + Integer.parseInt(strEdt2);
        edt3.setText(result.toString());
    }
}