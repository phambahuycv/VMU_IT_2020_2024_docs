package com.example.ki2_2022_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class N01_02 extends AppCompatActivity {
    private EditText edt1;
    private EditText edt2;
    private EditText edt3;
    private Button btnCong;
    private Button btnTru;
    private Button btnNhan;
    private Button btnChia;
    private void findViews() {
        edt1 = findViewById(R.id.edtSo1);
        edt2 = findViewById(R.id.edtSo2);
        edt3 = findViewById(R.id.edtSo3);
        btnCong = findViewById(R.id.btnCong);
        btnTru = findViewById(R.id.btnTru);
        btnNhan = findViewById(R.id.btnNhan);
        btnChia = findViewById(R.id.btnChia);
    }
    private void correctForm() {
        if (edt1.getText().toString().equals(""))
            edt1.setText("0");
        if (edt2.getText().toString().equals(""))
            edt2.setText("0");
        edt1.setText(Integer.toString(Integer.parseInt(edt1.getText().toString())));
        edt2.setText(Integer.toString(Integer.parseInt(edt2.getText().toString())));
    }
    private void addEvents() {
        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correctForm();
                Integer so1 = Integer.parseInt(edt1.getText().toString());
                Integer so2 = Integer.parseInt(edt2.getText().toString());
                edt3.setText(Integer.toString(so1 + so2));
            }
        });
        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correctForm();
                Integer so1 = Integer.parseInt(edt1.getText().toString());
                Integer so2 = Integer.parseInt(edt2.getText().toString());
                edt3.setText(Integer.toString(so1 - so2));
            }
        });
        btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correctForm();
                Integer so1 = Integer.parseInt(edt1.getText().toString());
                Integer so2 = Integer.parseInt(edt2.getText().toString());
                if (so2 != 0)
                    edt3.setText(Integer.toString(so1 / so2));
                else
                    edt3.setText("NaN");
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n0102);
        findViews();
        addEvents();
    }
    public void btnNhan_Clicked(View view) {
        correctForm();
        Integer so1 = Integer.parseInt(edt1.getText().toString());
        Integer so2 = Integer.parseInt(edt2.getText().toString());
        edt3.setText(Integer.toString(so1 * so2));
    }
}