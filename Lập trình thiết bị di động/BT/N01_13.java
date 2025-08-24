package com.example.ki2_2022_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class N01_13 extends AppCompatActivity {
    private EditText edtInput;
    private EditText edtOutput;
    private void findViews() {
        edtInput = findViewById(R.id.edtInput0113);
        edtOutput = findViewById(R.id.edtOutput0113);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n0113);
        findViews();
    }

    private boolean E(int[] a) {
        int n = a.length;
        for (int i = 0; i < n / 2; i++)
            if (a[i] != a[n-1-i])
                return false;
        return true;
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
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 2; i < n; ++i) {
            boolean found = true;
            for (int j = 2; j <= Math.sqrt(i); j++)
                if (i % j == 0) {
                    found = false;
                    break;
                }
            if (found == true)
                list.add(i);
        }
        int[] a = new int[list.size()];
        for (int i = 0; i < a.length; ++i)
            a[i] =list.get(i);
        return a;
    }

    public void btnB_Clicked(View view) {
        int n = Integer.parseInt(edtInput.getText().toString());
        int[] a = B(n);
        String output = "";
        for (int i = 0; i < a.length; ++i)
            output = output + Integer.toString(a[i]) + " ";
        edtOutput.setText(output.trim());
    }

    private int ucln(int a, int b) {
        if (a == b)
            return a;
        else if (a < b)
            return ucln(b-a,a);
        else
            return ucln(a-b,b);
    }

    private int C(int[] a) {
        int ucln = a[0];
        for (int i = 1; i < a.length; ++i)
            ucln = ucln(ucln,a[i]);
        return ucln;
    }

    private double D(int[] a) {
        for (int i = 0; i < a.length; ++i)
            for (int j = i + 1; j < a.length; ++j)
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
        if (a.length % 2 == 1)
            return a[(int)(a.length / 2)];
        else
            return (a[a.length/2] + a[a.length/2 - 1]) / 2.0;
    }

    private int[] F(int[] a) {
        ArrayList<Integer> evens = new ArrayList<>();
        ArrayList<Integer> odds = new ArrayList<>();
        for (int i = 0; i < a.length; ++i)
            if (a[i] % 2 ==0)
                evens.add(a[i]);
            else
                odds.add(a[i]);
        for (int i = 0; i < evens.size(); ++i)
            a[i] = evens.get(i);
        for (int i = 0; i < odds.size(); ++i)
            a[evens.size() + i] = odds.get(i);
        return a;
    }

    public void btnA_Clicked(View view) {
        String line = edtInput.getText().toString();
        String[] parts = line.split(" ");
        int[] a = new int[parts.length];
        for (int i =0; i < a.length;++i)
            a[i] = Integer.parseInt(parts[i]);
        edtOutput.setText(Integer.toString(A(a)));
    }

    public void btnE_Clicked(View view) {
        String line = edtInput.getText().toString();
        String[] parts = line.split(" ");
        int[] a = new int[parts.length];
        for (int i =0; i < a.length;++i)
            a[i] = Integer.parseInt(parts[i]);
        edtOutput.setText(Boolean.toString(E(a)));
    }
}