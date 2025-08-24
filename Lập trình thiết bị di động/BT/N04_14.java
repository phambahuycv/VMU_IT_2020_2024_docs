package com.example.ki2_2022_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class N04_14 extends AppCompatActivity {
    private EditText edtInput;
    private EditText edtOutput;
    private void findViews() {
        edtInput = findViewById(R.id.edtInput0414);
        edtOutput = findViewById(R.id.edtOutput0414);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n0414);
        findViews();
    }

    private int A(int[] a) {
        int i = 1;
        while (true) {
            int i2 = i * i;
            boolean found = true;
            for (int j = 0; j < a.length; ++j)
                if (i2 % a[j] != 0) {
                    found = false;
                    break;
                }
            if (found == true)
                return i2;
            else
                i++;
        }
    }

    private int[] B(int n) {
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 2; i < n; ++i) {
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); ++j)
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            if (isPrime)
                a.add(i);
        }
        int[] b = new int[a.size()];
        for (int i = 0; i < b.length; ++i)
            b[i] = a.get(i);
        return b;
    }

    private int ucln(int a, int b) {
        if (a == b)
            return a;
        else if (a > b)
            return ucln(a - b, b);
        else
            return ucln(b - a, a);
    }

    private int C(int[] a) {
        int ucln = a[0];
        for (int i = 1; i < a.length; ++i)
            ucln = ucln(ucln, a[i]);
        return ucln;
    }

    public void btnC_Clicked(View view) {
        String input = edtInput.getText().toString();
        String[] parts = input.split(" ");
        int[] a = new int[parts.length];
        for (int i = 0; i < a.length; ++i)
            a[i] = Integer.parseInt(parts[i]);
        edtOutput.setText(Integer.toString(C(a)));
    }

    public void btnB_Clicked(View view) {
        int n = Integer.parseInt(edtInput.getText().toString());
        int[] a = B(n);
        String result = "";
        for (int i = 0; i < a.length; ++ i)
            result += Integer.toString(a[i]) + " ";
        edtOutput.setText(result.trim());
    }

    public void btnA_Clicked(View view) {
        String input = edtInput.getText().toString();
        String[] parts = input.split(" ");
        int[] a = new int[parts.length];
        for (int i = 0; i < a.length; ++i)
            a[i] = Integer.parseInt(parts[i]);
        edtOutput.setText(Integer.toString(A(a)));
    }
}