package com.example.ki2_2022_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class N08_02 extends AppCompatActivity {

    private EditText edtNumber1;
    private EditText edtNumber2;
    private EditText edtNumber3;
    private Button btnSubt;
    private Button btnMult;
    private Button btnDivi;
    private void findViews() {
        edtNumber1 = findViewById(R.id.edtNumber1);
        edtNumber2 = findViewById(R.id.edtNumber2);
        edtNumber3 = findViewById(R.id.edtNumber3);
        btnSubt = findViewById(R.id.btnSubt);
        btnMult = findViewById(R.id.btnMult);
        btnDivi = findViewById(R.id.btnDivi);
    }
    private void correctForm() {
        if (edtNumber1.getText().toString().equals(""))
            edtNumber1.setText("0");
        if (edtNumber2.getText().toString().equals(""))
            edtNumber2.setText("0");
        edtNumber1.setText(Integer.toString(Integer.parseInt(edtNumber1.getText().toString())));
        edtNumber2.setText(Integer.toString(Integer.parseInt(edtNumber2.getText().toString())));
    }
    private void addEvents() {
        btnSubt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correctForm();
                int number1 = Integer.parseInt(edtNumber1.getText().toString());
                int number2 = Integer.parseInt(edtNumber2.getText().toString());
                String result = Integer.toString(number1 - number2);
                edtNumber3.setText(result);
            }
        });
        btnMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correctForm();
                int number1 = Integer.parseInt(edtNumber1.getText().toString());
                int number2 = Integer.parseInt(edtNumber2.getText().toString());
                String result = Integer.toString(number1 * number2);
                edtNumber3.setText(result);
            }
        });
        btnDivi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correctForm();
                int number1 = Integer.parseInt(edtNumber1.getText().toString());
                int number2 = Integer.parseInt(edtNumber2.getText().toString());
                if (number2 != 0) {
                    String result = Integer.toString(number1 / number2);
                    edtNumber3.setText(result);
                }
                else
                    edtNumber3.setText("NaN");
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n0802);
        findViews();
        addEvents();
    }

    public void btnSum_Clicked(View view) {
        correctForm();
        int number1 = Integer.parseInt(edtNumber1.getText().toString());
        int number2 = Integer.parseInt(edtNumber2.getText().toString());
        String result = Integer.toString(number1 + number2);
        edtNumber3.setText(result);
    }
}