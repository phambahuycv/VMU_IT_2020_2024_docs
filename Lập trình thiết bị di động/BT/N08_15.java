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

public class N08_15 extends AppCompatActivity {
    private int[] values = new int[4];
    private TextView[] textViews = new TextView[4];
    private void findViews() {
        textViews[0] = findViewById(R.id.tvw10815);
        textViews[1] = findViewById(R.id.tvw20815);
        textViews[2] = findViewById(R.id.tvw30815);
        textViews[3] = findViewById(R.id.tvw40815);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n0815);
        findViews();
    }
    private void loadValues() {
        for (int i = 0; i < 4; ++i)
            textViews[i].setText(Integer.toString(values[i]));
        int[] indexes = new int[] {0,1,2,3};
        for (int i = 0; i < 4; ++i)
            for (int j = i + 1; j < 4; ++j)
                if (values[indexes[i]] > values[indexes[j]]) {
                    int temp = indexes[i];
                    indexes[i] = indexes[j];
                    indexes[j] = temp;
                }
        textViews[indexes[0]].setBackgroundColor(Color.YELLOW);
        textViews[indexes[1]].setBackgroundColor(Color.BLUE);
        textViews[indexes[2]].setBackgroundColor(Color.GREEN);
        textViews[indexes[3]].setBackgroundColor(Color.RED);
    }
    public void btnRand_Clicked(View view) {
        Random random = new Random();
        for (int i = 0; i < 4; ++i)
            values[i] = random.nextInt(100);
        loadValues();
    }
    private int[] A(int x1, int x2, int x3, int x4) {
        int[] a = new int[] {x1,x2,x3,x4};
        for (int i = 0; i < 4; ++i)
            for (int j = i + 1; j < 4; ++j)
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
        return a;
    }
    public void btnSort_Clicked(View view) {
        values = A(values[0],values[1],values[2],values[3]);
        loadValues();
    }
    public void btnSave_Clicked(View view) throws IOException {
        FileOutputStream stream = openFileOutput("n0815.txt",MODE_PRIVATE);
        OutputStreamWriter writer = new OutputStreamWriter(stream);
        for (int i = 0; i < 4; i++)
            writer.write(Integer.toString(values[i]) + "\n");
        writer.close();
        stream.close();
    }
    public void btnLoad_Clicked(View view) throws IOException {
        FileInputStream stream = openFileInput("n0815.txt");
        InputStreamReader streamReader = new InputStreamReader(stream);
        BufferedReader reader = new BufferedReader(streamReader);
        for (int i = 0; i < 4; ++i)
            values[i] = Integer.parseInt(reader.readLine());
        reader.close();
        streamReader.close();
        stream.close();
        loadValues();
    }
}