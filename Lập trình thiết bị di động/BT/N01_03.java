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

public class N01_03 extends AppCompatActivity {
    private Double ketQua = 0.0;
    private String phepToan = "";
    private EditText edtHienThi;
    private ConstraintLayout layN0103;
    private Switch swiRomantic;
    private void findViews() {
        edtHienThi = findViewById(R.id.edtHienThi);
        swiRomantic = findViewById(R.id.swiRomantic);
        layN0103 = findViewById(R.id.layN0103);
    }
    private void addEvents() {
        edtHienThi.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String currentText = s.toString();
                if (currentText.equals("Infinity") || currentText.equals("NaN"))
                    edtHienThi.setTextColor(Color.rgb(255,0,0));
                else
                    edtHienThi.setTextColor(Color.rgb(0,0,0));
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n0103);
        findViews();
        addEvents();
    }

    public void btnCancel_Clicked(View view) {
        edtHienThi.setText("0");
    }

    public void btnSo_Clicked(View view) {
        Button button = (Button) view;
        String buttonLabel = button.getText().toString();
        String currentText = edtHienThi.getText().toString();
        if (currentText.equals("0") || currentText.equals("Infinity") || currentText.equals("NaN"))
            edtHienThi.setText(buttonLabel);
        else
            edtHienThi.setText(currentText + buttonLabel);
    }

    public void btnDot_Clicked(View view) {
        String currentText = edtHienThi.getText().toString();
        if (currentText.equals("Infinity") || currentText.equals("NaN"))
            edtHienThi.setText("0.");
        else if (!currentText.contains("."))
            edtHienThi.setText(currentText + ".");
    }

    public void btnPhepToan_Clicked(View view) {
        Double currentValue = Double.parseDouble(edtHienThi.getText().toString());
        if (phepToan.equals(""))
            ketQua = currentValue;
        else if (phepToan.equals("+"))
            ketQua = ketQua + currentValue;
        else if (phepToan.equals("-"))
            ketQua = ketQua - currentValue;
        else if (phepToan.equals("*"))
            ketQua = ketQua * currentValue;
        else
            ketQua = ketQua / currentValue;
        Button button = (Button) view;
        if (!button.getText().toString().equals("=")) {
            phepToan = button.getText().toString();
            edtHienThi.setText("0");
        }
        else {
            phepToan = "";
            if (ketQua > ketQua.intValue())
                edtHienThi.setText(Double.toString(ketQua));
            else
                edtHienThi.setText(Integer.toString(ketQua.intValue()));
        }
    }

    public void swiRomatic_Clicked(View view) {
        if (swiRomantic.isChecked()) {
            layN0103.setBackgroundColor(Color.rgb(255,192,203));
        }
        else
            layN0103.setBackgroundColor(Color.rgb(255,255,255));
    }
}