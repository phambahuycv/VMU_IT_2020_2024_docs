package com.example.ki2_2022_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class N04_05 extends AppCompatActivity {
    private ArrayList<String> lines = new ArrayList<>();
    private int currentIndex = -1;
    private EditText edtN0405;
    private void findViews() {
        edtN0405 = findViewById(R.id.edtN0405);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n0405);
        findViews();
        //Nap cac dong trong file vao bien lines
        //Neu lines co phan tu thi nap phan tu dau tien len edittext
        try {
            FileInputStream stream = openFileInput("n0405.txt");
            InputStreamReader streamReader = new InputStreamReader(stream);
            BufferedReader reader = new BufferedReader(streamReader);
            String line = null;
            do {
                line = reader.readLine();
                if (line != null)
                    lines.add(line);
            }
            while (line != null);
            if (lines.size() > 0) {
                currentIndex = 0;
                edtN0405.setText(lines.get(currentIndex));
            }
            reader.close();
            streamReader.close();
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeFile() throws IOException {
        FileOutputStream stream = openFileOutput("n0405.txt", MODE_PRIVATE);
        OutputStreamWriter writer = new OutputStreamWriter(stream);
        for (int i = 0; i < lines.size(); ++i)
            writer.write(lines.get(i) + "\n");
        writer.close();
        stream.close();
    }

    public void btnAdd_Clicked(View view) throws IOException {
        //Kiem tra xem noi dung go vao co nam trong lines hay ko
        String currentText = edtN0405.getText().toString();
        if (!lines.contains(currentText)) {
            //Them noi dung go vao bien lines
            lines.add(currentText);
            //Ghi bien lines vao file text
            writeFile();
            //Nap phan tu dau tien cua lines len edittext
            currentIndex = 0;
            edtN0405.setText(lines.get(currentIndex));
        }
    }

    public void btnRemove_Clicked(View view) throws IOException {
        //Kiem tra xem noi dung go vao co nam trong lines hay ko
        String currentText = edtN0405.getText().toString();
        if (lines.contains(currentText)) {
            //Go noi dung do khoi lines
            lines.remove(currentText);
            //Ghi bien lines vao file text
            writeFile();
            //Nap phan tu dau tien cua lines len edittext neu co
            if (lines.size() > 0) {
                currentIndex = 0;
                edtN0405.setText(lines.get(currentIndex));
            }
            else {
                currentIndex = -1;
                edtN0405.setText("");
            }
        }
    }

    public void btnPrevious_Clicked(View view) {
        //giam currentIndex di
        //Hien thi phan tu thu currentIndex trong lines len edittext neu co
        if (currentIndex ==0) {
            currentIndex = lines.size() - 1;
            edtN0405.setText(lines.get(currentIndex));
        }
        else if(currentIndex > 0) {
            currentIndex--;
            edtN0405.setText(lines.get(currentIndex));
        }
    }

    public void btnNext_Clicked(View view) {
        //tang currentIndex len
        //Hien thi phan tu thu currentIndex trong lines len edittext neu co
        if (currentIndex == lines.size() - 1) {
            currentIndex = 0;
            edtN0405.setText(lines.get(currentIndex));
        }
        else if(currentIndex >= 0) {
            currentIndex++;
            edtN0405.setText(lines.get(currentIndex));
        }
    }

    public void btnSave_Clicked(View view) throws IOException {
        FileOutputStream stream = openFileOutput("n0405.txt", MODE_PRIVATE);
        OutputStreamWriter writer = new OutputStreamWriter(stream);
        writer.write(edtN0405.getText().toString());
        writer.close();
        stream.close();
        Toast.makeText(this, "Finished.", Toast.LENGTH_LONG).show();
    }

    public void btnLoad_Clicked(View view) throws IOException {
        FileInputStream stream = openFileInput("n0405.txt");
        InputStreamReader streamReader = new InputStreamReader(stream);
        BufferedReader reader = new BufferedReader(streamReader);
        String line = reader.readLine();
        edtN0405.setText(line);
        reader.close();
        streamReader.close();
        stream.close();
    }
}