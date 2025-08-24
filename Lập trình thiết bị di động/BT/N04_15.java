package com.example.ki2_2022_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Random;

public class N04_15 extends AppCompatActivity {
    private int[] arr = new int[4];
    private TextView[] tvis = new TextView[4];
    private void findViews() {
        tvis[0] = findViewById(R.id.tvi10415);
        tvis[1] = findViewById(R.id.tvi20415);
        tvis[2] = findViewById(R.id.tvi30415);
        tvis[3] = findViewById(R.id.tvi40415);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n0415);
        findViews();
    }
    public void btnRand_Clicked(View view) {
        Random random = new Random();
        random.nextInt(100);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
            tvis[i].setText(Integer.toString(arr[i]));
        }
        int[] indexes = new int[] {0, 1, 2, 3};
        for (int i = 0; i < arr.length; ++i)
            for (int j = i + 1; j < arr.length; ++j)
                if (arr[indexes[i]] > arr[indexes[j]]) {
                    int temp = indexes[i];
                    indexes[i] = indexes[j];
                    indexes[j] = temp;
                }
        tvis[indexes[3]].setBackgroundColor(Color.parseColor("#FF0000"));
        tvis[indexes[2]].setBackgroundColor(Color.parseColor("#00FF00"));
        tvis[indexes[1]].setBackgroundColor(Color.parseColor("#0000FF"));
        tvis[indexes[0]].setBackgroundColor(Color.parseColor("#FFFF00"));
    }

    private int[] A(int x1, int x2, int x3, int x4) {
        int[] a = new int[] {x1,x2,x3,x4};
        for (int i = 0; i < a.length; i++)
            for (int j = i + 1; j < a.length; ++j)
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
        return a;
    }

    public void btnSort_Clicked(View view) {
        arr = A(arr[0],arr[1],arr[2],arr[3]);
        for (int i = 0; i < arr.length; i++)
            tvis[i].setText(Integer.toString(arr[i]));
        int[] indexes = new int[] {0, 1, 2, 3};
        for (int i = 0; i < arr.length; ++i)
            for (int j = i + 1; j < arr.length; ++j)
                if (arr[indexes[i]] > arr[indexes[j]]) {
                    int temp = indexes[i];
                    indexes[i] = indexes[j];
                    indexes[j] = temp;
                }
        tvis[indexes[3]].setBackgroundColor(Color.parseColor("#FF0000"));
        tvis[indexes[2]].setBackgroundColor(Color.parseColor("#00FF00"));
        tvis[indexes[1]].setBackgroundColor(Color.parseColor("#0000FF"));
        tvis[indexes[0]].setBackgroundColor(Color.parseColor("#FFFF00"));
    }
    public void btnSave_Clicked(View view) throws IOException {
        FileOutputStream stream = openFileOutput("n0415.txt", MODE_PRIVATE);
        OutputStreamWriter writer = new OutputStreamWriter(stream);
        for (int i = 0; i < 4; ++i)
            writer.write(Integer.toString(arr[i]) + "\n");
        writer.close();
        stream.close();
    }
    public void btnLoad_Clicked(View view) throws IOException {
        FileInputStream stream = openFileInput("n0415.txt");
        InputStreamReader streamReader = new InputStreamReader(stream);
        BufferedReader reader = new BufferedReader(streamReader);
        for (int i = 0; i < 4; ++i) {
            arr[i] = Integer.parseInt(reader.readLine());
            tvis[i].setText(Integer.toString(arr[i]));
        }
        reader.close();
        streamReader.close();
        stream.close();
        int[] indexes = new int[] {0, 1, 2, 3};
        for (int i = 0; i < arr.length; ++i)
            for (int j = i + 1; j < arr.length; ++j)
                if (arr[indexes[i]] > arr[indexes[j]]) {
                    int temp = indexes[i];
                    indexes[i] = indexes[j];
                    indexes[j] = temp;
                }
        tvis[indexes[3]].setBackgroundColor(Color.parseColor("#FF0000"));
        tvis[indexes[2]].setBackgroundColor(Color.parseColor("#00FF00"));
        tvis[indexes[1]].setBackgroundColor(Color.parseColor("#0000FF"));
        tvis[indexes[0]].setBackgroundColor(Color.parseColor("#FFFF00"));
    }
}