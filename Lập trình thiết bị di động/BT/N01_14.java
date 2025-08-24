package com.example.ki2_2022_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class N01_14 extends AppCompatActivity {
    private EditText edtA;
    private EditText edtB;
    private View vie;
    private void findViews() {
        edtA = findViewById(R.id.edtA0114);
        edtB = findViewById(R.id.edtB0114);
        vie = findViewById(R.id.vie0114);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n0114);
        findViews();
    }

    private int ucln(int a, int b) {
        if (a == b)
            return a;
        else if (a > b)
            return ucln(a - b, b);
        else
            return ucln(b - a, a);
    }
    private int bcnn(int a, int b) {
        return a * b / ucln(a,b);
    }
    public void btnTransform_Clicked(View view) {
        int a = Integer.parseInt(edtA.getText().toString());
        int b = Integer.parseInt(edtB.getText().toString());
        int width = bcnn(a,b);
        int height = ucln(a,b);
        ViewGroup.LayoutParams params = vie.getLayoutParams();
        params.width = width;
        params.height = height;
        vie.setLayoutParams(params);
    }
}