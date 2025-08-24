package com.example.ki2_2022_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class N08_13 extends AppCompatActivity {
    private EditText edtInput;
    private EditText edtOutput;
    private void findViews() {
        edtInput = findViewById(R.id.edtInput0813);
        edtOutput = findViewById(R.id.edtOutput0813);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n0813);
        findViews();
    }

    private boolean e(int[] a) {
        int n = a.length;
        for (int i = 0; i < n / 2; ++i)
            if (a[i] != a[n-1-i])
                return false;
        return true;
    }

    private int a(int[] a) {
        int i = 1;
        while (true) {
            int i2 = i * i;
            boolean result = true;
            for (int j = 0; j < a.length; ++j)
                if (i2 % a[j] != 0) {
                    result = false;
                    break;
                }
            if (result)
                return i2;
            else
                i++;
        }
    }

    private boolean b1(int x) {
        double sqrtX = Math.sqrt(x);
        for (int i = 2; i <= sqrtX; ++i)
            if (x % i == 0)
                return false;
        return true;
    }

    private int[] b(int n) {
        boolean[] results = new boolean[n + 1];
        results[0] = false;
        results[1] = false;
        int count = 0;
        for (int i = 2; i <= n; i++) {
            results[i] = b1(i);
            if (results[i])
                count++;
        }
        int[] a = new int[count];
        int j = 0;
        for (int i = 2; i <= n; i++) {
            if (results[i]) {
                a[j] = i;
                j++;
            }
        }
        return a;
    }

    private int c1(int a, int b) {
        if (a == b)
            return a;
        if (a > b)
            return c1(a-b, b);
        else
            return c1(b-a, a);
    }

    private int c(int[] a) {
        int ucln = c1(a[0],a[1]);
        for (int i = 2; i < a.length; ++i)
            ucln = c1(ucln,a[i]);
        return ucln;
    }

    private double d(int[] a) {
        for (int i = 0; i < a.length; i++)
            for (int j = i + 1; j < a.length; j++)
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
        if (a.length % 2 == 0)
            return (a[a.length/2] + a[a.length/2 - 1]) / 2.0;
        else
            return a[a.length / 2];
    }

    public void btnD_Clicked(View view) {
        String input = edtInput.getText().toString();
        String[] parts = input.split(" ");
        int[] a = new int[parts.length];
        for (int i = 0; i < parts.length; ++i)
            a[i] = Integer.parseInt(parts[i]);
        edtOutput.setText(Double.toString(d(a)));
    }

    public void btnC_Clicked(View view) {
        String input = edtInput.getText().toString();
        String[] parts = input.split(" ");
        int[] a = new int[parts.length];
        for (int i = 0; i < parts.length; ++i)
            a[i] = Integer.parseInt(parts[i]);
        edtOutput.setText(Integer.toString(c(a)));
    }

    public void btnB_Clicked(View view) {
        String input = edtInput.getText().toString();
        int n = Integer.parseInt(input);
        int[] a = b(n);
        String result = "";
        for (int i = 0; i < a.length; ++i)
            result += Integer.toString(a[i]) + " ";
        edtOutput.setText(result);
    }

    public void btnA_Clicked(View view) {
        String input = edtInput.getText().toString();
        String[] parts = input.split(" ");
        int[] a = new int[parts.length];
        for (int i = 0; i < parts.length; ++i)
            a[i] = Integer.parseInt(parts[i]);
        edtOutput.setText(Integer.toString(a(a)));
    }

    public void btnE_Clicked(View view) {
        String input = edtInput.getText().toString();
        String[] parts = input.split(" ");
        int[] a = new int[parts.length];
        for (int i = 0; i < parts.length; ++i)
            a[i] = Integer.parseInt(parts[i]);
        edtOutput.setText(Boolean.toString(e(a)));
    }
}